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
    public static Mono<Void> webFailResponse(ServerHttpResponse response, String msg){
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseResult<String> result = ResponseResult.fail("失败", msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }
    public static Mono<Void> webSuccessResponse(ServerHttpResponse response, String msg){
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseResult<String> result = ResponseResult.fail("成功", msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
        return response.writeWith(Mono.just(dataBuffer));
    }
}
