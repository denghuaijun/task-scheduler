package com.ct.admin.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskWarningManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskWarningManagerExample() {
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

        public Criteria andTaskWarningCountIsNull() {
            addCriterion("task_warning_count is null");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountIsNotNull() {
            addCriterion("task_warning_count is not null");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountEqualTo(String value) {
            addCriterion("task_warning_count =", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountNotEqualTo(String value) {
            addCriterion("task_warning_count <>", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountGreaterThan(String value) {
            addCriterion("task_warning_count >", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountGreaterThanOrEqualTo(String value) {
            addCriterion("task_warning_count >=", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountLessThan(String value) {
            addCriterion("task_warning_count <", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountLessThanOrEqualTo(String value) {
            addCriterion("task_warning_count <=", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountLike(String value) {
            addCriterion("task_warning_count like", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountNotLike(String value) {
            addCriterion("task_warning_count not like", value, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountIn(List<String> values) {
            addCriterion("task_warning_count in", values, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountNotIn(List<String> values) {
            addCriterion("task_warning_count not in", values, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountBetween(String value1, String value2) {
            addCriterion("task_warning_count between", value1, value2, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningCountNotBetween(String value1, String value2) {
            addCriterion("task_warning_count not between", value1, value2, "taskWarningCount");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameIsNull() {
            addCriterion("task_warning_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameIsNotNull() {
            addCriterion("task_warning_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameEqualTo(String value) {
            addCriterion("task_warning_name =", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameNotEqualTo(String value) {
            addCriterion("task_warning_name <>", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameGreaterThan(String value) {
            addCriterion("task_warning_name >", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_warning_name >=", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameLessThan(String value) {
            addCriterion("task_warning_name <", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameLessThanOrEqualTo(String value) {
            addCriterion("task_warning_name <=", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameLike(String value) {
            addCriterion("task_warning_name like", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameNotLike(String value) {
            addCriterion("task_warning_name not like", value, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameIn(List<String> values) {
            addCriterion("task_warning_name in", values, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameNotIn(List<String> values) {
            addCriterion("task_warning_name not in", values, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameBetween(String value1, String value2) {
            addCriterion("task_warning_name between", value1, value2, "taskWarningName");
            return (Criteria) this;
        }

        public Criteria andTaskWarningNameNotBetween(String value1, String value2) {
            addCriterion("task_warning_name not between", value1, value2, "taskWarningName");
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