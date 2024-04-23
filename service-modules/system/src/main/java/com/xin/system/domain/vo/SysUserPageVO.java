package com.xin.system.domain.vo;

import java.util.Date;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 下午 2:24
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class SysUserPageVO extends PageVO{
    private List<SysUserVO> sysUserVOList;

    @Override
    public String toString() {
        return "SysUserPageVO{" +
                "sysUserVOList=" + sysUserVOList +
                ", total=" + total +
                '}';
    }

    public List<SysUserVO> getSysUserVOList() {
        return sysUserVOList;
    }

    public void setSysUserVOList(List<SysUserVO> sysUserVOList) {
        this.sysUserVOList = sysUserVOList;
    }
}
