package com.ct.admin.dao.entity;

import java.util.Date;

public class TaskInterfaceLog {
    private Long id;

    private String taskRequestPath;

    private String taskRequestParam;

    private String taskReponseParam;

    private Date taskRequestTime;

    private Date taskReponseTime;

    private String taskSessionId;

    private String taskClientIp;

    private String taskRequestMethod;

    private String taskRequestType;

    private String taskReponseCode;

    private Date createTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskRequestPath() {
        return taskRequestPath;
    }

    public void setTaskRequestPath(String taskRequestPath) {
        this.taskRequestPath = taskRequestPath;
    }

    public String getTaskRequestParam() {
        return taskRequestParam;
    }

    public void setTaskRequestParam(String taskRequestParam) {
        this.taskRequestParam = taskRequestParam;
    }

    public String getTaskReponseParam() {
        return taskReponseParam;
    }

    public void setTaskReponseParam(String taskReponseParam) {
        this.taskReponseParam = taskReponseParam;
    }

    public Date getTaskRequestTime() {
        return taskRequestTime;
    }

    public void setTaskRequestTime(Date taskRequestTime) {
        this.taskRequestTime = taskRequestTime;
    }

    public Date getTaskReponseTime() {
        return taskReponseTime;
    }

    public void setTaskReponseTime(Date taskReponseTime) {
        this.taskReponseTime = taskReponseTime;
    }

    public String getTaskSessionId() {
        return taskSessionId;
    }

    public void setTaskSessionId(String taskSessionId) {
        this.taskSessionId = taskSessionId;
    }

    public String getTaskClientIp() {
        return taskClientIp;
    }

    public void setTaskClientIp(String taskClientIp) {
        this.taskClientIp = taskClientIp;
    }

    public String getTaskRequestMethod() {
        return taskRequestMethod;
    }

    public void setTaskRequestMethod(String taskRequestMethod) {
        this.taskRequestMethod = taskRequestMethod;
    }

    public String getTaskRequestType() {
        return taskRequestType;
    }

    public void setTaskRequestType(String taskRequestType) {
        this.taskRequestType = taskRequestType;
    }

    public String getTaskReponseCode() {
        return taskReponseCode;
    }

    public void setTaskReponseCode(String taskReponseCode) {
        this.taskReponseCode = taskReponseCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}