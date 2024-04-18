package com.xin.system.api.factory;

import com.xin.common.result.ResponseResult;
import com.xin.system.api.client.SysRoleClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/31 下午 2:15
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Component
public class SysRoleClientFallbackFactory implements FallbackFactory<SysRoleClient> {
    private static final Logger log = LoggerFactory.getLogger(SysRoleClientFallbackFactory.class);


    @Override
    public SysRoleClient create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new SysRoleClient() {
            @Override
            public ResponseResult<List<String>> getRoleNameById(Long id) {
                return ResponseResult.fail("获取角色列表失败:" + throwable.getMessage());
            }
        };
    }
}
