package com.cheng.chengRobot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.RobotMapper;
import com.cheng.chengRobot.domain.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobotService
{

    @Autowired
    RobotMapper robotMapper;

    //获取所有机器人qq号
    public List<Robot> getAllRobot()
    {
        return robotMapper.selectList(null);
    }

    //根据id获取机器人
    public Robot getRobot(int id)
    {
        return robotMapper.selectById(id);
    }

    //根据QQ号获取机器人
    public Robot getRobot(Long Qq)
    {
        QueryWrapper<Robot> robotQueryWrapper = new QueryWrapper<>();
        robotQueryWrapper.eq("qq", Qq);
        return robotMapper.selectOne(robotQueryWrapper);
    }

    //判断某个机器人消息转发是否开启
    public boolean isForwardTurnedOn(int id)
    {
        Robot robot = getRobot(id);
        if (robot != null)
        {
            return robot.getMessageForward();
        }
        else
        {
            return false;
        }

    }

    //判断某个机器人消息转发是否开启
    public boolean isForwardTurnedOn(Long qq)
    {
        Robot robot = getRobot(qq);
        if (robot != null)
        {
            return robot.getMessageForward();
        }
        else
        {
            return false;
        }
    }

    //判断机器人操场游戏开关是否开启
    public boolean isPlaygroundManagerTurnedOn(int id)
    {
        Robot robot = getRobot(id);
        if (robot == null) return false;
        else return robot.getPlaygroundManager();
    }

    public boolean isPlaygroundManagerTurnedOn(Long qq)
    {
        Robot robot = getRobot(qq);
        if (robot == null) return false;
        else return robot.getPlaygroundManager();
    }

    public boolean isChatGptTurnedOn(int id)
    {
        Robot robot = getRobot(id);
        if (robot == null) return false;
        else return robot.getChatGpt();
    }

    public boolean isChatGptTurnedOn(Long qq)
    {
        Robot robot = getRobot(qq);
        if (robot == null) return false;
        else return robot.getChatGpt();
    }
}
