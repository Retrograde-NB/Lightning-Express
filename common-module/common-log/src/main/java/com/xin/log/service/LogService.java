package com.xin.log.service;

import com.xin.common.domain.system.dto.SysOperationLogDTO;
import com.xin.system.api.client.SysLogClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/20 下午 3:42
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class LogService {
    private final SysLogClient sysLogClient;

    public LogService(SysLogClient sysLogClient) {
        this.sysLogClient = sysLogClient;
    }
    
    @Async
    public void saveOperationLog(SysOperationLogDTO sysOperationLogDTO) {
        sysLogClient.add(sysOperationLogDTO);
    }
}
