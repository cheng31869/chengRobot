package com.cheng.chengRobot.dao.mappers;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.chengRobot.domain.gpt.GroupMemberWithGpt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMemberWithGptMapper
    extends BaseMapper<GroupMemberWithGpt>
{
}
