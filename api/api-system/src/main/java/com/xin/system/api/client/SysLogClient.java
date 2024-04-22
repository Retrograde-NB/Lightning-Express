package com.xin.system.api.client;

import com.xin.common.constant.ServiceNameConstants;
import com.xin.common.domain.system.dto.SysLoginInfoDTO;
import com.xin.common.domain.system.dto.SysOperationLogDTO;
import com.xin.common.result.ResponseResult;
import com.xin.system.api.factory.SysLogClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 10:46
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 远程调用service-system模块的保存登录和操作日志功能
 */
@FeignClient(contextId = "sysLogClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysLogClientFallbackFactory.class)
public interface SysLogClient {
    /**
     * 添加登录信息日志
     * @param sysLoginInfoDTO 日志信息
     * @return 返回添加行数
     */
    @PostMapping("/api/admin/loginInfo/add")
    public ResponseResult<Integer> add(@RequestBody SysLoginInfoDTO sysLoginInfoDTO);

    /**
     * 添加操作日志信息
     * @param sysOperationLogDTO 操作日志
     * @return 返回添加行数
     */
    @PostMapping("/api/admin/operationLog/add")
    public ResponseResult<Integer> add(@RequestBody SysOperationLogDTO sysOperationLogDTO);
}
