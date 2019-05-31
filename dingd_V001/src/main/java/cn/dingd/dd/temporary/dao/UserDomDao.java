package cn.dingd.dd.temporary.dao;


import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.temporary.entity.UserDom;

/**
 * domUser类
 * @author XCD
 *
 */
public interface UserDomDao {

	
	/***
	 * 登录用户名和密码
	 * @param password
	 * @param account
	 * @return
	 */
	public UserDom loginUser(@Param("password") String password,@Param("account") String account);
}
