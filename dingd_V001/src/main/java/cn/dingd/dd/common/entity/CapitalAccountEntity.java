package cn.dingd.dd.common.entity;

import java.io.Serializable;
/**
 * 资金账户
 * @author XCD
 *
 */
public class CapitalAccountEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 23928122815684786L;
    /**id*/
	private int id;
	/**用户*/
	private int auserId;
	/**余额*/
	private float  balance;
	/**冻结*/
	private float freeze;
	/**提现*/
	private float withdraw;
	

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
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getFreeze() {
		return freeze;
	}
	public void setFreeze(float freeze) {
		this.freeze = freeze;
	}
	public float getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}
	
	
	
}
