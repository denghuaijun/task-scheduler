package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskWarningManager {
    private Long id;

    private String taskWarningCount;

    private String taskWarningName;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskWarningCount() {
        return taskWarningCount;
    }

    public void setTaskWarningCount(String taskWarningCount) {
        this.taskWarningCount = taskWarningCount;
    }

    public String getTaskWarningName() {
        return taskWarningName;
    }

    public void setTaskWarningName(String taskWarningName) {
        this.taskWarningName = taskWarningName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}