package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;
/***
 * 浏览车辆信息
 * @author XCD
 *
 */
public class CarBrowsingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3949084520952214837L;
	/**id*/
	private int id;
	/**车辆id*/
	private int carId;
	private TCarBasisInfoEntity basisInfoEntity;
	/**浏览用户*/
	private int auserId;
	/**浏览时间*/
	private Date cTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TCarBasisInfoEntity getBasisInfoEntity() {
		return basisInfoEntity;
	}
	public void setBasisInfoEntity(TCarBasisInfoEntity basisInfoEntity) {
		this.basisInfoEntity = basisInfoEntity;
	}
	
	public int getAuserId() {
		return auserId;
	}
	public void setAuserId(int auserId) {
		this.auserId = auserId;
	}
	public Date getcTime() {
		return cTime;
	}
	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	

	
	
}
