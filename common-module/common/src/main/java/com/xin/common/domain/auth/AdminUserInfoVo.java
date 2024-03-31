package com.xin.common.domain.auth;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/14 上午 8:55
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class AdminUserInfoVo {
    private List<String> permissions;
    private List<String> roles;
    private UserInfoVo user;

    public AdminUserInfoVo(List<String> permissions, List<String> roles, UserInfoVo user) {
        this.permissions = permissions;
        this.roles = roles;
        this.user = user;
    }

    public AdminUserInfoVo() {
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserInfoVo getUser() {
        return user;
    }

    public void setUser(UserInfoVo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AdminUserInfoVo{" +
                "permissions=" + permissions +
                ", roles=" + roles +
                ", user=" + user +
                '}';
    }
}
