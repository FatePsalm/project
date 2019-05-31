package cn.dingd.dd.management.service;

import java.util.Map;

import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月8日 上午11:07:31
* 类说明
*/
public interface ManageMoneyService {
	/** 管理端-资金管理-查询用户扣款记录 */
	public Map<String, Object> findDeductions(Integer id, String retrieval, PageObject pageObject);
	/** 管理端-资金管理-查询用户冻结/解冻记录 */
	public Map<String, Object> findFreeze(Integer id, String retrieval, PageObject pageObject) ;
	/** 管理端-资金管理-查询用户提现记录 */
	public Map<String, Object> findWithdrawal(Integer id, String retrieval, PageObject pageObject);
	/**管理端-资金管理-A端用户提现*/
	public float FindBalance(Integer id);
	/**管理端-资金管理-A端用户提现*/
	public int AddWithdrawal(Integer id,Integer money);
	/**管理端-资金管理-查询用户充值记录*/
	public Map<String, Object> FindCharge(Integer id,String retrieval,PageObject pageObject) ;
	/**管理端-资金管理-A端用户充值*/
	public int AddMoney(Integer id,Integer money,String note,Integer mtype,String orderId,Integer carId);
	/**管理端-资金管理-A端客服账户*/
	public Map<String, Object> FindMoney(String retrieval,PageObject pageObject) ;
}
