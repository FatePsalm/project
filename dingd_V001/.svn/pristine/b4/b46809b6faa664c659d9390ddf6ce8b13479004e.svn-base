package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 充值记录
 * 
 * @author XCD
 *
 */
public class RechargeInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1226008222588952842L;

	/** id */
	private int id;
	/** 用户id */
	private int auserId;
	/** 金额 */
	private float money;
	/** 创建时间 */
	private Date createTime;
	/** 支付订单id */
	private int payOrderId;
	/** 付款账号 */
	private String rechargeAccount;
	/** 当前余额 */
	private float currentBalance;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuserId() {
		return auserId;
	}

	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRechargeAccount() {
		return rechargeAccount;
	}

	public void setRechargeAccount(String rechargeAccount) {
		this.rechargeAccount = rechargeAccount;
	}

	public int getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(int payOrderId) {
		this.payOrderId = payOrderId;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "RechargeInfoEntity [id=" + id + ", auserId=" + auserId + ", money=" + money + ", createTime="
				+ createTime + ", payOrderId=" + payOrderId + ", rechargeAccount=" + rechargeAccount
				+ ", currentBalance=" + currentBalance + "]";
	}

}
