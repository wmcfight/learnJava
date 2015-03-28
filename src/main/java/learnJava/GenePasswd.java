/*
 * Copyright 2014 Renren.com All right reserved. This software is the
 * confidential and proprietary information of Renren.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Renren.com.
 */
package learnJava;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * Descriptions of the class GenePasswd.java's implementation��TODO described the implementation of class
 * @author wmc 2014��5��16�� ����10:18:38
 */
public class GenePasswd {
	private static final String PASSWORD_DIG = "4d6e6d7f52798";

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String digest = SHAUtil.sha1(PASSWORD_DIG, "654321");
		System.out.println(digest);
	}
}

abstract class SHAUtil {

    /**
     * 对输入的字符串列表产生SHA签名
     *
     * @param plainTexts 用来产生SHA签名的字符串列表
     * @return 输入字符串列表的SHA签名
     * @throws NoSuchAlgorithmException 当用户的JDK不支持SHA哈希算法时
     * @throws UnsupportedEncodingException 当输入的字符串不是UTF-8编码时
     */
    public static final String sha1(String... plainTexts) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        for (String plainText : plainTexts) {
            md.update(plainText.getBytes("UTF-8"));
        }
        byte bytes[] = md.digest();

        return Base16Util.byteToBase16(bytes);
    }

    /**
     * 根据输入的SHA签名和字符串列表进行校验
     *
     * @param sha1 用来进行校验的SHA签名
     * @param plainTexts 用来进行校验的字符串列表
     * @return 如果通过返回true，失败返回false
     * @throws NoSuchAlgorithmException 当用户的JDK不支持SHA哈希算法时
     * @throws UnsupportedEncodingException 当输入的字符串不是UTF-8编码时
     */
    public static final boolean sha1Check(String sha1, String... plainTexts) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA");
        for (String plainText : plainTexts) {
            md.update(plainText.getBytes("UTF-8"));
        }
        byte bytes[] = md.digest();

        return Base16Util.byteToBase16(bytes).equalsIgnoreCase(sha1);
    }

}

abstract class Base16Util {

    /**
     * 将byte数组转换成16进制字符串
     *
     * @param bytes 待转换的byte数组
     * @return 转换后的16进制字符串
     * @throws IllegalArgumentException 假如byte数组是null
     */
    public static final String byteToBase16(byte[] bytes) {
        if (bytes == null)
            throw new IllegalArgumentException("The parameter should not be null!");
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Integer.toHexString((b & 0xF0) >> 4));
            sb.append(Integer.toHexString(b & 0x0F));
        }
        return sb.toString();
    }

    /**
     * 将16进制字符串转换成byte数组
     *
     * @param str 待转换的16进制字符串
     * @return 转换后的byte数组，假如待转换的16进制字符串不可以被2整除则返回空数组
     * @throws IllegalArgumentException 假如输入字符串是null
     * @throws NumberFormatException 假如待转换的16进制字符串含有不可以解析成16进制数字的字符
     */
    public static final byte[] base16toByte(String str) {
        if (str == null)
            throw new IllegalArgumentException("The parameter should not be null!");
        if (str.length() % 2 != 0) {
            return new byte[] {};
        } else {
            char[] hex = str.toCharArray();
            byte[] bytes = new byte[hex.length / 2];
            for (int i = 0, j = 0; i < hex.length; i += 2, ++j) {
                bytes[j] = (byte) ((Integer.parseInt(String.valueOf(hex[i]), 16) << 4) | (Integer.parseInt(String
                        .valueOf(hex[i + 1]), 16)));
            }
            return bytes;
        }
    }




}

