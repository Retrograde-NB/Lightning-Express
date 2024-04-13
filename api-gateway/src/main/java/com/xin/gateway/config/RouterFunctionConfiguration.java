package com.xin.gateway.config;

import com.xin.gateway.handler.CaptchaImageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 1:53
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Configuration
public class RouterFunctionConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routeFunction(CaptchaImageHandler captchaImageHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/api/code")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), captchaImageHandler::handle);
    }
}
