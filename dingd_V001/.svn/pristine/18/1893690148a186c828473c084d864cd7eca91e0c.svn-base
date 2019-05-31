package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年12月20日 下午4:29:43
* 类说明
* 建档
*/
public class RecordEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private int id;
	/**地区*/
	private int region;
	/**建档时间*/
	private Date createTime;
	/**车辆id*/
	private int carId;
	/**建档人id*/
	private int staffId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	@Override
	public String toString() {
		return "RecordEntity [id=" + id + ", region=" + region + ", createTime=" + createTime + ", carId=" + carId
				+ ", staffId=" + staffId + "]";
	}
	
}
