package com.xin.auth.controller;

import com.xin.auth.domain.dto.AdminLoginDTO;
import com.xin.common.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 8:48
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/auth")
@Api(description = "登录管理")
public class LoginController {
    @PostMapping("/admin/login")
    @ApiOperation(value = "后台登录")
    public ResponseResult adminLogin(@RequestBody AdminLoginDTO adminLoginDTO){

        return null;
    }
}
