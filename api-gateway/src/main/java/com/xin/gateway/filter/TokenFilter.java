package com.xin.gateway.filter;

import com.xin.common.constant.RedisConstants;
import com.xin.common.redis.service.RedisService;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.StringUtils;
import com.xin.common.utils.WebResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/14 下午 2:11
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * token过滤器  GlobalFilter不需要配置
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);

    public TokenFilter(RedisService redisService) {
        this.redisService = redisService;
    }
    private final static List<String> TOKEN_URL = new ArrayList<>(Arrays.asList("/api/auth/admin/login","/api/code"));

    private final RedisService redisService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        // 跳过不需要验证的路径
        if (StringUtils.matches(url, TOKEN_URL)) {
            return chain.filter(exchange);
        }
        // 判断是否有token
        String token = JwtUtils.getToken(request);
        if (StringUtils.isEmpty(token)) {
            log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
            return WebResponseUtils.webFailResponse(exchange.getResponse(), "令牌不能为空!");
        }
        // 判断token是否有效或者是否过期
        if (!JwtUtils.checkToken(token)) {
            log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
            return WebResponseUtils.webFailResponse(exchange.getResponse(), "令牌已过期或验证不正确!");
        }
        Long id = JwtUtils.getIdByJwtToken(token);
        String redisToken = redisService.getCacheObject(RedisConstants.ADMIN_TOKEN_KEY + id);
        if (!redisToken.equals(token)) {
            log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
            return WebResponseUtils.webFailResponse(exchange.getResponse(), "登录状态已过期!");
        }
        // TODO 存储日志
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }

    @Override
    public int getOrder() {
        return -200;
    }
}
