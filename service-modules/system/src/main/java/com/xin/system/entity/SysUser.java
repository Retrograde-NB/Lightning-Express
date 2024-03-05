package com.xin.system.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 4:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 用户表
 */
public class SysUser implements Serializable {

    /**
     * 主键
     */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    private Long id;
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
    private String phonenumber;
    /**
     * 头像
     */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("头像")
    @Length(max= 128,message="编码长度不能超过128")
    private String avatar;
    /**
     * 创建者
     */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("创建者")
    @Length(max= 64,message="编码长度不能超过64")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("更新者")
    @Length(max= 64,message="编码长度不能超过64")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

    /**
     * 主键
     */
    private void setId(Long id){
        this.id = id;
    }

    /**
     * 用户名
     */
    private void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * 昵称
     */
    private void setNickName(String nickName){
        this.nickName = nickName;
    }

    /**
     * 密码
     */
    private void setPassword(String password){
        this.password = password;
    }

    /**
     * 账号状态（0正常 1停用）
     */
    private void setStatus(String status){
        this.status = status;
    }

    /**
     * 手机号
     */
    private void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    /**
     * 头像
     */
    private void setAvatar(String avatar){
        this.avatar = avatar;
    }

    /**
     * 创建者
     */
    private void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    private void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * 更新者
     */
    private void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     */
    private void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private void setDelFlag(Integer delFlag){
        this.delFlag = delFlag;
    }


    /**
     * 主键
     */
    private Long getId(){
        return this.id;
    }

    /**
     * 用户名
     */
    private String getUserName(){
        return this.userName;
    }

    /**
     * 昵称
     */
    private String getNickName(){
        return this.nickName;
    }

    /**
     * 密码
     */
    private String getPassword(){
        return this.password;
    }

    /**
     * 账号状态（0正常 1停用）
     */
    private String getStatus(){
        return this.status;
    }

    /**
     * 手机号
     */
    private String getPhonenumber(){
        return this.phonenumber;
    }

    /**
     * 头像
     */
    private String getAvatar(){
        return this.avatar;
    }

    /**
     * 创建者
     */
    private String getCreateBy(){
        return this.createBy;
    }

    /**
     * 创建时间
     */
    private Date getCreateTime(){
        return this.createTime;
    }

    /**
     * 更新者
     */
    private String getUpdateBy(){
        return this.updateBy;
    }

    /**
     * 更新时间
     */
    private Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    private Integer getDelFlag(){
        return this.delFlag;
    }

}
