package com.fheebiy.test;

import com.alibaba.fastjson.JSONObject;
import com.fheebiy.common.StrUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 14-7-7.
 */
public class CommTest {


    @Test
    public void valueTest() {
        String s = "20170327205653,0\n" +
                "17032720565322592";

        String[] ss = s.split("\n");

        System.out.print(ss[0]);

    }


    @Test
    public void jsonTest() {
        List<Person> list = new ArrayList<Person>();
        Person person = new Person("沧海横流", 10, "男");

        for (int i = 0; i < 10; i++) {
            list.add(person);
        }


        Object object = JSONObject.toJSON(list);

        System.out.print(object.toString());

    }

    @Test
    public void codeTest() {
        // Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(String.valueOf(generateRandomArray(6)));
        }
        //System.out.println("随机数为" + imei);
    }


    @Test
    public void tokenTest() {
        for (int i = 0; i < 10; i++) {
            String s = StrUtil.getTokenByPwd("zhoenbo132");
            System.out.println(s.trim());
        }
    }

    public static int getRandNum(int min, int max) {
        int randNum = min + (int) (Math.random() * ((max - min) + 1));
        return randNum;
    }



    @Test
    public void listTest() {
        List<String> strings = new ArrayList<String>();

        String[] sts = new String[]{"11","22","22","33"};

        for (int x = 0; x<sts.length; x++) {
            strings.add(sts[x]);
        }

        for (String s : strings) {
            if (s.equals("22")) {
                s = "zhouwenbo";
            }
        }

        System.out.print(strings.toString());


    }



    public static char[] generateRandomArray(int num) {
        String chars = "0123456789";
        char[] rands = new char[num];
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

}
