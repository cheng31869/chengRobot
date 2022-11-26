package com.cheng.chengRobot;

import com.cheng.chengRobot.domain.MessageForward;
import com.cheng.chengRobot.domain.PlaygroundGame;
import com.cheng.chengRobot.domain.Robot;
import com.cheng.chengRobot.interceptor.LoginInterceptor;
import com.cheng.chengRobot.service.*;
import lombok.extern.slf4j.Slf4j;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.utils.BotConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;
import java.util.List;

//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
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.cheng.chengRobot.dao.mappers")
@Component
@Slf4j
public class ChengRobotApplication
        implements WebMvcConfigurer
{
    private static MessageForwardService messageForwardService = null;
    private static RobotService robotService = null;
    private static GroupService groupService = null;
    private static RobotFriendService robotFriendService = null;

    private static PlaygroundMessageService playgroundMessageService = null;

    public static void main(String[] args)
            throws IOException, InterruptedException
    {

        ConfigurableApplicationContext run = SpringApplication.run(ChengRobotApplication.class, args);
        try
        {
            //获取配置文件
            ConfigurableEnvironment environment = run.getEnvironment();

            //获取service
            messageForwardService = (MessageForwardService) run.getBean(MessageForwardService.class);
            robotService = (RobotService) run.getBean(RobotService.class);
            groupService = (GroupService) run.getBean(GroupService.class);
            playgroundMessageService = (PlaygroundMessageService) run.getBean(PlaygroundMessageService.class);
            robotFriendService = (RobotFriendService) run.getBean(RobotFriendService.class);

            //循环登录数据库里面的每一个qq
            for (Robot robot : robotService.getAllRobot())
            {
                Bot bot = BotFactory.INSTANCE.newBot(robot.getQq(), robot.getPassword(), new BotConfiguration()
                {{
                    //设置缓存与设备信息路径
                    String robotCachePath = environment.getProperty("robot-cache-path") + robot.getCachePath();
                    System.out.println(robotCachePath);
                    setProtocol(MiraiProtocol.ANDROID_PHONE);


                    setCacheDir(new File(robotCachePath + "\\cache"));
                    fileBasedDeviceInfo(robotCachePath + "\\myDeviceInfo.json");
                }});
                bot.login();
            }

            EventChannel<Event> channel = GlobalEventChannel.INSTANCE.filter(event -> {
                return event instanceof MessageEvent;
            });


            // 操场游戏功能监听器
            channel.subscribeAlways(MessageEvent.class, event -> {
                playgroundMessageService.messageHandler(event);
            });

            //消息转发监听器
            Listener<MessageEvent> messageForwardListener = channel.subscribeAlways(MessageEvent.class, ev -> {
                if (ev instanceof GroupMessageEvent)
                {
                    forwardGroupMessage((GroupMessageEvent) ev);
                }
                else if (ev instanceof FriendMessageEvent)
                {
                    forwardFriendMessage((FriendMessageEvent) ev);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        //刷新数据库里面的群
        groupService.flushGroupListToDB();

        //刷新机器人好友
        robotFriendService.flushRobotFriendsToDB();
    }

    //群消息转发
    public static void forwardGroupMessage(GroupMessageEvent event)
    {
        //获取收信机器人qq号，群号以及发送者QQ号
        Long robotQq = event.getBot().getId();
        Long GroupQq = event.getGroup().getId();
        Long senderQq = event.getSender().getId();

        //判断机器人的消息转发是否开启
        if (!robotService.isForwardTurnedOn(robotQq))
        {
            return;
        }

        //获取消息转发列表
        List<MessageForward> messageForwardList = messageForwardService
                .getMessageForward(robotQq, null, GroupQq, senderQq);
        //给列表里所有的接收者转发
        for (MessageForward messageForward : messageForwardList)
        {
            //必须要那个机器人的消息转发功能开启且这条消息转发处于激活状态才能转发
            if (messageForward.getActive() && robotService.isForwardTurnedOn(messageForward.getToRobotQq()))
            {

                Bot toRobot = Bot.getInstance(messageForward.getToRobotQq());
                //如果设置了转发到群就转发到那个群，设置了转发到好友就转发到好友
                if (messageForward.getToGroup() != null)
                {
                    //在消息链前面添加fix
                    MessageChain chain = event.getMessage();
                    toRobot.getGroup(messageForward.getToGroup())
                            .sendMessage(new PlainText(messageForward.getFix()).plus(chain));
                }

                if (messageForward.getToQq() != null)
                {
                    //在消息链前面添加fix
                    MessageChain chain = event.getMessage();
                    toRobot.getFriend(messageForward.getToQq())
                            .sendMessage(new PlainText(messageForward.getFix()).plus(chain));
                }
            }
        }

    }

    //好友消息转发
    public static void forwardFriendMessage(FriendMessageEvent event)
    {
        Long robotQq = event.getBot().getId();
        Long senderQq = event.getSender().getId();

        //判断来消息的机器人是否开启消息转发
        if (!robotService.isForwardTurnedOn(robotQq))
        {
            return;
        }

        List<MessageForward> messageForwardList = messageForwardService.getMessageForward(robotQq, senderQq, null,
                null);

        //循环发送
        for (MessageForward messageForward : messageForwardList)
        {
            //如果送消息的机器人没开转发就不转发
            if (!robotService.isForwardTurnedOn(messageForward.getToRobotQq()))
            {
                continue;
            }

            Bot toRobot = Bot.getInstance(messageForward.getToRobotQq());
            //如果设置了转发到群就转发到那个群，设置了转发到好友就转发到好友
            if (messageForward.getToGroup() != null)
            {
                //在消息链前面添加fix
                MessageChain chain = event.getMessage();
                toRobot.getGroup(messageForward.getToGroup())
                        .sendMessage(new PlainText(messageForward.getFix()).plus(chain));
            }

            if (messageForward.getToQq() != null)
            {
                //在消息链前面添加fix
                MessageChain chain = event.getMessage();
                toRobot.getFriend(messageForward.getToQq())
                        .sendMessage(new PlainText(messageForward.getFix()).plus(chain));
            }
        }

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //addPathPatterns拦截的路径
        String[] addPathPatterns = {
                "/user/**"
        };
        //excludePathPatterns排除的路径
        String[] excludePathPatterns = {
                "/user/login","/user/noLg","/user/error"
        };
        //创建用户拦截器对象并指定其拦截的路径和排除的路径
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(new String[]{"/**"})
                .excludePathPatterns(new String[]{"/login/**","/login"});
    }
}
