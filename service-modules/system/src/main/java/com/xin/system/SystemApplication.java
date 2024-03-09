package com.xin.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/05 下午 3:04
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@SpringBootApplication
@ComponentScan({"com.xin"})
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
