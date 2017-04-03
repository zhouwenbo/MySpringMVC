package com.fheebiy.common;

/**
 * Created by cm on 2017/3/29.
 */
public class StrUtil {

    public static final String SALT = "LOVE_SHCOOLE";

    public static String getTokenByPwd(String pwd) {
        return MD5Util.encode(pwd, SALT).trim();
    }

}
