package com.xin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xin.common.result.ResponseResult;
import com.xin.system.domain.dto.SysLoginInfoDTO;
import com.xin.system.domain.entity.SysLoginInfo;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/18 下午 8:05
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysLoginInfoService extends IService<SysLoginInfo> {
    ResponseResult<Integer> add(SysLoginInfoDTO sysLoginInfoDTO);
}
