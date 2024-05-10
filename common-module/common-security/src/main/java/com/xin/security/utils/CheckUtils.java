package com.xin.security.utils;

import com.xin.security.annotation.IsPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Retrograde-LX
 * @Date 2024/05/10 下午 1:15
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Component
public class CheckUtils {

    @Autowired
    public CheckPermissionsUtils checkPermissionsUtils;

    /**
     * 根据注解传入参数鉴权, 如果验证未通过，则抛出异常: NotPermissionException
     *
     * @param isPermissions 权限注解
     */
    public void checkPermissions(IsPermissions isPermissions) {
        checkPermissionsUtils.checkPermission(isPermissions);
    }
}
