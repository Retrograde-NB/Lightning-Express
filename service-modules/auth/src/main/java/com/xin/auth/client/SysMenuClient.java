package com.xin.auth.client;

import com.xin.auth.client.factory.SysMenuClientFallbackFactory;
import com.xin.common.constant.ServiceNameConstants;
import com.xin.common.result.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/31 下午 1:55
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
//@Component(value = "sysMenuClient")
@FeignClient(contextId = "sysMenuClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysMenuClientFallbackFactory.class)
public interface SysMenuClient {
    @GetMapping("/api/admin/menu/getPermissionById/{id}")
    public ResponseResult<List<String>> getPermissionById(@PathVariable("id") Long id);

    @GetMapping("/api/admin/menu/getRoutesById/{id}")
    public ResponseResult<List<String>> getRoutesById(@PathVariable("id") Long id);
}
