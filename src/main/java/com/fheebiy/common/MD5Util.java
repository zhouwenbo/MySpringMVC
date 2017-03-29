package com.fheebiy.common;

import java.security.MessageDigest;

/**
 * Created by cm on 2017/3/29.
 */
public class MD5Util {


    /**
     * MD5普通加密
     *
     * @param rawPass
     *            明文
     * @return
     */
    public final static String encode(String rawPass) {
        return encode(rawPass, null);
    }

    /**
     * * MD5盐值加密
     *
     * @param rawPass
     *            明文
     * @param salt
     *            盐值
     * @return
     */
    public final static String encode(String rawPass, Object salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
            return new String(encode(digest));
        } catch (Exception e) {
            return rawPass;
        }
    }

    /**
     *
     * 拼接密码与盐值
     *
     * @param password
     * @param salt
     *
     * @return 密码{盐值}
     */
    private static String mergePasswordAndSalt(String password, Object salt) {
        if (salt == null || "".equals(salt.toString().trim())) {
            return password;
        }
        return password + salt.toString();
    }

    /**
     * encode
     *
     * @param bytes
     * @return
     */
    private static char[] encode(byte[] bytes) {
        char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
                'f' };
        int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];
        int j = 0;
        for (int i = 0; i < nBytes; i++) { // Char for top 4 bits result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];

            // Bottom 4
            result[j++] = HEX[(0x0F & bytes[i])];
        }
        return result;
    }

    /**
     * Test
     *
     * @param args
     * */
    public static void main(String[] args) {
        // 21232f297a57a5a743894a0e4a801fc3
        System.out.println(MD5Util.encode("admin"));
        System.out.println(MD5Util.encode("admin", "zhanqi"));
    }
}
