package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskInterfaceLogExample.Criteria;
import com.ct.admin.dao.entity.TaskInterfaceLogExample.Criterion;
import com.ct.admin.dao.entity.TaskInterfaceLogExample;
import com.ct.admin.dao.entity.TaskInterfaceLogWithBLOBs;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskInterfaceLogSqlProvider {

    public String countByExample(TaskInterfaceLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("task_interface_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskInterfaceLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("task_interface_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskInterfaceLogWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("task_interface_log");
        
        if (record.getTaskRequestPath() != null) {
            sql.VALUES("task_request_path", "#{taskRequestPath,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestTime() != null) {
            sql.VALUES("task_request_time", "#{taskRequestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskReponseTime() != null) {
            sql.VALUES("task_reponse_time", "#{taskReponseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskSessionId() != null) {
            sql.VALUES("task_session_id", "#{taskSessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskClientIp() != null) {
            sql.VALUES("task_client_ip", "#{taskClientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestMethod() != null) {
            sql.VALUES("task_request_method", "#{taskRequestMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestType() != null) {
            sql.VALUES("task_request_type", "#{taskRequestType,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskReponseCode() != null) {
            sql.VALUES("task_reponse_code", "#{taskReponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestParam() != null) {
            sql.VALUES("task_request_param", "#{taskRequestParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTaskReponseParam() != null) {
            sql.VALUES("task_reponse_param", "#{taskReponseParam,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(TaskInterfaceLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_request_path");
        sql.SELECT("task_request_time");
        sql.SELECT("task_reponse_time");
        sql.SELECT("task_session_id");
        sql.SELECT("task_client_ip");
        sql.SELECT("task_request_method");
        sql.SELECT("task_request_type");
        sql.SELECT("task_reponse_code");
        sql.SELECT("create_time");
        sql.SELECT("remark");
        sql.SELECT("task_request_param");
        sql.SELECT("task_reponse_param");
        sql.FROM("task_interface_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskInterfaceLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_request_path");
        sql.SELECT("task_request_time");
        sql.SELECT("task_reponse_time");
        sql.SELECT("task_session_id");
        sql.SELECT("task_client_ip");
        sql.SELECT("task_request_method");
        sql.SELECT("task_request_type");
        sql.SELECT("task_reponse_code");
        sql.SELECT("create_time");
        sql.SELECT("remark");
        sql.FROM("task_interface_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskInterfaceLogWithBLOBs record = (TaskInterfaceLogWithBLOBs) parameter.get("record");
        TaskInterfaceLogExample example = (TaskInterfaceLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("task_interface_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTaskRequestPath() != null) {
            sql.SET("task_request_path = #{record.taskRequestPath,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestTime() != null) {
            sql.SET("task_request_time = #{record.taskRequestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskReponseTime() != null) {
            sql.SET("task_reponse_time = #{record.taskReponseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskSessionId() != null) {
            sql.SET("task_session_id = #{record.taskSessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskClientIp() != null) {
            sql.SET("task_client_ip = #{record.taskClientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestMethod() != null) {
            sql.SET("task_request_method = #{record.taskRequestMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestType() != null) {
            sql.SET("task_request_type = #{record.taskRequestType,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskReponseCode() != null) {
            sql.SET("task_reponse_code = #{record.taskReponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestParam() != null) {
            sql.SET("task_request_param = #{record.taskRequestParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTaskReponseParam() != null) {
            sql.SET("task_reponse_param = #{record.taskReponseParam,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task_interface_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("task_request_path = #{record.taskRequestPath,jdbcType=VARCHAR}");
        sql.SET("task_request_time = #{record.taskRequestTime,jdbcType=TIMESTAMP}");
        sql.SET("task_reponse_time = #{record.taskReponseTime,jdbcType=TIMESTAMP}");
        sql.SET("task_session_id = #{record.taskSessionId,jdbcType=VARCHAR}");
        sql.SET("task_client_ip = #{record.taskClientIp,jdbcType=VARCHAR}");
        sql.SET("task_request_method = #{record.taskRequestMethod,jdbcType=VARCHAR}");
        sql.SET("task_request_type = #{record.taskRequestType,jdbcType=VARCHAR}");
        sql.SET("task_reponse_code = #{record.taskReponseCode,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("task_request_param = #{record.taskRequestParam,jdbcType=LONGVARCHAR}");
        sql.SET("task_reponse_param = #{record.taskReponseParam,jdbcType=LONGVARCHAR}");
        
        TaskInterfaceLogExample example = (TaskInterfaceLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task_interface_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("task_request_path = #{record.taskRequestPath,jdbcType=VARCHAR}");
        sql.SET("task_request_time = #{record.taskRequestTime,jdbcType=TIMESTAMP}");
        sql.SET("task_reponse_time = #{record.taskReponseTime,jdbcType=TIMESTAMP}");
        sql.SET("task_session_id = #{record.taskSessionId,jdbcType=VARCHAR}");
        sql.SET("task_client_ip = #{record.taskClientIp,jdbcType=VARCHAR}");
        sql.SET("task_request_method = #{record.taskRequestMethod,jdbcType=VARCHAR}");
        sql.SET("task_request_type = #{record.taskRequestType,jdbcType=VARCHAR}");
        sql.SET("task_reponse_code = #{record.taskReponseCode,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        TaskInterfaceLogExample example = (TaskInterfaceLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskInterfaceLogWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("task_interface_log");
        
        if (record.getTaskRequestPath() != null) {
            sql.SET("task_request_path = #{taskRequestPath,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestTime() != null) {
            sql.SET("task_request_time = #{taskRequestTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskReponseTime() != null) {
            sql.SET("task_reponse_time = #{taskReponseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskSessionId() != null) {
            sql.SET("task_session_id = #{taskSessionId,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskClientIp() != null) {
            sql.SET("task_client_ip = #{taskClientIp,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestMethod() != null) {
            sql.SET("task_request_method = #{taskRequestMethod,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestType() != null) {
            sql.SET("task_request_type = #{taskRequestType,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskReponseCode() != null) {
            sql.SET("task_reponse_code = #{taskReponseCode,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRequestParam() != null) {
            sql.SET("task_request_param = #{taskRequestParam,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTaskReponseParam() != null) {
            sql.SET("task_reponse_param = #{taskReponseParam,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskInterfaceLogExample example, boolean includeExamplePhrase) {
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