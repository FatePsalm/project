package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年2月5日 上午11:32:33 类说明 拍卖订单变更记录
 */
public class AuctionOrderTimeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2713408658950129122L;
	// id
	private Integer id;
	// 拍卖订单ID
	private Integer auctionOrderId;
	// 发起人id
	private Integer person;
	// 更新时间
	private Date updTime;
	// 创建时间
	private Date createTime;
	// 发起人类型
	private Integer personType;
	// 备注
	private String remark;
	// 操作类型 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中
	private Integer type;
	// 仲裁前状态记录类型 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中
	private Integer typeOld;
	// 责任方
	private String responsibility;
	// 操作状态 0-仲裁关闭 1-有效仲裁 2-继续交易
	private Integer operatingState;
	// 是否冻结车辆
	private Integer freeze;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAuctionOrderId() {
		return auctionOrderId;
	}
	public void setAuctionOrderId(Integer auctionOrderId) {
		this.auctionOrderId = auctionOrderId;
	}
	public Integer getPerson() {
		return person;
	}
	public void setPerson(Integer person) {
		this.person = person;
	}
	public Date getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getPersonType() {
		return personType;
	}
	public void setPersonType(Integer personType) {
		this.personType = personType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Integer getOperatingState() {
		return operatingState;
	}
	public void setOperatingState(Integer operatingState) {
		this.operatingState = operatingState;
	}
	
	public Integer getFreeze() {
		return freeze;
	}
	public void setFreeze(Integer freeze) {
		this.freeze = freeze;
	}
	public Integer getTypeOld() {
		return typeOld;
	}
	public void setTypeOld(Integer typeOld) {
		this.typeOld = typeOld;
	}
	@Override
	public String toString() {
		return "AuctionOrderTimeEntity [id=" + id + ", auctionOrderId=" + auctionOrderId + ", person=" + person
				+ ", updTime=" + updTime + ", createTime=" + createTime + ", personType=" + personType + ", remark="
				+ remark + ", type=" + type + ", typeOld=" + typeOld + ", responsibility=" + responsibility
				+ ", operatingState=" + operatingState + ", freeze=" + freeze + "]";
	}
}
