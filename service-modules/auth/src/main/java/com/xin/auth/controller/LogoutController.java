package com.xin.auth.controller;

import com.xin.auth.service.LogoutService;
import com.xin.common.result.ResponseResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/05 下午 2:11
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "logout-controller", description = "退出登录管理")
public class LogoutController {
    private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }

    @PostMapping("/admin/logout")
    public ResponseResult<String> adminLogout(){
        return logoutService.adminLogout();
    }
}
