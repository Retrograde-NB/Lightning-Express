package com.xin.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/07 上午 9:24
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Configuration
@MapperScan("com.xin.*.mapper")
public class MybatisPlusConfig {

}
