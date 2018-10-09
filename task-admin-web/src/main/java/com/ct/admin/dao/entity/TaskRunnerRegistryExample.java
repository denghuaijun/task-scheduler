package com.ct.admin.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRunnerRegistryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskRunnerRegistryExample() {
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

        public Criteria andTaskRunnerAppkeyIsNull() {
            addCriterion("task_runner_appkey is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyIsNotNull() {
            addCriterion("task_runner_appkey is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyEqualTo(String value) {
            addCriterion("task_runner_appkey =", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyNotEqualTo(String value) {
            addCriterion("task_runner_appkey <>", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyGreaterThan(String value) {
            addCriterion("task_runner_appkey >", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("task_runner_appkey >=", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyLessThan(String value) {
            addCriterion("task_runner_appkey <", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyLessThanOrEqualTo(String value) {
            addCriterion("task_runner_appkey <=", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyLike(String value) {
            addCriterion("task_runner_appkey like", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyNotLike(String value) {
            addCriterion("task_runner_appkey not like", value, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyIn(List<String> values) {
            addCriterion("task_runner_appkey in", values, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyNotIn(List<String> values) {
            addCriterion("task_runner_appkey not in", values, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyBetween(String value1, String value2) {
            addCriterion("task_runner_appkey between", value1, value2, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAppkeyNotBetween(String value1, String value2) {
            addCriterion("task_runner_appkey not between", value1, value2, "taskRunnerAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressIsNull() {
            addCriterion("task_runner_address is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressIsNotNull() {
            addCriterion("task_runner_address is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressEqualTo(String value) {
            addCriterion("task_runner_address =", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressNotEqualTo(String value) {
            addCriterion("task_runner_address <>", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressGreaterThan(String value) {
            addCriterion("task_runner_address >", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("task_runner_address >=", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressLessThan(String value) {
            addCriterion("task_runner_address <", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressLessThanOrEqualTo(String value) {
            addCriterion("task_runner_address <=", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressLike(String value) {
            addCriterion("task_runner_address like", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressNotLike(String value) {
            addCriterion("task_runner_address not like", value, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressIn(List<String> values) {
            addCriterion("task_runner_address in", values, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressNotIn(List<String> values) {
            addCriterion("task_runner_address not in", values, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressBetween(String value1, String value2) {
            addCriterion("task_runner_address between", value1, value2, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunnerAddressNotBetween(String value1, String value2) {
            addCriterion("task_runner_address not between", value1, value2, "taskRunnerAddress");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
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