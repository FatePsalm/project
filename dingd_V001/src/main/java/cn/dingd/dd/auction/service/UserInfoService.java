package cn.dingd.dd.auction.service;

import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.AUserEntity;
import cn.dingd.dd.common.web.PageObject;
/**
 * 获取用户信息
 * @author xcd
 *
 */
public interface UserInfoService {
	 /**
	  * 拍卖端获取用户
	  */
		@SuppressWarnings("rawtypes")
		public Map getAUserEntity(String account);
		/**
		 * 通过账号获取用户是否存在
		 * @param account
		 * @return
		 */
		public int getAUserEntityId(String  account)throws Exception ;
		/** 
		 * 注册账号
		 *  */
		public int aUserRegistration(AUserEntity aUserEntity)throws Exception ;
		/**
		 * 获取用户信息
		 * @param userId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public Map queryUserinfo(int userId)throws Exception ;
		
		/**
		 * 获取用户信息
		 */
		public AUserEntity getUserInfo(int userId)throws Exception ;
		/**
		 * 获取用户资金使用信息
		 * @param userId
		 * @return
		 * @throws Exception 
		 */
		@SuppressWarnings("rawtypes")
		public List<Map> getUserCapitlAccount(int userId,PageObject pageObject) throws Exception;
		/**
		 * 获取用户资金明细
		 * @param userId
		 * @return
		 */
		public Map getAUserInfo(int userId);
		/**
		 * 获取用户信息
		 * @param account
		 * @return
		 */
		public AUserEntity geAUserEntity(String account);
		
		/**
		 * 获取总条数
		 * @param userId
		 * @return
		 */
		public Integer getUserInfoPage(int userId);
}
