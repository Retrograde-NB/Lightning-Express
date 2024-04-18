package com.xin.system.domain.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 4:08
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 角色和菜单关联表
 */

public class SysRoleMenu implements Serializable {

    /**
    * 角色ID
    */
    @NotNull(message="[角色ID]不能为空")
    @ApiModelProperty("角色ID")
    private Long roleId;
    /**
    * 菜单ID
    */
    @NotNull(message="[菜单ID]不能为空")
    @ApiModelProperty("菜单ID")
    private Long menuId;

    /**
    * 角色ID
    */
    private void setRoleId(Long roleId){
    this.roleId = roleId;
    }

    /**
    * 菜单ID
    */
    private void setMenuId(Long menuId){
    this.menuId = menuId;
    }


    /**
    * 角色ID
    */
    private Long getRoleId(){
    return this.roleId;
    }

    /**
    * 菜单ID
    */
    private Long getMenuId(){
    return this.menuId;
    }

}