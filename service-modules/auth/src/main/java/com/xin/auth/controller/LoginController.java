package com.xin.auth.controller;

import com.xin.auth.domain.dto.AdminLoginDTO;
import com.xin.auth.service.LoginService;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.CurrentThreadTokenUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 8:48
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 用户认证
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "login-controller", description = "用户登录管理")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/admin/login")
    @ApiOperation(value = "后台登录")
    public ResponseResult<String> adminLogin(@RequestBody AdminLoginDTO adminLoginDTO){
        String token = loginService.adminLogin(adminLoginDTO);
        return ResponseResult.ok(token, "登陆成功");
    }
}
