package com.fheebiy.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("随机数为" + getRandNum(1, 999999));
    }


    public static int getRandNum(int min, int max) {
        int randNum = min + (int) (Math.random() * ((max - min) + 1));
        return randNum;
    }


}
