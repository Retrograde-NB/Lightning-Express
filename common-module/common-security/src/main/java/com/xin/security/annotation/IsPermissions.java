package com.xin.security.annotation;

import com.xin.security.enums.VerificationMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 上午 10:32
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface IsPermissions {
    /**
     * 需要校验的权限码
     */
    String[] value() default {};
    /**
     * 验证模式：AND | OR，默认AND
     */
    VerificationMode verificationMode() default VerificationMode.AND;
}
