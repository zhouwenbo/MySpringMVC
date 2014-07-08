package com.fheebiy.test;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 14-7-7.
 */
public class CommTest {


    @Test
    public void valueTest() {
        String s = "";
        boolean is = StringUtils.isNumeric(s);
        System.out.print(is);

    }
}
