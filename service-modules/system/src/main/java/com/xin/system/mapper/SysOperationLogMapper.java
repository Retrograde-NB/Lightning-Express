package com.xin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.system.domain.entity.SysOperationLog;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:09
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysOperationLogMapper extends BaseMapper<SysOperationLog> {
    int add(SysOperationLog sysOperationLog);
}
