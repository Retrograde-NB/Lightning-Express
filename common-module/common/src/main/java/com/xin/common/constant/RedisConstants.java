package com.xin.common.constant;

import org.springframework.cloud.client.loadbalancer.LoadBalancerProperties;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/31 下午 2:28
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * redis常量
 */
public class RedisConstants {
    /**
     * 权限
     */
    public static final String PERMISSION_KEY = "permission:";
    /**
     * 角色
     */
    public static final String ROLE_KEY = "role:";
    /**
     * 动态路由
     */
    public static final String ROUTES_KEY = "routes:";
    /**
     * token 用户token
     */
    public static final String ADMIN_TOKEN_KEY = "admin-token:";
    /**
     * 验证码
     */
    public static final String VERIFICATION_CODE_KEY = "verification-code:";
    /**
     * 当前用户存储token
     */
    public static final String TOKEN = "token";
}
