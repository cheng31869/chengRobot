package com.cheng.chengRobot.result;

import lombok.Data;

@Data
public class RestData
{
    public static int LOGIN_SUCCESS = 10;
    public static int WRONG_PASSWORD = 10;
    public static int LESS_INFO = 10;

    public int code;
    public String message;
    public Object data;
}
