package com.xin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xin.system.domain.entity.SysMenu;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:07
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysMenuService extends IService<SysMenu> {
    List<String> getPermissionById(Long id);

    List<String> getRoutesById(Long id);
}
