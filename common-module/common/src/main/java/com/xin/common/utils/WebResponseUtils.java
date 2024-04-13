package com.xin.common.utils;

import com.alibaba.fastjson2.JSON;
import com.xin.common.result.ResponseResult;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/13 下午 1:38
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 响应工具类
 */
public class WebResponseUtils {
    public static Mono<Void> webResponse(ServerHttpResponse response, String msg){
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseResult<?> result = ResponseResult.fail(ResponseResult.FAIL, msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }
}
