package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.entity.TaskLogExample.Criteria;
import com.ct.admin.dao.entity.TaskLogExample.Criterion;
import com.ct.admin.dao.entity.TaskLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskLogSqlProvider {

    public String countByExample(TaskLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("task_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("task_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("task_log");
        
        if (record.getFkTaskId() != null) {
            sql.VALUES("fk_task_id", "#{fkTaskId,jdbcType=BIGINT}");
        }
        
        if (record.getFkTaskRunnerId() != null) {
            sql.VALUES("fk_task_runner_id", "#{fkTaskRunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getRunnerAppkey() != null) {
            sql.VALUES("runner_appkey", "#{runnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAppname() != null) {
            sql.VALUES("runner_appname", "#{runnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAddress() != null) {
            sql.VALUES("runner_address", "#{runnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            sql.VALUES("message", "#{message,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskStarttime() != null) {
            sql.VALUES("task_starttime", "#{taskStarttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskEndtime() != null) {
            sql.VALUES("task_endtime", "#{taskEndtime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("fk_task_id");
        sql.SELECT("fk_task_runner_id");
        sql.SELECT("runner_appkey");
        sql.SELECT("runner_appname");
        sql.SELECT("runner_address");
        sql.SELECT("message");
        sql.SELECT("code");
        sql.SELECT("create_time");
        sql.SELECT("task_starttime");
        sql.SELECT("task_endtime");
        sql.FROM("task_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskLog record = (TaskLog) parameter.get("record");
        TaskLogExample example = (TaskLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("task_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getFkTaskId() != null) {
            sql.SET("fk_task_id = #{record.fkTaskId,jdbcType=BIGINT}");
        }
        
        if (record.getFkTaskRunnerId() != null) {
            sql.SET("fk_task_runner_id = #{record.fkTaskRunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getRunnerAppkey() != null) {
            sql.SET("runner_appkey = #{record.runnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAppname() != null) {
            sql.SET("runner_appname = #{record.runnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAddress() != null) {
            sql.SET("runner_address = #{record.runnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            sql.SET("message = #{record.message,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskStarttime() != null) {
            sql.SET("task_starttime = #{record.taskStarttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskEndtime() != null) {
            sql.SET("task_endtime = #{record.taskEndtime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task_log");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("fk_task_id = #{record.fkTaskId,jdbcType=BIGINT}");
        sql.SET("fk_task_runner_id = #{record.fkTaskRunnerId,jdbcType=BIGINT}");
        sql.SET("runner_appkey = #{record.runnerAppkey,jdbcType=VARCHAR}");
        sql.SET("runner_appname = #{record.runnerAppname,jdbcType=VARCHAR}");
        sql.SET("runner_address = #{record.runnerAddress,jdbcType=VARCHAR}");
        sql.SET("message = #{record.message,jdbcType=VARCHAR}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("task_starttime = #{record.taskStarttime,jdbcType=TIMESTAMP}");
        sql.SET("task_endtime = #{record.taskEndtime,jdbcType=TIMESTAMP}");
        
        TaskLogExample example = (TaskLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskLog record) {
        SQL sql = new SQL();
        sql.UPDATE("task_log");
        
        if (record.getFkTaskId() != null) {
            sql.SET("fk_task_id = #{fkTaskId,jdbcType=BIGINT}");
        }
        
        if (record.getFkTaskRunnerId() != null) {
            sql.SET("fk_task_runner_id = #{fkTaskRunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getRunnerAppkey() != null) {
            sql.SET("runner_appkey = #{runnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAppname() != null) {
            sql.SET("runner_appname = #{runnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getRunnerAddress() != null) {
            sql.SET("runner_address = #{runnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getMessage() != null) {
            sql.SET("message = #{message,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskStarttime() != null) {
            sql.SET("task_starttime = #{taskStarttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTaskEndtime() != null) {
            sql.SET("task_endtime = #{taskEndtime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskLogExample example, boolean includeExamplePhrase) {
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