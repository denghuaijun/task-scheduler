package com.ct.admin.core.remote;

import com.ct.admin.constants.DBConsts;
import com.ct.admin.core.schedule.SchedulerFactory;
import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskrunnerService;
import com.ct.core.client.RunnerInvokerDef;
import com.ct.core.model.ReturnDTO;
import com.ct.core.model.RpcTransport;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * InvokerBean
 * quartz调用类
 */
@Slf4j
public class TaskJobInvokerBean extends QuartzJobBean {

    private static final String OA_ID = "libin93";
    private static final String PLATNAME = "分布式调度平台";

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getTrigger().getJobKey();
        Long taskId = Long.parseLong(jobKey.getGroup());
        Long taskrunnerId = Long.parseLong(jobKey.getName());


        TaskrunnerService taskrunnerService = SchedulerFactory.getTaskrunnerService();
        TaskService taskService = SchedulerFactory.getTaskService();

        //获取Rpc地址数据封装RPC参数
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(taskrunnerId);
        Task validTask = taskService.findValidTask(taskId, DBConsts.TaskConst.Status.正常, DBConsts.TaskConst.Status.暂停);

        if (validTask != null && validTaskRunner != null) {
            //保存返回日志
            TaskLog taskLog = new TaskLog();
            SchedulerFactory.getTaskLogService().insertTaskLog(taskLog);


            log.info("开始执行调度任务 taskid:{} , taskrunnerid:{} , ", jobKey.getGroup(), jobKey.getName());
            RpcTransport.RpcRequestTransport build = RpcTransport.RequestBuilder()
                    //设置调用地址
                    .clientAddress(validTaskRunner.getTaskRunnerAddress())
                    .createTime(new Date().getTime())
                    .interfaceClass(RunnerInvokerDef.class)
                    .appKey(validTaskRunner.getTaskRunnerAppkey())
                    .appName(validTaskRunner.getTaskRunnerAppname())
                    .logId(taskLog.getId())
                    .build();

            ClientProxyBean clientProxyBean = new ClientProxyBean(build);
            RunnerInvokerDef runnerInvoker = (RunnerInvokerDef) clientProxyBean.get();
            ReturnDTO<String> run = runnerInvoker.run();


            taskLog.setCode(Integer.toString(run.getCode()));
            taskLog.setFkTaskId(validTask.getId());
            taskLog.setFkTaskRunnerId(validTaskRunner.getId());
            taskLog.setMessage(run.getMsg());
            taskLog.setRunnerAppname(validTaskRunner.getTaskRunnerAppname());
            taskLog.setRunnerAppkey(validTaskRunner.getTaskRunnerAppkey());
            taskLog.setRunnerAddress(build.getClientAddress());
            SchedulerFactory.getTaskLogService().updateTaskLog(taskLog);
        }

    }
}
