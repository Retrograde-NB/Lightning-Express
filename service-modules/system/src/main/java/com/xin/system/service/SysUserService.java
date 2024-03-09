package com.xin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xin.system.entity.SysUser;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:07
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysUserService extends IService<SysUser> {
    SysUser getUserInfoByUsername(String username);
}
