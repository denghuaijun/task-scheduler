package com.ct.admin.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaskWarningDTO {
    private Long id;

    private String taskWarningCount;

    private String taskWarningName;

    private Date createTime;
}