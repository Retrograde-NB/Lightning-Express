package com.xin.swagger.annotation;

import com.xin.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 上午 9:59
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ SwaggerAutoConfiguration.class })
public @interface EnableCustomSwagger2 {
}
