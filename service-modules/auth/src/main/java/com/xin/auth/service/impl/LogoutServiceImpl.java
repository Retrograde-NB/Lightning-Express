package com.xin.auth.service.impl;

import com.xin.auth.service.LogService;
import com.xin.auth.service.LogoutService;
import com.xin.auth.utils.PackageUtils;
import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.redis.service.RedisService;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.IpUtils;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.ServletUtils;
import org.springframework.stereotype.Service;


/**
 * @Author Retrograde-LX
 * @Date 2024/04/05 下午 2:12
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class LogoutServiceImpl implements LogoutService {
    private final RedisService redisService;

    private final LogService logService;

    public LogoutServiceImpl(RedisService redisService, LogService logService) {
        this.redisService = redisService;
        this.logService = logService;
    }

    @Override
    public ResponseResult<String> adminLogout() {
        Long id = JwtUtils.getId();
        redisService.deleteObject(RedisConstants.ROUTES_KEY + id);
        redisService.deleteObject(RedisConstants.ROLE_KEY + id);
        redisService.deleteObject(RedisConstants.PERMISSION_KEY + id);
        redisService.deleteObject(RedisConstants.ADMIN_TOKEN_KEY + id);
        logService.recordLoginInfoLog(PackageUtils.getSysLoginInfoDTO(JwtUtils.getUserName(JwtUtils.getToken()), "退出登录成功！", Constants.LOGOUT));
        return ResponseResult.ok("退出登录成功！");
    }
}
