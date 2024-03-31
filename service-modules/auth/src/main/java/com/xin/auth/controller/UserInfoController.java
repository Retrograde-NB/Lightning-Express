package com.xin.auth.controller;

import com.xin.auth.service.UserInfoService;
import com.xin.common.domain.auth.AdminUserInfoVo;
import com.xin.common.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/14 上午 8:50
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 获取用户信息
 */
@RestController
@RequestMapping("/api/auth")
@Api(description = "用户信息管理")
public class UserInfoController {
    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    @GetMapping("/getAdminUserInfo")
    @ApiOperation(value = "获取后台用户信息")
    public ResponseResult getAdminUserInfo(){
        AdminUserInfoVo adminUserInfoVo = userInfoService.getAdminUserInfo();
        return ResponseResult.ok(adminUserInfoVo);
    }
}
