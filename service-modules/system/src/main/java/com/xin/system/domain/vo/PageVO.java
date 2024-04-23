package com.xin.system.domain.vo;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 下午 2:23
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class PageVO {
    public Long total;

    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
