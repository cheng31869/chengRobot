package com.cheng.chengRobot.service;

import com.cheng.chengRobot.domain.PlaygroundGame;
import com.cheng.chengRobot.domain.Robot;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.SingleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundMessageService
{

    @Autowired
    PlaygroundGameService playgroundGameService;

    @Autowired
    GroupService groupService;

    @Autowired
    RobotService robotService;

    @Autowired
    RobotFriendService robotFriendService;

    public void messageHandler(MessageEvent event)
    {

        if (!robotService.isPlaygroundManagerTurnedOn(event.getBot().getId())) return;

        if (event instanceof GroupMessageEvent)
        {
            if (!groupService.isPlaygroundManagerOpen(event.getBot().getId(),
                    ((GroupMessageEvent) event).getGroup().getId())) return;
        }
        else if (event instanceof FriendMessageEvent)
        {
            if (!robotFriendService.isPlaygroundManagerTurnedOn(event.getBot().getId(),
                    ((FriendMessageEvent) event).getFriend().getId())) return;
        }
        //获取消息的纯文本形式
        String messageString = "";
        for (SingleMessage message : event.getMessage())
        {
            messageString += message.contentToString();
        }

        String messageReturn = "";
        if (messageString.startsWith("获取玩法"))
        {
            List<PlaygroundGame> playgroundGames = null;
            if (messageString.split("获取玩法").length == 1
                    || messageString.split("获取玩法").length == 0)
            {
                playgroundGames = playgroundGameService.getPlaygroundGame();
            }
            else
            {
                playgroundGames = playgroundGameService
                        .getPlaygroundGame(messageString.split("获取玩法")[1]);
            }
            if (playgroundGames.size() == 0)
            {
                messageReturn += "未查询到相关玩法";
                event.getSubject().sendMessage(messageReturn);
                return;
            }
            else if (playgroundGames.size() == 1)
            {
                messageReturn += "玩法名称：";
                messageReturn += playgroundGames.get(0).getName() + "\n";
                messageReturn += playgroundGames.get(0).getHowToPlay();
                event.getSubject().sendMessage(messageReturn);
                return;
            }
            else if (playgroundGames.size() > 1)
            {
                for (PlaygroundGame playgroundGame : playgroundGames)
                {
                    messageReturn += "游戏" + (playgroundGames.indexOf(playgroundGame) + 1) + ":";
                    messageReturn += playgroundGame.getName() + "\n";
                    messageReturn += playgroundGame.getHowToPlay() + "\n";
                }
                event.getSubject().sendMessage(messageReturn);
                return;
            }
            return;
        }
        else if (messageString.startsWith("添加玩法"))
        {
            if (messageString.split("添加玩法").length == 0)
            {
                messageReturn += "请输入要添加的玩法";
                event.getSubject().sendMessage(messageReturn);
                return;
            }
            else if (messageString.split("添加玩法").length == 2)
            {
                String gameName = messageString.split("添加玩法")[1].split("玩法")[0];
                String howToPlay = messageString.split("添加玩法")[1].split("玩法")[1];
                gameName.replaceAll(" ", "");
                howToPlay.replaceAll(" ", "");
                if (gameName == null || howToPlay == null)
                {
                    messageReturn += "输入信息不全请补全";
                    event.getSubject().sendMessage(messageReturn);
                    return;
                }
                if ("".equals(gameName)
                        || "".equals(howToPlay))
                {
                    messageReturn += "输入信息不全请补全";
                    event.getSubject().sendMessage(messageReturn);
                    return;
                }
                PlaygroundGame playgroundGame = new PlaygroundGame();
                playgroundGame.setName(gameName);
                playgroundGame.setHowToPlay(howToPlay);
                playgroundGameService.addNewGame(playgroundGame);
                messageReturn += "添加玩法成功";
                event.getSubject().sendMessage(messageReturn);
                return;
            }
        }

    }
}
