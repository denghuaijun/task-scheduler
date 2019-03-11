package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdVendorService;
import com.taikang.task.data.dao.entity.HdVendorServiceExample;
import com.taikang.task.data.dao.entity.HdVendorServiceExample.Criteria;
import com.taikang.task.data.dao.entity.HdVendorServiceExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class HdVendorServiceSqlProvider {

    public String countByExample(HdVendorServiceExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("hd_vendor_service");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(HdVendorServiceExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("hd_vendor_service");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(HdVendorService record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hd_vendor_service");
        
        if (record.getVendorId() != null) {
            sql.VALUES("vendor_id", "#{vendorId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCode() != null) {
            sql.VALUES("service_code", "#{serviceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorizeMsg() != null) {
            sql.VALUES("authorize_msg", "#{authorizeMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceUrl() != null) {
            sql.VALUES("service_url", "#{serviceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getInterval() != null) {
            sql.VALUES("interval", "#{interval,jdbcType=INTEGER}");
        }
        
        if (record.getServiceTypeId() != null) {
            sql.VALUES("service_type_id", "#{serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceDesc() != null) {
            sql.VALUES("service_desc", "#{serviceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceStatus() != null) {
            sql.VALUES("service_status", "#{serviceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("level", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getServiceLink() != null) {
            sql.VALUES("service_link", "#{serviceLink,jdbcType=VARCHAR}");
        }
        
        if (record.getServicePhone() != null) {
            sql.VALUES("service_phone", "#{servicePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorCode() != null) {
            sql.VALUES("creator_code", "#{creatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyCode() != null) {
            sql.VALUES("modify_code", "#{modifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyTime() != null) {
            sql.VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(HdVendorServiceExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("vendor_id");
        sql.SELECT("service_code");
        sql.SELECT("authorize_msg");
        sql.SELECT("service_url");
        sql.SELECT("interval");
        sql.SELECT("service_type_id");
        sql.SELECT("service_desc");
        sql.SELECT("service_status");
        sql.SELECT("level");
        sql.SELECT("service_link");
        sql.SELECT("service_phone");
        sql.SELECT("creator_code");
        sql.SELECT("created_time");
        sql.SELECT("modify_code");
        sql.SELECT("modify_time");
        sql.FROM("hd_vendor_service");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        HdVendorService record = (HdVendorService) parameter.get("record");
        HdVendorServiceExample example = (HdVendorServiceExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("hd_vendor_service");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getVendorId() != null) {
            sql.SET("vendor_id = #{record.vendorId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCode() != null) {
            sql.SET("service_code = #{record.serviceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorizeMsg() != null) {
            sql.SET("authorize_msg = #{record.authorizeMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceUrl() != null) {
            sql.SET("service_url = #{record.serviceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getInterval() != null) {
            sql.SET("interval = #{record.interval,jdbcType=INTEGER}");
        }
        
        if (record.getServiceTypeId() != null) {
            sql.SET("service_type_id = #{record.serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceDesc() != null) {
            sql.SET("service_desc = #{record.serviceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceStatus() != null) {
            sql.SET("service_status = #{record.serviceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getServiceLink() != null) {
            sql.SET("service_link = #{record.serviceLink,jdbcType=VARCHAR}");
        }
        
        if (record.getServicePhone() != null) {
            sql.SET("service_phone = #{record.servicePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorCode() != null) {
            sql.SET("creator_code = #{record.creatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyCode() != null) {
            sql.SET("modify_code = #{record.modifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hd_vendor_service");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("vendor_id = #{record.vendorId,jdbcType=VARCHAR}");
        sql.SET("service_code = #{record.serviceCode,jdbcType=VARCHAR}");
        sql.SET("authorize_msg = #{record.authorizeMsg,jdbcType=VARCHAR}");
        sql.SET("service_url = #{record.serviceUrl,jdbcType=VARCHAR}");
        sql.SET("interval = #{record.interval,jdbcType=INTEGER}");
        sql.SET("service_type_id = #{record.serviceTypeId,jdbcType=BIGINT}");
        sql.SET("service_desc = #{record.serviceDesc,jdbcType=VARCHAR}");
        sql.SET("service_status = #{record.serviceStatus,jdbcType=INTEGER}");
        sql.SET("level = #{record.level,jdbcType=INTEGER}");
        sql.SET("service_link = #{record.serviceLink,jdbcType=VARCHAR}");
        sql.SET("service_phone = #{record.servicePhone,jdbcType=VARCHAR}");
        sql.SET("creator_code = #{record.creatorCode,jdbcType=VARCHAR}");
        sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        sql.SET("modify_code = #{record.modifyCode,jdbcType=VARCHAR}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        HdVendorServiceExample example = (HdVendorServiceExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HdVendorService record) {
        SQL sql = new SQL();
        sql.UPDATE("hd_vendor_service");
        
        if (record.getVendorId() != null) {
            sql.SET("vendor_id = #{vendorId,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceCode() != null) {
            sql.SET("service_code = #{serviceCode,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthorizeMsg() != null) {
            sql.SET("authorize_msg = #{authorizeMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceUrl() != null) {
            sql.SET("service_url = #{serviceUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getInterval() != null) {
            sql.SET("interval = #{interval,jdbcType=INTEGER}");
        }
        
        if (record.getServiceTypeId() != null) {
            sql.SET("service_type_id = #{serviceTypeId,jdbcType=BIGINT}");
        }
        
        if (record.getServiceDesc() != null) {
            sql.SET("service_desc = #{serviceDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceStatus() != null) {
            sql.SET("service_status = #{serviceStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getServiceLink() != null) {
            sql.SET("service_link = #{serviceLink,jdbcType=VARCHAR}");
        }
        
        if (record.getServicePhone() != null) {
            sql.SET("service_phone = #{servicePhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorCode() != null) {
            sql.SET("creator_code = #{creatorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyCode() != null) {
            sql.SET("modify_code = #{modifyCode,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyTime() != null) {
            sql.SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, HdVendorServiceExample example, boolean includeExamplePhrase) {
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