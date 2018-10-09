package com.ct.admin.service;

import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.mapper.TaskLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

}
