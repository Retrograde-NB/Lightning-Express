package com.xin.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.xin.auth.client.SysMenuClient;
import com.xin.auth.client.SysRoleClient;
import com.xin.auth.client.SysUserClient;
import com.xin.auth.service.UserInfoService;
import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.domain.auth.AdminUserInfoVo;
import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.exception.XinException;
import com.xin.common.redis.service.RedisService;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.ServletUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/14 上午 8:51
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final SysUserClient sysUserClient;

    private final SysMenuClient sysMenuClient;

    private final SysRoleClient sysRoleClient;

    private final RedisService redisService;

    public UserInfoServiceImpl(SysUserClient sysUserClient, SysMenuClient sysMenuClient, SysRoleClient sysRoleClient, RedisService redisService) {
        this.sysUserClient = sysUserClient;
        this.sysMenuClient = sysMenuClient;
        this.sysRoleClient = sysRoleClient;
        this.redisService = redisService;
    }

    @Override
    public AdminUserInfoVo getAdminUserInfo() {
        // 获取token
        HttpServletRequest request = ServletUtils.getRequest();
        if (request == null) {
            throw new XinException(Constants.FAIL, "获取失败");
        }
        String token = request.getHeader("token");
        if (StrUtil.isEmpty(token)) {
            throw new XinException(Constants.FAIL, "获取失败,无token");
        }
        if (!JwtUtils.checkToken(token)) {
            throw new XinException(Constants.FAIL, "凭证已过期请从新认证");
        }
        Long id = JwtUtils.getMemberIdByJwtToken(token);
        // 获取权限
        List<String> permissionList = redisService.getCacheList(RedisConstants.PERMISSION_KEY + id);
        if (permissionList.size() == 0) {
            ResponseResult<List<String>> permissionResult = sysMenuClient.getPermissionById(id);
            permissionList = permissionResult.getData();
            redisService.setCacheList(RedisConstants.PERMISSION_KEY + id, permissionList);
        }
        // 获取角色
        List<String> roleNameList = redisService.getCacheList(RedisConstants.ROLE_KEY + id);
        if (roleNameList.size() == 0) {
            ResponseResult<List<String>> roleNameResult = sysRoleClient.getRoleNameById(id);
            roleNameList = roleNameResult.getData();
            redisService.setCacheList(RedisConstants.ROLE_KEY + id, roleNameList);
        }
        // 获取用户信息
        ResponseResult<UserInfoVo> userInfo = sysUserClient.getUserInfo(id);
        // 封装
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo();
        adminUserInfoVo.setPermissions(permissionList);
        adminUserInfoVo.setRoles(roleNameList);
        adminUserInfoVo.setUser(userInfo.getData());
        return adminUserInfoVo;
    }
}
