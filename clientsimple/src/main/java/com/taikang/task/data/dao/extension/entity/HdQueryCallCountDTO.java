package com.taikang.task.data.dao.extension.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询批量调用次数对象类
 */
@Data
public class HdQueryCallCountDTO implements Serializable {

    private String serviceCode;

    private Long serviceTypeId;

    private Long tenantId;

    private String flagChange;

    private String currentTime;

    private String lastWeekTime;

}
