package com.xin.auth.domain.dto;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 上午 9:46
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class AdminLoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
