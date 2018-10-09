package com.ct.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 12:11 2018/9/6
 * @ Description：任务DTO类
 * @ Modified By：
 * @Version:
 */
@Data
public class TaskRunnerDTO {

    private Long id;

    /**
     * 运行器名称
     */
    private String taskRunnerName;

    /**
     * 运行器Appkey
     */
    private String taskRunnerAppkey;

    /**
     * 运行器Appname
     */
    private String taskRunnerAppname;

    /**
     * 运行器Address
     */
    private String taskRunnerAddress;

    /**
     * 运行器状态
     */
    private Integer status;

    /**
     * 创建用户id
     */
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 状态
     */
    private Integer active;
}
