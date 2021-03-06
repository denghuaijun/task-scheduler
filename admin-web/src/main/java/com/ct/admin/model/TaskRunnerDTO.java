package com.ct.admin.model;

import lombok.Data;

/**
 * taskrunner注解
 */
@Data
public class TaskRunnerDTO {

    private Long id;

    /**
     * 运行器名称
     */
    private String taskRunnerName;

    private String taskRunnerAppkey;

    private String taskRunnerAppname;

    private String taskRunnerAddress;

    private Integer discoveryServices;

    private Integer status;

    private Long creatorId;

    private String createAt;

    private Integer active;
}
