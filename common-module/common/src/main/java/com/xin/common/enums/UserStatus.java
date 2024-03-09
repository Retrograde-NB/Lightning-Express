package com.xin.common.enums;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 2:42
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public enum UserStatus {
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("1", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
