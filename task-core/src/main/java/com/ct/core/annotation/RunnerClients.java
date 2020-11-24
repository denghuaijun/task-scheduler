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

    String appkey(); // 执行器名称

    String port(); // 端口号

    String[] value() default {};

    String[] serviceurls() default {}; // 注册到哪些注册中心

    String[] basePackages() default {};// 扫描哪些包

    boolean discoveryEnable() default true;// 是否可以被发现
}
