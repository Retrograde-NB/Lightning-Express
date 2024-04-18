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
 * @Date 2024/03/05 下午 4:06
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 菜单权限表
 */
public class SysMenu implements Serializable {

    /**
     * 菜单ID
     */
    @NotNull(message="[菜单ID]不能为空")
    @ApiModelProperty("菜单ID")
    private Long id;
    /**
     * 菜单名称
     */
    @NotBlank(message="[菜单名称]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("菜单名称")
    @Length(max= 50,message="编码长度不能超过50")
    private String menuName;
    /**
     * 父菜单ID
     */
    @ApiModelProperty("父菜单ID")
    private Long parentId;
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer orderNum;
    /**
     * 路由地址
     */
    @Size(max= 200,message="编码长度不能超过200")
    @ApiModelProperty("路由地址")
    @Length(max= 200,message="编码长度不能超过200")
    private String path;
    /**
     * 组件路径
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("组件路径")
    @Length(max= 255,message="编码长度不能超过255")
    private String component;
    /**
     * 是否为外链（0是 1否）
     */
    @ApiModelProperty("是否为外链（0是 1否）")
    private String isFrame;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    @ApiModelProperty("菜单状态（0正常 1停用）")
    private String status;
    /**
     * 权限标识
     */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("权限标识")
    @Length(max= 100,message="编码长度不能超过100")
    private String perms;
    /**
     * 菜单图标
     */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("菜单图标")
    @Length(max= 100,message="编码长度不能超过100")
    private String icon;
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
    //@ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("备注")
    @Length(max= 500,message="编码长度不能超过500")
    private String remark;

    /**
     * 菜单ID
     */
    private void setId(Long id){
        this.id = id;
    }

    /**
     * 菜单名称
     */
    private void setMenuName(String menuName){
        this.menuName = menuName;
    }

    /**
     * 父菜单ID
     */
    private void setParentId(Long parentId){
        this.parentId = parentId;
    }

    /**
     * 显示顺序
     */
    private void setOrderNum(Integer orderNum){
        this.orderNum = orderNum;
    }

    /**
     * 路由地址
     */
    private void setPath(String path){
        this.path = path;
    }

    /**
     * 组件路径
     */
    private void setComponent(String component){
        this.component = component;
    }

    /**
     * 是否为外链（0是 1否）
     */
    private void setIsFrame(String isFrame){
        this.isFrame = isFrame;
    }

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private void setMenuType(String menuType){
        this.menuType = menuType;
    }

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private void setVisible(String visible){
        this.visible = visible;
    }

    /**
     * 菜单状态（0正常 1停用）
     */
    private void setStatus(String status){
        this.status = status;
    }

    /**
     * 权限标识
     */
    private void setPerms(String perms){
        this.perms = perms;
    }

    /**
     * 菜单图标
     */
    private void setIcon(String icon){
        this.icon = icon;
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
     * 菜单ID
     */
    private Long getId(){
        return this.id;
    }

    /**
     * 菜单名称
     */
    private String getMenuName(){
        return this.menuName;
    }

    /**
     * 父菜单ID
     */
    private Long getParentId(){
        return this.parentId;
    }

    /**
     * 显示顺序
     */
    private Integer getOrderNum(){
        return this.orderNum;
    }

    /**
     * 路由地址
     */
    private String getPath(){
        return this.path;
    }

    /**
     * 组件路径
     */
    private String getComponent(){
        return this.component;
    }

    /**
     * 是否为外链（0是 1否）
     */
    private String getIsFrame(){
        return this.isFrame;
    }

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String getMenuType(){
        return this.menuType;
    }

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String getVisible(){
        return this.visible;
    }

    /**
     * 菜单状态（0正常 1停用）
     */
    private String getStatus(){
        return this.status;
    }

    /**
     * 权限标识
     */
    private String getPerms(){
        return this.perms;
    }

    /**
     * 菜单图标
     */
    private String getIcon(){
        return this.icon;
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
