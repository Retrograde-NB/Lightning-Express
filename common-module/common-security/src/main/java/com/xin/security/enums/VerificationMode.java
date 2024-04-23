package com.xin.security.enums;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/23 上午 10:47
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 验证的模式，与 和 或
 */
public enum VerificationMode {
    /**
     * 必须具有所有的元素
     */
    AND,

    /**
     * 只需具有其中一个元素
     */
    OR
}
