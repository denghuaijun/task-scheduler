package com.ct.core.annotation;

import com.ct.core.runner.RunnerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 15:08 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RunnerRegistrar.class)
public @interface Runner {

    String appname();
}
