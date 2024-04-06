package com.xin.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 上午 10:36
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 地址 swagger-ui/index.html
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 是否开启swagger配置，生产环境需关闭
     */
    @Value("${swagger.enabled}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(enable)
                .apiInfo(this.apiInfo())
                .select() // 指定需要发布到Swagger的接口目录，不支持通配符
                .apis(RequestHandlerSelectors.basePackage("com.xin"))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(this.newHashSet("https", "http"));
    }
    /**
     * 项目信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger Api Doc")
                .description("接口文档")
                .contact(new Contact("user", null, "2352017802@qq.com"))
                .version("Application Version: 1.0.0")
                .build();
    }
    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }
}
