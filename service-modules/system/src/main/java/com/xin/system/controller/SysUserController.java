package com.xin.system.controller;

import com.xin.common.domain.auth.vo.UserInfoVo;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.PageUtils;
import com.xin.log.annotation.Log;
import com.xin.log.enums.OperationType;
import com.xin.system.domain.dto.SysUserPageDTO;
import com.xin.system.domain.vo.SysUserPageVO;
import com.xin.system.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:13
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 用户管理控制层
 */
@RestController
@RequestMapping("/api/admin/user")
@Tag(name = "sys-user-controller", description = "后台用户管理")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/getUserInfoByUsername/{username}")
    @ApiOperation(value = "根据用户名获取信息")
    @Log(title = "根据用户名获取用户信息", operationType = OperationType.OTHER)
    public ResponseResult<UserInfoVo> getUserInfoByUsername(@PathVariable("username") String username){
        return sysUserService.getUserInfoByUsername(username);
    }

    /**
     * 根据id获取后台用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUserInfoById/{id}")
    @ApiOperation(value = "根据id获取信息")
    @Log(title = "根据id获取后台用户信息", operationType = OperationType.OTHER)
    public ResponseResult<UserInfoVo> getUserInfoById(@PathVariable("id") Long id){
        return sysUserService.getUserInfoById(id);
    }

    /**
     * 获取用户分页数据
     * @param sysUserPageDTO 查询条件
     * @return 用户数据
     */
    @GetMapping("/page")
    @ApiOperation(value = "获取用户分页数据")
    @Log(title = "获取用户分页数据", operationType = OperationType.OTHER)
    public ResponseResult<SysUserPageVO> page(SysUserPageDTO sysUserPageDTO){
        PageUtils.startPage();
        return sysUserService.page(sysUserPageDTO);
    }
}
