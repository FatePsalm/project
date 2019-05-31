package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 申请提现
 * @author XCD
 *
 */
public class EnchashmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2476228682387692445L;
    /**id*/
    private int id;
    /**金额*/
    private int money;
    /**创建时间*/
    private Date creatTime;
    /**用户id*/
    private int auserId;
    /**状态*/
    private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public int getAuserId() {
		return auserId;
	}
	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    
    
}
