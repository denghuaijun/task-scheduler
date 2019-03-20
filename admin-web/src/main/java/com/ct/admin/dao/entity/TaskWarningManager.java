package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskWarningManager {
    private Long id;

    private String taskWarningCount;

    private String taskWarningName;

    private Integer status;

    private Integer active;

    private Date createTime;

    private Date updateTime;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}