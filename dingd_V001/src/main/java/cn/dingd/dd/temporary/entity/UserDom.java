package cn.dingd.dd.temporary.entity;


import java.io.Serializable;

/**
 * userdom临时类
 * @author XCD
 *
 */
public class UserDom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1266672467339303439L;
	
	/**密码*/
	private String password;
	private String account;
	/**主键*/
	private int id;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserDom [password=" + password + ", account=" + account + ", id=" + id + "]";
	}
	
	
	

	
	
	
}
