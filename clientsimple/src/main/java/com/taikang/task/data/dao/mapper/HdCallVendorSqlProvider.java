package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdCallVendorExample;
import com.taikang.task.data.dao.entity.HdCallVendorExample.Criteria;
import com.taikang.task.data.dao.entity.HdCallVendorExample.Criterion;
import com.taikang.task.data.dao.entity.HdCallVendorWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class HdCallVendorSqlProvider {

    public String countByExample(HdCallVendorExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("hd_call_vendor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(HdCallVendorExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("hd_call_vendor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(HdCallVendorWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hd_call_vendor");
        
        if (record.getTenantId() != null) {
            sql.VALUES("tenant_id", "#{tenantId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.VALUES("service_id", "#{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getIdType() != null) {
            sql.VALUES("id_type", "#{idType,jdbcType=INTEGER}");
        }
        
        if (record.getIdNum() != null) {
            sql.VALUES("id_num", "#{idNum,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNo() != null) {
            sql.VALUES("serial_no", "#{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.VALUES("client_ip", "#{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getServerIp() != null) {
            sql.VALUES("server_ip", "#{serverIp,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgChange() != null) {
            sql.VALUES("falg_change", "#{falgChange,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.VALUES("expire_time", "#{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqParam() != null) {
            sql.VALUES("req_param", "#{reqParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getHealthData() != null) {
            sql.VALUES("health_data", "#{healthData,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getRetContent() != null) {
            sql.VALUES("ret_content", "#{retContent,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(HdCallVendorExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("tenant_id");
        sql.SELECT("service_id");
        sql.SELECT("id_type");
        sql.SELECT("id_num");
        sql.SELECT("serial_no");
        sql.SELECT("client_ip");
        sql.SELECT("server_ip");
        sql.SELECT("falg_change");
        sql.SELECT("created_time");
        sql.SELECT("expire_time");
        sql.SELECT("req_param");
        sql.SELECT("health_data");
        sql.SELECT("ret_content");
        sql.FROM("hd_call_vendor");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(HdCallVendorExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("tenant_id");
        sql.SELECT("service_id");
        sql.SELECT("id_type");
        sql.SELECT("id_num");
        sql.SELECT("serial_no");
        sql.SELECT("client_ip");
        sql.SELECT("server_ip");
        sql.SELECT("falg_change");
        sql.SELECT("created_time");
        sql.SELECT("expire_time");
        sql.FROM("hd_call_vendor");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        HdCallVendorWithBLOBs record = (HdCallVendorWithBLOBs) parameter.get("record");
        HdCallVendorExample example = (HdCallVendorExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("hd_call_vendor");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTenantId() != null) {
            sql.SET("tenant_id = #{record.tenantId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getIdType() != null) {
            sql.SET("id_type = #{record.idType,jdbcType=INTEGER}");
        }
        
        if (record.getIdNum() != null) {
            sql.SET("id_num = #{record.idNum,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getServerIp() != null) {
            sql.SET("server_ip = #{record.serverIp,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgChange() != null) {
            sql.SET("falg_change = #{record.falgChange,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqParam() != null) {
            sql.SET("req_param = #{record.reqParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getHealthData() != null) {
            sql.SET("health_data = #{record.healthData,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getRetContent() != null) {
            sql.SET("ret_content = #{record.retContent,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hd_call_vendor");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("tenant_id = #{record.tenantId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        sql.SET("id_type = #{record.idType,jdbcType=INTEGER}");
        sql.SET("id_num = #{record.idNum,jdbcType=VARCHAR}");
        sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        sql.SET("server_ip = #{record.serverIp,jdbcType=VARCHAR}");
        sql.SET("falg_change = #{record.falgChange,jdbcType=INTEGER}");
        sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        sql.SET("req_param = #{record.reqParam,jdbcType=LONGVARCHAR}");
        sql.SET("health_data = #{record.healthData,jdbcType=LONGVARCHAR}");
        sql.SET("ret_content = #{record.retContent,jdbcType=LONGVARCHAR}");
        
        HdCallVendorExample example = (HdCallVendorExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hd_call_vendor");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("tenant_id = #{record.tenantId,jdbcType=BIGINT}");
        sql.SET("service_id = #{record.serviceId,jdbcType=BIGINT}");
        sql.SET("id_type = #{record.idType,jdbcType=INTEGER}");
        sql.SET("id_num = #{record.idNum,jdbcType=VARCHAR}");
        sql.SET("serial_no = #{record.serialNo,jdbcType=VARCHAR}");
        sql.SET("client_ip = #{record.clientIp,jdbcType=VARCHAR}");
        sql.SET("server_ip = #{record.serverIp,jdbcType=VARCHAR}");
        sql.SET("falg_change = #{record.falgChange,jdbcType=INTEGER}");
        sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        sql.SET("expire_time = #{record.expireTime,jdbcType=TIMESTAMP}");
        
        HdCallVendorExample example = (HdCallVendorExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HdCallVendorWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("hd_call_vendor");
        
        if (record.getTenantId() != null) {
            sql.SET("tenant_id = #{tenantId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceId() != null) {
            sql.SET("service_id = #{serviceId,jdbcType=BIGINT}");
        }
        
        if (record.getIdType() != null) {
            sql.SET("id_type = #{idType,jdbcType=INTEGER}");
        }
        
        if (record.getIdNum() != null) {
            sql.SET("id_num = #{idNum,jdbcType=VARCHAR}");
        }
        
        if (record.getSerialNo() != null) {
            sql.SET("serial_no = #{serialNo,jdbcType=VARCHAR}");
        }
        
        if (record.getClientIp() != null) {
            sql.SET("client_ip = #{clientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getServerIp() != null) {
            sql.SET("server_ip = #{serverIp,jdbcType=VARCHAR}");
        }
        
        if (record.getFalgChange() != null) {
            sql.SET("falg_change = #{falgChange,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpireTime() != null) {
            sql.SET("expire_time = #{expireTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReqParam() != null) {
            sql.SET("req_param = #{reqParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getHealthData() != null) {
            sql.SET("health_data = #{healthData,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getRetContent() != null) {
            sql.SET("ret_content = #{retContent,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, HdCallVendorExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}