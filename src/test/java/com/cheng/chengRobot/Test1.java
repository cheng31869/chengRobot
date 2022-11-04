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

        String str = "Nowadays, going abroad for studies is enjoying a striking popularity among adolescents. " +
                "Importance should be attached to studying abroad.\n" +
                "There are a great many advantages of studying overseas. First and foremost, living and studying " +
                "abroad offers students a different perspective of the world. On a university campus, international " +
                "students are likely to encounter their counterparts from various countries and areas and are exposed" +
                " to perse ideas and values. What is more, overseas experience is the best opportunity for the " +
                "real-life use of foreign languages. There is no better opportunity to improve second-language skills" +
                " than living in the country in which it is spoken.\n" +
                "Generally peaking, it is my view that although going abroad is expensive and perhaps painful, the " +
                "payoff is worthwhile. In the first place, in addition to knowledge, overseas students can gain " +
                "precious experiences that those who stay at home will never have. Furthermore, overseas experience, " +
                "frustrating and painful as it may be, is conducive to the growth of adolescents.";
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
        String s = "a";
        System.out.println(s.codePointAt(0));
    }
}
