package com.cheng.chengRobot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.AdministratorMapper;
import com.cheng.chengRobot.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService
{
    @Autowired
    private AdministratorMapper mapper;

    public Administrator getAdministrator(String username, int password)
    {
        QueryWrapper<Administrator> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);

        return mapper.selectOne(wrapper);
    }
}
