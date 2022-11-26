package com.cheng.chengRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<Integer> priceList = new ArrayList<>();
        List<Integer> likeList = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            priceList.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++)
        {
            likeList.add(scanner.nextInt());
        }
        List<Gift> commodity = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            commodity.add(new Gift(priceList.get(i), likeList.get(i)));
        }
        List<List<Gift>> giftsLIst = new ArrayList<>();
        for (int i = 0; i < commodity.size(); i++)
        {
            giftsLIst.addAll(getGiftsList(commodity.size() - i, commodity));
        }
        int maxLike = 0;
        for (List<Gift> gifts : giftsLIst)
        {
            if (getPrice(gifts) <= m)
            {
                boolean canBeGift = true;
                int like = getLike(gifts);
                String likeStr = String.valueOf(like);
                for (int i = 0; i < likeStr.length(); i++)
                {
                    int value = Integer.valueOf(String.valueOf(likeStr.charAt(i)));
                    canBeGift = (value == 0) || (value == 1) || (value == 3) || (value == 7) || (value == 9) ? canBeGift : false;
                }
                if (canBeGift)
                {
                    maxLike = maxLike < like ? like : maxLike;
                }
            }
        }
        System.out.print(maxLike);


    }

    public static int getPrice(List<Gift> gifts)
    {
        int price = 0;
        for (Gift gift : gifts)
        {
            price += gift.getPrice();
        }
        return price;
    }

    public static int getLike(List<Gift> gifts)
    {
        int like = 0;
        for (Gift gift : gifts)
        {
            like += gift.getLike();
        }
        return like;
    }

    public static List<List<Gift>> getGiftsList(int n, List<Gift> commodity)
    {
        List<List<Gift>> giftsList = new ArrayList<>();
        if (n == 1)
        {
            for (int i = 0; i < commodity.size(); i++)
            {
                List<Gift> gifts = new ArrayList<>();
                gifts.add(commodity.get(i));
                giftsList.add(gifts);
            }
        }
        else if (n > 1)
        {
            for (int i = 0; i < commodity.size() - n + 1; i++)
            {
                for (List<Gift> gifts1 : getGiftsList(n - 1, commodity.subList(i + 1, commodity.size())))
                {
                    List<Gift> gifts = new ArrayList<>();
                    gifts.add(commodity.get(i));
                    gifts.addAll(gifts1);
                    giftsList.add(gifts);
                }
            }
        }
        return giftsList;
    }
}

class Gift
{
    private int price, like;

    public Gift(int price, int like)
    {
        this.price = price;
        this.like = like;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getLike()
    {
        return like;
    }

    public void setLike(int like)
    {
        this.like = like;
    }
}



