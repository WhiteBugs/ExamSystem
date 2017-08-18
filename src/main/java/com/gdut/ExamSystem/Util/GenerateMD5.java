package com.gdut.ExamSystem.Util;

import java.security.MessageDigest;

public class GenerateMD5 {

	public static String getMD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};        
        try {
            byte[] btInput = s.getBytes("utf-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            byte[] md = mdInst.digest(btInput);
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                //byte是8位
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];//取byte高4位转化为二进制数
                str[k++] = hexDigits[byte0 & 0xf];//取byte低4位转化为二进制数
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
