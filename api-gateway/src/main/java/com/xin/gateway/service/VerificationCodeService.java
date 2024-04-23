package com.xin.gateway.service;

import java.util.Map;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 2:12
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface VerificationCodeService {
    /**
     * 生成验证码图片
     *
     * @return 验证码参数
     */
    public Map<String, Object> createVerificationCode();

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid 唯一标识
     */
    public void checkVerificationCode(String code, String uuid);
}
