package com.xin.auth.service.impl;

import com.xin.auth.service.LogService;
import com.xin.common.constant.Constants;
import com.xin.common.domain.system.dto.SysLoginInfoDTO;
import com.xin.common.utils.IpUtils;
import com.xin.common.utils.ReflectionUtils;
import com.xin.common.utils.ServletUtils;
import com.xin.common.utils.StringUtils;
import com.xin.system.api.client.SysLogClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/22 上午 11:27
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class LogServiceImpl implements LogService {
    private final SysLogClient sysLogClient;

    public LogServiceImpl(SysLogClient sysLogClient) {
        this.sysLogClient = sysLogClient;
    }
    @Async
    @Override
    public void recordLoginInfoLog(SysLoginInfoDTO sysLoginInfoDTO) {
        sysLogClient.add(sysLoginInfoDTO);
    }
}
