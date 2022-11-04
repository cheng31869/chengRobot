package com.cheng.chengRobot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cheng.chengRobot.dao.mappers.PlaygroundGameMapper;
import com.cheng.chengRobot.domain.PlaygroundGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundGameService
{

    @Autowired
    private PlaygroundGameMapper mapper;

    public PlaygroundGame getPlaygroundGame(int id)
    {
        return mapper.selectById(id);
    }

    public List<PlaygroundGame> getPlaygroundGame()
    {
        return mapper.selectList(null);
    }

    //根据玩法名称获取玩法
    public List<PlaygroundGame> getPlaygroundGame(String name)
    {
        QueryWrapper<PlaygroundGame> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);

        return mapper.selectList(wrapper);
    }

    public void addNewGame(PlaygroundGame game)
    {
        mapper.insert(game);
        return;
    }
}
