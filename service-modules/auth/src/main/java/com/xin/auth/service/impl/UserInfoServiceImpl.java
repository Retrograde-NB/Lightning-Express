package com.xin.auth.service.impl;

import com.xin.auth.service.UserInfoService;
import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.domain.auth.AdminUserInfoVo;
import com.xin.common.domain.auth.UserInfoVo;
import com.xin.common.exception.XinException;
import com.xin.common.redis.service.RedisService;
import com.xin.common.result.ResponseResult;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.ReflectionUtils;
import com.xin.system.api.client.SysMenuClient;
import com.xin.system.api.client.SysRoleClient;
import com.xin.system.api.client.SysUserClient;
import org.springframework.stereotype.Service;

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
        // 获取当前用户id
        Long id = JwtUtils.getId();
        String token = JwtUtils.getToken();
        String redisToken = redisService.getCacheObject(RedisConstants.ADMIN_TOKEN_KEY + id);
        if (redisToken == null || !redisToken.equals(token)) {
            throw new XinException(Constants.FAIL, "token不存在请重新登陆！");
        }
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
        // 获取动态路由信息
        List<String> routesList = redisService.getCacheList(RedisConstants.ROUTES_KEY + id);
        if (routesList.size() == 0) {
            ResponseResult<List<String>> routesResult = sysMenuClient.getRoutesById(id);
            routesList = routesResult.getData();
            redisService.setCacheList(RedisConstants.ROUTES_KEY + id, routesList);
        }
        // 获取用户信息
        ResponseResult<UserInfoVo> userInfo = sysUserClient.getUserInfo(id);
        // 封装
        AdminUserInfoVo adminUserInfoVo = ReflectionUtils.newInstance(AdminUserInfoVo.class);
        adminUserInfoVo.setPermissions(permissionList);
        adminUserInfoVo.setRoles(roleNameList);
        adminUserInfoVo.setRoutes(routesList);
        adminUserInfoVo.setUserName(userInfo.getData().getUserName());
        adminUserInfoVo.setAvatar(userInfo.getData().getAvatar());
        return adminUserInfoVo;
    }
}
