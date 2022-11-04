package com.cheng.chengRobot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.GroupMemberMapper;
import com.cheng.chengRobot.domain.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberService
{
    @Autowired
    private GroupMemberMapper groupMemberMapper;

/*    public int addGroupMember()
    {

    }*/
    public int deleteGroupMember(Long robotQQ, Long groupNumber,Long qq)
    {
        QueryWrapper<GroupMember> wrapper = new QueryWrapper<>();
        wrapper.eq("robot_qq", robotQQ);
        wrapper.eq("group_number", groupNumber);
        wrapper.eq("qq", qq);
        return groupMemberMapper.delete(wrapper);
    }
}
