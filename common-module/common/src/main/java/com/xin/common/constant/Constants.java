package com.xin.common.constant;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 2:11
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 通用常量信息
 */
public class Constants {
    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.xin" };
    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";
    /**
     * token
     */
    public static final String TOKEN = "token";
    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

}
