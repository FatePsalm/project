package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年9月19日 上午11:33:35
* 类说明 登录日志文件
*/
public class LoginCodeLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1423910801386614195L;
	/**日志文件ID*/
	private Integer LoginCodeLogID;
	/**登录用户民*/
	private String LoginCodeLogStaffAccounts;
	/**登录验证码*/
	private String LoginCodeLogCode;
	/**验证码内容*/
	private String LoginCodeLogContent;
	/**时间*/
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date LoginCodeLogTime;
	
	
	public Integer getLoginCodeLogID() {
		return LoginCodeLogID;
	}
	public void setLoginCodeLogID(Integer loginCodeLogID) {
		LoginCodeLogID = loginCodeLogID;
	}
	public String getLoginCodeLogStaffAccounts() {
		return LoginCodeLogStaffAccounts;
	}
	public void setLoginCodeLogStaffAccounts(String loginCodeLogStaffAccounts) {
		LoginCodeLogStaffAccounts = loginCodeLogStaffAccounts;
	}
	public String getLoginCodeLogCode() {
		return LoginCodeLogCode;
	}
	public void setLoginCodeLogCode(String loginCodeLogCode) {
		LoginCodeLogCode = loginCodeLogCode;
	}
	public String getLoginCodeLogContent() {
		return LoginCodeLogContent;
	}
	public void setLoginCodeLogContent(String loginCodeLogContent) {
		LoginCodeLogContent = loginCodeLogContent;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getLoginCodeLogTime() {
		return LoginCodeLogTime;
	}
	public void setLoginCodeLogTime(Date loginCodeLogTime) {
		LoginCodeLogTime = loginCodeLogTime;
	}
	@Override
	public String toString() {
		return "LoginCodeLog [LoginCodeLogID=" + LoginCodeLogID + ", LoginCodeLogStaffAccounts="
				+ LoginCodeLogStaffAccounts + ", LoginCodeLogCode=" + LoginCodeLogCode + ", LoginCodeLogContent="
				+ LoginCodeLogContent + ", LoginCodeLogTime=" + LoginCodeLogTime + "]";
	}
	
	
	
	
	
}