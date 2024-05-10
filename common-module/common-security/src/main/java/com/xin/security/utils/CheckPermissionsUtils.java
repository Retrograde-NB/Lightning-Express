package com.xin.security.utils;

import com.xin.common.constant.Constants;
import com.xin.common.constant.RedisConstants;
import com.xin.common.exception.XinException;
import com.xin.common.redis.service.RedisService;
import com.xin.common.utils.JwtUtils;
import com.xin.common.utils.StringUtils;
import com.xin.security.annotation.IsPermissions;
import com.xin.security.enums.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import java.util.Collection;
import java.util.List;

/**
 * @Author Retrograde-LX
 * @Date 2024/05/10 下午 1:20
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Component
public class CheckPermissionsUtils {
    @Autowired
    private RedisService redisService;

    /**
     * 所有权限标识
     */
    private static final String ALL_PERMISSION = "*:*:*";

    /**
     * 从redis中获取当前用户权限列表
     *
     * @return 权限列表
     */
    public List<String> getPermissions() {
        String token = redisService.getCacheObject(RedisConstants.TOKEN);
        return redisService.getCacheList(RedisConstants.PERMISSION_KEY + JwtUtils.getIdByJwtToken(token));
    }

    /**
     * 根据注解(@IsPermissions)鉴权, 如果验证未通过，则抛出异常: NotPermissionException
     *
     * @param isPermissions 注解对象
     */
    public void checkPermission(IsPermissions isPermissions) {
        // 判断是与还是或
        if (isPermissions.verificationMode() == VerificationMode.AND) {
            checkPermissionAnd(isPermissions.value());
        } else {
            checkPermissionOr(isPermissions.value());
        }
    }

    /**
     * 验证用户是否含有指定权限，必须全部拥有
     *
     * @param permissions 权限列表
     */
    public void checkPermissionAnd(String... permissions) {
        List<String> permissionList = getPermissions();
        for (String permission : permissions) {
            if (!hasPermission(permissionList, permission)) {
                throw new XinException(Constants.FAIL, "权限不足");
            }
        }
    }

    /**
     * 验证用户是否含有指定权限，只需包含其中一个
     *
     * @param permissions 权限列表
     */
    public void checkPermissionOr(String... permissions) {
        List<String> permissionList = getPermissions();
        for (String permission : permissions) {
            if (hasPermission(permissionList, permission)) {
                return;
            }
        }
        if (permissions.length > 0) {
            throw new XinException(Constants.FAIL, "权限不足");
        }
    }

    public boolean hasPermission(Collection<String> authorities, String permission) {
        return authorities.stream().filter(StringUtils::hasText)
                .anyMatch(x -> ALL_PERMISSION.contains(x) || PatternMatchUtils.simpleMatch(x, permission));
    }
}
