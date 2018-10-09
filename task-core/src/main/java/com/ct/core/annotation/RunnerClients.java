package com.ct.core.annotation;

import com.ct.core.runner.RunnerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RunnerRegistrar.class)
public @interface RunnerClients {

    String appkey();

    String port();

    String[] value() default {};

    String[] basePackages() default {};
}
