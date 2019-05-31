package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月17日 下午12:22:42 类说明 检测订单
 */
public class CheckBillEntity implements Serializable {

	/**
	 * 车辆检测订单
	 */
	private static final long serialVersionUID = 8359223501902338916L;
	// 主键id
	private int id;
	// 检查单号（唯一）格式JC-时间戳
	private String checkAccount;
	// 检查状态1.我的订单(待检测)2.待上传(检测中)3.完成检测4.取消
	private int checkStatus;
	// 联系人
	private String person;
	// 联系人性别
	private int gender;
	// 联系人电话
	private String telephone;
	// /**创建人*/
	private int createPerson;
	// 门店',
	private String stores;
	// /**地址*/
	private String address;
	// /**省*/
	private int province;
	// /**市*/
	private int city;
	// /**区县*/
	private int area;
	// /**品系*/
	private String cars;
	// /**品牌*/
	private String carName;
	// /**款式*/
	private String carModel;
	// /**车辆类型*/
	private String carType;
	// 车牌号码
	private String carNumber;
	// /**车辆出厂日期*/
	private Date carCreateTime;
	// 心理期望价格
	private float retentionMoney;
	// 创建时间
	private Date createTime;
	// 预约检测时间
	private Date appointmentTime;
	// 订单取消时间
	private Date cancelTime;
	// 分配时间
	private Date allotusTime;
	// 应答时间
	private Date responseTime;
	// 检查时间
	private Date uploadTime;
	// 结束时间
	private Date overTime;
	// 备注',
	private String remark;
	// 检测师
	private int staffId;
	//车辆ID
	private int carId;
	//创建订单类型 1-PC 2-检测端 3-商家
	private int checkType;
	//模糊查询
	private String find;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCheckAccount() {
		return checkAccount;
	}

	public void setCheckAccount(String checkAccount) {
		this.checkAccount = checkAccount;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(int createPerson) {
		this.createPerson = createPerson;
	}

	public String getStores() {
		return stores;
	}

	public void setStores(String stores) {
		this.stores = stores;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCarCreateTime() {
		return carCreateTime;
	}

	public void setCarCreateTime(Date carCreateTime) {
		this.carCreateTime = carCreateTime;
	}

	public float getRetentionMoney() {
		return retentionMoney;
	}

	public void setRetentionMoney(float retentionMoney) {
		this.retentionMoney = retentionMoney;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getAllotusTime() {
		return allotusTime;
	}

	public void setAllotusTime(Date allotusTime) {
		this.allotusTime = allotusTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getCheckType() {
		return checkType;
	}

	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}

	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	@Override
	public String toString() {
		return "CheckBillEntity [id=" + id + ", checkAccount=" + checkAccount + ", checkStatus=" + checkStatus
				+ ", person=" + person + ", gender=" + gender + ", telephone=" + telephone + ", createPerson="
				+ createPerson + ", stores=" + stores + ", address=" + address + ", province=" + province + ", city="
				+ city + ", area=" + area + ", cars=" + cars + ", carName=" + carName + ", carModel=" + carModel
				+ ", carType=" + carType + ", carNumber=" + carNumber + ", carCreateTime=" + carCreateTime
				+ ", retentionMoney=" + retentionMoney + ", createTime=" + createTime + ", appointmentTime="
				+ appointmentTime + ", cancelTime=" + cancelTime + ", allotusTime=" + allotusTime + ", responseTime="
				+ responseTime + ", uploadTime=" + uploadTime + ", overTime=" + overTime + ", remark=" + remark
				+ ", staffId=" + staffId + ", carId=" + carId + ", checkType=" + checkType + ", find=" + find + "]";
	}

	

	

	

}
