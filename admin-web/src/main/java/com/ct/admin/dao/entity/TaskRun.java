package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskRun {
    private Long id;

    private String taskRunName;

    private String taskRunAppkey;

    private String taskRunAddress;

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

    public String getTaskRunName() {
        return taskRunName;
    }

    public void setTaskRunName(String taskRunName) {
        this.taskRunName = taskRunName;
    }

    public String getTaskRunAppkey() {
        return taskRunAppkey;
    }

    public void setTaskRunAppkey(String taskRunAppkey) {
        this.taskRunAppkey = taskRunAppkey;
    }

    public String getTaskRunAddress() {
        return taskRunAddress;
    }

    public void setTaskRunAddress(String taskRunAddress) {
        this.taskRunAddress = taskRunAddress;
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