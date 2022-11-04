package com.cheng.chengRobot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.GroupBlackMapper;
import com.cheng.chengRobot.domain.GroupBlack;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupBlackService
{

    @Autowired
    private GroupBlackMapper mapper;

    public int deleteGroupBlack(Long robotQQ, Long groupNumber, Long qq)
    {
        QueryWrapper<GroupBlack> wrapper = new QueryWrapper<>();
        wrapper.eq("robot_qq", robotQQ);
        wrapper.eq("group_number", groupNumber);
        wrapper.eq("qq", qq);
        return mapper.delete(wrapper);
    }
}
