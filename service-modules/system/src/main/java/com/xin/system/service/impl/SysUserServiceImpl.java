package com.xin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.system.entity.SysUser;
import com.xin.system.mapper.SysUserMapper;
import com.xin.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public SysUser getUserInfoByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        return this.getOne(wrapper);
    }
}
