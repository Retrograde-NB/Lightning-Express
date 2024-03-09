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

    public SysUser(Long id, String userName, String nickName, String password, String status, String phonenumber, String avatar, String createBy, Date createTime, String updateBy, Date updateTime, Integer delFlag) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.status = status;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public SysUser() {
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                '}';
    }

    /**
     * 主键
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    /**
     * 密码
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 账号状态（0正常 1停用）
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * 手机号
     */
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    /**
     * 头像
     */
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    /**
     * 创建者
     */
    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * 更新者
     */
    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    public void setDelFlag(Integer delFlag){
        this.delFlag = delFlag;
    }


    /**
     * 主键
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 用户名
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * 昵称
     */
    public String getNickName(){
        return this.nickName;
    }

    /**
     * 密码
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * 账号状态（0正常 1停用）
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * 手机号
     */
    public String getPhonenumber(){
        return this.phonenumber;
    }

    /**
     * 头像
     */
    public String getAvatar(){
        return this.avatar;
    }

    /**
     * 创建者
     */
    public String getCreateBy(){
        return this.createBy;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime(){
        return this.createTime;
    }

    /**
     * 更新者
     */
    public String getUpdateBy(){
        return this.updateBy;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    public Integer getDelFlag(){
        return this.delFlag;
    }

}
