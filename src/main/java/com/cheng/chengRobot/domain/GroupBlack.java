package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@TableName("group_black_list")
@Data
public class GroupBlack
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long qq;
    private Long robotQq;
    private String groupNumber;
    private Date beBlackedTime;


}
