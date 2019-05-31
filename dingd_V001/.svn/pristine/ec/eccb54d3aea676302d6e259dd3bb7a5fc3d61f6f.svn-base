package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月28日 下午3:30:05 类说明 管理端-检测订单-模糊查询
 * 
 */
public class CheckQueryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5962985582340078599L;
	// ===============================/以下内容为管理端-检测单-检测单查询条件
	// '检查状态1.我的订单(待检测)2.待上传(检测中)3.完成检测4.取消',
	private int checkStatus;
	// 模糊查询对话框
	private String retrieval;
	// 门店
	private int stores;
	// 新建订单时间排序
	private String createTime;
	// 预约时间排序
	private String appointmentTime;
	// 订单取消时间排序
	private String cancelTime;
	// 结束时间排序
	private Date overTime;
	// ================================/以下内容为管理端-车辆管理-库存车辆查询条件
	// 车辆状态1-车库2-拍卖中3-成交4-冻结5-下架,6-待拍卖
	private int carState;
	// 上传时间-开始条件
	private Date createTimeStart;
	// 结束时间-结束条件
	private Date createTimeOver;
	// 上传时间排序
	private String createTimeSort;
	// 下架时间排序
	private String removeTimeSort;
	// 冻结时间排序
	private String freezingTimeSort;
	// =================================/以下内容为管理端-拍卖订单-拍卖订单查询条件
	// 订单状态
	private int orderState;
	// 筛选开始时间
	private Date startTime;
	// 筛选结束时间
	// *overTime
	// 建单时间排序
	private String orderTimeSort;
	// 完成时间排序
	private String overTimeSort;
	// 下架时间排序
	// *removeTimeSort
	// 扣款时间排序
	private String abortTimeSort;
	// 排序
	private String sort;

	// =================================/以下内容为管理端-人员管理-A端用户管理
	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getRetrieval() {
		return retrieval;
	}

	public void setRetrieval(String retrieval) {
		this.retrieval = retrieval;
	}

	public int getStores() {
		return stores;
	}

	public void setStores(int stores) {
		this.stores = stores;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public int getCarState() {
		return carState;
	}

	public void setCarState(int carState) {
		this.carState = carState;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTimeOver() {
		return createTimeOver;
	}

	public void setCreateTimeOver(Date createTimeOver) {
		this.createTimeOver = createTimeOver;
	}

	public String getCreateTimeSort() {
		return createTimeSort;
	}

	public void setCreateTimeSort(String createTimeSort) {
		this.createTimeSort = createTimeSort;
	}

	public String getRemoveTimeSort() {
		return removeTimeSort;
	}

	public void setRemoveTimeSort(String removeTimeSort) {
		this.removeTimeSort = removeTimeSort;
	}

	public String getFreezingTimeSort() {
		return freezingTimeSort;
	}

	public void setFreezingTimeSort(String freezingTimeSort) {
		this.freezingTimeSort = freezingTimeSort;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getOrderTimeSort() {
		return orderTimeSort;
	}

	public void setOrderTimeSort(String orderTimeSort) {
		this.orderTimeSort = orderTimeSort;
	}

	public String getOverTimeSort() {
		return overTimeSort;
	}

	public void setOverTimeSort(String overTimeSort) {
		this.overTimeSort = overTimeSort;
	}

	public String getAbortTimeSort() {
		return abortTimeSort;
	}

	public void setAbortTimeSort(String abortTimeSort) {
		this.abortTimeSort = abortTimeSort;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "CheckQueryEntity [checkStatus=" + checkStatus + ", retrieval=" + retrieval + ", stores=" + stores
				+ ", createTime=" + createTime + ", appointmentTime=" + appointmentTime + ", cancelTime=" + cancelTime
				+ ", overTime=" + overTime + ", carState=" + carState + ", createTimeStart=" + createTimeStart
				+ ", createTimeOver=" + createTimeOver + ", createTimeSort=" + createTimeSort + ", removeTimeSort="
				+ removeTimeSort + ", freezingTimeSort=" + freezingTimeSort + ", orderState=" + orderState
				+ ", startTime=" + startTime + ", orderTimeSort=" + orderTimeSort + ", overTimeSort=" + overTimeSort
				+ ", abortTimeSort=" + abortTimeSort + "]";
	}

}
