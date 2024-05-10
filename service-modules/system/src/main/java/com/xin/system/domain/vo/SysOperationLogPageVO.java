package com.xin.system.domain.vo;

import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/25 上午 9:21
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysOperationLogPageVO {
    private Long total;
    private List<SysOperationLogVO> sysOperationLogVOList;

    @Override
    public String toString() {
        return "SysOperationLogPageVO{" +
                "total=" + total +
                ", sysOperationLogVOList=" + sysOperationLogVOList +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<SysOperationLogVO> getSysOperationLogVOList() {
        return sysOperationLogVOList;
    }

    public void setSysOperationLogVOList(List<SysOperationLogVO> sysOperationLogVOList) {
        this.sysOperationLogVOList = sysOperationLogVOList;
    }
}
