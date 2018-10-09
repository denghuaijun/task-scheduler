package com.ct.core.runner;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class BeanFactoryMapper {

    private static ConcurrentHashMap<String ,ServiceBean> beanMap = new ConcurrentHashMap();

    public static String createAppKey(String appKey, String appName, String methodName) {
        return appKey + "[" + appName + "]:" + methodName;

    }

    public static ServiceBean getBeanMapper(String key) {
        return beanMap.get(key);
    }

    public static void add(String key, ServiceBean serviceBean) {
        beanMap.put(key, serviceBean);
    }


    @Data
    public static class ServiceBean{

        private Object bean;

        private Method method;

    }
}
