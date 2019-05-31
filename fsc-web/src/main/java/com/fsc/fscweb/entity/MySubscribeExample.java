package com.fsc.fscweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySubscribeExample {
    /**
     * my_subscribe
     */
    protected String orderByClause;

    /**
     * my_subscribe
     */
    protected boolean distinct;

    /**
     * my_subscribe
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public MySubscribeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * my_subscribe 2018-07-03
     */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIdIsNull() {
            addCriterion("user_name_id is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIdIsNotNull() {
            addCriterion("user_name_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameIdEqualTo(Integer value) {
            addCriterion("user_name_id =", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdNotEqualTo(Integer value) {
            addCriterion("user_name_id <>", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdGreaterThan(Integer value) {
            addCriterion("user_name_id >", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_name_id >=", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdLessThan(Integer value) {
            addCriterion("user_name_id <", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_name_id <=", value, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdIn(List<Integer> values) {
            addCriterion("user_name_id in", values, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdNotIn(List<Integer> values) {
            addCriterion("user_name_id not in", values, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdBetween(Integer value1, Integer value2) {
            addCriterion("user_name_id between", value1, value2, "userNameId");
            return (Criteria) this;
        }

        public Criteria andUserNameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_name_id not between", value1, value2, "userNameId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNull() {
            addCriterion("money_type is null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNotNull() {
            addCriterion("money_type is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeEqualTo(String value) {
            addCriterion("money_type =", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotEqualTo(String value) {
            addCriterion("money_type <>", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThan(String value) {
            addCriterion("money_type >", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("money_type >=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThan(String value) {
            addCriterion("money_type <", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThanOrEqualTo(String value) {
            addCriterion("money_type <=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLike(String value) {
            addCriterion("money_type like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotLike(String value) {
            addCriterion("money_type not like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIn(List<String> values) {
            addCriterion("money_type in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotIn(List<String> values) {
            addCriterion("money_type not in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeBetween(String value1, String value2) {
            addCriterion("money_type between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotBetween(String value1, String value2) {
            addCriterion("money_type not between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberIsNull() {
            addCriterion("subscribe_number is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberIsNotNull() {
            addCriterion("subscribe_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberEqualTo(Integer value) {
            addCriterion("subscribe_number =", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberNotEqualTo(Integer value) {
            addCriterion("subscribe_number <>", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberGreaterThan(Integer value) {
            addCriterion("subscribe_number >", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("subscribe_number >=", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberLessThan(Integer value) {
            addCriterion("subscribe_number <", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("subscribe_number <=", value, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberIn(List<Integer> values) {
            addCriterion("subscribe_number in", values, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberNotIn(List<Integer> values) {
            addCriterion("subscribe_number not in", values, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberBetween(Integer value1, Integer value2) {
            addCriterion("subscribe_number between", value1, value2, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andSubscribeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("subscribe_number not between", value1, value2, "subscribeNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIsNull() {
            addCriterion("money_number is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIsNotNull() {
            addCriterion("money_number is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberEqualTo(Integer value) {
            addCriterion("money_number =", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotEqualTo(Integer value) {
            addCriterion("money_number <>", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberGreaterThan(Integer value) {
            addCriterion("money_number >", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_number >=", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberLessThan(Integer value) {
            addCriterion("money_number <", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberLessThanOrEqualTo(Integer value) {
            addCriterion("money_number <=", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIn(List<Integer> values) {
            addCriterion("money_number in", values, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotIn(List<Integer> values) {
            addCriterion("money_number not in", values, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberBetween(Integer value1, Integer value2) {
            addCriterion("money_number between", value1, value2, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("money_number not between", value1, value2, "moneyNumber");
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

    /**
     * my_subscribe
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * my_subscribe 2018-07-03
     */
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