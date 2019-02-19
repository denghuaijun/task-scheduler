package com.ct.core.runner.eureka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class TaskEurekaClientConfiguration {

    private ConfigurableEnvironment env;

    public TaskEurekaClientConfiguration(ConfigurableEnvironment env) {
        this.env = env;
    }

    @Bean(destroyMethod = "stop" )
    public EurekaClientServiceBase eurekaClientServiceBase() {
        return new EurekaClientServiceBase();
    }



}
