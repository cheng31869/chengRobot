package com.cheng.chengRobot.controller;



import com.cheng.chengRobot.dao.mappers.RobotMapper;
import com.cheng.chengRobot.domain.Robot;
import net.mamoe.mirai.Bot;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller80
{
    @Autowired
    private RobotMapper robotMapper;

    @GetMapping("/")
    public String getIndex()
    {
        System.out.println(robotMapper+ "----------------------------------------------");
        try
        {
            List<Robot> robots = robotMapper.selectList(null);
            for (Robot robot : robots)
            {
                System.out.println(robot.toString());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        List<Bot> bots = Bot.getInstances();
        bots.forEach((bot) -> {
            System.out.println(bot);
        });

        return "1111";
    }
}
