package com.ct.admin.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdIsNull() {
            addCriterion("fk_task_id is null");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdIsNotNull() {
            addCriterion("fk_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdEqualTo(Long value) {
            addCriterion("fk_task_id =", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdNotEqualTo(Long value) {
            addCriterion("fk_task_id <>", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdGreaterThan(Long value) {
            addCriterion("fk_task_id >", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fk_task_id >=", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdLessThan(Long value) {
            addCriterion("fk_task_id <", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("fk_task_id <=", value, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdIn(List<Long> values) {
            addCriterion("fk_task_id in", values, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdNotIn(List<Long> values) {
            addCriterion("fk_task_id not in", values, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdBetween(Long value1, Long value2) {
            addCriterion("fk_task_id between", value1, value2, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("fk_task_id not between", value1, value2, "fkTaskId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdIsNull() {
            addCriterion("fk_task_runner_id is null");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdIsNotNull() {
            addCriterion("fk_task_runner_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdEqualTo(Long value) {
            addCriterion("fk_task_runner_id =", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdNotEqualTo(Long value) {
            addCriterion("fk_task_runner_id <>", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdGreaterThan(Long value) {
            addCriterion("fk_task_runner_id >", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fk_task_runner_id >=", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdLessThan(Long value) {
            addCriterion("fk_task_runner_id <", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdLessThanOrEqualTo(Long value) {
            addCriterion("fk_task_runner_id <=", value, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdIn(List<Long> values) {
            addCriterion("fk_task_runner_id in", values, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdNotIn(List<Long> values) {
            addCriterion("fk_task_runner_id not in", values, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdBetween(Long value1, Long value2) {
            addCriterion("fk_task_runner_id between", value1, value2, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andFkTaskRunnerIdNotBetween(Long value1, Long value2) {
            addCriterion("fk_task_runner_id not between", value1, value2, "fkTaskRunnerId");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyIsNull() {
            addCriterion("runner_appkey is null");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyIsNotNull() {
            addCriterion("runner_appkey is not null");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyEqualTo(String value) {
            addCriterion("runner_appkey =", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyNotEqualTo(String value) {
            addCriterion("runner_appkey <>", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyGreaterThan(String value) {
            addCriterion("runner_appkey >", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("runner_appkey >=", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyLessThan(String value) {
            addCriterion("runner_appkey <", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyLessThanOrEqualTo(String value) {
            addCriterion("runner_appkey <=", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyLike(String value) {
            addCriterion("runner_appkey like", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyNotLike(String value) {
            addCriterion("runner_appkey not like", value, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyIn(List<String> values) {
            addCriterion("runner_appkey in", values, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyNotIn(List<String> values) {
            addCriterion("runner_appkey not in", values, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyBetween(String value1, String value2) {
            addCriterion("runner_appkey between", value1, value2, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppkeyNotBetween(String value1, String value2) {
            addCriterion("runner_appkey not between", value1, value2, "runnerAppkey");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameIsNull() {
            addCriterion("runner_appname is null");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameIsNotNull() {
            addCriterion("runner_appname is not null");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameEqualTo(String value) {
            addCriterion("runner_appname =", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameNotEqualTo(String value) {
            addCriterion("runner_appname <>", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameGreaterThan(String value) {
            addCriterion("runner_appname >", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameGreaterThanOrEqualTo(String value) {
            addCriterion("runner_appname >=", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameLessThan(String value) {
            addCriterion("runner_appname <", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameLessThanOrEqualTo(String value) {
            addCriterion("runner_appname <=", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameLike(String value) {
            addCriterion("runner_appname like", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameNotLike(String value) {
            addCriterion("runner_appname not like", value, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameIn(List<String> values) {
            addCriterion("runner_appname in", values, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameNotIn(List<String> values) {
            addCriterion("runner_appname not in", values, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameBetween(String value1, String value2) {
            addCriterion("runner_appname between", value1, value2, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAppnameNotBetween(String value1, String value2) {
            addCriterion("runner_appname not between", value1, value2, "runnerAppname");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressIsNull() {
            addCriterion("runner_address is null");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressIsNotNull() {
            addCriterion("runner_address is not null");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressEqualTo(String value) {
            addCriterion("runner_address =", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressNotEqualTo(String value) {
            addCriterion("runner_address <>", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressGreaterThan(String value) {
            addCriterion("runner_address >", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("runner_address >=", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressLessThan(String value) {
            addCriterion("runner_address <", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressLessThanOrEqualTo(String value) {
            addCriterion("runner_address <=", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressLike(String value) {
            addCriterion("runner_address like", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressNotLike(String value) {
            addCriterion("runner_address not like", value, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressIn(List<String> values) {
            addCriterion("runner_address in", values, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressNotIn(List<String> values) {
            addCriterion("runner_address not in", values, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressBetween(String value1, String value2) {
            addCriterion("runner_address between", value1, value2, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andRunnerAddressNotBetween(String value1, String value2) {
            addCriterion("runner_address not between", value1, value2, "runnerAddress");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIsNull() {
            addCriterion("task_starttime is null");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIsNotNull() {
            addCriterion("task_starttime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeEqualTo(Date value) {
            addCriterion("task_starttime =", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotEqualTo(Date value) {
            addCriterion("task_starttime <>", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeGreaterThan(Date value) {
            addCriterion("task_starttime >", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_starttime >=", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeLessThan(Date value) {
            addCriterion("task_starttime <", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("task_starttime <=", value, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeIn(List<Date> values) {
            addCriterion("task_starttime in", values, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotIn(List<Date> values) {
            addCriterion("task_starttime not in", values, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeBetween(Date value1, Date value2) {
            addCriterion("task_starttime between", value1, value2, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("task_starttime not between", value1, value2, "taskStarttime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIsNull() {
            addCriterion("task_endtime is null");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIsNotNull() {
            addCriterion("task_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeEqualTo(Date value) {
            addCriterion("task_endtime =", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotEqualTo(Date value) {
            addCriterion("task_endtime <>", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeGreaterThan(Date value) {
            addCriterion("task_endtime >", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_endtime >=", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeLessThan(Date value) {
            addCriterion("task_endtime <", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("task_endtime <=", value, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeIn(List<Date> values) {
            addCriterion("task_endtime in", values, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotIn(List<Date> values) {
            addCriterion("task_endtime not in", values, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeBetween(Date value1, Date value2) {
            addCriterion("task_endtime between", value1, value2, "taskEndtime");
            return (Criteria) this;
        }

        public Criteria andTaskEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("task_endtime not between", value1, value2, "taskEndtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}