package com.taikang.task.data;

import com.ct.core.annotation.RunnerClients;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@RunnerClients(appkey = "data", port = "8086",
        basePackages = {"com.taikang.task.data"},
        serviceurls = {"http://10.130.215.194:8761/eureka/"})
@ComponentScan(basePackages = {"springconfig","com.taikang.task.data"})
public class TaskClientApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskClientApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }
}
