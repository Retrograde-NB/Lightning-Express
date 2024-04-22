package com.xin.log.annotation;

import com.xin.log.enums.OperationType;
import com.xin.log.enums.OperatorType;

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
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public OperationType operationType() default OperationType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;

    /**
     * 排除指定的请求参数
     */
    public String[] excludeParamNames() default {};
}
