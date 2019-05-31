package com.fsc.fscweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyRecordExample {
    /**
     * my_record
     */
    protected String orderByClause;

    /**
     * my_record
     */
    protected boolean distinct;

    /**
     * my_record
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public MyRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-04
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
     * @mbggenerated 2018-07-04
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-04
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * my_record 2018-07-04
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

        public Criteria andRecordStateIsNull() {
            addCriterion("record_state is null");
            return (Criteria) this;
        }

        public Criteria andRecordStateIsNotNull() {
            addCriterion("record_state is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStateEqualTo(Integer value) {
            addCriterion("record_state =", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotEqualTo(Integer value) {
            addCriterion("record_state <>", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThan(Integer value) {
            addCriterion("record_state >", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_state >=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThan(Integer value) {
            addCriterion("record_state <", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateLessThanOrEqualTo(Integer value) {
            addCriterion("record_state <=", value, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateIn(List<Integer> values) {
            addCriterion("record_state in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotIn(List<Integer> values) {
            addCriterion("record_state not in", values, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateBetween(Integer value1, Integer value2) {
            addCriterion("record_state between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andRecordStateNotBetween(Integer value1, Integer value2) {
            addCriterion("record_state not between", value1, value2, "recordState");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableIsNull() {
            addCriterion("money_usable is null");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableIsNotNull() {
            addCriterion("money_usable is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableEqualTo(Integer value) {
            addCriterion("money_usable =", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableNotEqualTo(Integer value) {
            addCriterion("money_usable <>", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableGreaterThan(Integer value) {
            addCriterion("money_usable >", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_usable >=", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableLessThan(Integer value) {
            addCriterion("money_usable <", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableLessThanOrEqualTo(Integer value) {
            addCriterion("money_usable <=", value, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableIn(List<Integer> values) {
            addCriterion("money_usable in", values, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableNotIn(List<Integer> values) {
            addCriterion("money_usable not in", values, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableBetween(Integer value1, Integer value2) {
            addCriterion("money_usable between", value1, value2, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyUsableNotBetween(Integer value1, Integer value2) {
            addCriterion("money_usable not between", value1, value2, "moneyUsable");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeIsNull() {
            addCriterion("money_freeze is null");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeIsNotNull() {
            addCriterion("money_freeze is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeEqualTo(Integer value) {
            addCriterion("money_freeze =", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeNotEqualTo(Integer value) {
            addCriterion("money_freeze <>", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeGreaterThan(Integer value) {
            addCriterion("money_freeze >", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_freeze >=", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeLessThan(Integer value) {
            addCriterion("money_freeze <", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeLessThanOrEqualTo(Integer value) {
            addCriterion("money_freeze <=", value, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeIn(List<Integer> values) {
            addCriterion("money_freeze in", values, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeNotIn(List<Integer> values) {
            addCriterion("money_freeze not in", values, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeBetween(Integer value1, Integer value2) {
            addCriterion("money_freeze between", value1, value2, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyFreezeNotBetween(Integer value1, Integer value2) {
            addCriterion("money_freeze not between", value1, value2, "moneyFreeze");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallIsNull() {
            addCriterion("money_overall is null");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallIsNotNull() {
            addCriterion("money_overall is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallEqualTo(Integer value) {
            addCriterion("money_overall =", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallNotEqualTo(Integer value) {
            addCriterion("money_overall <>", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallGreaterThan(Integer value) {
            addCriterion("money_overall >", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallGreaterThanOrEqualTo(Integer value) {
            addCriterion("money_overall >=", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallLessThan(Integer value) {
            addCriterion("money_overall <", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallLessThanOrEqualTo(Integer value) {
            addCriterion("money_overall <=", value, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallIn(List<Integer> values) {
            addCriterion("money_overall in", values, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallNotIn(List<Integer> values) {
            addCriterion("money_overall not in", values, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallBetween(Integer value1, Integer value2) {
            addCriterion("money_overall between", value1, value2, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andMoneyOverallNotBetween(Integer value1, Integer value2) {
            addCriterion("money_overall not between", value1, value2, "moneyOverall");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNull() {
            addCriterion("record_type is null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIsNotNull() {
            addCriterion("record_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTypeEqualTo(Integer value) {
            addCriterion("record_type =", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotEqualTo(Integer value) {
            addCriterion("record_type <>", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThan(Integer value) {
            addCriterion("record_type >", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_type >=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThan(Integer value) {
            addCriterion("record_type <", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeLessThanOrEqualTo(Integer value) {
            addCriterion("record_type <=", value, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeIn(List<Integer> values) {
            addCriterion("record_type in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotIn(List<Integer> values) {
            addCriterion("record_type not in", values, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeBetween(Integer value1, Integer value2) {
            addCriterion("record_type between", value1, value2, "recordType");
            return (Criteria) this;
        }

        public Criteria andRecordTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("record_type not between", value1, value2, "recordType");
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
    }

    /**
     * my_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * my_record 2018-07-04
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