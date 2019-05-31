package com.fsc.fscweb.entity;

import java.util.ArrayList;
import java.util.List;

public class MyWalletExample {
    /**
     * my_wallet
     */
    protected String orderByClause;

    /**
     * my_wallet
     */
    protected boolean distinct;

    /**
     * my_wallet
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public MyWalletExample() {
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
     * my_wallet 2018-07-03
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
    }

    /**
     * my_wallet
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * my_wallet 2018-07-03
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