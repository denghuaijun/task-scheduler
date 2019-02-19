package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskRunner {
    private Long id;

    private String taskRunnerName;

    private String taskRunnerAppkey;

    private String taskRunnerAppname;

    private String taskRunnerAddress;

    private Integer status;

    private Short active;

    private Long creatorId;

    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskRunnerName() {
        return taskRunnerName;
    }

    public void setTaskRunnerName(String taskRunnerName) {
        this.taskRunnerName = taskRunnerName;
    }

    public String getTaskRunnerAppkey() {
        return taskRunnerAppkey;
    }

    public void setTaskRunnerAppkey(String taskRunnerAppkey) {
        this.taskRunnerAppkey = taskRunnerAppkey;
    }

    public String getTaskRunnerAppname() {
        return taskRunnerAppname;
    }

    public void setTaskRunnerAppname(String taskRunnerAppname) {
        this.taskRunnerAppname = taskRunnerAppname;
    }

    public String getTaskRunnerAddress() {
        return taskRunnerAddress;
    }

    public void setTaskRunnerAddress(String taskRunnerAddress) {
        this.taskRunnerAddress = taskRunnerAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}