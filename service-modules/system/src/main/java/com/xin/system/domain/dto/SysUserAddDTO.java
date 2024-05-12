package com.xin.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author Retrograde-LX
 * @Date 2024/05/12 下午 2:38
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysUserAddDTO {
    /**
     * 用户名
     */
    @NotBlank(message="[用户名]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("用户名")
    @Length(max= 64,message="编码长度不能超过64")
    private String userName;
    /**
     * 昵称
     */
    @NotBlank(message="[昵称]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("昵称")
    @Length(max= 64,message="编码长度不能超过64")
    private String nickName;
    /**
     * 密码
     */
    @NotBlank(message="[密码]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("密码")
    @Length(max= 64,message="编码长度不能超过64")
    private String password;
    /**
     * 账号状态（0正常 1停用）
     */
    @ApiModelProperty("账号状态（0正常 1停用）")
    private String status;
    /**
     * 手机号
     */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("手机号")
    @Length(max= 32,message="编码长度不能超过32")
    private String phoneNumber;
    /**
     * 头像
     */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("头像")
    @Length(max= 128,message="编码长度不能超过128")
    private String avatar;

    @Override
    public String toString() {
        return "SysUserAddDTO{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
