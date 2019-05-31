package com.fsc.fscweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserNameExample {
    /**
     * user_name
     */
    protected String orderByClause;

    /**
     * user_name
     */
    protected boolean distinct;

    /**
     * user_name
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public UserNameExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-12
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
     * @mbggenerated 2018-07-12
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2018-07-12
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * user_name 2018-07-12
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNull() {
            addCriterion("Invitation_code is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNotNull() {
            addCriterion("Invitation_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeEqualTo(String value) {
            addCriterion("Invitation_code =", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotEqualTo(String value) {
            addCriterion("Invitation_code <>", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThan(String value) {
            addCriterion("Invitation_code >", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Invitation_code >=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThan(String value) {
            addCriterion("Invitation_code <", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
            addCriterion("Invitation_code <=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLike(String value) {
            addCriterion("Invitation_code like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotLike(String value) {
            addCriterion("Invitation_code not like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIn(List<String> values) {
            addCriterion("Invitation_code in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotIn(List<String> values) {
            addCriterion("Invitation_code not in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeBetween(String value1, String value2) {
            addCriterion("Invitation_code between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotBetween(String value1, String value2) {
            addCriterion("Invitation_code not between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidIsNull() {
            addCriterion("Invitation_code_pid is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidIsNotNull() {
            addCriterion("Invitation_code_pid is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidEqualTo(String value) {
            addCriterion("Invitation_code_pid =", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidNotEqualTo(String value) {
            addCriterion("Invitation_code_pid <>", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidGreaterThan(String value) {
            addCriterion("Invitation_code_pid >", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidGreaterThanOrEqualTo(String value) {
            addCriterion("Invitation_code_pid >=", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidLessThan(String value) {
            addCriterion("Invitation_code_pid <", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidLessThanOrEqualTo(String value) {
            addCriterion("Invitation_code_pid <=", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidLike(String value) {
            addCriterion("Invitation_code_pid like", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidNotLike(String value) {
            addCriterion("Invitation_code_pid not like", value, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidIn(List<String> values) {
            addCriterion("Invitation_code_pid in", values, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidNotIn(List<String> values) {
            addCriterion("Invitation_code_pid not in", values, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidBetween(String value1, String value2) {
            addCriterion("Invitation_code_pid between", value1, value2, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andInvitationCodePidNotBetween(String value1, String value2) {
            addCriterion("Invitation_code_pid not between", value1, value2, "invitationCodePid");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andCompellationIsNull() {
            addCriterion("compellation is null");
            return (Criteria) this;
        }

        public Criteria andCompellationIsNotNull() {
            addCriterion("compellation is not null");
            return (Criteria) this;
        }

        public Criteria andCompellationEqualTo(String value) {
            addCriterion("compellation =", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationNotEqualTo(String value) {
            addCriterion("compellation <>", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationGreaterThan(String value) {
            addCriterion("compellation >", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationGreaterThanOrEqualTo(String value) {
            addCriterion("compellation >=", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationLessThan(String value) {
            addCriterion("compellation <", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationLessThanOrEqualTo(String value) {
            addCriterion("compellation <=", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationLike(String value) {
            addCriterion("compellation like", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationNotLike(String value) {
            addCriterion("compellation not like", value, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationIn(List<String> values) {
            addCriterion("compellation in", values, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationNotIn(List<String> values) {
            addCriterion("compellation not in", values, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationBetween(String value1, String value2) {
            addCriterion("compellation between", value1, value2, "compellation");
            return (Criteria) this;
        }

        public Criteria andCompellationNotBetween(String value1, String value2) {
            addCriterion("compellation not between", value1, value2, "compellation");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeIsNull() {
            addCriterion("lately_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeIsNotNull() {
            addCriterion("lately_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeEqualTo(Date value) {
            addCriterion("lately_login_time =", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeNotEqualTo(Date value) {
            addCriterion("lately_login_time <>", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeGreaterThan(Date value) {
            addCriterion("lately_login_time >", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lately_login_time >=", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeLessThan(Date value) {
            addCriterion("lately_login_time <", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("lately_login_time <=", value, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeIn(List<Date> values) {
            addCriterion("lately_login_time in", values, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeNotIn(List<Date> values) {
            addCriterion("lately_login_time not in", values, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeBetween(Date value1, Date value2) {
            addCriterion("lately_login_time between", value1, value2, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andLatelyLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("lately_login_time not between", value1, value2, "latelyLoginTime");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeIsNull() {
            addCriterion("passport_type is null");
            return (Criteria) this;
        }

        public Criteria andPassportTypeIsNotNull() {
            addCriterion("passport_type is not null");
            return (Criteria) this;
        }

        public Criteria andPassportTypeEqualTo(String value) {
            addCriterion("passport_type =", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeNotEqualTo(String value) {
            addCriterion("passport_type <>", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeGreaterThan(String value) {
            addCriterion("passport_type >", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeGreaterThanOrEqualTo(String value) {
            addCriterion("passport_type >=", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeLessThan(String value) {
            addCriterion("passport_type <", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeLessThanOrEqualTo(String value) {
            addCriterion("passport_type <=", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeLike(String value) {
            addCriterion("passport_type like", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeNotLike(String value) {
            addCriterion("passport_type not like", value, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeIn(List<String> values) {
            addCriterion("passport_type in", values, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeNotIn(List<String> values) {
            addCriterion("passport_type not in", values, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeBetween(String value1, String value2) {
            addCriterion("passport_type between", value1, value2, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportTypeNotBetween(String value1, String value2) {
            addCriterion("passport_type not between", value1, value2, "passportType");
            return (Criteria) this;
        }

        public Criteria andPassportNumberIsNull() {
            addCriterion("passport_number is null");
            return (Criteria) this;
        }

        public Criteria andPassportNumberIsNotNull() {
            addCriterion("passport_number is not null");
            return (Criteria) this;
        }

        public Criteria andPassportNumberEqualTo(String value) {
            addCriterion("passport_number =", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberNotEqualTo(String value) {
            addCriterion("passport_number <>", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberGreaterThan(String value) {
            addCriterion("passport_number >", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberGreaterThanOrEqualTo(String value) {
            addCriterion("passport_number >=", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberLessThan(String value) {
            addCriterion("passport_number <", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberLessThanOrEqualTo(String value) {
            addCriterion("passport_number <=", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberLike(String value) {
            addCriterion("passport_number like", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberNotLike(String value) {
            addCriterion("passport_number not like", value, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberIn(List<String> values) {
            addCriterion("passport_number in", values, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberNotIn(List<String> values) {
            addCriterion("passport_number not in", values, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberBetween(String value1, String value2) {
            addCriterion("passport_number between", value1, value2, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andPassportNumberNotBetween(String value1, String value2) {
            addCriterion("passport_number not between", value1, value2, "passportNumber");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIsNull() {
            addCriterion("birth_time is null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIsNotNull() {
            addCriterion("birth_time is not null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeEqualTo(Date value) {
            addCriterion("birth_time =", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotEqualTo(Date value) {
            addCriterion("birth_time <>", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThan(Date value) {
            addCriterion("birth_time >", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_time >=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThan(Date value) {
            addCriterion("birth_time <", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThanOrEqualTo(Date value) {
            addCriterion("birth_time <=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIn(List<Date> values) {
            addCriterion("birth_time in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotIn(List<Date> values) {
            addCriterion("birth_time not in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeBetween(Date value1, Date value2) {
            addCriterion("birth_time between", value1, value2, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotBetween(Date value1, Date value2) {
            addCriterion("birth_time not between", value1, value2, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNull() {
            addCriterion("birthplace is null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIsNotNull() {
            addCriterion("birthplace is not null");
            return (Criteria) this;
        }

        public Criteria andBirthplaceEqualTo(String value) {
            addCriterion("birthplace =", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotEqualTo(String value) {
            addCriterion("birthplace <>", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThan(String value) {
            addCriterion("birthplace >", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceGreaterThanOrEqualTo(String value) {
            addCriterion("birthplace >=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThan(String value) {
            addCriterion("birthplace <", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLessThanOrEqualTo(String value) {
            addCriterion("birthplace <=", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceLike(String value) {
            addCriterion("birthplace like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotLike(String value) {
            addCriterion("birthplace not like", value, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceIn(List<String> values) {
            addCriterion("birthplace in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotIn(List<String> values) {
            addCriterion("birthplace not in", values, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceBetween(String value1, String value2) {
            addCriterion("birthplace between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andBirthplaceNotBetween(String value1, String value2) {
            addCriterion("birthplace not between", value1, value2, "birthplace");
            return (Criteria) this;
        }

        public Criteria andPassportTimeIsNull() {
            addCriterion("passport_time is null");
            return (Criteria) this;
        }

        public Criteria andPassportTimeIsNotNull() {
            addCriterion("passport_time is not null");
            return (Criteria) this;
        }

        public Criteria andPassportTimeEqualTo(Date value) {
            addCriterion("passport_time =", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeNotEqualTo(Date value) {
            addCriterion("passport_time <>", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeGreaterThan(Date value) {
            addCriterion("passport_time >", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("passport_time >=", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeLessThan(Date value) {
            addCriterion("passport_time <", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeLessThanOrEqualTo(Date value) {
            addCriterion("passport_time <=", value, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeIn(List<Date> values) {
            addCriterion("passport_time in", values, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeNotIn(List<Date> values) {
            addCriterion("passport_time not in", values, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeBetween(Date value1, Date value2) {
            addCriterion("passport_time between", value1, value2, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeNotBetween(Date value1, Date value2) {
            addCriterion("passport_time not between", value1, value2, "passportTime");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverIsNull() {
            addCriterion("passport_time_over is null");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverIsNotNull() {
            addCriterion("passport_time_over is not null");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverEqualTo(Date value) {
            addCriterion("passport_time_over =", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverNotEqualTo(Date value) {
            addCriterion("passport_time_over <>", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverGreaterThan(Date value) {
            addCriterion("passport_time_over >", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverGreaterThanOrEqualTo(Date value) {
            addCriterion("passport_time_over >=", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverLessThan(Date value) {
            addCriterion("passport_time_over <", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverLessThanOrEqualTo(Date value) {
            addCriterion("passport_time_over <=", value, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverIn(List<Date> values) {
            addCriterion("passport_time_over in", values, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverNotIn(List<Date> values) {
            addCriterion("passport_time_over not in", values, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverBetween(Date value1, Date value2) {
            addCriterion("passport_time_over between", value1, value2, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andPassportTimeOverNotBetween(Date value1, Date value2) {
            addCriterion("passport_time_over not between", value1, value2, "passportTimeOver");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMyTokenIsNull() {
            addCriterion("my_token is null");
            return (Criteria) this;
        }

        public Criteria andMyTokenIsNotNull() {
            addCriterion("my_token is not null");
            return (Criteria) this;
        }

        public Criteria andMyTokenEqualTo(String value) {
            addCriterion("my_token =", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenNotEqualTo(String value) {
            addCriterion("my_token <>", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenGreaterThan(String value) {
            addCriterion("my_token >", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenGreaterThanOrEqualTo(String value) {
            addCriterion("my_token >=", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenLessThan(String value) {
            addCriterion("my_token <", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenLessThanOrEqualTo(String value) {
            addCriterion("my_token <=", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenLike(String value) {
            addCriterion("my_token like", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenNotLike(String value) {
            addCriterion("my_token not like", value, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenIn(List<String> values) {
            addCriterion("my_token in", values, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenNotIn(List<String> values) {
            addCriterion("my_token not in", values, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenBetween(String value1, String value2) {
            addCriterion("my_token between", value1, value2, "myToken");
            return (Criteria) this;
        }

        public Criteria andMyTokenNotBetween(String value1, String value2) {
            addCriterion("my_token not between", value1, value2, "myToken");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNull() {
            addCriterion("isCheck is null");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNotNull() {
            addCriterion("isCheck is not null");
            return (Criteria) this;
        }

        public Criteria andIscheckEqualTo(Integer value) {
            addCriterion("isCheck =", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotEqualTo(Integer value) {
            addCriterion("isCheck <>", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThan(Integer value) {
            addCriterion("isCheck >", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("isCheck >=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThan(Integer value) {
            addCriterion("isCheck <", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThanOrEqualTo(Integer value) {
            addCriterion("isCheck <=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckIn(List<Integer> values) {
            addCriterion("isCheck in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotIn(List<Integer> values) {
            addCriterion("isCheck not in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckBetween(Integer value1, Integer value2) {
            addCriterion("isCheck between", value1, value2, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotBetween(Integer value1, Integer value2) {
            addCriterion("isCheck not between", value1, value2, "ischeck");
            return (Criteria) this;
        }
    }

    /**
     * user_name
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_name 2018-07-12
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