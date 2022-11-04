package com.cheng.chengRobot.bean;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceConfig
{
    @Autowired
    ConfigurableEnvironment environment;

    @Bean
    public DataSource getDruidDataSource()
    {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//        druidDataSource.setName();
        druidDataSource.setUsername(environment.getProperty("spring.datasource.name"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        return druidDataSource;
    }
}
