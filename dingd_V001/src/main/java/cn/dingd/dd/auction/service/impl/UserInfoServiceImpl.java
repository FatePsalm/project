package cn.dingd.dd.auction.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.auction.dao.UserInfoDao;
import cn.dingd.dd.auction.service.UserInfoService;
import cn.dingd.dd.common.entity.AUserEntity;
import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 获取用户
 * 
 * @author xcd
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;

	/**
	 * 获取拍卖端用户
	 */
	@SuppressWarnings("rawtypes")
	public Map  getAUserEntity(String account)  {
		return userInfoDao.getAUserEntity(account);
	}

	/**
	 * 获取用户是否存在
	 */
	@Override
	public int getAUserEntityId(String account)throws Exception {
		try {
			if (userInfoDao.getAUserEntityId(account) == null) {
				return 0;
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("注册失败！");
		}
	}
	
	

	/**
	 * 拍卖端注册用户
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int aUserRegistration(AUserEntity aUserEntity)throws Exception {
		try {
			int result = userInfoDao.aUserRegistration(aUserEntity);
			if (result < 0) {
				throw new RuntimeException("注册失败！");
			} 
			CapitalAccountEntity accountEntity=new CapitalAccountEntity();
			accountEntity.setAuserId(aUserEntity.getId());
			accountEntity.setBalance(0);
			accountEntity.setFreeze(0);
			accountEntity.setWithdraw(0);
		    if(userInfoDao.saveCapitalAccount(accountEntity)<0){
		    	throw new RuntimeException("注册失败！");
		    }
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("注册失败！");
		}
		return aUserEntity.getId();
	}
	/**
	 * 获取用户信息及资金信息
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map queryUserinfo(int userId)throws Exception {
	
		try {
			return userInfoDao.queryUserinfo(userId);
		} catch (Exception e) {
			throw new Exception("获取用户信息失败！");
		}
	}

	/**
	 * 获取用户信息
	 */
	@Override
	public AUserEntity getUserInfo(int userId) throws Exception{
	
		try {
			return userInfoDao.queryUserEntity(userId);
		} catch (Exception e) {
			throw new Exception("获取用户信息失败！");
		}
	}

	/**
	 * 获取用户资金使用信息
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getUserCapitlAccount(int userId,PageObject pageObject) throws Exception {
		try {
			List<Map> ls=userInfoDao.getUserCapitlAccount(userId,pageObject);
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取用户资金信息失败！");
		}
	}
  /**
   * 获取用户资金明细
   */
	@Override
	public Map getAUserInfo(int userId) {
		
		return userInfoDao.getAUserInfo(userId);
	}
	/**
	 * 根据账户获取用户信息
	 */
	@Override
	public AUserEntity geAUserEntity(String account) {
		 
		return userInfoDao.geAUserEntity(account);
	}
	/**
	 * 获取分页信息
	 * @param userId
	 * @return
	 */
	@Override
	public Integer getUserInfoPage(int userId) {
		return userInfoDao.getUserInfoPage(userId);
	}

	
	
}
