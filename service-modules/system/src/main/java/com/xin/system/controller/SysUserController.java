package com.xin.system.controller;

import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.result.ResponseResult;
import com.xin.system.entity.SysUser;
import com.xin.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:13
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/user")
@Api(description = "后台用户管理")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getUserInfoByUsername/{username}")
    public ResponseResult getUserInfoByUsername(@PathVariable("username") String username){
        SysUser sysUser = sysUserService.getUserInfoByUsername(username);
        if (Objects.isNull(sysUser)) {
            return ResponseResult.fail("用户名或密码错误");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(sysUser, userInfoVo);
        return ResponseResult.ok(userInfoVo);
    }
}
