package com.cheng.chengRobot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.RobotFriendMapper;
import com.cheng.chengRobot.domain.RobotFriend;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotFriendService
{
    @Autowired
    RobotFriendMapper mapper;
    public RobotFriend getRobotFriend(int id)
    {
        return mapper.selectById(id);
    }

    public RobotFriend getRobotFriend(Long robotQq, Long friendQq)
    {
        QueryWrapper<RobotFriend> robotFriendQueryWrapper = new QueryWrapper<>();
        robotFriendQueryWrapper.eq("robot_qq", robotQq);
        robotFriendQueryWrapper.eq("qq", friendQq);
        return mapper.selectOne(robotFriendQueryWrapper);
    }

    //查询操场管理功能是否开启
    public boolean isPlaygroundManagerTurnedOn(int id)
    {
        RobotFriend robotFriend = getRobotFriend(id);
        if (robotFriend == null)
        {
            return false;
        }
        else
        {
            return robotFriend.getPlaygroundManager();
        }
    }

    public boolean isPlaygroundManagerTurnedOn(Long robotQq, Long friendQq)
    {
        RobotFriend robotFriend = getRobotFriend(robotQq, friendQq);
        if (robotFriend == null)
        {
            return false;
        }
        else
        {
            return robotFriend.getPlaygroundManager();
        }
    }

    //刷新数据库的好友列表
    public void flushRobotFriendsToDB()
    {
        //检查每个机器人的每个好友数据库里是否都有
        for (Bot bot : Bot.getInstances())
        {
            for (Friend friend : bot.getFriends())
            {
                RobotFriend robotFriend = getRobotFriend(bot.getId(), friend.getId());
                //如果没有就添加进数据库
                if (robotFriend == null)
                {
                    robotFriend = new RobotFriend();
                    robotFriend.setRobotQq(bot.getId());
                    robotFriend.setQq(friend.getId());
                    mapper.insert(robotFriend);
                }
            }
        }

        //检查数据库里面的每个好友是否都是好友（有没有被删的）
        for (RobotFriend robotFriend : mapper.selectList(null))
        {
            Bot bot = Bot.getInstance(robotFriend.getRobotQq());
            if (bot == null)
            {
                continue;
            }
            Friend friend = bot.getFriend(robotFriend.getQq());
            //如果数据库里有的好友机器人没有那就删掉数据库记录
            if (friend == null)
            {
                mapper.deleteById(robotFriend.getId());
            }
        }
    }
}
