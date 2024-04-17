package com.xin.log.annotation;

import java.lang.annotation.*;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/17 下午 1:57
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 自定义操作日志注解
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
