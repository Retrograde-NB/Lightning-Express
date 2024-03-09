package com.xin.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/09 下午 3:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class MD5Utils {
    public static String transToMD5(String password) {

        try {
            //获取消息摘要对象
            MessageDigest md = MessageDigest.getInstance("md5");
            //通过MD5计算摘要，返回byte数组形式
            byte [] b=md.digest(password.getBytes());
            /*
             * Base64算法将 byte数组转换成可保存的字符串（a-z A-Z 0-9 * /）形式
             */
            String str = Base64.getEncoder().encodeToString(b);
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
