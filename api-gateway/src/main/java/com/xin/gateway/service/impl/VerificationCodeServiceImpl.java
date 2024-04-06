package com.xin.gateway.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.exception.XinException;
import com.xin.common.redis.service.RedisService;
import com.xin.common.utils.ReflectionUtils;
import com.xin.gateway.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/06 下午 2:12
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private final DefaultKaptcha defaultKaptcha;
    private final RedisService redisService;

    public VerificationCodeServiceImpl(DefaultKaptcha defaultKaptcha, RedisService redisService) {
        this.defaultKaptcha = defaultKaptcha;
        this.redisService = redisService;
    }

    @Override
    public Map<String, Object> createVerificationCode() {
        Map<String, Object> map = new HashMap<>();
        // 生成验证码
        String capText = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(capText);
        // 保存验证码信息
        String randomStr = UUID.randomUUID().toString().replaceAll("-", "");
        redisService.setCacheObject(RedisConstants.VERIFICATION_CODE_KEY + randomStr, capText, 60L, TimeUnit.SECONDS);
        map.put("randomStr", randomStr);
        map.put("image", image);

        return map;
    }

    @Override
    public void checkVerificationCode(String code, String uuid) throws XinException{
        if (!StringUtils.hasText(code)) {
            throw new XinException("验证码不能为空", ReflectionUtils.newInstance(IllegalStateException.class));
        }
        if (!StringUtils.hasText(uuid)) {
            throw new XinException("验证码已过期", ReflectionUtils.newInstance(IllegalStateException.class));
        }
        String captcha = redisService.getCacheObject(RedisConstants.VERIFICATION_CODE_KEY + uuid);
        redisService.deleteObject(RedisConstants.VERIFICATION_CODE_KEY + uuid);
        if (!code.equalsIgnoreCase(captcha)) {
            throw new XinException("验证码错误", ReflectionUtils.newInstance(IllegalStateException.class));
        }
    }
}
