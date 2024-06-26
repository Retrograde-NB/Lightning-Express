package com.xin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.system.domain.entity.SysRole;
import com.xin.system.mapper.SysRoleMapper;
import com.xin.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:09
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<String> getRoleNameById(Long id) {
        return sysRoleMapper.getRoleNameById(id);
    }
}
