package com.ct.admin.service;

import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.entity.TaskLogExample;
import com.ct.admin.dao.mapper.TaskLogMapper;
import com.ct.admin.model.TaskLogDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 21:12 2018/9/27
 * @ Description： 任务日志服务类
 * @ Modified By：
 * @Version:
 */
@Service
public class TaskLogService {

    @Resource
    private TaskLogMapper taskLogMapper;

    public void insertTaskLog(TaskLog taskLog) {
        taskLog.setCreateTime(new Date());
        taskLogMapper.insert(taskLog);
    }
    /**
     * 查询任务器列表
     *
     * @param start
     * @param length
     * @return
     */
    public Map<String, Object> pageList(int start, int length) {

        TaskLogExample example = new TaskLogExample();
        example.setOrderByClause(" create_time desc");
        Page<Object> objects = PageHelper.offsetPage(start, length);

        // page list
        List<TaskLog> taskLogList = taskLogMapper.selectByExample(example);
        List list = new ArrayList();
        if (!taskLogList.isEmpty()) {
            taskLogList.forEach(n -> {
                TaskLogDTO taskLogDTO = new TaskLogDTO();
                taskLogDTO.setCode(n.getCode());
                taskLogDTO.setCreateTime(n.getCreateTime());
                taskLogDTO.setRunnerAddress(n.getRunnerAddress());
                taskLogDTO.setRunnerAppKey(n.getRunnerAppkey());
                taskLogDTO.setRunnerAppName(n.getRunnerAppname());
                taskLogDTO.setTaskId(n.getFkTaskId());
                taskLogDTO.setTaskLogId(n.getId());
                taskLogDTO.setTaskRunnerId(n.getFkTaskRunnerId());
                list.add(taskLogDTO);
            });
        }
        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", objects.getTotal());        // 总记录数
        maps.put("recordsFiltered", objects.getTotal());    // 过滤后的总记录数
        maps.put("data", list);                    // 分页列表
        return maps;
    }
}
