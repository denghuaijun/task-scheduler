package springconfig;

import com.ct.admin.core.schedule.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class SchedulerConfiguration {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }




    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory =  new HttpComponentsClientHttpRequestFactory();
        //httpRequestFactory.setReadTimeout(5000);
        //httpRequestFactory.setConnectTimeout(5000);
        return new RestTemplate(httpRequestFactory);
    }

/*    @Bean(name = "dataSource")
    @Qualifier(value = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }*/


    @Bean
    public SchedulerFactoryBean getQuartzScheduler(DataSource primaryDataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(primaryDataSource);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setStartupDelay(20);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        Resource resource = resourceLoader.getResource("classpath:quartz.properties");
        schedulerFactoryBean.setConfigLocation(resource);
        return schedulerFactoryBean;

    }

    @Bean
    public SchedulerFactory initSchedulerFactory() {
        SchedulerFactory schedulerFactory = new SchedulerFactory();
        return schedulerFactory;
    }
}
