package com.xiaojiang.putongxiaohai.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/03/10:49
 * @QQ群: 807092830
 * @Description: 加密工具类，防止用户输入密码，在传输密码的时候被抓包工具获取密码
 */
public class MD5Utils {

    /**
     * 直接调用code()函数加密即可
     * @param str
     * @return
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(code("jiang0406"));
    }

}
