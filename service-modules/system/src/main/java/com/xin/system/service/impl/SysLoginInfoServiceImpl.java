package com.xin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.ReflectionUtils;
import com.xin.system.domain.dto.SysLoginInfoDTO;
import com.xin.system.domain.entity.SysLoginInfo;
import com.xin.system.domain.entity.SysUser;
import com.xin.system.mapper.SysLoginInfoMapper;
import com.xin.system.service.SysLoginInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/18 下午 8:05
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysLoginInfoServiceImpl extends ServiceImpl<SysLoginInfoMapper, SysLoginInfo> implements SysLoginInfoService {
    @Resource
    private SysLoginInfoMapper sysLoginInfoMapper;
    @Override
    public ResponseResult<Integer> add(SysLoginInfoDTO sysLoginInfoDTO) {
        System.out.println(sysLoginInfoDTO.toString());
        SysLoginInfo sysLoginInfo = ReflectionUtils.newInstance(SysLoginInfo.class);
        BeanUtils.copyProperties(sysLoginInfoDTO, sysLoginInfo);
        int result = sysLoginInfoMapper.add(sysLoginInfo);
        return result > 0 ? ResponseResult.ok(result) : ResponseResult.fail("操作失败");
    }
}
