package com.cheng.chengRobot.result;

import lombok.Data;

@Data
public class RestData
{
    public static int SUCCESS = 10;
    public static int WRONG_PASSWORD = 11;
    //缺少信息
    public static int LESS_INFO = 12;


    public int code;
    public String message;
    public Object data;
}
