package com.xin.auth.service;

import com.xin.common.domain.system.dto.SysLoginInfoDTO;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/22 上午 11:49
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface LogService {
    public void recordLoginInfoLog(SysLoginInfoDTO sysLoginInfoDTO);
}
