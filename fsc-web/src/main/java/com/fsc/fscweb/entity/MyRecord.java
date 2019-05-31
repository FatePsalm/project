package com.fsc.fscweb.entity;

import java.util.Date;

public class MyRecord {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userNameId;

    /**
     * 订单状态1-完成 2-取消 3-挂起
     */
    private Integer recordState;

    /**
     * 可用金额
     */
    private Integer moneyUsable;

    /**
     * 冻结金额
     */
    private Integer moneyFreeze;

    /**
     * 总金额=冻结+可用
     */
    private Integer moneyOverall;

    /**
     * 1-充值记录  2-体现记录 3-认购记录
     */
    private Integer recordType;

    /**
     * 生成时间
     */
    private Date createTime;

    /**
     * 认购/提现/充值数量
     */
    private Integer moneyNumber;

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
     * 订单状态1-完成 2-取消 3-挂起
     * @return record_state 订单状态1-完成 2-取消 3-挂起
     */
    public Integer getRecordState() {
        return recordState;
    }

    /**
     * 订单状态1-完成 2-取消 3-挂起
     * @param recordState 订单状态1-完成 2-取消 3-挂起
     */
    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
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
     * 总金额=冻结+可用
     * @return money_overall 总金额=冻结+可用
     */
    public Integer getMoneyOverall() {
        return moneyOverall;
    }

    /**
     * 总金额=冻结+可用
     * @param moneyOverall 总金额=冻结+可用
     */
    public void setMoneyOverall(Integer moneyOverall) {
        this.moneyOverall = moneyOverall;
    }

    /**
     * 1-充值记录  2-体现记录 3-认购记录
     * @return record_type 1-充值记录  2-体现记录 3-认购记录
     */
    public Integer getRecordType() {
        return recordType;
    }

    /**
     * 1-充值记录  2-体现记录 3-认购记录
     * @param recordType 1-充值记录  2-体现记录 3-认购记录
     */
    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    /**
     * 生成时间
     * @return create_time 生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 生成时间
     * @param createTime 生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 认购/提现/充值数量
     * @return money_number 认购/提现/充值数量
     */
    public Integer getMoneyNumber() {
        return moneyNumber;
    }

    /**
     * 认购/提现/充值数量
     * @param moneyNumber 认购/提现/充值数量
     */
    public void setMoneyNumber(Integer moneyNumber) {
        this.moneyNumber = moneyNumber;
    }
}