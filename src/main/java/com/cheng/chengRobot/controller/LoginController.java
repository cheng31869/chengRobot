package com.cheng.chengRobot.controller;


import com.cheng.chengRobot.domain.Administrator;
import com.cheng.chengRobot.result.RestData;
import com.cheng.chengRobot.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping()
public class LoginController
{
    @Autowired
    public AdministratorService service;

    @PostMapping("/login")
    @ResponseBody()
    public RestData login(String username, Integer password, HttpServletRequest request)
    {
        System.out.println(username);
        RestData result = new RestData();
        if (username == null || password == null)
        {
            result.setCode(RestData.LESS_INFO);
            result.setMessage("请输入用户名与密码");
            return result;
        }
        Administrator administrator = service.getAdministrator(username, password);
        if (administrator == null)
        {
            result.setCode(RestData.WRONG_PASSWORD);
            result.setMessage("用户名或密码错误");
            return result;
        }
        
        request.getSession().setAttribute("administrator",administrator);
        result.setCode(RestData.SUCCESS);
        result.setMessage("登陆成功");
        return result;
    }
}
