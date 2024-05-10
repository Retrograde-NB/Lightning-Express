package com.xin.security.aspect;

import com.xin.security.annotation.IsPermissions;
import com.xin.security.utils.CheckUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author Retrograde-LX
 * @Date 2024/05/10 下午 1:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Aspect
@Component
public class IsPermissionsAspect {

    @Autowired
    private CheckUtils checkUtils;

    /**
     * 构建
     */
    public IsPermissionsAspect() {
    }

    /**
     * 定义AOP签名 (切入所有使用鉴权注解的方法)
     * //public static final String POINTCUT_SIGN = " @annotation(com.ruoyi.common.security.annotation.RequiresLogin) || "
     * //        + "@annotation(com.ruoyi.common.security.annotation.RequiresPermissions) || "
     * //        + "@annotation(com.ruoyi.common.security.annotation.RequiresRoles)";
     */
    public static final String POINTCUT_SIGN = "@annotation(com.xin.security.annotation.IsPermissions)";

    /**
     * 声明AOP签名
     */
    @Pointcut(POINTCUT_SIGN)
    public void pointcut() {
    }

    /**
     * 环绕切入
     *
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解鉴权
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        checkMethodAnnotation(signature.getMethod());
        try {
            // 执行原有逻辑
            Object obj = joinPoint.proceed();
            return obj;
        } catch (Throwable e) {
            throw e;
        }
    }

    /**
     * 对一个Method对象进行注解检查     暂时只考虑权限
     */
    public void checkMethodAnnotation(Method method) {
        // 校验 @RequiresPermissions 注解
        IsPermissions isPermissions = method.getAnnotation(IsPermissions.class);
        if (isPermissions != null) {
            checkUtils.checkPermissions(isPermissions);
        }
    }
}
