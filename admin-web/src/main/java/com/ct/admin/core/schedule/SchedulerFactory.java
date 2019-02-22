package com.ct.admin.core.schedule;

import com.ct.admin.service.TaskLogService;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskWarningService;
import com.ct.admin.service.TaskrunnerService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class SchedulerFactory implements ApplicationContextAware {

    @Getter
    private static Scheduler scheduler;

    @Getter
    private static TaskService taskService;

    @Getter
    private static TaskrunnerService taskrunnerService;

    @Getter
    private static TaskLogService taskLogService;

    @Getter
    private static RestTemplate restTemplate;

    @Getter
    private static TaskWarningService taskWarningService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SchedulerFactoryBean schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
        taskService = applicationContext.getBean(TaskService.class);
        taskrunnerService = applicationContext.getBean(TaskrunnerService.class);
        scheduler = schedulerFactoryBean.getScheduler();
        taskLogService = applicationContext.getBean(TaskLogService.class);
        taskWarningService = applicationContext.getBean(TaskWarningService.class);
        restTemplate = applicationContext.getBean(RestTemplate.class);
    }

    @PostConstruct
    public void init() {
        //注册监控

        log.info("初始化注册监控线程完成");

    }

    @PreDestroy
    public void dostory() {
        log.info("结束");
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
