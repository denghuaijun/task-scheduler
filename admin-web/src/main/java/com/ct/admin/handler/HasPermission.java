package com.ct.admin.handler;

import java.lang.annotation.*;

/**
 * 自定义注解，用来判断是否需要进行权限判断
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface HasPermission {
    boolean value();
}
