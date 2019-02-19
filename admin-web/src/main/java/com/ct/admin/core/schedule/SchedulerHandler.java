package com.ct.admin.core.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ct.admin.core.remote.TaskJobInvokerBean;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
public class SchedulerHandler {

    private static Scheduler scheduler;

    static {
        scheduler = SchedulerFactory.getScheduler();
    }

    public static boolean addTaskJob(String jobName, String jobGroup, String cron) throws SchedulerException {
        //设置触发器key
        if (checkTriggerKeyExists(jobName, jobGroup)) {
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
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean removeTaskJob(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkTriggerKeyExists(jobName, jobGroup)) {
            scheduler.unscheduleJob(triggerKey);
            log.info("删除任务, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        return false;
    }

    /**
     * 暂停任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean pauseTaskJob(String jobName, String jobGroup) throws SchedulerException {


        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkTriggerKeyExists(jobName, jobGroup)) {
            scheduler.pauseTrigger(triggerKey);
            log.info("暂停任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        log.info("暂停任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
        return false;
    }


    /**
     * 恢复任务执行
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean resumeTaskJob(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkTriggerKeyExists(jobName, jobGroup)) {

           // scheduler.resumeTrigger(triggerKey);
            JobKey jobKey = new JobKey(jobName, jobGroup);

            scheduler.resumeJob(jobKey);
            log.info("恢复任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        }
        log.info("恢复任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
        return false;
    }

    /**
     * 执行一次任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean triggerJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        if (checkTriggerKeyExists(jobName, jobGroup)) {
            scheduler.triggerJob(jobKey);
            log.info("执行任务成功, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        } else {
            log.info("执行任务失败, jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }
    }


    /**
     * 修改
     *
     * @param jobGroup
     * @param jobName
     * @param cronExpression
     * @return
     * @throws SchedulerException
     */
    public static boolean rescheduleJob(String jobName, String jobGroup, String cronExpression) throws SchedulerException {
        if (!checkTriggerKeyExists(jobName, jobGroup)) {
            log.info("triggerKey 不存在 , jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        CronTrigger oldTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        if (oldTrigger != null) {
            String oldCron = oldTrigger.getCronExpression();
            if (oldCron.equals(cronExpression)) {
                return true;
            }
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
            oldTrigger = oldTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, oldTrigger);
            return true;
        }

        log.info("修改任务失败 rescheduleJob , jobName:{}, jobGroup:{}", jobName, jobGroup);
        return false;
    }


    /**
     * 检查任务是否存在
     *
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public static boolean checkTriggerKeyExists(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }

    /**
     * 测试使用 移除全部的scheduler
     *
     * @return
     * @throws SchedulerException
     */
    public static JSONObject unscheduleByAll(boolean delete) throws SchedulerException {
        JSONObject jsonObject = new JSONObject();
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        jsonObject.put("jobGroupNames", jobGroupNames);
        Set<String> pausedTriggerGroups = scheduler.getPausedTriggerGroups();
        jsonObject.put("pausedTriggerGroups", pausedTriggerGroups);
        List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
        jsonObject.put("triggerGroupNames", triggerGroupNames);
        Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(GroupMatcher.anyGroup());
        JSONArray triggerJsonArray = new JSONArray();
        for (TriggerKey triggerKey : triggerKeys) {
            Trigger trigger = scheduler.getTrigger(triggerKey);
            TriggerKey key = trigger.getKey();
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("group", key.getGroup());
            jsonObject1.put("name", key.getName());
            jsonObject1.put("starttime", trigger.getStartTime());
            jsonObject1.put("endtime", trigger.getEndTime());
            jsonObject1.put("previousfiretime", trigger.getPreviousFireTime());
            jsonObject1.put("nextfiretime", trigger.getNextFireTime());
            jsonObject1.put("finalfiretime", trigger.getFinalFireTime());
            triggerJsonArray.add(jsonObject1);
            if (delete) {
                scheduler.unscheduleJob(triggerKey);
            }
        }
        jsonObject.put("triggerdetail", triggerJsonArray);
        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyJobGroup());
        JSONArray jobJsonArray = new JSONArray();
        for (JobKey jobKey : jobKeys) {
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            JobKey key = jobDetail.getKey();
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("group", key.getGroup());
            jsonObject1.put("name", key.getName());
            jobJsonArray.add(jsonObject1);
        }
        jsonObject.put("jobdetail", jobJsonArray);
        String jsonString = JSON.toJSONString(jsonObject,


                SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);


        return jsonObject;
    }

}
