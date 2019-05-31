package com.fsc.fscweb.entity;

import java.util.Date;

public class MySubscribe {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userNameId;

    /**
     * 认购项目ID
     */
    private Integer projectId;

    /**
     * 币种
     */
    private String moneyType;

    /**
     * 认购份数
     */
    private Integer subscribeNumber;

    /**
     * 代币数量
     */
    private Integer moneyNumber;

    /**
     * 交易时间
     */
    private Date createTime;

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
     * 用户ID
     * @return user_name_id 用户ID
     */
    public Integer getUserNameId() {
        return userNameId;
    }

    /**
     * 用户ID
     * @param userNameId 用户ID
     */
    public void setUserNameId(Integer userNameId) {
        this.userNameId = userNameId;
    }

    /**
     * 认购项目ID
     * @return project_id 认购项目ID
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 认购项目ID
     * @param projectId 认购项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 币种
     * @return money_type 币种
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 币种
     * @param moneyType 币种
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType == null ? null : moneyType.trim();
    }

    /**
     * 认购份数
     * @return subscribe_number 认购份数
     */
    public Integer getSubscribeNumber() {
        return subscribeNumber;
    }

    /**
     * 认购份数
     * @param subscribeNumber 认购份数
     */
    public void setSubscribeNumber(Integer subscribeNumber) {
        this.subscribeNumber = subscribeNumber;
    }

    /**
     * 代币数量
     * @return money_number 代币数量
     */
    public Integer getMoneyNumber() {
        return moneyNumber;
    }

    /**
     * 代币数量
     * @param moneyNumber 代币数量
     */
    public void setMoneyNumber(Integer moneyNumber) {
        this.moneyNumber = moneyNumber;
    }

    /**
     * 交易时间
     * @return create_time 交易时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 交易时间
     * @param createTime 交易时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}