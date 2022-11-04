package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("administrator")
@Data
public class Administrator
{
    @TableId
    private int id;
    private String username;
    private String password;
}
