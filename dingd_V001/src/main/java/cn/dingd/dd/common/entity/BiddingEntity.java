package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 竞价类
 * @author XCD
 *
 */
public class BiddingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8072892051362658553L;
	/**id*/
	private int id;
	/**用户*/
	private int auserId;
	private AUserEntity aUserEntity;
	/**竞价时间*/
	private Date bidingTime;
	/**竞价车价*/
	private float money;
	/**车辆ID*/
	private int carId;
   /**场次号*/
	private int auctionId;
	/**合手价*/
	private int totalPrire;
	
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
	public AUserEntity getaUserEntity() {
		return aUserEntity;
	}
	public void setaUserEntity(AUserEntity aUserEntity) {
		this.aUserEntity = aUserEntity;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getBidingTime() {
		return bidingTime;
	}
	public void setBidingTime(Date bidingTime) {
		this.bidingTime = bidingTime;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
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
	public int getTotalPrire() {
		return totalPrire;
	}
	public void setTotalPrire(int totalPrire) {
		this.totalPrire = totalPrire;
	}
   
    
}
