package com.xin.system.controller;

import com.xin.common.result.ResponseResult;
import com.xin.system.domain.dto.SysLoginInfoDTO;
import com.xin.system.domain.entity.SysLoginInfo;
import com.xin.system.service.SysLoginInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/18 下午 8:01
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/loginInfo")
@Tag(name = "sys-login-info-controller", description = "后台登录信息管理")
public class SysLoginInfoController {
    private final SysLoginInfoService sysLoginInfoService;

    public SysLoginInfoController(SysLoginInfoService sysLoginInfoService) {
        this.sysLoginInfoService = sysLoginInfoService;
    }
    /**
     * 添加登录信息日志
     * @param sysLoginInfoDTO 日志信息
     * @return 返回添加行数
     */
    @PostMapping("/add")
    public ResponseResult<Integer> add(@RequestBody SysLoginInfoDTO sysLoginInfoDTO){
        return sysLoginInfoService.add(sysLoginInfoDTO);
    }
}
