package wang.niceu.task.simple;

import com.ct.core.annotation.RunnerClients;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@RunnerClients(appkey = "data", port = "8087", basePackages = {"wang.niceu.task.simple.service.impl"},
        serviceurls = {"http://localhost:8761/eureka/"})
@ComponentScan(basePackages = {"springconfig", "wang.niceu.task.simple"})
public class TaskClientApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskClientApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }
}
