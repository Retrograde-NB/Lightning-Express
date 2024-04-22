package com.xin.log.enums;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 9:16
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 业务操作的类型
 */
public enum OperationType {
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 查询
     */
    SELECT,

    /**
     * 清空数据
     */
    CLEAN,
}
