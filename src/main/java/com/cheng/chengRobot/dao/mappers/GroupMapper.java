package com.cheng.chengRobot.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.chengRobot.domain.RobotGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper
    extends BaseMapper<RobotGroup>
{
}
