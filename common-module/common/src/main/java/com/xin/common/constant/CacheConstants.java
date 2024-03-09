package com.xin.common.constant;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 1:02
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class CacheConstants {
    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";
    /**
     * 登录IP黑名单 cache key
     */
    public static final String SYS_LOGIN_BLACKIPLIST = SYS_CONFIG_KEY + "sys.login.blackIPList";
    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";
}
