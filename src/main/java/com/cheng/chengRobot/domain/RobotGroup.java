package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@TableName("robot_group")
@Data
public class RobotGroup
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long robotQq;
    private Long groupNumber;
    private String groupName;
    private Boolean playgroundManager;
    private Boolean chatGpt;
}
