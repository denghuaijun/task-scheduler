package com.ct.admin.core.schedule;

import com.ct.admin.core.remote.TaskJobInvokerBean;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.util.Date;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 10:5 2018/9/1
 * @ Description：调度功能方法handler
 * @ Modified By：
 * @Version:
 */
@Slf4j
public class SchedulerHandler {

    private static Scheduler scheduler;

    static {
        scheduler = SchedulerFactory.getScheduler();
    }
    public static boolean addTaskJob(String jobName,String jobGroup,String cron) throws SchedulerException {
        //设置触发器key
        if (checkJobExists(jobName, jobGroup)) {
            log.info("任务已存在 添加失败 , jobGroup:{}, jobName:{}", jobGroup, jobName);
            return false;
        }

        //设置CronSchedule
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule(cron)
                .withMisfireHandlingInstructionDoNothing();

        //设置Trigger
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        CronTrigger cronTrigger = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(cronScheduleBuilder)
                .build();

        //设置JobDetail
        Class<? extends Job> jobClass = TaskJobInvokerBean.class;
        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = JobBuilder
                .newJob(jobClass)
                .withIdentity(jobKey)
                .build();

        //加入到scheduler
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);
        log.info("添加任务成功, jobDetail:{}, cronTrigger:{}, date:{}", jobDetail, cronTrigger, date);
        return true;
    }

    /**
     * 删除调度任务
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean removeTaskJob(String jobName,String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkJobExists(jobName, jobGroup)) {
            scheduler.unscheduleJob(triggerKey);
            log.info("删除任务, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        return false;
    }

    /**
     * 暂停任务
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean pauseTaskJob(String jobName,String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkJobExists(jobName, jobGroup)) {
            scheduler.pauseTrigger(triggerKey);
            log.info("暂停任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        log.info("暂停任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
        return false;
    }


    /**
     * 恢复任务执行
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean resumeTaskJob(String jobName,String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkJobExists(jobName, jobGroup)) {
            scheduler.resumeTrigger(triggerKey);
            log.info("恢复任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        log.info("恢复任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
        return false;
    }

    /**
     * 执行一次任务
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean triggerJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkJobExists(jobName, jobGroup)) {
            scheduler.triggerJob(jobKey);
            log.info("执行任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        } else {
            log.info("执行任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }
    }

    /**
     * 检查任务是否存在
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean checkJobExists(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }

}
