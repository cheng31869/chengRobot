package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@TableName("robots")
@Data
public class Robot
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long qq;
    private String password;
    private String cachePath;

    //消息转发功能开关
    private Boolean messageForward;

    //操场管理功能开关
    private Boolean playgroundManager;
}
