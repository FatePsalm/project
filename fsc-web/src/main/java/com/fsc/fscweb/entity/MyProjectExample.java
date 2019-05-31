package com.fsc.fscweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyProjectExample {
    /**
     * my_project
     */
    protected String orderByClause;

    /**
     * my_project
     */
    protected boolean distinct;

    /**
     * my_project
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-03
     */
    public MyProjectExample() {
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
     * my_project 2018-07-03
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

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andProjectTargetIsNull() {
            addCriterion("project_target is null");
            return (Criteria) this;
        }

        public Criteria andProjectTargetIsNotNull() {
            addCriterion("project_target is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTargetEqualTo(Integer value) {
            addCriterion("project_target =", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotEqualTo(Integer value) {
            addCriterion("project_target <>", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetGreaterThan(Integer value) {
            addCriterion("project_target >", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_target >=", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetLessThan(Integer value) {
            addCriterion("project_target <", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetLessThanOrEqualTo(Integer value) {
            addCriterion("project_target <=", value, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetIn(List<Integer> values) {
            addCriterion("project_target in", values, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotIn(List<Integer> values) {
            addCriterion("project_target not in", values, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetBetween(Integer value1, Integer value2) {
            addCriterion("project_target between", value1, value2, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andProjectTargetNotBetween(Integer value1, Integer value2) {
            addCriterion("project_target not between", value1, value2, "projectTarget");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysIsNull() {
            addCriterion("remaining_days is null");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysIsNotNull() {
            addCriterion("remaining_days is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysEqualTo(Integer value) {
            addCriterion("remaining_days =", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysNotEqualTo(Integer value) {
            addCriterion("remaining_days <>", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysGreaterThan(Integer value) {
            addCriterion("remaining_days >", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("remaining_days >=", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysLessThan(Integer value) {
            addCriterion("remaining_days <", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysLessThanOrEqualTo(Integer value) {
            addCriterion("remaining_days <=", value, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysIn(List<Integer> values) {
            addCriterion("remaining_days in", values, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysNotIn(List<Integer> values) {
            addCriterion("remaining_days not in", values, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysBetween(Integer value1, Integer value2) {
            addCriterion("remaining_days between", value1, value2, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andRemainingDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("remaining_days not between", value1, value2, "remainingDays");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIsNull() {
            addCriterion("support_number is null");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIsNotNull() {
            addCriterion("support_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupportNumberEqualTo(Integer value) {
            addCriterion("support_number =", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotEqualTo(Integer value) {
            addCriterion("support_number <>", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberGreaterThan(Integer value) {
            addCriterion("support_number >", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("support_number >=", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberLessThan(Integer value) {
            addCriterion("support_number <", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberLessThanOrEqualTo(Integer value) {
            addCriterion("support_number <=", value, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberIn(List<Integer> values) {
            addCriterion("support_number in", values, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotIn(List<Integer> values) {
            addCriterion("support_number not in", values, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberBetween(Integer value1, Integer value2) {
            addCriterion("support_number between", value1, value2, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andSupportNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("support_number not between", value1, value2, "supportNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIsNull() {
            addCriterion("collection_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIsNotNull() {
            addCriterion("collection_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberEqualTo(Integer value) {
            addCriterion("collection_number =", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotEqualTo(Integer value) {
            addCriterion("collection_number <>", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberGreaterThan(Integer value) {
            addCriterion("collection_number >", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_number >=", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberLessThan(Integer value) {
            addCriterion("collection_number <", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberLessThanOrEqualTo(Integer value) {
            addCriterion("collection_number <=", value, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberIn(List<Integer> values) {
            addCriterion("collection_number in", values, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotIn(List<Integer> values) {
            addCriterion("collection_number not in", values, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberBetween(Integer value1, Integer value2) {
            addCriterion("collection_number between", value1, value2, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_number not between", value1, value2, "collectionNumber");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }
    }

    /**
     * my_project
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * my_project 2018-07-03
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