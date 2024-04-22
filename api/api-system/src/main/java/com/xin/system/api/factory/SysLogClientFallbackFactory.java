package com.xin.system.api.factory;

import com.xin.common.domain.system.dto.SysLoginInfoDTO;
import com.xin.common.domain.system.dto.SysOperationLogDTO;
import com.xin.common.result.ResponseResult;
import com.xin.system.api.client.SysLogClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 10:46
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * SysLogClient执行失败的兜底实现类
 */
@Component
public class SysLogClientFallbackFactory implements FallbackFactory<SysLogClient> {
    private static final Logger log = LoggerFactory.getLogger(SysLogClientFallbackFactory.class);

    @Override
    public SysLogClient create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new SysLogClient() {
            @Override
            public ResponseResult<Integer> add(SysLoginInfoDTO sysLoginInfoDTO) {
                return ResponseResult.fail("添加登录信息日志失败:" + throwable.getMessage());
            }

            @Override
            public ResponseResult<Integer> add(SysOperationLogDTO sysOperationLogDTO) {
                return ResponseResult.fail("添加操作日志信息失败:" + throwable.getMessage());
            }
        };
    }
}
