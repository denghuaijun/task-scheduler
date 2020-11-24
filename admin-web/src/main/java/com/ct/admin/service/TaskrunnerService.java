package com.ct.admin.service;

import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.dao.entity.TaskRunnerExample;
import com.ct.admin.dao.mapper.TaskRunnerMapper;
import com.ct.admin.model.TaskRunnerDTO;
import com.ct.core.model.ReturnDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TaskrunnerService {

    @Resource
    private TaskService taskService;

    @Resource
    private TaskRunnerMapper taskRunnerMapper;

    @Autowired
    private EurekaClient eurekaClient;


    public TaskRunner findValidTaskRunner(long id) {
        TaskRunner taskRunner = taskRunnerMapper.selectByPrimaryKey(id);
        if (taskRunner != null && taskRunner.getActive().equals(new Short("1")) && taskRunner.getStatus().equals(1)) {
            return taskRunner;
        }
        return null;
    }

    /**
     * 添加运行器
     *
     * @param taskRunnerDTO
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskrunnerAdd(TaskRunnerDTO taskRunnerDTO) {

        ReturnDTO<String> stringReturnDTO = validateTaskRunner(taskRunnerDTO);
        if (stringReturnDTO.getCode() != ReturnDTO.RETURN_SUCCESS_CODE) {
            return stringReturnDTO;
        }

        TaskRunner taskRunner = new TaskRunner();
        taskRunner.setTaskRunnerName(taskRunnerDTO.getTaskRunnerName());
        taskRunner.setTaskRunnerAppkey(taskRunnerDTO.getTaskRunnerAppkey());
        taskRunner.setTaskRunnerAppname(taskRunnerDTO.getTaskRunnerAppname());
        taskRunner.setTaskRunnerAddress(taskRunnerDTO.getTaskRunnerAddress());
        taskRunner.setActive(new Short("1"));
        taskRunner.setCreateAt(new Date());
        taskRunner.setStatus(1);
        int i = taskRunnerMapper.insertSelective(taskRunner);
        if (i == 1) {
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.FAIL();
    }

    /**
     * 修改运行器参数（包含删除逻辑）
     *
     * @param taskRunnerDTO
     * @return
     */
    public ReturnDTO<String> taskrunnerModify(TaskRunnerDTO taskRunnerDTO) {
        ReturnDTO<String> stringReturnDTO = validateTaskRunner(taskRunnerDTO);
        if (stringReturnDTO.getCode() != ReturnDTO.RETURN_SUCCESS_CODE) {
            return stringReturnDTO;
        }
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.setId(taskRunnerDTO.getId());
        taskRunner.setTaskRunnerName(taskRunnerDTO.getTaskRunnerName());
        taskRunner.setTaskRunnerAppkey(taskRunnerDTO.getTaskRunnerAppkey());
        taskRunner.setTaskRunnerAppname(taskRunnerDTO.getTaskRunnerAppname());
        taskRunner.setTaskRunnerAddress(taskRunnerDTO.getTaskRunnerAddress());

        if (taskRunnerDTO.getActive() != null) {
            //删除
            taskRunner.setActive(new Short(taskRunnerDTO.getActive().shortValue()));
        }

        int i = taskRunnerMapper.updateByPrimaryKeySelective(taskRunner);
        if (i == 1) {
            return ReturnDTO.SUCCESS();
        }
        return ReturnDTO.SUCCESS();

    }

    public List<TaskRunner> findAllTaskrunner() {
        TaskRunnerExample taskRunnerExample = new TaskRunnerExample();
        taskRunnerExample.setOrderByClause(" id desc");
        taskRunnerExample.createCriteria().andActiveEqualTo(Short.valueOf("1"));
        List<TaskRunner> TaskRunners = taskRunnerMapper.selectByExample(taskRunnerExample);
        return TaskRunners;
    }

    public Map<String, Object> pageList(int start, int length) {
        TaskRunnerExample taskrunnerExample = new TaskRunnerExample();
        taskrunnerExample.setOrderByClause(" id desc");
        taskrunnerExample.createCriteria().andActiveEqualTo(new Short("1"));
        Page<Object> objects = PageHelper.offsetPage(start, length);

        // page list
        List<TaskRunner> tasks = taskRunnerMapper.selectByExample(taskrunnerExample);
        List taskrunnerList = new ArrayList();
        if (!tasks.isEmpty()) {
            tasks.forEach(n -> {
                TaskRunnerDTO taskRunnerDTO = new TaskRunnerDTO();
                taskRunnerDTO.setId(n.getId());
                taskRunnerDTO.setCreateAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(n.getCreateAt()));
                taskRunnerDTO.setStatus(n.getStatus());
                taskRunnerDTO.setTaskRunnerName(n.getTaskRunnerName());
                if (StringUtils.isBlank(n.getTaskRunnerAddress())) {
                    Application application = eurekaClient.getApplication(n.getTaskRunnerAppkey());
                    if (application != null) {
                        List<InstanceInfo> instances = application.getInstances();
                        Set<String> services = new HashSet<>();
                        for (InstanceInfo instance : instances) {
                            String ipAddr = instance.getIPAddr();
                            int port = instance.getPort();
                            services.add(ipAddr + ":" + port);
                        }
                        taskRunnerDTO.setTaskRunnerAddress("任务执行地址：" + Arrays.toString(services.toArray()));
                    } else {
                        taskRunnerDTO.setTaskRunnerAddress("没有找到服务");
                    }
                    taskRunnerDTO.setDiscoveryServices(1);
                } else {
                    taskRunnerDTO.setTaskRunnerAddress(n.getTaskRunnerAddress());
                    taskRunnerDTO.setDiscoveryServices(0);
                }


                taskRunnerDTO.setTaskRunnerAppkey(n.getTaskRunnerAppkey());
                taskRunnerDTO.setTaskRunnerAppname(n.getTaskRunnerAppname());
                taskrunnerList.add(taskRunnerDTO);
            });
        }

        //查询调度状态

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", objects.getTotal());        // 总记录数
        maps.put("recordsFiltered", objects.getTotal());    // 过滤后的总记录数
        maps.put("data", taskrunnerList);                    // 分页列表
        return maps;
    }

    /**
     * 重复校验
     *
     * @param taskRunnerDTO
     * @return
     */
    private ReturnDTO<String> validateTaskRunner(TaskRunnerDTO taskRunnerDTO) {
        if (taskRunnerDTO.getActive() != null) {
            //删除逻辑 校验是否有任务关联
            Task taskByTaskrunner = taskService.findTaskByTaskrunner(taskRunnerDTO.getId());
            if (taskByTaskrunner != null) {
                return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "失败: 运行器已被任务关联请先删除任务 : " + taskByTaskrunner.getTaskName());
            }
            return ReturnDTO.SUCCESS();
        }

        TaskRunnerExample taskRunnerExample = new TaskRunnerExample();
        TaskRunnerExample.Criteria criteria = taskRunnerExample.createCriteria();
        criteria.andActiveEqualTo(new Short("1"));
        if (taskRunnerDTO.getId() != null) {
            criteria.andIdNotEqualTo(taskRunnerDTO.getId());
        }
        criteria.andTaskRunnerNameEqualTo(taskRunnerDTO.getTaskRunnerName());
        long count = taskRunnerMapper.countByExample(taskRunnerExample);
        if (count > 0) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "添加失败: 运行器名称已存在");
        }
        criteria = taskRunnerExample.createCriteria();
        criteria.andActiveEqualTo(new Short("1"));
        criteria.andTaskRunnerAddressEqualTo(taskRunnerDTO.getTaskRunnerAddress());
        criteria.andTaskRunnerAppkeyEqualTo(taskRunnerDTO.getTaskRunnerAppkey());
        criteria.andTaskRunnerAppnameEqualTo(taskRunnerDTO.getTaskRunnerAppname());
        if (taskRunnerDTO.getId() != null) {
            criteria.andIdNotEqualTo(taskRunnerDTO.getId());
        }
        count = taskRunnerMapper.countByExample(taskRunnerExample);
        if (count > 0) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "失败: 运行器 appKey、appName、服务器地址 已存在");
        }


        return ReturnDTO.SUCCESS();
    }

}
