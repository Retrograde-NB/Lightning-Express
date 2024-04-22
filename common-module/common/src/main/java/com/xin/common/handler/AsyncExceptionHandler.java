package com.xin.common.handler;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/22 下午 8:04
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        // 你可以在这里处理异常，比如记录到日志或发送警报
        System.err.println("在方法 " + method.getName() + " 中发生了一个未捕获的异常:");
        ex.printStackTrace();

        // 如果需要，你可以根据方法或参数的信息来定制异常处理逻辑
        // 例如，可以记录方法的参数或调用上下文信息
        for (Object param : params) {
            System.err.println("参数: " + param);
        }
        // 你也可以将异常信息发送到监控系统或通知相关人员
    }
}
