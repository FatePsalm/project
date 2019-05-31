package com.fsc.fscweb.entity;

import java.util.Date;

public class MyProject {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 货币类型
     */
    private String moneyType;

    /**
     * 筹集目标
     */
    private Integer projectTarget;

    /**
     * 剩余天数
     */
    private Integer remainingDays;

    /**
     * 支持人数
     */
    private Integer supportNumber;

    /**
     * 募捐数
     */
    private Integer collectionNumber;

    /**
     * 创建时间
     */
    private Date creationTime;

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
     * 项目名称
     * @return project_name 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
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
     * 筹集目标
     * @return project_target 筹集目标
     */
    public Integer getProjectTarget() {
        return projectTarget;
    }

    /**
     * 筹集目标
     * @param projectTarget 筹集目标
     */
    public void setProjectTarget(Integer projectTarget) {
        this.projectTarget = projectTarget;
    }

    /**
     * 剩余天数
     * @return remaining_days 剩余天数
     */
    public Integer getRemainingDays() {
        return remainingDays;
    }

    /**
     * 剩余天数
     * @param remainingDays 剩余天数
     */
    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }

    /**
     * 支持人数
     * @return support_number 支持人数
     */
    public Integer getSupportNumber() {
        return supportNumber;
    }

    /**
     * 支持人数
     * @param supportNumber 支持人数
     */
    public void setSupportNumber(Integer supportNumber) {
        this.supportNumber = supportNumber;
    }

    /**
     * 募捐数
     * @return collection_number 募捐数
     */
    public Integer getCollectionNumber() {
        return collectionNumber;
    }

    /**
     * 募捐数
     * @param collectionNumber 募捐数
     */
    public void setCollectionNumber(Integer collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    /**
     * 创建时间
     * @return creation_time 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * 创建时间
     * @param creationTime 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}