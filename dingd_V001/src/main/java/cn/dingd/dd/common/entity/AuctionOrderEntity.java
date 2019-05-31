package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 拍卖订单对象
 * @author XCD
 *
 */
public class AuctionOrderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7395805675151908884L;
	/**id*/
	private int id;
	/**车辆ID*/
    private int carId;
    /**订单状态  1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁*/
    private int orderState;
    /**成交价格*/
    private float achieveMoney;
    /**是否有发票*/
    private int invoice;
    /**发票金额*/
    private float invoiceMoney;
    /**A端用户*/
    private int auserId;
    private AUserEntity aUser;
    /**订单生成时间*/
    private Date orderTime;
    /**订单支付时间*/
    private Date payTime;
    /**订单号*/
    private String orderNum;
    /**订单交易截止时间*/
    private Date abortTime;
    /**备注*/
    private String remarks;
    /**场次号*/
 	private int auctionId;
 	/**合手价*/
 	private float totalMoney;
 	 /**撤销时间*/
    private Date cancelTime;
    /**服务费*/
    private int serverMoney;
    /**过户费*/
    private int registFee;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public float getAchieveMoney() {
		return achieveMoney;
	}
	public void setAchieveMoney(float achieveMoney) {
		this.achieveMoney = achieveMoney;
	}
	public int getInvoice() {
		return invoice;
	}
	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}
	public float getInvoiceMoney() {
		return invoiceMoney;
	}
	public void setInvoiceMoney(float invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}
	public int getAuserId() {
		return auserId;
	}
	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}
	public AUserEntity getaUser() {
		return aUser;
	}
	public void setaUser(AUserEntity aUser) {
		this.aUser = aUser;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getAbortTime() {
		return abortTime;
	}
	public void setAbortTime(Date abortTime) {
		this.abortTime = abortTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public int getServerMoney() {
		return serverMoney;
	}
	public void setServerMoney(int serverMoney) {
		this.serverMoney = serverMoney;
	}
	public int getRegistFee() {
		return registFee;
	}
	public void setRegistFee(int registFee) {
		this.registFee = registFee;
	}
	@Override
	public String toString() {
		return "AuctionOrderEntity [id=" + id + ", carId=" + carId + ", orderState=" + orderState + ", achieveMoney="
				+ achieveMoney + ", invoice=" + invoice + ", invoiceMoney=" + invoiceMoney + ", auserId=" + auserId
				+ ", aUser=" + aUser + ", orderTime=" + orderTime + ", payTime=" + payTime + ", orderNum=" + orderNum
				+ ", abortTime=" + abortTime + ", remarks=" + remarks + ", auctionId=" + auctionId + ", totalMoney="
				+ totalMoney + ", cancelTime=" + cancelTime + ", serverMoney=" + serverMoney + ", registFee="
				+ registFee + "]";
	}
	
	
    
}
