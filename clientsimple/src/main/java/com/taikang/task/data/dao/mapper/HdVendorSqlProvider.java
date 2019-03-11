package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdVendor;
import com.taikang.task.data.dao.entity.HdVendorExample;
import com.taikang.task.data.dao.entity.HdVendorExample.Criteria;
import com.taikang.task.data.dao.entity.HdVendorExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class HdVendorSqlProvider {

    public String countByExample(HdVendorExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("hd_vendor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(HdVendorExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("hd_vendor");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(HdVendor record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hd_vendor");
        
        if (record.getVendorCode() != null) {
            sql.VALUES("vendor_code", "#{vendorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorName() != null) {
            sql.VALUES("vendor_name", "#{vendorName,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPerson() != null) {
            sql.VALUES("vendor_person", "#{vendorPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPhone() != null) {
            sql.VALUES("vendor_phone", "#{vendorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorStatus() != null) {
            sql.VALUES("vendor_status", "#{vendorStatus,jdbcType=INTEGER}");
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

    public String selectByExample(HdVendorExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("vendor_code");
        sql.SELECT("vendor_name");
        sql.SELECT("vendor_person");
        sql.SELECT("vendor_phone");
        sql.SELECT("vendor_status");
        sql.SELECT("creator_code");
        sql.SELECT("created_time");
        sql.SELECT("modify_code");
        sql.SELECT("modify_time");
        sql.FROM("hd_vendor");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        HdVendor record = (HdVendor) parameter.get("record");
        HdVendorExample example = (HdVendorExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("hd_vendor");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getVendorCode() != null) {
            sql.SET("vendor_code = #{record.vendorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorName() != null) {
            sql.SET("vendor_name = #{record.vendorName,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPerson() != null) {
            sql.SET("vendor_person = #{record.vendorPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPhone() != null) {
            sql.SET("vendor_phone = #{record.vendorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorStatus() != null) {
            sql.SET("vendor_status = #{record.vendorStatus,jdbcType=INTEGER}");
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
        sql.UPDATE("hd_vendor");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("vendor_code = #{record.vendorCode,jdbcType=VARCHAR}");
        sql.SET("vendor_name = #{record.vendorName,jdbcType=VARCHAR}");
        sql.SET("vendor_person = #{record.vendorPerson,jdbcType=VARCHAR}");
        sql.SET("vendor_phone = #{record.vendorPhone,jdbcType=VARCHAR}");
        sql.SET("vendor_status = #{record.vendorStatus,jdbcType=INTEGER}");
        sql.SET("creator_code = #{record.creatorCode,jdbcType=VARCHAR}");
        sql.SET("created_time = #{record.createdTime,jdbcType=TIMESTAMP}");
        sql.SET("modify_code = #{record.modifyCode,jdbcType=VARCHAR}");
        sql.SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        HdVendorExample example = (HdVendorExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HdVendor record) {
        SQL sql = new SQL();
        sql.UPDATE("hd_vendor");
        
        if (record.getVendorCode() != null) {
            sql.SET("vendor_code = #{vendorCode,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorName() != null) {
            sql.SET("vendor_name = #{vendorName,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPerson() != null) {
            sql.SET("vendor_person = #{vendorPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorPhone() != null) {
            sql.SET("vendor_phone = #{vendorPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getVendorStatus() != null) {
            sql.SET("vendor_status = #{vendorStatus,jdbcType=INTEGER}");
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

    protected void applyWhere(SQL sql, HdVendorExample example, boolean includeExamplePhrase) {
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