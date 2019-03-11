package com.taikang.task.data.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HdVendorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HdVendorExample() {
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

        public Criteria andVendorCodeIsNull() {
            addCriterion("vendor_code is null");
            return (Criteria) this;
        }

        public Criteria andVendorCodeIsNotNull() {
            addCriterion("vendor_code is not null");
            return (Criteria) this;
        }

        public Criteria andVendorCodeEqualTo(String value) {
            addCriterion("vendor_code =", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeNotEqualTo(String value) {
            addCriterion("vendor_code <>", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeGreaterThan(String value) {
            addCriterion("vendor_code >", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_code >=", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeLessThan(String value) {
            addCriterion("vendor_code <", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeLessThanOrEqualTo(String value) {
            addCriterion("vendor_code <=", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeLike(String value) {
            addCriterion("vendor_code like", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeNotLike(String value) {
            addCriterion("vendor_code not like", value, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeIn(List<String> values) {
            addCriterion("vendor_code in", values, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeNotIn(List<String> values) {
            addCriterion("vendor_code not in", values, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeBetween(String value1, String value2) {
            addCriterion("vendor_code between", value1, value2, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorCodeNotBetween(String value1, String value2) {
            addCriterion("vendor_code not between", value1, value2, "vendorCode");
            return (Criteria) this;
        }

        public Criteria andVendorNameIsNull() {
            addCriterion("vendor_name is null");
            return (Criteria) this;
        }

        public Criteria andVendorNameIsNotNull() {
            addCriterion("vendor_name is not null");
            return (Criteria) this;
        }

        public Criteria andVendorNameEqualTo(String value) {
            addCriterion("vendor_name =", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotEqualTo(String value) {
            addCriterion("vendor_name <>", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameGreaterThan(String value) {
            addCriterion("vendor_name >", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_name >=", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLessThan(String value) {
            addCriterion("vendor_name <", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLessThanOrEqualTo(String value) {
            addCriterion("vendor_name <=", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameLike(String value) {
            addCriterion("vendor_name like", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotLike(String value) {
            addCriterion("vendor_name not like", value, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameIn(List<String> values) {
            addCriterion("vendor_name in", values, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotIn(List<String> values) {
            addCriterion("vendor_name not in", values, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameBetween(String value1, String value2) {
            addCriterion("vendor_name between", value1, value2, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorNameNotBetween(String value1, String value2) {
            addCriterion("vendor_name not between", value1, value2, "vendorName");
            return (Criteria) this;
        }

        public Criteria andVendorPersonIsNull() {
            addCriterion("vendor_person is null");
            return (Criteria) this;
        }

        public Criteria andVendorPersonIsNotNull() {
            addCriterion("vendor_person is not null");
            return (Criteria) this;
        }

        public Criteria andVendorPersonEqualTo(String value) {
            addCriterion("vendor_person =", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonNotEqualTo(String value) {
            addCriterion("vendor_person <>", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonGreaterThan(String value) {
            addCriterion("vendor_person >", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_person >=", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonLessThan(String value) {
            addCriterion("vendor_person <", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonLessThanOrEqualTo(String value) {
            addCriterion("vendor_person <=", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonLike(String value) {
            addCriterion("vendor_person like", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonNotLike(String value) {
            addCriterion("vendor_person not like", value, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonIn(List<String> values) {
            addCriterion("vendor_person in", values, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonNotIn(List<String> values) {
            addCriterion("vendor_person not in", values, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonBetween(String value1, String value2) {
            addCriterion("vendor_person between", value1, value2, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPersonNotBetween(String value1, String value2) {
            addCriterion("vendor_person not between", value1, value2, "vendorPerson");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneIsNull() {
            addCriterion("vendor_phone is null");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneIsNotNull() {
            addCriterion("vendor_phone is not null");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneEqualTo(String value) {
            addCriterion("vendor_phone =", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneNotEqualTo(String value) {
            addCriterion("vendor_phone <>", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneGreaterThan(String value) {
            addCriterion("vendor_phone >", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_phone >=", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneLessThan(String value) {
            addCriterion("vendor_phone <", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneLessThanOrEqualTo(String value) {
            addCriterion("vendor_phone <=", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneLike(String value) {
            addCriterion("vendor_phone like", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneNotLike(String value) {
            addCriterion("vendor_phone not like", value, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneIn(List<String> values) {
            addCriterion("vendor_phone in", values, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneNotIn(List<String> values) {
            addCriterion("vendor_phone not in", values, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneBetween(String value1, String value2) {
            addCriterion("vendor_phone between", value1, value2, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorPhoneNotBetween(String value1, String value2) {
            addCriterion("vendor_phone not between", value1, value2, "vendorPhone");
            return (Criteria) this;
        }

        public Criteria andVendorStatusIsNull() {
            addCriterion("vendor_status is null");
            return (Criteria) this;
        }

        public Criteria andVendorStatusIsNotNull() {
            addCriterion("vendor_status is not null");
            return (Criteria) this;
        }

        public Criteria andVendorStatusEqualTo(Integer value) {
            addCriterion("vendor_status =", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusNotEqualTo(Integer value) {
            addCriterion("vendor_status <>", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusGreaterThan(Integer value) {
            addCriterion("vendor_status >", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("vendor_status >=", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusLessThan(Integer value) {
            addCriterion("vendor_status <", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusLessThanOrEqualTo(Integer value) {
            addCriterion("vendor_status <=", value, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusIn(List<Integer> values) {
            addCriterion("vendor_status in", values, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusNotIn(List<Integer> values) {
            addCriterion("vendor_status not in", values, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusBetween(Integer value1, Integer value2) {
            addCriterion("vendor_status between", value1, value2, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andVendorStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("vendor_status not between", value1, value2, "vendorStatus");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIsNull() {
            addCriterion("creator_code is null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIsNotNull() {
            addCriterion("creator_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeEqualTo(String value) {
            addCriterion("creator_code =", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotEqualTo(String value) {
            addCriterion("creator_code <>", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThan(String value) {
            addCriterion("creator_code >", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("creator_code >=", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThan(String value) {
            addCriterion("creator_code <", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThanOrEqualTo(String value) {
            addCriterion("creator_code <=", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLike(String value) {
            addCriterion("creator_code like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotLike(String value) {
            addCriterion("creator_code not like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIn(List<String> values) {
            addCriterion("creator_code in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotIn(List<String> values) {
            addCriterion("creator_code not in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeBetween(String value1, String value2) {
            addCriterion("creator_code between", value1, value2, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotBetween(String value1, String value2) {
            addCriterion("creator_code not between", value1, value2, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andModifyCodeIsNull() {
            addCriterion("modify_code is null");
            return (Criteria) this;
        }

        public Criteria andModifyCodeIsNotNull() {
            addCriterion("modify_code is not null");
            return (Criteria) this;
        }

        public Criteria andModifyCodeEqualTo(String value) {
            addCriterion("modify_code =", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeNotEqualTo(String value) {
            addCriterion("modify_code <>", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeGreaterThan(String value) {
            addCriterion("modify_code >", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("modify_code >=", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeLessThan(String value) {
            addCriterion("modify_code <", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeLessThanOrEqualTo(String value) {
            addCriterion("modify_code <=", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeLike(String value) {
            addCriterion("modify_code like", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeNotLike(String value) {
            addCriterion("modify_code not like", value, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeIn(List<String> values) {
            addCriterion("modify_code in", values, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeNotIn(List<String> values) {
            addCriterion("modify_code not in", values, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeBetween(String value1, String value2) {
            addCriterion("modify_code between", value1, value2, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyCodeNotBetween(String value1, String value2) {
            addCriterion("modify_code not between", value1, value2, "modifyCode");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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