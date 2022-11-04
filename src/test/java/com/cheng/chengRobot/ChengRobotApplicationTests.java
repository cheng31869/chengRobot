package com.cheng.chengRobot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.GroupMapper;
import com.cheng.chengRobot.domain.RobotGroup;
import com.cheng.chengRobot.domain.MessageForward;
import com.cheng.chengRobot.domain.PlaygroundGame;
import com.cheng.chengRobot.service.MessageForwardService;
import com.cheng.chengRobot.service.PlaygroundGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;


@SpringBootTest
class ChengRobotApplicationTests
{

    @Autowired
    private PlaygroundGameService service;

    @Test
    public void test1()
            throws IOException, AWTException, InterruptedException
    {

    }
}
