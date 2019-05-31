package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 出价记录对象
 * @author XCD
 *
 */
public class AuctionRecordEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3336585834906136226L;

	/**id*/
	private int id;

	/**用户*/
	private int auserId;
	private AUserEntity aUserEntity;
	/**竞价时间*/
	private Date auctionTime;
	/**竞价幅度*/
	private int auctionRange;
	/**竞价后车价*/
	private float auctionMoney;
	/**委托ID*/
	private int carId;
	
	 /**场次号*/
	private int auctionId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public AUserEntity getaUserEntity() {
		return aUserEntity;
	}
	public void setaUserEntity(AUserEntity aUserEntity) {
		this.aUserEntity = aUserEntity;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getAuctionTime() {
		return auctionTime;
	}
	public void setAuctionTime(Date auctionTime) {
		this.auctionTime = auctionTime;
	}
	public int getAuctionRange() {
		return auctionRange;
	}
	public void setAuctionRange(int auctionRange) {
		this.auctionRange = auctionRange;
	}
	public float getAuctionMoney() {
		return auctionMoney;
	}
	public void setAuctionMoney(float auctionMoney) {
		this.auctionMoney = auctionMoney;
	}
	public int getAuserId() {
		return auserId;
	}
	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	
}
