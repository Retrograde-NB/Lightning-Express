package com.xin.gateway.filter;

import com.alibaba.fastjson2.JSON;
import com.xin.common.exception.XinException;
import com.xin.common.result.ResponseResult;
import com.xin.gateway.service.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 2:34
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 验证码过滤器
 */
@Component
public class ValidateCodeFilter extends AbstractGatewayFilterFactory<Object> {
    private final static String[] VALIDATE_URL = new String[]{"/api/auth/admin/login"};

    private static final String CODE = "code";

    private static final String UUID = "uuid";

    private final VerificationCodeService verificationCodeService;

    public ValidateCodeFilter(VerificationCodeService verificationCodeService) {
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            // 非后台登录请求，不处理
            if (!StringUtils.containsAnyIgnoreCase(request.getURI().getPath(), VALIDATE_URL)) {
                return chain.filter(exchange);
            }
            try {
                String code = Objects.requireNonNull(request.getHeaders().get(CODE)).get(0);
                String uuid = Objects.requireNonNull(request.getHeaders().get(UUID)).get(0);
                verificationCodeService.checkVerificationCode(code, uuid);
            } catch (XinException e) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.OK);
                response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                ResponseResult<?> result = ResponseResult.fail(ResponseResult.FAIL, e.getMessage());
                DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
                return response.writeWith(Mono.just(dataBuffer));
            }
            return chain.filter(exchange);
        };
    }
}
