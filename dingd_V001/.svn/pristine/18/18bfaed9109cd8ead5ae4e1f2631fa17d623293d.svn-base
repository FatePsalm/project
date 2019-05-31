package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/***
 * 收藏对象
 * @author XCD
 *
 */
public class CollectInfoEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4941144277043736160L;
	
	/**id*/
	private int id;
	/**用户id*/
	private int aUserId;
	/**收藏车辆*/
	private int carId;
	/**收藏时间*/
	private Date cTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getaUserId() {
		return aUserId;
	}
	public void setaUserId(int aUserId) {
		this.aUserId = aUserId;
	}
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	} 
	
	
	
}
