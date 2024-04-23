package com.xin.common.utils;

import com.github.pagehelper.PageHelper;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 下午 1:50
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 分页工具类
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        int pageNum = Integer.parseInt(ServletUtils.getParameter("pageNum"));
        int pageSize = Integer.parseInt(ServletUtils.getParameter("pageSize"));
        PageHelper.startPage(pageNum, pageSize).setReasonable(true);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
