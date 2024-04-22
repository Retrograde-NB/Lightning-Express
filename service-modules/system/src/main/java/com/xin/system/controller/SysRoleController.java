package com.xin.system.controller;

import com.xin.common.result.ResponseResult;
import com.xin.log.annotation.Log;
import com.xin.log.enums.OperationType;
import com.xin.system.service.SysRoleService;
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
 * @Date 2024/03/05 下午 5:13
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/role")
@Tag(name = "sys-role-controller", description = "后台角色管理")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/getRoleNameById/{id}")
    @ApiOperation(value = "根据用户id获取角色")
    @Log(title = "根据用户id获取角色列表", operationType = OperationType.OTHER)
    public ResponseResult<List<String>> getRoleNameById(@PathVariable("id") String id){
        List<String> roleNameList = sysRoleService.getRoleNameById(id);
        return ResponseResult.ok(roleNameList);
    }
}
