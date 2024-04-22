package com.xin.common.config;

import com.xin.common.handler.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/20 下午 4:00
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * async开启异步配置
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    /**
     * 实现 AsyncConfigurer 接口中的 getAsyncExecutor 方法
     * @return 配置好的线程池执行器
     */
    @Override
    public Executor getAsyncExecutor() {
        // 创建一个 ThreadPoolTaskExecutor 实例
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心线程数，即线程池维持的最小线程数
        executor.setCorePoolSize(5);

        // 设置最大线程数，即线程池允许的最大线程数
        executor.setMaxPoolSize(10);

        // 设置队列容量，即当线程池中的线程数达到最大时，新提交的任务将保存在此队列中
        executor.setQueueCapacity(25);

        // 初始化线程池
        executor.initialize();

        // 返回配置好的线程池执行器
        return executor;
    }

    // AsyncConfigurer 接口中还有一个 getAsyncUncaughtExceptionHandler 方法，
    // 用于处理异步任务执行过程中未捕获的异常。默认情况下，如果不实现此方法，
    // 异步任务中的未捕获异常将被记录到日志中，但不会传播给调用线程。
    // 如果你需要处理这些异常，你可以重写这个方法，并提供一个自定义的 AsyncUncaughtExceptionHandler。

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }
}
