package com.xin.common.domain.auth.vo;

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
    private List<String> routes;
    private String userName;
    private String avatar;

    @Override
    public String toString() {
        return "AdminUserInfoVo{" +
                "permissions=" + permissions +
                ", roles=" + roles +
                ", routes=" + routes +
                ", userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
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

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AdminUserInfoVo() {
    }

    public AdminUserInfoVo(List<String> permissions, List<String> roles, List<String> routes, String userName, String avatar) {
        this.permissions = permissions;
        this.roles = roles;
        this.routes = routes;
        this.userName = userName;
        this.avatar = avatar;
    }
}
