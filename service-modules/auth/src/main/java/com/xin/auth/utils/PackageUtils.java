package com.xin.auth.utils;

import com.xin.common.constant.Constants;
import com.xin.common.domain.system.dto.SysLoginInfoDTO;
import com.xin.common.utils.IpUtils;
import com.xin.common.utils.ReflectionUtils;
import com.xin.common.utils.ServletUtils;
import com.xin.common.utils.StringUtils;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/22 下午 12:20
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class PackageUtils {
    public static SysLoginInfoDTO getSysLoginInfoDTO(String username, String msg, String status){
        SysLoginInfoDTO sysLoginInfoDTO = ReflectionUtils.newInstance(SysLoginInfoDTO.class);
        sysLoginInfoDTO.setUserName(username);
        sysLoginInfoDTO.setMsg(msg);
        sysLoginInfoDTO.setBrowser(ServletUtils.getBrowser());
        sysLoginInfoDTO.setIpAddress(IpUtils.getIpAddr());
        sysLoginInfoDTO.setOs(ServletUtils.getOS());
        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) {
            sysLoginInfoDTO.setStatus(Constants.LOGIN_SUCCESS_STATUS);
        } else if (Constants.LOGIN_FAIL.equals(status)) {
            sysLoginInfoDTO.setStatus(Constants.LOGIN_FAIL_STATUS);
        }
        return sysLoginInfoDTO;
    }
}
