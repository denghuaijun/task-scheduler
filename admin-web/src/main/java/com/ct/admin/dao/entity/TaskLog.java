package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskLog {
    private Long id;

    private Long fkTaskId;

    private Long fkTaskRunnerId;

    private String runnerAppkey;

    private String runnerAppname;

    private String runnerAddress;

    private String message;

    private String code;

    private Date createTime;

    private Date taskStarttime;

    private Date taskEndtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkTaskId() {
        return fkTaskId;
    }

    public void setFkTaskId(Long fkTaskId) {
        this.fkTaskId = fkTaskId;
    }

    public Long getFkTaskRunnerId() {
        return fkTaskRunnerId;
    }

    public void setFkTaskRunnerId(Long fkTaskRunnerId) {
        this.fkTaskRunnerId = fkTaskRunnerId;
    }

    public String getRunnerAppkey() {
        return runnerAppkey;
    }

    public void setRunnerAppkey(String runnerAppkey) {
        this.runnerAppkey = runnerAppkey;
    }

    public String getRunnerAppname() {
        return runnerAppname;
    }

    public void setRunnerAppname(String runnerAppname) {
        this.runnerAppname = runnerAppname;
    }

    public String getRunnerAddress() {
        return runnerAddress;
    }

    public void setRunnerAddress(String runnerAddress) {
        this.runnerAddress = runnerAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTaskStarttime() {
        return taskStarttime;
    }

    public void setTaskStarttime(Date taskStarttime) {
        this.taskStarttime = taskStarttime;
    }

    public Date getTaskEndtime() {
        return taskEndtime;
    }

    public void setTaskEndtime(Date taskEndtime) {
        this.taskEndtime = taskEndtime;
    }
}