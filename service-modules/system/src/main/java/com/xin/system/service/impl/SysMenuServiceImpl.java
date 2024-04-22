package com.xin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.system.domain.entity.SysMenu;
import com.xin.system.mapper.SysMenuMapper;
import com.xin.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;


    @Override
    public List<String> getPermissionById(Long id) {
        return sysMenuMapper.getPermissionById(id);
    }

    @Override
    public List<String> getRoutesById(Long id) {
        return sysMenuMapper.getRoutesById(id);
    }
}
