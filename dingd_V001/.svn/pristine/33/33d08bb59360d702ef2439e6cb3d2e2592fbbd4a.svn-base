package cn.dingd.dd.common.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author zoucong
 * 2018年1月31日下午2:55:03
 * 自定义token,加入用户登录类型判断
 */
public class UserLoginToken extends UsernamePasswordToken{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginType;
	public  UserLoginToken(String username,String password,String loginType) {
		super(username, password);
		this.loginType = loginType;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
