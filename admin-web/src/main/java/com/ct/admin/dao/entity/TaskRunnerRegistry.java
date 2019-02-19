package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskRunnerRegistry {
    private Long id;

    private String taskRunnerAppkey;

    private String taskRunnerAddress;

    private Date pushTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskRunnerAppkey() {
        return taskRunnerAppkey;
    }

    public void setTaskRunnerAppkey(String taskRunnerAppkey) {
        this.taskRunnerAppkey = taskRunnerAppkey;
    }

    public String getTaskRunnerAddress() {
        return taskRunnerAddress;
    }

    public void setTaskRunnerAddress(String taskRunnerAddress) {
        this.taskRunnerAddress = taskRunnerAddress;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}