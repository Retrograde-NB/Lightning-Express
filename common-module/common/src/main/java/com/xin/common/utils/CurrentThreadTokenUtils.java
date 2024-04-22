package com.xin.common.utils;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/20 下午 5:11
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 暂时存放当前线程的token
 */
public class CurrentThreadTokenUtils {
    private static CurrentThreadTokenUtils currentThreadTokenUtils = new CurrentThreadTokenUtils();

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private CurrentThreadTokenUtils(){
    }

    public static CurrentThreadTokenUtils getCurrentThreadTokenUtils(){
        return currentThreadTokenUtils;
    }
}
