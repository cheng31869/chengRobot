package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@TableName("group_members")
@Data
public class GroupMember
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Long qq;
    private Long robotQQ;
    private Long groupNumber;
    private String nameInGroup;
    private String nickName;
    private Date lastSpeakTime;
    private String welcomeWord;
    private Integer money;

}
