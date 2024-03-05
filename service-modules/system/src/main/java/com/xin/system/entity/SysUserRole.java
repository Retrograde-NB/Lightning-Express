package com.xin.system.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 4:09
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 用户和角色关联表
 */
public class SysUserRole implements Serializable {

    /**
     * 用户ID
     */
    @NotNull(message="[用户ID]不能为空")
    @ApiModelProperty("用户ID")
    private Long userId;
    /**
     * 角色ID
     */
    @NotNull(message="[角色ID]不能为空")
    @ApiModelProperty("角色ID")
    private Long roleId;

    /**
     * 用户ID
     */
    private void setUserId(Long userId){
        this.userId = userId;
    }

    /**
     * 角色ID
     */
    private void setRoleId(Long roleId){
        this.roleId = roleId;
    }


    /**
     * 用户ID
     */
    private Long getUserId(){
        return this.userId;
    }

    /**
     * 角色ID
     */
    private Long getRoleId(){
        return this.roleId;
    }

}