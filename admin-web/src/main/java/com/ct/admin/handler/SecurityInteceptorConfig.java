package com.ct.admin.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot2.x之后拦截器配置文件加载及相关拦截配置
 */
@Configuration
public class SecurityInteceptorConfig implements WebMvcConfigurer {
    /**
     * 注入拦截器对象bean
     * @return
     */
    @Bean
    public SecurityInteceptor securityInteceptor(){
        return new SecurityInteceptor();
    }

    /**
     * 进行对所有后台controller访问进行拦截，同时除去对静态资源的拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInteceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }
}
