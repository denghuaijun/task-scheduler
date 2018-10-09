package com.ct.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 13:10 2018/9/7
 * @ Description：任务DTO类
 * @ Modified By：
 * @Version:
 */
@Data
public class TaskDTO {

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 关联运行器id
     */
    private Long taskRunnerId;

    /**
     * cron 配置
     */
    private String taskCron;

    /**
     * 任务状态
     */
    private Integer taskStatus;

    /**
     * 任务创建时间
     */
    private Date createAt;

    /**
     * 状态（冗余）
     */
    private Integer status;

}

