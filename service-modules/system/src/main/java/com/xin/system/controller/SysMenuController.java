package com.xin.system.controller;

import com.xin.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 5:14
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@RestController
@RequestMapping("/api/admin/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
}
