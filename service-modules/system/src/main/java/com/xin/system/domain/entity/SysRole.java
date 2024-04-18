package com.xin.system.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 4:07
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 角色信息表
 */
public class SysRole implements Serializable {

    /**
     * 角色ID
     */
    @NotNull(message="[角色ID]不能为空")
    @ApiModelProperty("角色ID")
    private Long id;
    /**
     * 角色名称
     */
    @NotBlank(message="[角色名称]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    @ApiModelProperty("角色名称")
    @Length(max= 30,message="编码长度不能超过30")
    private String roleName;
    /**
     * 角色权限字符串
     */
    @NotBlank(message="[角色权限字符串]不能为空")
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("角色权限字符串")
    @Length(max= 100,message="编码长度不能超过100")
    private String roleKey;
    /**
     * 显示顺序
     */
    @NotNull(message="[显示顺序]不能为空")
    @ApiModelProperty("显示顺序")
    private Integer roleSort;
    /**
     * 角色状态（0正常 1停用）
     */
    @NotNull(message="[角色状态（0正常 1停用）]不能为空")
    @ApiModelProperty("角色状态（0正常 1停用）")
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    private String delFlag;
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
     * 备注
     */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("备注")
    @Length(max= 500,message="编码长度不能超过500")
    private String remark;

    /**
     * 角色ID
     */
    private void setId(Long id){
        this.id = id;
    }

    /**
     * 角色名称
     */
    private void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /**
     * 角色权限字符串
     */
    private void setRoleKey(String roleKey){
        this.roleKey = roleKey;
    }

    /**
     * 显示顺序
     */
    private void setRoleSort(Integer roleSort){
        this.roleSort = roleSort;
    }

    /**
     * 角色状态（0正常 1停用）
     */
    private void setStatus(String status){
        this.status = status;
    }

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private void setDelFlag(String delFlag){
        this.delFlag = delFlag;
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
     * 备注
     */
    private void setRemark(String remark){
        this.remark = remark;
    }


    /**
     * 角色ID
     */
    private Long getId(){
        return this.id;
    }

    /**
     * 角色名称
     */
    private String getRoleName(){
        return this.roleName;
    }

    /**
     * 角色权限字符串
     */
    private String getRoleKey(){
        return this.roleKey;
    }

    /**
     * 显示顺序
     */
    private Integer getRoleSort(){
        return this.roleSort;
    }

    /**
     * 角色状态（0正常 1停用）
     */
    private String getStatus(){
        return this.status;
    }

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String getDelFlag(){
        return this.delFlag;
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
     * 备注
     */
    private String getRemark(){
        return this.remark;
    }

}
