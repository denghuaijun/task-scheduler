package com.ct.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * 任务日志回显展示
 */
@Data
public class TaskLogDTO {

    private Long taskLogId;//日志ID

    private Long taskId;//任务ID

    private Long taskRunnerId;//执行器ID

    private String runnerAppKey;//执行器appKey

    private String runnerAppName;//执行器执行的调度类名

    private String runnerAddress;//执行器地址

    private String code;

    private Date createTime;//创建时间



}
