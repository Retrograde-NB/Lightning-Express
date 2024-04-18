package com.xin.system.api.client;

import com.xin.common.constant.ServiceNameConstants;
import com.xin.common.result.ResponseResult;
import com.xin.system.api.factory.SysRoleClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/31 下午 2:14
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
//@Component(value = "sysRoleClient")
@FeignClient(contextId = "sysRoleClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysRoleClientFallbackFactory.class)
public interface SysRoleClient {
    @GetMapping("/api/admin/role/getRoleNameById/{id}")
    public ResponseResult<List<String>> getRoleNameById(@PathVariable("id") Long id);
}
