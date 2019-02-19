package com.ct.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"springconfig","com.ct.admin.controller","com.ct.admin"})
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootStrap.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
