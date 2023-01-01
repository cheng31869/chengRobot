package com.cheng.chengRobot.service;


import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class ChatGptService
{
    //这个里面装gpt与某个人的聊天记录，装五个来回的。以序列的形式，消息大于十条就会把之前的消息顶出来
    private abstract class MessageMemory
    {

        private ArrayBlockingQueue messages;

        public MessageMemory()
        {
            messages = new ArrayBlockingQueue<String>(10);
        }

        //往里面加人类说的话
        public void addHumanMessage(String message)
        {
            if (messages.size() == 10)
            {
                messages.remove();
            }
            messages.add("人类:" + message);
        }

        //往里面加gpt说的话
        public void addGptMessage(String message)
        {
            if (messages.size() == 10)
            {
                messages.remove();
            }
            messages.add("gpt:" + message);
        }

        //把里面所有的消息变成文本
        public String toString()
        {
            Iterator iterator = messages.iterator();
            String str = "";
            while (iterator.hasNext())
            {
                str += (String) iterator.next();
            }

            return str;
        }
    }

    //装与群友的聊天记录，每个群友的分开装
    private class GroupMessageMemory
            extends MessageMemory
    {
        private Long groupNumber;
        private Long qq;

        public GroupMessageMemory()
        {
            super();
        }

        public GroupMessageMemory(Long groupNumber, Long qq)
        {
            super();
            this.groupNumber = groupNumber;
            this.qq = qq;
        }

        public boolean equals(Long groupNumber, Long qq)
        {
            if (this.groupNumber.equals(groupNumber) && this.qq.equals(qq))
            {
                return true;
            }
            else return false;
        }
    }

    private class FriendMessageMemory
            extends MessageMemory
    {
        private Long qq;

        public FriendMessageMemory()
        {
            super();
        }

        public FriendMessageMemory(Long qq)
        {
            super();
            this.qq = qq;
        }

        public boolean equals(Long qq)
        {
            if (this.qq.equals(qq))
            {
                return true;
            }
            else return false;
        }
    }

    //这个列表里面装与所有群友的聊天记录对象
    private List<GroupMessageMemory> groupMessages;
    //这个里面装与所有好友聊天记录对象
    private List<FriendMessageMemory> friendMessages;

    public void handleGroupMessage(GroupMessageEvent event)
    {

    }
}
