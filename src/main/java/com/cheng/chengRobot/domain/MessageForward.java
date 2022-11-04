package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@TableName("message_forward")
@Data
public class MessageForward
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long fromRobotQq;
    private Long fromGroup;
    private Long fromGroupMember;
    private Long toRobotQq;
    private Long toGroup;
    private Long toQq;
    private String fix;
    private Boolean active;

}
