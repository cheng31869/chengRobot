package com.cheng.chengRobot.controller;

import com.cheng.chengRobot.result.RestData;
import com.cheng.chengRobot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class botsController
{
    @Autowired
    RobotService service;

    @GetMapping
    public RestData getAllBots()
    {
        service.getAllRobot();
        RestData data = new RestData();
        data.setMessage("成功");
        data.setData(service.getAllRobot());
        data.setCode(RestData.SUCCESS);
        return data;
    }
}
