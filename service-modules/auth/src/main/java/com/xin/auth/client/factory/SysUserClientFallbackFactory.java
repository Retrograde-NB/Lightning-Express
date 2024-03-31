package com.xin.auth.client.factory;

import com.xin.auth.client.SysUserClient;
import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 2:32
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Component
public class SysUserClientFallbackFactory implements FallbackFactory<SysUserClient> {
    private static final Logger log = LoggerFactory.getLogger(SysUserClientFallbackFactory.class);

    @Override
    public SysUserClient create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new SysUserClient() {
            @Override
            public ResponseResult<UserInfoVo> getUserInfo(String username) {
                return ResponseResult.fail("获取用户信息失败:" + throwable.getMessage());
            }

            @Override
            public ResponseResult<UserInfoVo> getUserInfo(Long id) {
                return ResponseResult.fail("获取用户信息失败:" + throwable.getMessage());
            }
        };
    }
}
