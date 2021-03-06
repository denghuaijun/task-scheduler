package com.ct.admin.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskRunExample() {
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

        public Criteria andTaskRunNameIsNull() {
            addCriterion("task_run_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameIsNotNull() {
            addCriterion("task_run_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameEqualTo(String value) {
            addCriterion("task_run_name =", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameNotEqualTo(String value) {
            addCriterion("task_run_name <>", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameGreaterThan(String value) {
            addCriterion("task_run_name >", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_run_name >=", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameLessThan(String value) {
            addCriterion("task_run_name <", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameLessThanOrEqualTo(String value) {
            addCriterion("task_run_name <=", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameLike(String value) {
            addCriterion("task_run_name like", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameNotLike(String value) {
            addCriterion("task_run_name not like", value, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameIn(List<String> values) {
            addCriterion("task_run_name in", values, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameNotIn(List<String> values) {
            addCriterion("task_run_name not in", values, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameBetween(String value1, String value2) {
            addCriterion("task_run_name between", value1, value2, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunNameNotBetween(String value1, String value2) {
            addCriterion("task_run_name not between", value1, value2, "taskRunName");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyIsNull() {
            addCriterion("task_run_appkey is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyIsNotNull() {
            addCriterion("task_run_appkey is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyEqualTo(String value) {
            addCriterion("task_run_appkey =", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyNotEqualTo(String value) {
            addCriterion("task_run_appkey <>", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyGreaterThan(String value) {
            addCriterion("task_run_appkey >", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("task_run_appkey >=", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyLessThan(String value) {
            addCriterion("task_run_appkey <", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyLessThanOrEqualTo(String value) {
            addCriterion("task_run_appkey <=", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyLike(String value) {
            addCriterion("task_run_appkey like", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyNotLike(String value) {
            addCriterion("task_run_appkey not like", value, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyIn(List<String> values) {
            addCriterion("task_run_appkey in", values, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyNotIn(List<String> values) {
            addCriterion("task_run_appkey not in", values, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyBetween(String value1, String value2) {
            addCriterion("task_run_appkey between", value1, value2, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAppkeyNotBetween(String value1, String value2) {
            addCriterion("task_run_appkey not between", value1, value2, "taskRunAppkey");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressIsNull() {
            addCriterion("task_run_address is null");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressIsNotNull() {
            addCriterion("task_run_address is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressEqualTo(String value) {
            addCriterion("task_run_address =", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressNotEqualTo(String value) {
            addCriterion("task_run_address <>", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressGreaterThan(String value) {
            addCriterion("task_run_address >", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressGreaterThanOrEqualTo(String value) {
            addCriterion("task_run_address >=", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressLessThan(String value) {
            addCriterion("task_run_address <", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressLessThanOrEqualTo(String value) {
            addCriterion("task_run_address <=", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressLike(String value) {
            addCriterion("task_run_address like", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressNotLike(String value) {
            addCriterion("task_run_address not like", value, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressIn(List<String> values) {
            addCriterion("task_run_address in", values, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressNotIn(List<String> values) {
            addCriterion("task_run_address not in", values, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressBetween(String value1, String value2) {
            addCriterion("task_run_address between", value1, value2, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andTaskRunAddressNotBetween(String value1, String value2) {
            addCriterion("task_run_address not between", value1, value2, "taskRunAddress");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(Short value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(Short value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(Short value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(Short value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(Short value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(Short value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<Short> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<Short> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(Short value1, Short value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(Short value1, Short value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Long value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Long value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Long value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Long value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Long value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Long> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Long> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Long value1, Long value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Long value1, Long value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
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