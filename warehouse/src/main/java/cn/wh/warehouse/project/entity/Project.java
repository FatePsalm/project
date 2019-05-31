package cn.wh.warehouse.project.entity;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.wh.warehouse.common.web.DateJsonTypeConvert;

public class Project implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6408453846524955602L;
	/**开始时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start_time;
	/**结束时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_time;
	/**表示维修件ID*/
	private Integer id;
	/**送修时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maintain_time;
	/**品牌型号*/
	private String type;
	/**数量*/
	private Integer number;
	/**单位*/
	private String unit;
	/**故障情况*/
	private String malfunction;
	/**序列号*/
	private String keyId;
	/**费用*/
	private double cost;
	/**送修人员*/
	private String send_people;
	/**维修情况*/
	private Integer result;
	/**维修时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date result_time;
	/**领取人*/
	private String name;
	/**项目/学校*/
	private String school;
	/**学校保修取件时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date school_time;
	/**学校联系人*/
	private String school_teachr;
	/**添加人*/
	private String user;
	/**学校/项目取件人*/
	private String school_name;
	/**修改人*/
	private String updateUser;
	/**修改时间*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateUser_time;
	/**联系电话*/
	private String school_phone;
	/**备注*/
	private String remark;
	
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getMaintain_time() {
		return maintain_time;
	}
	public void setMaintain_time(Date maintain_time) {
		this.maintain_time = maintain_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMalfunction() {
		return malfunction;
	}
	public void setMalfunction(String malfunction) {
		this.malfunction = malfunction;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getSend_people() {
		return send_people;
	}
	public void setSend_people(String send_people) {
		this.send_people = send_people;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getResult_time() {
		return result_time;
	}
	public void setResult_time(Date result_time) {
		this.result_time = result_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getSchool_time() {
		return school_time;
	}
	public void setSchool_time(Date school_time) {
		this.school_time = school_time;
	}
	public String getSchool_teachr() {
		return school_teachr;
	}
	public void setSchool_teachr(String school_teachr) {
		this.school_teachr = school_teachr;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getUpdateUser_time() {
		return updateUser_time;
	}
	public void setUpdateUser_time(Date updateUser_time) {
		this.updateUser_time = updateUser_time;
	}
	public String getSchool_phone() {
		return school_phone;
	}
	public void setSchool_phone(String school_phone) {
		this.school_phone = school_phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Project [start_time=" + start_time + ", end_time=" + end_time + ", id=" + id + ", maintain_time="
				+ maintain_time + ", type=" + type + ", number=" + number + ", unit=" + unit + ", malfunction="
				+ malfunction + ", keyId=" + keyId + ", cost=" + cost + ", send_people=" + send_people + ", result="
				+ result + ", result_time=" + result_time + ", name=" + name + ", school=" + school + ", school_time="
				+ school_time + ", school_teachr=" + school_teachr + ", user=" + user + ", school_name=" + school_name
				+ ", updateUser=" + updateUser + ", updateUser_time=" + updateUser_time + ", school_phone="
				+ school_phone + ", remark=" + remark + "]";
	}
	
}
