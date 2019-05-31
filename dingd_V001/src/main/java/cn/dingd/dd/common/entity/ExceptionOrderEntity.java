package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 异常订单
 * @author XCD
 *
 */
@SuppressWarnings("serial")
public class ExceptionOrderEntity implements Serializable {

	/**id	 */
	private int id;
	/**订单号*/
	private String orderNo;
	/**第三方单号*/
	private String threeNo;
	/**创建时间*/
	private Date createTime;
	/**状态*/
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getThreeNo() {
		return threeNo;
	}
	public void setThreeNo(String threeNo) {
		this.threeNo = threeNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
