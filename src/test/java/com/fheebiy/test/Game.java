package com.fheebiy.test;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by bob zhou on 14-6-18.
 */
public class Game {

    private int[] array = {1, 2, 3}; //石头，剪刀，布

    private String[] result = {"你赢了!", "电脑赢了!", "出拳一样，未分胜负!", "出错了!"};

    public int getPcNum() {
        Random random = new Random();
        int i = random.nextInt(3);
        return array[i];
    }


    public int getYourNum() {
        while (true) {
            System.out.println("请输入1或2或3");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            int num = 0;
            try {
                num = Integer.parseInt(str);
                if (num > 3 || num < 1) {
                    System.out.println("输入错误，请重新输入！");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输入！");
            }
        }
    }


    public String getResult(int yourNum, int pcNum) {
        if (yourNum == pcNum) {
            return result[2];
        }

        if (yourNum == 1) {
            switch (pcNum) {
                case 2:
                    return result[0];
                case 3:
                    return result[1];
            }
        }

        if (yourNum == 2) {
            switch (pcNum) {
                case 1:
                    return result[1];
                case 3:
                    return result[0];
            }
        }

        if (yourNum == 3) {
            switch (pcNum) {
                case 1:
                    return result[0];
                case 2:
                    return result[1];
            }
        }
        return result[3];
    }


    public static void main(String[] args) {
        while (true){
            Game game = new Game();
            int yourNum = game.getYourNum();
            int pcNum = game.getPcNum();
            String result = game.getResult(yourNum,pcNum);
            System.out.print(result);
            System.out.println("继续请输入y，其他任意键退出.");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(!str.equalsIgnoreCase("y")){
                break;
            }
        }
    }



}
