package com.cheng.chengRobot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.MessageForwardMapper;
import com.cheng.chengRobot.domain.MessageForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageForwardService
{
    @Autowired
    MessageForwardMapper messageForwardMapper;

    //根据收消息机器人qq号，群号和群员号获取转发信息
    public List<MessageForward> getMessageForward(Long fromRobotQq, Long fromQq, Long fromGroup, Long fromGroupMember)
    {
        QueryWrapper<MessageForward> messageForwardQueryWrapper = new QueryWrapper<>();
        Map<String, Long> map = new HashMap<>();
        map.put("from_robot_qq", fromRobotQq);
        map.put("from_qq", fromQq);
        map.put("from_group", fromGroup);
        map.put("from_group_member", fromGroupMember);
        messageForwardQueryWrapper.allEq(map);

        return messageForwardMapper.selectList(messageForwardQueryWrapper);
    }

}
