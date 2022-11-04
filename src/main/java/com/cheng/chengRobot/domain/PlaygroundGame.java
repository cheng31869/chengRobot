package com.cheng.chengRobot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("playground_games")
@Data
public class PlaygroundGame
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String howToPlay;
}
