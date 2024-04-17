package com.xin.auth.service.impl;

import com.xin.auth.client.SysUserClient;
import com.xin.auth.domain.dto.AdminLoginDTO;
import com.xin.auth.service.LoginService;
import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.constant.UserConstants;
import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.enums.UserStatus;
import com.xin.common.exception.XinException;
import com.xin.common.redis.service.RedisService;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 8:56
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final RedisService redisService;

    private final SysUserClient sysUserClient;

    public LoginServiceImpl(RedisService redisService, SysUserClient sysUserClient) {
        this.redisService = redisService;
        this.sysUserClient = sysUserClient;
    }

    @Override
    public String adminLogin(AdminLoginDTO adminLoginDTO) {
        String username = adminLoginDTO.getUsername();
        String password = adminLoginDTO.getPassword();
        // 用户名或密码为空 错误
        if (Objects.isNull(username) || Objects.isNull(password)) {
            //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "用户/密码必须填写");
            throw new XinException(Constants.FAIL, "用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "用户密码不在指定范围");
            throw new XinException(Constants.FAIL, "用户密码不在指定范围");
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "用户名不在指定范围");
            throw new XinException(Constants.FAIL, "用户名不在指定范围");
        }
        // TODO IP黑名单校验
        // String blackStr = Convert.toStr(redisService.getCacheObject(CacheConstants.SYS_LOGIN_BLACKIPLIST));
        //if (IpUtils.isMatchedIp(blackStr, IpUtils.getIpAddr())) {
        //    //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "很遗憾，访问IP已被列入系统黑名单");
        //    throw new XinException(Constants.FAIL, "很遗憾，访问IP已被列入系统黑名单");
        //}
        ResponseResult<UserInfoVo> responseResult = sysUserClient.getUserInfo(username);
        if (Objects.isNull(responseResult) || Objects.isNull(responseResult.getData())) {
            //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "登录用户不存在");
            throw new XinException(Constants.FAIL, "登录用户：" + username + " 不存在");
        }
        if (ResponseResult.FAIL == responseResult.getCode()) {
            throw new XinException(Constants.FAIL, responseResult.getMsg());
        }
        if (UserStatus.DISABLE.getCode().equals(responseResult.getData().getStatus())) {
            //recordLogService.recordLogininfor(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
            throw new XinException(Constants.FAIL, "对不起，您的账号：" + username + " 已停用");
        }
        if (!responseResult.getData().getPassword().equals(MD5Utils.transToMD5(password))) {
            throw new XinException(Constants.FAIL, "密码错误");
        }
        String token = JwtUtils.getJwtToken(responseResult.getData().getId());
        redisService.setCacheObject(RedisConstants.ADMIN_TOKEN_KEY + responseResult.getData().getId(), token);
        return token;
    }
}
