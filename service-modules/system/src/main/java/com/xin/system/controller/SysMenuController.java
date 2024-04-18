package com.xin.system.controller;

import com.xin.common.result.ResponseResult;
import com.xin.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:14
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/menu")
@Tag(name = "sys-menu-controller", description = "后台菜单管理")
public class SysMenuController {
    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }
    @GetMapping("/getPermissionById/{id}")
    @ApiOperation(value = "根据用户id获取权限")
    public ResponseResult<List<String>> getPermissionById(@PathVariable("id") Long id) {
        List<String> permissionList = sysMenuService.getPermissionById(id);
        return ResponseResult.ok(permissionList);
    }

    @GetMapping("/getRoutesById/{id}")
    @ApiOperation(value = "根据id获取路由信息")
    public ResponseResult<List<String>> getRoutesById(@PathVariable("id") Long id){
        List<String> routesList = sysMenuService.getRoutesById(id);
        return ResponseResult.ok(routesList);
    }

}
