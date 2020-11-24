package com.ct.admin.model;

import lombok.Data;

@Data
public class TaskDTO {

    private Long taskId;

    private String taskName;

    private Long taskRunnerId;

    private Long taskWarningId;

    private String taskCron;

    private Integer taskStatus;

    private String createAt;

    private Integer status;

}

