package com.xin.system.controller;

import com.xin.common.result.ResponseResult;
import com.xin.system.domain.dto.SysOperationLogDTO;
import com.xin.system.service.SysOperationLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:07
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/operationLog")
@Tag(name = "sys-operation-log-controller", description = "操作日志管理")
public class SysOperationLogController {
    private final SysOperationLogService sysOperationLogService;

    public SysOperationLogController(SysOperationLogService sysOperationLogService) {
        this.sysOperationLogService = sysOperationLogService;
    }
    /**
     * 添加操作日志信息
     * @param sysOperationLogDTO 操作日志
     * @return 返回添加行数
     */
    @PostMapping("/add")
    public ResponseResult<Integer> add(@RequestBody SysOperationLogDTO sysOperationLogDTO){
        return sysOperationLogService.add(sysOperationLogDTO);
    }
}
