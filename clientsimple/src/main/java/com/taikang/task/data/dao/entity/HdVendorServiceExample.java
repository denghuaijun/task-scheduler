package com.taikang.task.data.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HdVendorServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HdVendorServiceExample() {
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

        public Criteria andVendorIdIsNull() {
            addCriterion("vendor_id is null");
            return (Criteria) this;
        }

        public Criteria andVendorIdIsNotNull() {
            addCriterion("vendor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVendorIdEqualTo(String value) {
            addCriterion("vendor_id =", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotEqualTo(String value) {
            addCriterion("vendor_id <>", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThan(String value) {
            addCriterion("vendor_id >", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_id >=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThan(String value) {
            addCriterion("vendor_id <", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLessThanOrEqualTo(String value) {
            addCriterion("vendor_id <=", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdLike(String value) {
            addCriterion("vendor_id like", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotLike(String value) {
            addCriterion("vendor_id not like", value, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdIn(List<String> values) {
            addCriterion("vendor_id in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotIn(List<String> values) {
            addCriterion("vendor_id not in", values, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdBetween(String value1, String value2) {
            addCriterion("vendor_id between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andVendorIdNotBetween(String value1, String value2) {
            addCriterion("vendor_id not between", value1, value2, "vendorId");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNull() {
            addCriterion("service_code is null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNotNull() {
            addCriterion("service_code is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeEqualTo(String value) {
            addCriterion("service_code =", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotEqualTo(String value) {
            addCriterion("service_code <>", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThan(String value) {
            addCriterion("service_code >", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("service_code >=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThan(String value) {
            addCriterion("service_code <", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("service_code <=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLike(String value) {
            addCriterion("service_code like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotLike(String value) {
            addCriterion("service_code not like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIn(List<String> values) {
            addCriterion("service_code in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotIn(List<String> values) {
            addCriterion("service_code not in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeBetween(String value1, String value2) {
            addCriterion("service_code between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotBetween(String value1, String value2) {
            addCriterion("service_code not between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgIsNull() {
            addCriterion("authorize_msg is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgIsNotNull() {
            addCriterion("authorize_msg is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgEqualTo(String value) {
            addCriterion("authorize_msg =", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgNotEqualTo(String value) {
            addCriterion("authorize_msg <>", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgGreaterThan(String value) {
            addCriterion("authorize_msg >", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgGreaterThanOrEqualTo(String value) {
            addCriterion("authorize_msg >=", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgLessThan(String value) {
            addCriterion("authorize_msg <", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgLessThanOrEqualTo(String value) {
            addCriterion("authorize_msg <=", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgLike(String value) {
            addCriterion("authorize_msg like", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgNotLike(String value) {
            addCriterion("authorize_msg not like", value, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgIn(List<String> values) {
            addCriterion("authorize_msg in", values, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgNotIn(List<String> values) {
            addCriterion("authorize_msg not in", values, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgBetween(String value1, String value2) {
            addCriterion("authorize_msg between", value1, value2, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andAuthorizeMsgNotBetween(String value1, String value2) {
            addCriterion("authorize_msg not between", value1, value2, "authorizeMsg");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIsNull() {
            addCriterion("service_url is null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIsNotNull() {
            addCriterion("service_url is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlEqualTo(String value) {
            addCriterion("service_url =", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotEqualTo(String value) {
            addCriterion("service_url <>", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThan(String value) {
            addCriterion("service_url >", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("service_url >=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThan(String value) {
            addCriterion("service_url <", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThanOrEqualTo(String value) {
            addCriterion("service_url <=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLike(String value) {
            addCriterion("service_url like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotLike(String value) {
            addCriterion("service_url not like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIn(List<String> values) {
            addCriterion("service_url in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotIn(List<String> values) {
            addCriterion("service_url not in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlBetween(String value1, String value2) {
            addCriterion("service_url between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotBetween(String value1, String value2) {
            addCriterion("service_url not between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNull() {
            addCriterion("interval is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNotNull() {
            addCriterion("interval is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalEqualTo(Integer value) {
            addCriterion("interval =", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotEqualTo(Integer value) {
            addCriterion("interval <>", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThan(Integer value) {
            addCriterion("interval >", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("interval >=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThan(Integer value) {
            addCriterion("interval <", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("interval <=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalIn(List<Integer> values) {
            addCriterion("interval in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotIn(List<Integer> values) {
            addCriterion("interval not in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalBetween(Integer value1, Integer value2) {
            addCriterion("interval between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("interval not between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIsNull() {
            addCriterion("service_type_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIsNotNull() {
            addCriterion("service_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdEqualTo(Long value) {
            addCriterion("service_type_id =", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotEqualTo(Long value) {
            addCriterion("service_type_id <>", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThan(Long value) {
            addCriterion("service_type_id >", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_type_id >=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThan(Long value) {
            addCriterion("service_type_id <", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("service_type_id <=", value, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdIn(List<Long> values) {
            addCriterion("service_type_id in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotIn(List<Long> values) {
            addCriterion("service_type_id not in", values, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdBetween(Long value1, Long value2) {
            addCriterion("service_type_id between", value1, value2, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("service_type_id not between", value1, value2, "serviceTypeId");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNull() {
            addCriterion("service_desc is null");
            return (Criteria) this;
        }

        public Criteria andServiceDescIsNotNull() {
            addCriterion("service_desc is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDescEqualTo(String value) {
            addCriterion("service_desc =", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotEqualTo(String value) {
            addCriterion("service_desc <>", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThan(String value) {
            addCriterion("service_desc >", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescGreaterThanOrEqualTo(String value) {
            addCriterion("service_desc >=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThan(String value) {
            addCriterion("service_desc <", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLessThanOrEqualTo(String value) {
            addCriterion("service_desc <=", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescLike(String value) {
            addCriterion("service_desc like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotLike(String value) {
            addCriterion("service_desc not like", value, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescIn(List<String> values) {
            addCriterion("service_desc in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotIn(List<String> values) {
            addCriterion("service_desc not in", values, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescBetween(String value1, String value2) {
            addCriterion("service_desc between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceDescNotBetween(String value1, String value2) {
            addCriterion("service_desc not between", value1, value2, "serviceDesc");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIsNull() {
            addCriterion("service_status is null");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIsNotNull() {
            addCriterion("service_status is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStatusEqualTo(Integer value) {
            addCriterion("service_status =", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotEqualTo(Integer value) {
            addCriterion("service_status <>", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusGreaterThan(Integer value) {
            addCriterion("service_status >", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_status >=", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusLessThan(Integer value) {
            addCriterion("service_status <", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("service_status <=", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIn(List<Integer> values) {
            addCriterion("service_status in", values, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotIn(List<Integer> values) {
            addCriterion("service_status not in", values, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusBetween(Integer value1, Integer value2) {
            addCriterion("service_status between", value1, value2, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("service_status not between", value1, value2, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andServiceLinkIsNull() {
            addCriterion("service_link is null");
            return (Criteria) this;
        }

        public Criteria andServiceLinkIsNotNull() {
            addCriterion("service_link is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLinkEqualTo(String value) {
            addCriterion("service_link =", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkNotEqualTo(String value) {
            addCriterion("service_link <>", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkGreaterThan(String value) {
            addCriterion("service_link >", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkGreaterThanOrEqualTo(String value) {
            addCriterion("service_link >=", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkLessThan(String value) {
            addCriterion("service_link <", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkLessThanOrEqualTo(String value) {
            addCriterion("service_link <=", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkLike(String value) {
            addCriterion("service_link like", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkNotLike(String value) {
            addCriterion("service_link not like", value, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkIn(List<String> values) {
            addCriterion("service_link in", values, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkNotIn(List<String> values) {
            addCriterion("service_link not in", values, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkBetween(String value1, String value2) {
            addCriterion("service_link between", value1, value2, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServiceLinkNotBetween(String value1, String value2) {
            addCriterion("service_link not between", value1, value2, "serviceLink");
            return (Criteria) this;
        }

        public Criteria andServicePhoneIsNull() {
            addCriterion("service_phone is null");
            return (Criteria) this;
        }

        public Criteria andServicePhoneIsNotNull() {
            addCriterion("service_phone is not null");
            return (Criteria) this;
        }

        public Criteria andServicePhoneEqualTo(String value) {
            addCriterion("service_phone =", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneNotEqualTo(String value) {
            addCriterion("service_phone <>", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneGreaterThan(String value) {
            addCriterion("service_phone >", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("service_phone >=", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneLessThan(String value) {
            addCriterion("service_phone <", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneLessThanOrEqualTo(String value) {
            addCriterion("service_phone <=", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneLike(String value) {
            addCriterion("service_phone like", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneNotLike(String value) {
            addCriterion("service_phone not like", value, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneIn(List<String> values) {
            addCriterion("service_phone in", values, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneNotIn(List<String> values) {
            addCriterion("service_phone not in", values, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneBetween(String value1, String value2) {
            addCriterion("service_phone between", value1, value2, "servicePhone");
            return (Criteria) this;
        }

        public Criteria andServicePhoneNotBetween(String value1, String value2) {
            addCriterion("service_phone not between", value1, value2, "servicePhone");
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