package com.xin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.ReflectionUtils;
import com.xin.system.domain.dto.SysOperationLogDTO;
import com.xin.system.domain.entity.SysOperationLog;
import com.xin.system.mapper.SysOperationLogMapper;
import com.xin.system.service.SysOperationLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:10
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements SysOperationLogService {
    @Resource
    private SysOperationLogMapper sysOperationLogMapper;
    @Override
    public ResponseResult<Integer> add(SysOperationLogDTO sysOperationLogDTO) {
        SysOperationLog sysOperationLog = ReflectionUtils.newInstance(SysOperationLog.class);
        BeanUtils.copyProperties(sysOperationLogDTO, sysOperationLog);
        int result = sysOperationLogMapper.add(sysOperationLog);
        return result > 0 ? ResponseResult.ok(result) : ResponseResult.fail();
    }

    @Override
    public ResponseResult page() {
        List<SysOperationLog> sysOperationLogList = sysOperationLogMapper.page();
        System.out.println(sysOperationLogList);
        return null;
    }
}
