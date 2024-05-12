package com.xin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xin.common.domain.auth.vo.UserInfoVo;
import com.xin.common.result.ResponseResult;
import com.xin.system.domain.dto.SysUserAddDTO;
import com.xin.system.domain.dto.SysUserPageDTO;
import com.xin.system.domain.entity.SysUser;
import com.xin.system.domain.vo.SysUserPageVO;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:07
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface SysUserService extends IService<SysUser> {
    ResponseResult<UserInfoVo> getUserInfoByUsername(String username);

    ResponseResult<UserInfoVo> getUserInfoById(Long id);

    ResponseResult<SysUserPageVO> page(SysUserPageDTO sysUserPageDTO);

    ResponseResult<String> add(SysUserAddDTO sysUserAddDTO);
}
