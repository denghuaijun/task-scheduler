package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskExample.Criteria;
import com.ct.admin.dao.entity.TaskExample.Criterion;
import com.ct.admin.dao.entity.TaskExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TaskSqlProvider {

    public String countByExample(TaskExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(TaskExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("task");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Task record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("task");
        
        if (record.getTaskName() != null) {
            sql.VALUES("task_name", "#{taskName,jdbcType=VARCHAR}");
        }
        
        if (record.getFkTaskrunnerId() != null) {
            sql.VALUES("fk_taskrunner_id", "#{fkTaskrunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskCron() != null) {
            sql.VALUES("task_cron", "#{taskCron,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.VALUES("creator_id", "#{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            sql.VALUES("task_status", "#{taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.VALUES("active", "#{active,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(TaskExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_name");
        sql.SELECT("fk_taskrunner_id");
        sql.SELECT("task_cron");
        sql.SELECT("creator_id");
        sql.SELECT("create_at");
        sql.SELECT("status");
        sql.SELECT("task_status");
        sql.SELECT("active");
        sql.FROM("task");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Task record = (Task) parameter.get("record");
        TaskExample example = (TaskExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("task");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getTaskName() != null) {
            sql.SET("task_name = #{record.taskName,jdbcType=VARCHAR}");
        }
        
        if (record.getFkTaskrunnerId() != null) {
            sql.SET("fk_taskrunner_id = #{record.fkTaskrunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskCron() != null) {
            sql.SET("task_cron = #{record.taskCron,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            sql.SET("task_status = #{record.taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{record.active,jdbcType=SMALLINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("task");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("task_name = #{record.taskName,jdbcType=VARCHAR}");
        sql.SET("fk_taskrunner_id = #{record.fkTaskrunnerId,jdbcType=BIGINT}");
        sql.SET("task_cron = #{record.taskCron,jdbcType=VARCHAR}");
        sql.SET("creator_id = #{record.creatorId,jdbcType=BIGINT}");
        sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("task_status = #{record.taskStatus,jdbcType=INTEGER}");
        sql.SET("active = #{record.active,jdbcType=SMALLINT}");
        
        TaskExample example = (TaskExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Task record) {
        SQL sql = new SQL();
        sql.UPDATE("task");
        
        if (record.getTaskName() != null) {
            sql.SET("task_name = #{taskName,jdbcType=VARCHAR}");
        }
        
        if (record.getFkTaskrunnerId() != null) {
            sql.SET("fk_taskrunner_id = #{fkTaskrunnerId,jdbcType=BIGINT}");
        }
        
        if (record.getTaskCron() != null) {
            sql.SET("task_cron = #{taskCron,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatorId() != null) {
            sql.SET("creator_id = #{creatorId,jdbcType=BIGINT}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getTaskStatus() != null) {
            sql.SET("task_status = #{taskStatus,jdbcType=INTEGER}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{active,jdbcType=SMALLINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, TaskExample example, boolean includeExamplePhrase) {
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