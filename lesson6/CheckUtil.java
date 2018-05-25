package com.ruite.app.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.ruite.configure.Tips;

/**
 * APP验签函数
 * 
 * @author FangZhiyang
 *
 */
public class CheckUtil {
	private static final String TOKEN = "scu-app-version-1.0";
	public static final String TOKEN1 = "scu-ykt-version-1.0";

	public static String checkSignature(String signature, String timestamp, String nonce) {
//		Calendar now = Calendar.getInstance();
//		long nowTime = now.getTimeInMillis();
//		long timeElapse = (nowTime - Long.valueOf(timestamp)) / 1000;
//		if (timeElapse > 2 * 60 * 60)
//			return "请求已过期";

		String temp = generateSignature(timestamp, nonce, TOKEN);
		if (!temp.equals(signature))
			return Tips.PARAMS_ERROR;
		return "ok";
	}

	public static String generateSignature(String timestamp, String nonce, String tt) {
		String[] arr = new String[] { tt, timestamp, nonce };
		Arrays.sort(arr);

		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		return getSha1(content.toString());
	}

	public static String getSha1(String str) {
		if (null == str || 0 == str.length()) {
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] buf = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
