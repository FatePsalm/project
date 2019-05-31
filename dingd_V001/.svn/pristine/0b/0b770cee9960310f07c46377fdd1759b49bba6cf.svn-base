package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 支出信息
 * @author XCD
 *
 */
public class PaymentInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4700116259900032984L;
	
	/**id*/
	private int id;
	/**用户id*/
	private int auserId;
	/**金额*/
	private float money;
	/**创建时间*/
	private Date createTime;
	/**订单id*/
	private int payOrderId;
	/**备注*/
	private String comments;
	/**收款账号*/
	private String payAccount;
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
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPayOrderId() {
		return payOrderId;
	}
	public void setPayOrderId(int payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public float getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "PaymentInfoEntity [id=" + id + ", auserId=" + auserId + ", money=" + money + ", createTime="
				+ createTime + ", payOrderId=" + payOrderId + ", comments=" + comments + ", payAccount=" + payAccount
				+ ", currentBalance=" + currentBalance + "]";
	}
	
	

}
