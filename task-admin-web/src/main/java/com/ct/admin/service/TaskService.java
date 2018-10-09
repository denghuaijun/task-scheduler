package com.ct.admin.service;

import com.ct.admin.constants.DBConsts;
import com.ct.admin.core.schedule.SchedulerHandler;
import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskExample;
import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.dao.mapper.TaskMapper;
import com.ct.admin.model.TaskDTO;
import com.ct.core.model.ReturnDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 20:23 2018/9/27
 * @ Description： 任务服务类
 * @ Modified By：
 * @Version:
 */
@Slf4j
@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;

    @Resource
    private TaskrunnerService taskrunnerService;

    /**
     * 查询任务器列表
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
            tasks.forEach(n->{
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setCreateAt(n.getCreateAt());
                taskDTO.setTaskId(n.getFkTaskrunnerId());
                taskDTO.setStatus(n.getStatus());
                taskDTO.setTaskCron(n.getTaskCron());
                taskDTO.setTaskId(n.getId());
                taskDTO.setTaskName(n.getTaskName());
                taskList.add(taskDTO);
            });
        }

        //查询调度状态

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", objects.getTotal());		// 总记录数
        maps.put("recordsFiltered", objects.getTotal());	// 过滤后的总记录数
        maps.put("data", taskList);  					// 分页列表
        return maps;
    }

    /**
     * 删除任务
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
                SchedulerHandler.removeTaskJob(String.valueOf(task.getFkTaskrunnerId()),String.valueOf(task.getId()));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE,"删除任务失败:" + e.getMessage());
            }
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.FAIL();
    }

    /**
     * 添加任务
     * @param taskDTO
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskAdd(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskCron(taskDTO.getTaskCron());
        task.setFkTaskrunnerId(taskDTO.getTaskRunnerId());
        task.setStatus(1);
        task.setCreateAt(new Date());
        int i = taskMapper.insertSelective(task);
        if (i == 1) {
            try {
                SchedulerHandler.addTaskJob(String.valueOf(task.getFkTaskrunnerId()),String.valueOf(task.getId()) , taskDTO.getTaskCron());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                try {
                    SchedulerHandler.removeTaskJob(String.valueOf(task.getId()),String.valueOf(task.getFkTaskrunnerId()));
                } catch (SchedulerException e1) {
                    log.error(e.getMessage(), e1);
                }
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE,"添加任务失败:" + e.getMessage());
            }
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.FAIL();
    }

    /**
     * 任务修改
     * @param taskDTO
     * @return
     */
    public ReturnDTO<String> taskModify(TaskDTO taskDTO) {

        return ReturnDTO.SUCCESS();
    }

    /**
     * 任务暂停
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
            SchedulerHandler.pauseTaskJob(validTaskRunner.getId().toString(),task.getId().toString());
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE,"暂停任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    /**
     * 任务恢复
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
            SchedulerHandler.resumeTaskJob(validTaskRunner.getId().toString(),task.getId().toString());
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE,"恢复任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    /**
     * 执行一次任务
     * @param id
     * @return
     */
    public ReturnDTO<String> triggerJob(long id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        TaskRunner validTaskRunner = taskrunnerService.findValidTaskRunner(task.getFkTaskrunnerId());
        try {
            SchedulerHandler.triggerJob(validTaskRunner.getId().toString(),task.getId().toString());
        } catch (SchedulerException e) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE,"恢复任务失败:" + e.getMessage());
        }
        return ReturnDTO.SUCCESS();
    }

    public Task findValidTask(Long taskId , DBConsts.TaskConst.Status... status) {

        Task task = taskMapper.selectByPrimaryKey(taskId);

        if (task == null || task.getActive().equals(new Short("0"))) {
            return null;
        }

        if (status!=null) {
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
}
