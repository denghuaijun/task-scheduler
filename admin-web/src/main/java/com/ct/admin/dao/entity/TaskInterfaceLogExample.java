package com.ct.admin.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskInterfaceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskInterfaceLogExample() {
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

        public Criteria andTaskRequestPathIsNull() {
            addCriterion("task_request_path is null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathIsNotNull() {
            addCriterion("task_request_path is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathEqualTo(String value) {
            addCriterion("task_request_path =", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathNotEqualTo(String value) {
            addCriterion("task_request_path <>", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathGreaterThan(String value) {
            addCriterion("task_request_path >", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathGreaterThanOrEqualTo(String value) {
            addCriterion("task_request_path >=", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathLessThan(String value) {
            addCriterion("task_request_path <", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathLessThanOrEqualTo(String value) {
            addCriterion("task_request_path <=", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathLike(String value) {
            addCriterion("task_request_path like", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathNotLike(String value) {
            addCriterion("task_request_path not like", value, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathIn(List<String> values) {
            addCriterion("task_request_path in", values, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathNotIn(List<String> values) {
            addCriterion("task_request_path not in", values, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathBetween(String value1, String value2) {
            addCriterion("task_request_path between", value1, value2, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestPathNotBetween(String value1, String value2) {
            addCriterion("task_request_path not between", value1, value2, "taskRequestPath");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamIsNull() {
            addCriterion("task_request_param is null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamIsNotNull() {
            addCriterion("task_request_param is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamEqualTo(String value) {
            addCriterion("task_request_param =", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamNotEqualTo(String value) {
            addCriterion("task_request_param <>", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamGreaterThan(String value) {
            addCriterion("task_request_param >", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamGreaterThanOrEqualTo(String value) {
            addCriterion("task_request_param >=", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamLessThan(String value) {
            addCriterion("task_request_param <", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamLessThanOrEqualTo(String value) {
            addCriterion("task_request_param <=", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamLike(String value) {
            addCriterion("task_request_param like", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamNotLike(String value) {
            addCriterion("task_request_param not like", value, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamIn(List<String> values) {
            addCriterion("task_request_param in", values, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamNotIn(List<String> values) {
            addCriterion("task_request_param not in", values, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamBetween(String value1, String value2) {
            addCriterion("task_request_param between", value1, value2, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestParamNotBetween(String value1, String value2) {
            addCriterion("task_request_param not between", value1, value2, "taskRequestParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamIsNull() {
            addCriterion("task_reponse_param is null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamIsNotNull() {
            addCriterion("task_reponse_param is not null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamEqualTo(String value) {
            addCriterion("task_reponse_param =", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamNotEqualTo(String value) {
            addCriterion("task_reponse_param <>", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamGreaterThan(String value) {
            addCriterion("task_reponse_param >", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamGreaterThanOrEqualTo(String value) {
            addCriterion("task_reponse_param >=", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamLessThan(String value) {
            addCriterion("task_reponse_param <", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamLessThanOrEqualTo(String value) {
            addCriterion("task_reponse_param <=", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamLike(String value) {
            addCriterion("task_reponse_param like", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamNotLike(String value) {
            addCriterion("task_reponse_param not like", value, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamIn(List<String> values) {
            addCriterion("task_reponse_param in", values, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamNotIn(List<String> values) {
            addCriterion("task_reponse_param not in", values, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamBetween(String value1, String value2) {
            addCriterion("task_reponse_param between", value1, value2, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskReponseParamNotBetween(String value1, String value2) {
            addCriterion("task_reponse_param not between", value1, value2, "taskReponseParam");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeIsNull() {
            addCriterion("task_request_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeIsNotNull() {
            addCriterion("task_request_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeEqualTo(Date value) {
            addCriterion("task_request_time =", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeNotEqualTo(Date value) {
            addCriterion("task_request_time <>", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeGreaterThan(Date value) {
            addCriterion("task_request_time >", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_request_time >=", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeLessThan(Date value) {
            addCriterion("task_request_time <", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_request_time <=", value, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeIn(List<Date> values) {
            addCriterion("task_request_time in", values, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeNotIn(List<Date> values) {
            addCriterion("task_request_time not in", values, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeBetween(Date value1, Date value2) {
            addCriterion("task_request_time between", value1, value2, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_request_time not between", value1, value2, "taskRequestTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeIsNull() {
            addCriterion("task_reponse_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeIsNotNull() {
            addCriterion("task_reponse_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeEqualTo(Date value) {
            addCriterion("task_reponse_time =", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeNotEqualTo(Date value) {
            addCriterion("task_reponse_time <>", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeGreaterThan(Date value) {
            addCriterion("task_reponse_time >", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_reponse_time >=", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeLessThan(Date value) {
            addCriterion("task_reponse_time <", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_reponse_time <=", value, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeIn(List<Date> values) {
            addCriterion("task_reponse_time in", values, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeNotIn(List<Date> values) {
            addCriterion("task_reponse_time not in", values, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeBetween(Date value1, Date value2) {
            addCriterion("task_reponse_time between", value1, value2, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskReponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_reponse_time not between", value1, value2, "taskReponseTime");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdIsNull() {
            addCriterion("task_session_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdIsNotNull() {
            addCriterion("task_session_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdEqualTo(String value) {
            addCriterion("task_session_id =", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdNotEqualTo(String value) {
            addCriterion("task_session_id <>", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdGreaterThan(String value) {
            addCriterion("task_session_id >", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_session_id >=", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdLessThan(String value) {
            addCriterion("task_session_id <", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdLessThanOrEqualTo(String value) {
            addCriterion("task_session_id <=", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdLike(String value) {
            addCriterion("task_session_id like", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdNotLike(String value) {
            addCriterion("task_session_id not like", value, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdIn(List<String> values) {
            addCriterion("task_session_id in", values, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdNotIn(List<String> values) {
            addCriterion("task_session_id not in", values, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdBetween(String value1, String value2) {
            addCriterion("task_session_id between", value1, value2, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskSessionIdNotBetween(String value1, String value2) {
            addCriterion("task_session_id not between", value1, value2, "taskSessionId");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpIsNull() {
            addCriterion("task_client_ip is null");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpIsNotNull() {
            addCriterion("task_client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpEqualTo(String value) {
            addCriterion("task_client_ip =", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpNotEqualTo(String value) {
            addCriterion("task_client_ip <>", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpGreaterThan(String value) {
            addCriterion("task_client_ip >", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("task_client_ip >=", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpLessThan(String value) {
            addCriterion("task_client_ip <", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpLessThanOrEqualTo(String value) {
            addCriterion("task_client_ip <=", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpLike(String value) {
            addCriterion("task_client_ip like", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpNotLike(String value) {
            addCriterion("task_client_ip not like", value, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpIn(List<String> values) {
            addCriterion("task_client_ip in", values, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpNotIn(List<String> values) {
            addCriterion("task_client_ip not in", values, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpBetween(String value1, String value2) {
            addCriterion("task_client_ip between", value1, value2, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskClientIpNotBetween(String value1, String value2) {
            addCriterion("task_client_ip not between", value1, value2, "taskClientIp");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodIsNull() {
            addCriterion("task_request_method is null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodIsNotNull() {
            addCriterion("task_request_method is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodEqualTo(String value) {
            addCriterion("task_request_method =", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodNotEqualTo(String value) {
            addCriterion("task_request_method <>", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodGreaterThan(String value) {
            addCriterion("task_request_method >", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("task_request_method >=", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodLessThan(String value) {
            addCriterion("task_request_method <", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodLessThanOrEqualTo(String value) {
            addCriterion("task_request_method <=", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodLike(String value) {
            addCriterion("task_request_method like", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodNotLike(String value) {
            addCriterion("task_request_method not like", value, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodIn(List<String> values) {
            addCriterion("task_request_method in", values, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodNotIn(List<String> values) {
            addCriterion("task_request_method not in", values, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodBetween(String value1, String value2) {
            addCriterion("task_request_method between", value1, value2, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestMethodNotBetween(String value1, String value2) {
            addCriterion("task_request_method not between", value1, value2, "taskRequestMethod");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeIsNull() {
            addCriterion("task_request_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeIsNotNull() {
            addCriterion("task_request_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeEqualTo(String value) {
            addCriterion("task_request_type =", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeNotEqualTo(String value) {
            addCriterion("task_request_type <>", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeGreaterThan(String value) {
            addCriterion("task_request_type >", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_request_type >=", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeLessThan(String value) {
            addCriterion("task_request_type <", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeLessThanOrEqualTo(String value) {
            addCriterion("task_request_type <=", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeLike(String value) {
            addCriterion("task_request_type like", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeNotLike(String value) {
            addCriterion("task_request_type not like", value, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeIn(List<String> values) {
            addCriterion("task_request_type in", values, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeNotIn(List<String> values) {
            addCriterion("task_request_type not in", values, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeBetween(String value1, String value2) {
            addCriterion("task_request_type between", value1, value2, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskRequestTypeNotBetween(String value1, String value2) {
            addCriterion("task_request_type not between", value1, value2, "taskRequestType");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeIsNull() {
            addCriterion("task_reponse_code is null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeIsNotNull() {
            addCriterion("task_reponse_code is not null");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeEqualTo(String value) {
            addCriterion("task_reponse_code =", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeNotEqualTo(String value) {
            addCriterion("task_reponse_code <>", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeGreaterThan(String value) {
            addCriterion("task_reponse_code >", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("task_reponse_code >=", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeLessThan(String value) {
            addCriterion("task_reponse_code <", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeLessThanOrEqualTo(String value) {
            addCriterion("task_reponse_code <=", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeLike(String value) {
            addCriterion("task_reponse_code like", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeNotLike(String value) {
            addCriterion("task_reponse_code not like", value, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeIn(List<String> values) {
            addCriterion("task_reponse_code in", values, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeNotIn(List<String> values) {
            addCriterion("task_reponse_code not in", values, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeBetween(String value1, String value2) {
            addCriterion("task_reponse_code between", value1, value2, "taskReponseCode");
            return (Criteria) this;
        }

        public Criteria andTaskReponseCodeNotBetween(String value1, String value2) {
            addCriterion("task_reponse_code not between", value1, value2, "taskReponseCode");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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