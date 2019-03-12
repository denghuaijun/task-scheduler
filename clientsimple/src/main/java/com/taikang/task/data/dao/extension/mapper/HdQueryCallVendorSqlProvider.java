package com.taikang.task.data.dao.extension.mapper;

import com.taikang.task.data.dao.extension.entity.HdQueryCallCountDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class HdQueryCallVendorSqlProvider {

    public String countByCallCount(HdQueryCallCountDTO dto){
        SQL sql = new SQL();
        sql.SELECT("count(*)");
        sql.FROM("hd_call_vendor hcv");
        sql.LEFT_OUTER_JOIN("hd_vendor_service hvs ON hcv.`service_id` = hvs.`id` ");
        if (dto.getServiceTypeId() !=null){
        sql.WHERE("hvs.`service_type_id` = #{serviceTypeId,jdbcType=BIGINT}");
        }
        if (dto.getTenantId() !=null){
            sql.WHERE("hcv.`tenant_id` = #{tenantId,jdbcType=BIGINT}");
        }
        if (StringUtils.isNotEmpty(dto.getServiceCode())){
            sql.WHERE("hvs.`service_code`=#{serviceCode,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotEmpty(dto.getFlagChange())){
            sql.WHERE("hcv.`falg_change`=#{flagChange,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotEmpty(dto.getCurrentTime())) {
            sql.WHERE("hcv.`created_time`<= #{currentTime,jdbcType=VARCHAR}");
        }
        if (StringUtils.isNotEmpty(dto.getLastWeekTime())){
            sql.WHERE("hcv.`created_time`> #{lastWeekTime,jdbcType=VARCHAR}");

        }        return sql.toString();
    }
}
