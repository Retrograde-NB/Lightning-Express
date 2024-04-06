package com.xin.gateway.service;

import java.util.Map;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 2:12
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface VerificationCodeService {
    public Map<String, Object> createVerificationCode();
    public void checkVerificationCode(String code, String uuid);
}
