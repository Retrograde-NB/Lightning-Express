package com.xin.common.domain.auth;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 1:35
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 根据用户名获取的用户信息
 */
public class UserInfoVo {
    private Long id;
    private String userName;
    private String password;
    private String status;

    private String avatar;

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserInfoVo() {
    }

    public UserInfoVo(Long id, String userName, String password, String status, String avatar) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.avatar = avatar;
    }
}
