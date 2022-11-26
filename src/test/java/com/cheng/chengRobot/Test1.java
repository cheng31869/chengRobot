package com.cheng.chengRobot;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Test1
{
    public static void main(String[] args)
            throws AWTException, InterruptedException
    {
        Robot robot = new Robot();
                Thread.sleep(1500);

        String str = "Technology: Blessing Or Curse Different people have different views whether the technology is a blessing or a curse. In my opinion, in the history of modern human civilization, technology has played an indispensable role. And it has also been living and social prosperity of the first driving force. So, I tend to support the idea that technology is mainly blessing for us." +
                "First of all, science and technology make our lives easier, more convenient than ever in the past and fascinating. For example, most of us no longer need to worry about assistance under the food. Instead, we offer a variety of tasty and nutritious foods. Household appliances, computers, modern transport and communications have revolutionized our lives in different ways. More importantly, technology allows us to choose the way diversified entertainment and education in a different selection." +
                "In addition to the contribution of technology, our society is essential to our economy. With the development of technology , it creates an opportunity for wealth and vacancies. More important is amazing, it is to meet people dream of getting rich overnight. On the other hand, it allows us to increase productivity levels, which led to the ever-large quantity of goods and services. Considering these factors,it is no doubt that we bring the benefits of science and technology are greater than problems. Therefore,we think that the blessing of technology is for human being.";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.codePointAt(i) >= 97 && str.codePointAt(i) <= 122)
            {
//                System.out.println((str.codePointAt(i)));
                robot.keyPress(str.codePointAt(i) - 32);
                robot.keyRelease(str.codePointAt(i) - 32);
            }
            else if (str.codePointAt(i) >= 65 && str.codePointAt(i) <= 90)
            {
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(str.codePointAt(i));
                robot.keyRelease(str.codePointAt(i));
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            else if (",".equals(new String(new char[]{str.charAt(i)})))
            {
                robot.keyPress(KeyEvent.VK_COMMA);
                robot.keyRelease(KeyEvent.VK_COMMA);
            }
            else if ("-".equals(new String(new char[]{str.charAt(i)})))
            {
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
            }
            else if (".".equals(new String(new char[]{str.charAt(i)})))
            {
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
            }
            else if ("\n".equals(new String(new char[]{str.charAt(i)})))
            {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
            else if (" ".equals(new String(new char[]{str.charAt(i)})))
            {
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
            }
        }
    }
}

