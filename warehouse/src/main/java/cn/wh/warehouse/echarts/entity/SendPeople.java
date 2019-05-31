package cn.wh.warehouse.echarts.entity;

import java.io.Serializable;

public class SendPeople implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6030181878491694482L;
	private String name;
	private Integer value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "SendPeople [name=" + name + ", value=" + value + "]";
	}
	
	
}
