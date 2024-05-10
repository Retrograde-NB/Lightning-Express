package com.xin.system.domain.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/25 上午 9:18
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysOperationLogPageDTO {
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @ApiModelProperty("业务类型（0其它 1新增 2修改 3删除）")
    private Integer businessType;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @ApiModelProperty("操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operatorType;
    /**
     * 操作状态（0正常 1异常）
     */
    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysOperationLogPageDTO{" +
                "businessType=" + businessType +
                ", operatorType=" + operatorType +
                ", status=" + status +
                '}';
    }
}
