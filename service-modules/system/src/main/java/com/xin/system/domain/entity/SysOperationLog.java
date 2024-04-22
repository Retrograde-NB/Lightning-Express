package com.xin.system.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:03
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysOperationLog implements Serializable {
    /**
     * 操作日志主键
     */
    @NotNull(message="[操作日志主键]不能为空")
    @ApiModelProperty("操作日志主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 模块标题
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("模块标题")
    @Length(max= 50,message="编码长度不能超过50")
    private String title;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @ApiModelProperty("业务类型（0其它 1新增 2修改 3删除）")
    private Integer businessType;
    /**
     * 方法名称
     */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("方法名称")
    @Length(max= 100,message="编码长度不能超过100")
    private String method;
    /**
     * 请求方式
     */
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("请求方式")
    @Length(max= 10,message="编码长度不能超过10")
    private String requestMethod;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @ApiModelProperty("操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operatorType;
    /**
     * 操作人员
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("操作人员")
    @Length(max= 50,message="编码长度不能超过50")
    private String operationName;
    /**
     * 部门名称
     */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("部门名称")
    @Length(max= 50,message="编码长度不能超过50")
    private String deptName;
    /**
     * 请求URL
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("请求URL")
    @Length(max= 255,message="编码长度不能超过255")
    private String operationUrl;
    /**
     * 主机地址
     */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("主机地址")
    @Length(max= 128,message="编码长度不能超过128")
    private String operationIp;
    /**
     * 操作地点
     */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("操作地点")
    @Length(max= 255,message="编码长度不能超过255")
    private String operationLocation;
    /**
     * 请求参数
     */
    @Size(max= 2000,message="编码长度不能超过2000")
    @ApiModelProperty("请求参数")
    @Length(max= 2000,message="编码长度不能超过2000")
    private String operationParam;
    /**
     * 返回参数
     */
    @Size(max= 2000,message="编码长度不能超过2000")
    @ApiModelProperty("返回参数")
    @Length(max= 2000,message="编码长度不能超过2000")
    private String jsonResult;
    /**
     * 操作状态（0正常 1异常）
     */
    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;
    /**
     * 错误消息
     */
    @Size(max= 2000,message="编码长度不能超过2000")
    @ApiModelProperty("错误消息")
    @Length(max= 2000,message="编码长度不能超过2000")
    private String errorMsg;
    /**
     * 操作时间
     */
    @ApiModelProperty("操作时间")
    private Date operationTime;
    /**
     * 消耗时间
     */
    @ApiModelProperty("消耗时间")
    private Long costTime;

    public SysOperationLog(Long id, String title, Integer businessType, String method, String requestMethod, Integer operatorType, String operationName, String deptName, String operationUrl, String operationIp, String operationLocation, String operationParam, String jsonResult, Integer status, String errorMsg, Date operationTime, Long costTime) {
        this.id = id;
        this.title = title;
        this.businessType = businessType;
        this.method = method;
        this.requestMethod = requestMethod;
        this.operatorType = operatorType;
        this.operationName = operationName;
        this.deptName = deptName;
        this.operationUrl = operationUrl;
        this.operationIp = operationIp;
        this.operationLocation = operationLocation;
        this.operationParam = operationParam;
        this.jsonResult = jsonResult;
        this.status = status;
        this.errorMsg = errorMsg;
        this.operationTime = operationTime;
        this.costTime = costTime;
    }

    public SysOperationLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp;
    }

    public String getOperationLocation() {
        return operationLocation;
    }

    public void setOperationLocation(String operationLocation) {
        this.operationLocation = operationLocation;
    }

    public String getOperationParam() {
        return operationParam;
    }

    public void setOperationParam(String operationParam) {
        this.operationParam = operationParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "SysOperationLog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", businessType=" + businessType +
                ", method='" + method + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", operatorType=" + operatorType +
                ", operationName='" + operationName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", operationUrl='" + operationUrl + '\'' +
                ", operationIp='" + operationIp + '\'' +
                ", operationLocation='" + operationLocation + '\'' +
                ", operationParam='" + operationParam + '\'' +
                ", jsonResult='" + jsonResult + '\'' +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                ", operationTime=" + operationTime +
                ", costTime=" + costTime +
                '}';
    }
}
