package com.fsc.fscweb.entity;

public class MyWallet {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userNameId;

    /**
     * 货币类型
     */
    private String moneyType;

    /**
     * 可用金额
     */
    private Integer moneyUsable;

    /**
     * 冻结金额
     */
    private Integer moneyFreeze;

    /**
     * 总值=冻结+可用
     */
    private Integer moneyOverall;

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
     * 货币类型
     * @return money_type 货币类型
     */
    public String getMoneyType() {
        return moneyType;
    }

    /**
     * 货币类型
     * @param moneyType 货币类型
     */
    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType == null ? null : moneyType.trim();
    }

    /**
     * 可用金额
     * @return money_usable 可用金额
     */
    public Integer getMoneyUsable() {
        return moneyUsable;
    }

    /**
     * 可用金额
     * @param moneyUsable 可用金额
     */
    public void setMoneyUsable(Integer moneyUsable) {
        this.moneyUsable = moneyUsable;
    }

    /**
     * 冻结金额
     * @return money_freeze 冻结金额
     */
    public Integer getMoneyFreeze() {
        return moneyFreeze;
    }

    /**
     * 冻结金额
     * @param moneyFreeze 冻结金额
     */
    public void setMoneyFreeze(Integer moneyFreeze) {
        this.moneyFreeze = moneyFreeze;
    }

    /**
     * 总值=冻结+可用
     * @return money_overall 总值=冻结+可用
     */
    public Integer getMoneyOverall() {
        return moneyOverall;
    }

    /**
     * 总值=冻结+可用
     * @param moneyOverall 总值=冻结+可用
     */
    public void setMoneyOverall(Integer moneyOverall) {
        this.moneyOverall = moneyOverall;
    }
}