package com.cheng.chengRobot.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cheng.chengRobot.domain.Robot;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface RobotMapper
    extends BaseMapper<Robot>
{

}
