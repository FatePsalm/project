package cn.wh.warehouse.department.entity;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8305551083656180048L;
	
	/**ID*/
	private Integer department_Id;
	/**部门*/
	private String department;
	/**职位*/
	private String department_position;
	/**姓名*/
	private String department_name;
	/**手机*/
	private String department_phone;
	/**座机*/
	private String department_phoneExtension;
	/**短号*/
	private String department_phoneCornet;
	/**备注*/
	private String remark;
	public Integer getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(Integer department_Id) {
		this.department_Id = department_Id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment_position() {
		return department_position;
	}
	public void setDepartment_position(String department_position) {
		this.department_position = department_position;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_phone() {
		return department_phone;
	}
	public void setDepartment_phone(String department_phone) {
		this.department_phone = department_phone;
	}
	public String getDepartment_phoneExtension() {
		return department_phoneExtension;
	}
	public void setDepartment_phoneExtension(String department_phoneExtension) {
		this.department_phoneExtension = department_phoneExtension;
	}
	public String getDepartment_phoneCornet() {
		return department_phoneCornet;
	}
	public void setDepartment_phoneCornet(String department_phoneCornet) {
		this.department_phoneCornet = department_phoneCornet;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "department [department_Id=" + department_Id + ", department=" + department + ", department_position="
				+ department_position + ", department_name=" + department_name + ", department_phone="
				+ department_phone + ", department_phoneExtension=" + department_phoneExtension
				+ ", department_phoneCornet=" + department_phoneCornet + ", remark=" + remark + "]";
	}
	
}
