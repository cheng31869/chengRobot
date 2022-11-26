package com.cheng.chengRobot.domain.gpt;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

//群友和gpt的聊天记录
@Data
public class GroupMemberWithGpt
{
    @TableId
    private Integer id;
    private Long robotQq;
    private Long groupNumber;
    private Long qq;
    private Date time;
    private String message;

}
