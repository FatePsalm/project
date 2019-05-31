package cn.dingd.dd.auction.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AUserEntity;
import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 用户信息接口
 * @author xcd
 *
 */
public interface UserInfoDao {

	/**
	 * 获取A端用户
	 * @param account
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getAUserEntity(String account) ;
	/**
	 * 获取用户id
	 * @param account
	 * @return
	 */
	public Integer getAUserEntityId(String  account);
	/**
	 * 注册用户
	 * @param aUserEntity
	 * @return
	 */
    public int aUserRegistration(AUserEntity aUserEntity);
    
    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    @SuppressWarnings("rawtypes")
	public Map   queryUserinfo(int userId);
    /**
     * 获取用户信息
     * @param id
     * @return
     */
    public AUserEntity queryUserEntity(int id);
    
    /**
     * 获取用户资金使用信息
     * @param userId
     * @return
     */
    @SuppressWarnings("rawtypes")
	public List<Map> getUserCapitlAccount(@Param("userId")int userId,@Param("pageObject")PageObject pageObject) throws Exception;
 /**
  * 获取用户资金明细
  * @param userId
  * @return
  */
    @SuppressWarnings("rawtypes")
	public Map getAUserInfo(int userId);
    
    
	/**
	 * 获取用户信息
	 * @param account
	 * @return
	 */
	public AUserEntity geAUserEntity(String account);
 /**
  * 添加资金账户
  * @param accountEntity
  * @return
  */
	public Integer saveCapitalAccount(CapitalAccountEntity accountEntity);
	
	/**
	 * 获取总条数
	 * @param userId
	 * @return
	 */
	public Integer getUserInfoPage(int userId);
}
