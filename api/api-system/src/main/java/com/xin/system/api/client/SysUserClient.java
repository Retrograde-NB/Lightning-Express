package com.xin.system.api.client;

import com.xin.common.constant.ServiceNameConstants;
import com.xin.common.domain.auth.vo.UserInfoVo;
import com.xin.common.result.ResponseResult;
import com.xin.system.api.factory.SysUserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 2:17
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 远程调用service-system模块的根据用户名或id获取用户信息功能
 */
//@Component(value = "sysUserClient")
@FeignClient(contextId = "sysUserClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = SysUserClientFallbackFactory.class)
public interface SysUserClient {
    @GetMapping("/api/admin/user/getUserInfoByUsername/{username}")
    ResponseResult<UserInfoVo> getUserInfo(@PathVariable("username") String username);

    @GetMapping("/api/admin/user/getUserInfoById/{id}")
    ResponseResult<UserInfoVo> getUserInfo(@PathVariable("id") Long id);

}
