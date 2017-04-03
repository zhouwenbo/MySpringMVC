package com.fheebiy.common.smsgcode;


import org.apache.commons.lang.StringUtils;

public class HttpSender {

	public static final int MIN = 1;

	public static final int MAX = 999999;

	public static String sendSMS(String phone) {
		String code = String.valueOf(generateRandomArray(6));;
		String url = "http://sms.253.com/msg/";// 应用地址
		String un = "N8839264";// 账号
		String pw = "Dzo4Zfpnb";// 密码
		String msg = "【爱校】您好，您的验证码是"+ code;// 短信内容
		String rd = "0";// 是否需要状态报告，需要1，不需要0
		String ex = null;// 扩展码

		try {
			String returnString = HttpMsgSend.batchSend(url, un, pw, phone, msg, rd, ex);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx_____________"+returnString);
			if (StringUtils.isNotEmpty(returnString)) {
				System.out.println("1111111111111111");
				String[] array = returnString.split("\n");
				if (array.length > 0) {
					System.out.println("222222222222222222222");
					String ss  = array[0];
					if (StringUtils.isNotEmpty(ss)) {
						String[] array2 = ss.split(",");
						if (array2.length > 1) {
							String resultCode = array2[1];
							System.out.println("____________xxxxxx----------------resuleCode = "+ resultCode);
							if ("0".equals(resultCode)) {
								System.out.println("3333333333333333333333333");
								return code;
							}
						}
					}
				}
			}

			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
		System.out.println("44444444444444444444444444");
		return "-1";
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