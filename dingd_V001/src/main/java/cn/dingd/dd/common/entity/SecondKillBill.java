package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zoucong
 * 2018年1月16日下午2:15:30
 * 秒杀单
 */
public class SecondKillBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id
	private int id;
	//车辆id
	private int carId;
	//车价
	private Float carMoney;
	//服务费
	private Integer serverMoney;
	//秒杀开始时间
	private Date startTime;
	//创建时间
	private Date createTime;
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
	public Float getCarMoney() {
		return carMoney;
	}
	public void setCarMoney(Float carMoney) {
		this.carMoney = carMoney;
	}
	public Integer getServerMoney() {
		return serverMoney;
	}
	public void setServerMoney(Integer serverMoney) {
		this.serverMoney = serverMoney;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
