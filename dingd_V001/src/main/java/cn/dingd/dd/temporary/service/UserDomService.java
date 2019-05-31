package cn.dingd.dd.temporary.service;


import cn.dingd.dd.temporary.entity.UserDom;

/**
 * 临时userDom
 * @author XCD
 *
 */
public interface UserDomService {

	
	/**
	 * 登录用户名和密码
	 * @param password
	 * @param account
	 * @return
	 */
	public UserDom loginUser(String password,String account);
}
