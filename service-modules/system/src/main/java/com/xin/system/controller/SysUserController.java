package com.xin.system.controller;

import com.xin.common.domain.auth.vo.UserInfoVo;
import com.xin.common.result.ResponseResult;
import com.xin.log.annotation.Log;
import com.xin.log.enums.OperationType;
import com.xin.system.domain.entity.SysUser;
import com.xin.system.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
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
@Tag(name = "sys-user-controller", description = "后台用户管理")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @GetMapping("/getUserInfoByUsername/{username}")
    @ApiOperation(value = "根据用户名获取信息")
    @Log(title = "根据用户名获取用户信息", operationType = OperationType.OTHER)
    public ResponseResult<UserInfoVo> getUserInfoByUsername(@PathVariable("username") String username){
        SysUser sysUser = sysUserService.getUserInfoByUsername(username);
        if (Objects.isNull(sysUser)) {
            return ResponseResult.fail("用户不存在");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(sysUser, userInfoVo);
        return ResponseResult.ok(userInfoVo);
    }
    @GetMapping("/getUserInfoById/{id}")
    @ApiOperation(value = "根据id获取信息")
    @Log(title = "根据id获取后台用户信息", operationType = OperationType.OTHER)
    public ResponseResult<UserInfoVo> getUserInfoById(@PathVariable("id") Long id){
        SysUser sysUser = sysUserService.getUserInfoById(id);
        if (Objects.isNull(sysUser)) {
            return ResponseResult.fail("获取失败");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        BeanUtils.copyProperties(sysUser, userInfoVo);
        return ResponseResult.ok(userInfoVo);
    }


}
