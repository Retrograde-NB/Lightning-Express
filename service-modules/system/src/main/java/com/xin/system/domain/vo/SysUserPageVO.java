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
    private List<SysUserVO> records;

    @Override
    public String toString() {
        return "SysUserPageVO{" +
                "records=" + records +
                '}';
    }

    public List<SysUserVO> getRecords() {
        return records;
    }

    public void setRecords(List<SysUserVO> records) {
        this.records = records;
    }
}
