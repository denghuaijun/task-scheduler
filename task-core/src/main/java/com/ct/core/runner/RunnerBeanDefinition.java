package com.ct.core.runner;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.lang.reflect.Method;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Data
public class RunnerBeanDefinition<T> implements InitializingBean, DisposableBean, ApplicationContextAware, ApplicationListener, BeanNameAware {

    private ApplicationContext applicationContext;

    private T ref;

    private String appKey;

    private String appName;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Method[] methods = ref.getClass().getDeclaredMethods();
        for (Method method : methods) {
            BeanFactoryMapper.ServiceBean serviceBean = new BeanFactoryMapper.ServiceBean();
            serviceBean.setBean(ref);
            serviceBean.setMethod(method);
            String mapKey = BeanFactoryMapper.createAppKey(appKey, appName, method.getName());
            BeanFactoryMapper.add(mapKey, serviceBean);
        }
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //添加到
    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
