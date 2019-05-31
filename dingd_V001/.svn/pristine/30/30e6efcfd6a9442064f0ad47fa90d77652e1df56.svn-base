package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 支付订单
 * @author XCD
 *
 */

public class PayOrderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8558107944849109278L;
	
	/**id*/
	private int id;
	/**类型  1.冻结,2.提现,3.解冻,4.扣款,5.充值*/
	private int mtype;
    /**订单号*/
	private String mnumber;
	/**创建时间*/
	private Date mtime;
	/**金额*/
	private float money;
	/**支付方式  1. 微信,2.支付宝,3.保证金*/
	private int mchannel;
	/**支付状态   1.付款，0.未付款*/
	private int mstate;
	/**支付者*/
	private int auserId;
	/**标题*/
	private String title;
	/** 第三方订单号 */
	private String threeNo;
	/**支付时间*/
	private String payTime;
	/**车辆id*/
	private int carId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMtype() {
		return mtype;
	}
	public void setMtype(int mtype) {
		this.mtype = mtype;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getMchannel() {
		return mchannel;
	}
	public void setMchannel(int mchannel) {
		this.mchannel = mchannel;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	
	public int getAuserId() {
		return auserId;
	}
	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThreeNo() {
		return threeNo;
	}
	public void setThreeNo(String threeNo) {
		this.threeNo = threeNo;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	@Override
	public String toString() {
		return "PayOrderEntity [id=" + id + ", mtype=" + mtype + ", mnumber=" + mnumber + ", mtime=" + mtime
				+ ", money=" + money + ", mchannel=" + mchannel + ", mstate=" + mstate + ", auserId=" + auserId
				+ ", title=" + title + ", threeNo=" + threeNo + ", payTime=" + payTime + ", carId=" + carId + "]";
	}
	
	
	
	
	
}
