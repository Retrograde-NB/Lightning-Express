package com.xin.system.domain.vo;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 下午 2:23
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class PageVO {
    /**
     * 总共数据
     */
    public Long total;
    /**
     * 每页数据大小
     */
    public Integer size;
    /**
     * 当前页数
     */
    public Integer current;
    /**
     * 总共页码
     */
    public Integer pages;

    @Override
    public String toString() {
        return "PageVO{" +
                "total=" + total +
                ", size=" + size +
                ", current=" + current +
                ", pages=" + pages +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
