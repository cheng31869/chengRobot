package com.cheng.chengRobot.domain.gpt;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

//机器人的好友与gpt的聊天记录
@Data
public class FriendWithGpt
{
    @TableId
    private Integer id;
    private Long robotQq;
    private Long qq;
    private Date time;
    private String message;
}
