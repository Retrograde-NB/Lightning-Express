package com.xin.system.domain.dto;

import com.xin.common.domain.dto.PageDTO;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 上午 10:15
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysUserPageDTO {
    private String userName;
    private String phoneNumber;
    private String status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysUserPageDTO{" +
                "userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
