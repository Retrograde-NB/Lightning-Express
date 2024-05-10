package com.xin.system.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/25 上午 9:21
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysOperationLogVO {
    /**
     * 操作日志主键
     */
    @NotNull(message="[操作日志主键]不能为空")
    @ApiModelProperty("操作日志主键")
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
     * 操作状态（0正常 1异常）
     */
    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;
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

    @Override
    public String toString() {
        return "SysOperationLogVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", businessType=" + businessType +
                ", requestMethod='" + requestMethod + '\'' +
                ", operatorType=" + operatorType +
                ", operationName='" + operationName + '\'' +
                ", status=" + status +
                ", operationTime=" + operationTime +
                ", costTime=" + costTime +
                '}';
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
