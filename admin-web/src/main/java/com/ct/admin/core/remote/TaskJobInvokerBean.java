package com.ct.admin.core.remote;

import com.ct.admin.constants.DBConsts;
import com.ct.admin.core.schedule.SchedulerFactory;
import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.dao.entity.TaskWarningManager;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskWarningService;
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



    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getTrigger().getJobKey();
        Long taskId = Long.parseLong(jobKey.getGroup());
        Long taskrunnerId = Long.parseLong(jobKey.getName());

        TaskrunnerService taskrunnerService = SchedulerFactory.getTaskrunnerService();
        TaskService taskService = SchedulerFactory.getTaskService();
        TaskWarningService taskWarningService = SchedulerFactory.getTaskWarningService();

        //获取Rpc地址数据封装RPC参数
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(taskrunnerId);
        Task validTask = taskService.findValidTask(taskId, DBConsts.TaskConst.Status.正常, DBConsts.TaskConst.Status.暂停);
        if (validTask != null && validTaskRunner != null) {
            //保存返回日志
            TaskLog taskLog = new TaskLog();
            SchedulerFactory.getTaskLogService().insertTaskLog(taskLog);
            TaskWarningManager taskWarning =null;
            if (validTask.getFkTaskwarningId() !=null){
                taskWarningService.findTaskWarning(validTask.getFkTaskwarningId());
            }
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
            if (run.getCode() == 500){//服务器异常发送告警信息
                taskService.sendWarningMessage(validTask,taskLog,taskWarning);
            }
        }
    }
}
