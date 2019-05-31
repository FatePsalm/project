package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 拍卖场次
 * @author XCD
 *
 */
public class AuctionSessionEntity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5225596785045291399L;

	/**id*/
	private int id;
	/**场次号*/
	private String auctionNum;
	/**场次时间*/
	private Date auctionDate;
	/**开始时间*/
	private Date auctionStart;
	/**结束时间*/
	private Date auctionOver;
	/**负责人*/
	private String principal;
	/**场次状态*/
	private int auctionState;
	/** 车辆信息 */
	private List<TCarBasisInfoEntity> basisInfoEntities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuctionNum() {
		return auctionNum;
	}
	public void setAuctionNum(String auctionNum) {
		this.auctionNum = auctionNum;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getAuctionStart() {
		return auctionStart;
	}
	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getAuctionOver() {
		return auctionOver;
	}
	public void setAuctionOver(Date auctionOver) {
		this.auctionOver = auctionOver;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public int getAuctionState() {
		return auctionState;
	}
	public void setAuctionState(int auctionState) {
		this.auctionState = auctionState;
	}
	public List<TCarBasisInfoEntity> getBasisInfoEntities() {
		return basisInfoEntities;
	}
	public void setBasisInfoEntities(List<TCarBasisInfoEntity> basisInfoEntities) {
		this.basisInfoEntities = basisInfoEntities;
	}
	@Override
	public String toString() {
		return "AuctionSessionEntity [id=" + id + ", auctionNum=" + auctionNum + ", auctionDate=" + auctionDate
				+ ", auctionStart=" + auctionStart + ", auctionOver=" + auctionOver + ", principal=" + principal
				+ ", auctionState=" + auctionState + ", basisInfoEntities=" + basisInfoEntities + "]";
	}
	
}
