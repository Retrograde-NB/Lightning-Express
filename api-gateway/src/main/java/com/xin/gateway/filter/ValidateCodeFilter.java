package com.xin.gateway.filter;

import com.xin.common.exception.XinException;
import com.xin.common.utils.WebResponseUtils;
import com.xin.gateway.service.VerificationCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

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
                return WebResponseUtils.webResponse(exchange.getResponse(), e.getMessage());
            }
            return chain.filter(exchange);
        };
    }
}
