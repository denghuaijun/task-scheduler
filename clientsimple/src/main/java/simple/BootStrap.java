package simple;

import com.ct.core.annotation.RunnerClients;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@RunnerClients(appkey = "test1", port = "8086",
        basePackages = "simple.impl",
        serviceurls = {"http://10.130.215.194:8761/eureka/"})
@ComponentScan("simple.impl")
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootStrap.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }
}
