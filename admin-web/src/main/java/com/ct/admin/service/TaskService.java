package com.ct.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.ct.admin.constants.DBConsts;
import com.ct.admin.core.schedule.SchedulerHandler;
import com.ct.admin.dao.entity.*;
import com.ct.admin.dao.mapper.TaskMapper;
import com.ct.admin.model.TaskDTO;
import com.ct.core.model.ReturnDTO;
import com.ct.core.utils.HttpUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskrunnerService taskrunnerService;

    @Value("${send.warning.project.url}")
    private String sendUrl;

    /**
     * 查询任务器列表
     *
     * @param start
     * @param length
     * @return
     */
    public Map<String, Object> pageList(int start, int length) {

        TaskExample taskExample = new TaskExample();
        taskExample.setOrderByClause(" id desc");
        taskExample.createCriteria().andActiveEqualTo(new Short("1"));
        Page<Object> objects = PageHelper.offsetPage(start, length);

        // page list
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        List taskList = new ArrayList();
        if (!tasks.isEmpty()) {
            tasks.forEach(n -> {
                TaskDTO taskDTO = new TaskDTO();

                taskDTO.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(n.getCreateAt()));
                taskDTO.setTaskId(n.getFkTaskrunnerId());
                taskDTO.setStatus(n.getStatus());
                taskDTO.setTaskCron(n.getTaskCron());
                taskDTO.setTaskId(n.getId());
                taskDTO.setTaskName(n.getTaskName());
                taskDTO.setTaskRunnerId(n.getFkTaskrunnerId());
                taskList.add(taskDTO);
            });
        }

        //查询调度状态

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", objects.getTotal());        // 总记录数
        maps.put("recordsFiltered", objects.getTotal());    // 过滤后的总记录数
        maps.put("data", taskList);                    // 分页列表
        return maps;
    }

    /**
     * 删除任务
     *
     * @param id
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskDelete(long id) {
        //删除任务
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setActive(new Short("0"));
        int i = taskMapper.updateByPrimaryKeySelective(task);
        if (i == 1) {
            try {
                SchedulerHandler.removeTaskJob(String.valueOf(task.getFkTaskrunnerId()), String.valueOf(task.getId()));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "删除任务失败:" + e.getMessage());
            }
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.FAIL();
    }

    /**
     * 添加任务
     *
     * @param taskDTO
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskAdd(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskCron(taskDTO.getTaskCron());
        task.setFkTaskrunnerId(taskDTO.getTaskRunnerId());
        task.setFkTaskwarningId(taskDTO.getTaskWarningId());
        task.setStatus(1);
        task.setCreateAt(new Date());
        int i = taskMapper.insertSelective(task);
        if (i == 1) {
            try {
                SchedulerHandler.addTaskJob(String.valueOf(task.getFkTaskrunnerId()), String.valueOf(task.getId()), taskDTO.getTaskCron());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                try {
                    SchedulerHandler.removeTaskJob(String.valueOf(task.getId()), String.valueOf(task.getFkTaskrunnerId()));
                } catch (SchedulerException e1) {
                    log.error(e.getMessage(), e1);
                }
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "添加任务失败:" + e.getMessage());
            }
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.FAIL();
    }

    /**
     * 任务修改
     *
     * @param taskDTO
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskModify(TaskDTO taskDTO) {
        Long taskId = taskDTO.getTaskId();
        Task oldtask = taskMapper.selectByPrimaryKey(taskId);
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(taskDTO.getTaskRunnerId());
        if (validTaskRunner == null) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "修改任务异常，请检查参数！");
        }

        //修改更新
        Task task = new Task();
        task.setId(taskId);
        task.setFkTaskwarningId(taskDTO.getTaskWarningId());
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskCron(taskDTO.getTaskCron());
        task.setFkTaskrunnerId(taskDTO.getTaskRunnerId());
        task.setStatus(1);
        taskMapper.updateByPrimaryKeySelective(task);

        //只更新触发器
        if (!taskDTO.getTaskCron().equals(oldtask.getTaskCron())) {
            //执行器变更，更新调度器
            try {
                boolean rescheduleJob = SchedulerHandler.rescheduleJob(String.valueOf(validTaskRunner.getId()), String.valueOf(taskId), taskDTO.getTaskCron());
                if (!rescheduleJob) {
                    log.error("修改新任务失败 runnerId:{} , taskId:{} , Cron:{}", taskDTO.getTaskRunnerId(), taskId, taskDTO.getTaskCron());
                    rescheduleJob = SchedulerHandler.rescheduleJob(String.valueOf(oldtask.getFkTaskrunnerId()), String.valueOf(taskId), oldtask.getTaskCron());
                    if (!rescheduleJob) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                    return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "修改任务异常，新增任务失败！");
                }
            } catch (SchedulerException e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error(e.getMessage(), e);
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "系统异常！" + e.getMessage());
            }
        }
        if (taskDTO.getTaskRunnerId().compareTo(oldtask.getFkTaskrunnerId())!=0) {
            //执行器变更，更新调度器
            try {
                boolean removeTaskJob = SchedulerHandler.removeTaskJob(String.valueOf(oldtask.getFkTaskrunnerId()), String.valueOf(taskId));

                if (!removeTaskJob) {
                    log.error("修改新任务失败 removeTaskJob runnerId:{} , taskId:{} , Cron:{}", taskDTO.getTaskRunnerId(), taskId, taskDTO.getTaskCron());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "修改任务异常，新增任务失败！");
                }
                boolean addTaskJob = SchedulerHandler.addTaskJob(String.valueOf(taskDTO.getTaskRunnerId()), String.valueOf(taskId),taskDTO.getTaskCron());
                if (!addTaskJob) {
                    log.error("修改新任务失败 addTaskJob runnerId:{} , taskId:{} , Cron:{}", taskDTO.getTaskRunnerId(), taskId, taskDTO.getTaskCron());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "修改任务异常，新增任务失败！");
                }
            } catch (SchedulerException e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                log.error(e.getMessage(), e);
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "系统异常！" + e.getMessage());
            }
        }
        return ReturnDTO.SUCCESS();
    }

    /**
     * 任务暂停
     *
     * @param id
     * @return
     */
    @Transactional
    public ReturnDTO<String> pause(long id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setStatus(2);
        taskMapper.updateByPrimaryKeySelective(task);
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(task.getFkTaskrunnerId());
        try {
            SchedulerHandler.pauseTaskJob(validTaskRunner.getId().toString(), task.getId().toString());
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "暂停任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    /**
     * 任务恢复
     *
     * @param id
     * @return
     */
    @Transactional
    public ReturnDTO<String> resume(long id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        task.setStatus(1);
        taskMapper.updateByPrimaryKeySelective(task);
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(task.getFkTaskrunnerId());
        try {
            SchedulerHandler.resumeTaskJob(validTaskRunner.getId().toString(), task.getId().toString());
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "恢复任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    /**
     * 执行一次任务
     *
     * @param id
     * @return
     */
    public ReturnDTO<String> triggerJob(long id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(task.getFkTaskrunnerId());
        try {
            SchedulerHandler.triggerJob(validTaskRunner.getId().toString(), task.getId().toString());
        } catch (SchedulerException e) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "恢复任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    public Task findValidTask(Long taskId, DBConsts.TaskConst.Status... status) {

        Task task = taskMapper.selectByPrimaryKey(taskId);

        if (task == null || task.getActive().equals(new Short("0"))) {
            return null;
        }

        if (status != null) {
            for (DBConsts.TaskConst.Status status1 : status) {
                if (status1.value == task.getStatus().intValue()) {
                    return task;
                }
            }
        }
        return null;
    }


    public Task findTaskByTaskrunner(Long taskrunnerId) {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andFkTaskrunnerIdEqualTo(taskrunnerId).andActiveEqualTo(new Short("1"));
        PageHelper.startPage(1, 1);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        if (tasks.size() > 0) {
            return tasks.get(0);
        }
        return null;
    }

    /**
     * 调度任务出现异常给相关告警人员发送告警
     * @param task
     * @param taskLog
     * @param taskWarning
     */
    public void sendWarningMessage(Task task,TaskLog taskLog, TaskWarningManager taskWarning){
        try {
            //组织请求数据
            HashMap map = new HashMap();
            map.put("tos",taskWarning == null ? "libin93":taskWarning.getTaskWarningCount());
            map.put("platform","分布式调度平台");
            map.put("content","执行调度任务服务器处理异常，异常任务名称【"+task.getTaskName()+"】，执行器ID：【"+taskLog.getFkTaskRunnerId()+"】-名称【"+taskLog.getRunnerAppname()+"】，请到平台查看！");
            String result = HttpUtil.postForm(map,sendUrl);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String code = jsonObject.getString("code");
            if ("200".equals(code)){
                log.info("告警信息发送成功，已发送至告警组账号为：{}",taskWarning.getTaskWarningCount());
            }else {
                log.info("告警信息发送失败，返回code:{}",code);
            }
        } catch (Exception e) {
            log.info("告警信息发送异常IOException：{}",e);
        }
    }
}
