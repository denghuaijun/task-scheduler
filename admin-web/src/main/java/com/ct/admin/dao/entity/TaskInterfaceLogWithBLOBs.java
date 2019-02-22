package com.ct.admin.dao.entity;

public class TaskInterfaceLogWithBLOBs extends TaskInterfaceLog {
    private String taskRequestParam;

    private String taskReponseParam;

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
}