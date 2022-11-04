package com.cheng.chengRobot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.GroupBlackMapper;
import com.cheng.chengRobot.dao.mappers.GroupMapper;
import com.cheng.chengRobot.dao.mappers.GroupMemberMapper;
import com.cheng.chengRobot.domain.GroupBlack;
import com.cheng.chengRobot.domain.GroupMember;
import com.cheng.chengRobot.domain.RobotGroup;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.awt.geom.PathIterator;
import java.util.List;

@Service
public class GroupService
{
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupMemberService groupMemberService;

    @Autowired
    private GroupBlackService groupBlackService;

    @Autowired
    private GroupBlackMapper groupBlackMapper;

    public List<RobotGroup> getGroup()
    {
        return groupMapper.selectList(null);
    }

    public RobotGroup getGroup(Integer id)
    {
        return groupMapper.selectById(id);
    }

    public RobotGroup getGroup(Long robotQQ, Long groupNumber)
    {
        QueryWrapper<RobotGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("robot_qq", robotQQ);
        queryWrapper.eq("group_number", groupNumber);
        return groupMapper.selectOne(queryWrapper);
    }

    public int deleteGroup(Long robotQQ, Long groupNumber)
    {
        //先清空此群的群员列表和黑名单列表再删除此群
        //清空群员列表
        groupMemberService.deleteGroupMember(robotQQ,groupNumber,null);
        //清空黑名单列表
        groupBlackService.deleteGroupBlack(robotQQ,groupNumber, null);
        QueryWrapper<RobotGroup> wrapper = new QueryWrapper<>();
        wrapper.eq("robot_qq", robotQQ);
        wrapper.eq("group_number", groupNumber);
        return groupMapper.delete(wrapper);
    }


    //刷新数据库里面的群列表
    public void flushGroupListToDB()
    {

        //循环刷新每个机器人的群列表
        for (Bot bot : Bot.getInstances())
        {
            for (Group group : bot.getGroups())
            {
                //判断数据库里是否有这个群
                RobotGroup selectOne =getGroup(bot.getId(),group.getId());

                //没有这个群就添加进去
                if (selectOne == null)
                {
                    selectOne = new RobotGroup();
                    selectOne.setId(null);
                    selectOne.setRobotQq(bot.getId());
                    selectOne.setGroupNumber(group.getId());
                    selectOne.setGroupName(group.getName());
                    groupMapper.insert(selectOne);
                }
            }

            // 循环判断数据库里面的群列表机器人是否都加了
            QueryWrapper<com.cheng.chengRobot.domain.RobotGroup> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("robot_qq", bot.getId());
            for (com.cheng.chengRobot.domain.RobotGroup select : groupMapper.selectList(queryWrapper))
            {
                //,如果没加,把群从数据库里面删除
                if (bot.getGroup(select.getGroupNumber()) == null)
                {


                    //删除群在数据库中的记录
                    deleteGroup(bot.getId(), select.getGroupNumber());
                }
            }

        }
    }

    public boolean isPlaygroundManagerOpen(Long robotQq,Long groupNumber)
    {
        RobotGroup group = getGroup(robotQq, groupNumber);
        if (group == null)
        {
            return false;
        }
        else
        {
            return group.getPlaygroundManager();
        }
    }

}
