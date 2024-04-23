package com.xin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xin.common.result.ResponseResult;
import com.xin.system.domain.dto.SysOperationLogDTO;
import com.xin.system.domain.entity.SysOperationLog;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:09
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysOperationLogService extends IService<SysOperationLog> {
    ResponseResult<Integer> add(SysOperationLogDTO sysOperationLogDTO);
    ResponseResult page();
}
