package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.dao.entity.TaskRunnerExample.Criteria;
import com.ct.admin.dao.entity.TaskRunnerExample.Criterion;
import com.ct.admin.dao.entity.TaskRunnerExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskRunnerSqlProvider {

    public String countByExample(TaskRunnerExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("task_runner");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskRunnerExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("task_runner");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(TaskRunner record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("task_runner");
        
        if (record.getTaskRunnerName() != null) {
            sql.VALUES("task_runner_name", "#{taskRunnerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppkey() != null) {
            sql.VALUES("task_runner_appkey", "#{taskRunnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppname() != null) {
            sql.VALUES("task_runner_appname", "#{taskRunnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAddress() != null) {
            sql.VALUES("task_runner_address", "#{taskRunnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.VALUES("active", "#{active,jdbcType=SMALLINT}");
        }
        
        if (record.getCreatorId() != null) {
            sql.VALUES("creator_id", "#{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskRunnerExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_runner_name");
        sql.SELECT("task_runner_appkey");
        sql.SELECT("task_runner_appname");
        sql.SELECT("task_runner_address");
        sql.SELECT("status");
        sql.SELECT("active");
        sql.SELECT("creator_id");
        sql.SELECT("create_at");
        sql.FROM("task_runner");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TaskRunner record = (TaskRunner) parameter.get("record");
        TaskRunnerExample example = (TaskRunnerExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("task_runner");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTaskRunnerName() != null) {
            sql.SET("task_runner_name = #{record.taskRunnerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppkey() != null) {
            sql.SET("task_runner_appkey = #{record.taskRunnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppname() != null) {
            sql.SET("task_runner_appname = #{record.taskRunnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAddress() != null) {
            sql.SET("task_runner_address = #{record.taskRunnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{record.active,jdbcType=SMALLINT}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task_runner");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("task_runner_name = #{record.taskRunnerName,jdbcType=VARCHAR}");
        sql.SET("task_runner_appkey = #{record.taskRunnerAppkey,jdbcType=VARCHAR}");
        sql.SET("task_runner_appname = #{record.taskRunnerAppname,jdbcType=VARCHAR}");
        sql.SET("task_runner_address = #{record.taskRunnerAddress,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("active = #{record.active,jdbcType=SMALLINT}");
        sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        
        TaskRunnerExample example = (TaskRunnerExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TaskRunner record) {
        SQL sql = new SQL();
        sql.UPDATE("task_runner");
        
        if (record.getTaskRunnerName() != null) {
            sql.SET("task_runner_name = #{taskRunnerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppkey() != null) {
            sql.SET("task_runner_appkey = #{taskRunnerAppkey,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAppname() != null) {
            sql.SET("task_runner_appname = #{taskRunnerAppname,jdbcType=VARCHAR}");
        }
        
        if (record.getTaskRunnerAddress() != null) {
            sql.SET("task_runner_address = #{taskRunnerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{active,jdbcType=SMALLINT}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskRunnerExample example, boolean includeExamplePhrase) {
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