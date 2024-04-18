package com.xin.system.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/18 下午 7:58
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysLoginInfo implements Serializable {
    /**
     * 主键ID
     */
    @NotNull(message="[主键ID]不能为空")
    @ApiModelProperty("主键ID")
    private Long id;
    /**
     * 用户账号
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("用户账号")
    @Length(max= 50,message="编码长度不能超过50")
    private String userName;
    /**
     * 登录IP地址
     */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("登录IP地址")
    @Length(max= 128,message="编码长度不能超过128")
    private String ipAddress;
    /**
     * 登录地点
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("登录地点")
    @Length(max= 255,message="编码长度不能超过255")
    private String loginLocation;
    /**
     * 浏览器类型
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("浏览器类型")
    @Length(max= 50,message="编码长度不能超过50")
    private String browser;
    /**
     * 操作系统
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("操作系统")
    @Length(max= 50,message="编码长度不能超过50")
    private String os;
    /**
     * 登录状态（0成功，1失败）
     */
    @ApiModelProperty("登录状态（0成功，1失败）")
    private String status;
    /**
     * 提示消息
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("提示消息")
    @Length(max= 255,message="编码长度不能超过255")
    private String msg;
    /**
     * 访问时间
     */
    @ApiModelProperty("访问时间")
    private Date loginTime;

    public SysLoginInfo(Long id, String userName, String ipAddress, String loginLocation, String browser, String os, String status, String msg, Date loginTime) {
        this.id = id;
        this.userName = userName;
        this.ipAddress = ipAddress;
        this.loginLocation = loginLocation;
        this.browser = browser;
        this.os = os;
        this.status = status;
        this.msg = msg;
        this.loginTime = loginTime;
    }

    public SysLoginInfo() {
    }

    @Override
    public String toString() {
        return "SysLoginInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", loginLocation='" + loginLocation + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", loginTime=" + loginTime +
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
