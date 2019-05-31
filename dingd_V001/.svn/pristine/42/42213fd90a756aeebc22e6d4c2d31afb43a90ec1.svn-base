package cn.dingd.dd.temporary.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dingd.dd.temporary.dao.UserDomDao;
import cn.dingd.dd.temporary.entity.UserDom;
import cn.dingd.dd.temporary.service.UserDomService;

/**
 * 临时userDom的service
 * @author XCD
 *
 */
@Service
public class UserDomServiceImpl implements UserDomService{

	@Resource
	private UserDomDao domDao;

	/**
	 * 用户登录
	 */
	@Override
	public UserDom loginUser(String password, String account) {
		
		return domDao.loginUser(password, account);
	}
	
	
}
