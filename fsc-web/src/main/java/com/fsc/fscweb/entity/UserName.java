package com.fsc.fscweb.entity;

import java.util.Date;

public class UserName {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 邀请码
     */
    private String invitationCode;

    /**
     * 父级邀请码
     */
    private String invitationCodePid;

    /**
     * 身份证
     */
    private String identity;

    /**
     * 姓名
     */
    private String compellation;

    /**
     * 性别
     */
    private Byte sex=1;

    /**
     * 电话
     */
    private String phone;

    /**
     * 最近登录时间
     */
    private Date latelyLoginTime;

    /**
     * 1-普通用户 100-管理员
     */
    private Integer userType;

    /**
     * 护照类型
     */
    private String passportType;

    /**
     * 护照号码
     */
    private String passportNumber;

    /**
     * 出生年月日
     */
    private Date birthTime;

    /**
     * 出生地
     */
    private String birthplace;

    /**
     * 签发日期
     */
    private Date passportTime;

    /**
     * 到期时间
     */
    private Date passportTimeOver;

    /**
     * 电话邮箱
     */
    private String email;

    /**
     * ImToken钱包地址
     */
    private String myToken;

    /**
     * 是否认证
     */
    private Integer ischeck;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     * @return user_password 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 密码
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 注册时间
     * @return register_time 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 注册时间
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 邀请码
     * @return Invitation_code 邀请码
     */
    public String getInvitationCode() {
        return invitationCode;
    }

    /**
     * 邀请码
     * @param invitationCode 邀请码
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    /**
     * 父级邀请码
     * @return Invitation_code_pid 父级邀请码
     */
    public String getInvitationCodePid() {
        return invitationCodePid;
    }

    /**
     * 父级邀请码
     * @param invitationCodePid 父级邀请码
     */
    public void setInvitationCodePid(String invitationCodePid) {
        this.invitationCodePid = invitationCodePid == null ? null : invitationCodePid.trim();
    }

    /**
     * 身份证
     * @return identity 身份证
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 身份证
     * @param identity 身份证
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * 姓名
     * @return compellation 姓名
     */
    public String getCompellation() {
        return compellation;
    }

    /**
     * 姓名
     * @param compellation 姓名
     */
    public void setCompellation(String compellation) {
        this.compellation = compellation == null ? null : compellation.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 最近登录时间
     * @return lately_login_time 最近登录时间
     */
    public Date getLatelyLoginTime() {
        return latelyLoginTime;
    }

    /**
     * 最近登录时间
     * @param latelyLoginTime 最近登录时间
     */
    public void setLatelyLoginTime(Date latelyLoginTime) {
        this.latelyLoginTime = latelyLoginTime;
    }

    /**
     * 1-普通用户 100-管理员
     * @return user_type 1-普通用户 100-管理员
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 1-普通用户 100-管理员
     * @param userType 1-普通用户 100-管理员
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 护照类型
     * @return passport_type 护照类型
     */
    public String getPassportType() {
        return passportType;
    }

    /**
     * 护照类型
     * @param passportType 护照类型
     */
    public void setPassportType(String passportType) {
        this.passportType = passportType == null ? null : passportType.trim();
    }

    /**
     * 护照号码
     * @return passport_number 护照号码
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * 护照号码
     * @param passportNumber 护照号码
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber == null ? null : passportNumber.trim();
    }

    /**
     * 出生年月日
     * @return birth_time 出生年月日
     */
    public Date getBirthTime() {
        return birthTime;
    }

    /**
     * 出生年月日
     * @param birthTime 出生年月日
     */
    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    /**
     * 出生地
     * @return birthplace 出生地
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * 出生地
     * @param birthplace 出生地
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    /**
     * 签发日期
     * @return passport_time 签发日期
     */
    public Date getPassportTime() {
        return passportTime;
    }

    /**
     * 签发日期
     * @param passportTime 签发日期
     */
    public void setPassportTime(Date passportTime) {
        this.passportTime = passportTime;
    }

    /**
     * 到期时间
     * @return passport_time_over 到期时间
     */
    public Date getPassportTimeOver() {
        return passportTimeOver;
    }

    /**
     * 到期时间
     * @param passportTimeOver 到期时间
     */
    public void setPassportTimeOver(Date passportTimeOver) {
        this.passportTimeOver = passportTimeOver;
    }

    /**
     * 电话邮箱
     * @return email 电话邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电话邮箱
     * @param email 电话邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * ImToken钱包地址
     * @return my_token ImToken钱包地址
     */
    public String getMyToken() {
        return myToken;
    }

    /**
     * ImToken钱包地址
     * @param myToken ImToken钱包地址
     */
    public void setMyToken(String myToken) {
        this.myToken = myToken == null ? null : myToken.trim();
    }

    /**
     * 是否认证
     * @return isCheck 是否认证
     */
    public Integer getIscheck() {
        return ischeck;
    }

    /**
     * 是否认证
     * @param ischeck 是否认证
     */
    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }
}