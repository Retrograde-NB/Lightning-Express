package com.xin.system.api.factory;

import com.xin.common.result.ResponseResult;
import com.xin.system.api.client.SysMenuClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/31 下午 1:56
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * SysMenuClient执行失败的兜底实现类
 */
@Component
public class SysMenuClientFallbackFactory implements FallbackFactory<SysMenuClient> {
    private static final Logger log = LoggerFactory.getLogger(SysMenuClientFallbackFactory.class);

    @Override
    public SysMenuClient create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());

        return new SysMenuClient() {
            @Override
            public ResponseResult<List<String>> getPermissionById(Long id) {
                return ResponseResult.fail("获取菜单权限失败:" + throwable.getMessage());
            }

            @Override
            public ResponseResult<List<String>> getRoutesById(Long id) {
                return ResponseResult.fail("获取动态路由信息失败:" + throwable.getMessage());
            }
        };
    }
}
