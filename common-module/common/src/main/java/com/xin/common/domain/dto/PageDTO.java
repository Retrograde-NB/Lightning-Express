package com.xin.common.domain.dto;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/22 下午 3:05
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class PageDTO {
    private Integer pageNum;
    private Integer pageSize;

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
