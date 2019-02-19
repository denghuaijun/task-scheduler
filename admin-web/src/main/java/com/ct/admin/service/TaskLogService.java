package com.ct.admin.service;

import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.mapper.TaskLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 20:42 2018/9/27
 * @ Description：
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

    public void updateTaskLog(TaskLog taskLog) {
        taskLogMapper.updateByPrimaryKeySelective(taskLog);
    }
}
