package com.xin.auth.client;

import com.xin.auth.client.factory.SysUserClientFallbackFactory;
import com.xin.common.constant.ServiceNameConstants;
import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.result.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 2:17
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
//@Component(value = "sysUserClient")
@FeignClient(contextId = "sysUserClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysUserClientFallbackFactory.class)
public interface SysUserClient {
    @GetMapping("/api/admin/user/getUserInfoByUsername/{username}")
    ResponseResult<UserInfoVo> getUserInfo(@PathVariable("username") String username);

    @GetMapping("/api/admin/user/getUserInfoById/{id}")
    ResponseResult<UserInfoVo> getUserInfo(@PathVariable("id") Long id);

}
