package com.ct.admin.dao.entity;

import java.util.Date;

public class Task {
    private Long id;

    private String taskName;

    private Long fkTaskrunnerId;

    private Long fkTaskwarningId;

    private String taskCron;

    private Long creatorId;

    private Date createAt;

    private Integer status;

    private Integer taskStatus;

    private Short active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getFkTaskrunnerId() {
        return fkTaskrunnerId;
    }

    public void setFkTaskrunnerId(Long fkTaskrunnerId) {
        this.fkTaskrunnerId = fkTaskrunnerId;
    }

    public Long getFkTaskwarningId() {
        return fkTaskwarningId;
    }

    public void setFkTaskwarningId(Long fkTaskwarningId) {
        this.fkTaskwarningId = fkTaskwarningId;
    }

    public String getTaskCron() {
        return taskCron;
    }

    public void setTaskCron(String taskCron) {
        this.taskCron = taskCron;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }
}