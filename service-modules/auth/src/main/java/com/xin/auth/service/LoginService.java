package com.xin.auth.service;

import com.xin.auth.domain.dto.AdminLoginDTO;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 8:55
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public interface LoginService {
    String adminLogin(AdminLoginDTO adminLoginDTO);
}
