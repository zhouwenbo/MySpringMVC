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
       char[] chars = new char[]{'a','b','b'};


       System.out.print(String.valueOf(chars));

    }


    @Test
    private void jsonTest(){
        List<Person> list = new ArrayList<Person>();

        Person person = new Person("沧海横流",10,"男");

        for(int i = 0; i < 10; i++){
            list.add(person);
        }


        Object object = JSONObject.toJSON(list);

        System.out.print(object.toString());

    }





}
