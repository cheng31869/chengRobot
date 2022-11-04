package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("robot_friend")
@Data
public class RobotFriend
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long robotQq;
    private Long Qq;
    private String nickName;
    private String remark;
    private Boolean playgroundManager;

}
