package com.xin.gateway.handler;

import com.xin.common.result.ResponseResult;
import com.xin.common.utils.Base64Utils;
import com.xin.gateway.service.VerificationCodeService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 1:44
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Component
public class CaptchaImageHandler implements HandlerFunction<ServerResponse> {
    private final VerificationCodeService verificationCodeService;

    public CaptchaImageHandler(VerificationCodeService verificationCodeService) {
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        Map<String, Object> verificationCode = verificationCodeService.createVerificationCode();
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write((BufferedImage)verificationCode.get("image"), "jpg", os);
        } catch (IOException e) {
            return Mono.error(e);
        }
        byte[] bytes = os.toByteArray();
        String encode = Base64Utils.encode(bytes);
        ResponseResult<String> responseResult = ResponseResult.ok(encode);

        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .header("random-code", verificationCode.get("random-code").toString())
                .body(BodyInserters.fromValue(responseResult));
    }
}
