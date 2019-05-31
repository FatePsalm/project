package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.PaymentInfoEntity;
import cn.dingd.dd.common.entity.RechargeInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月8日 上午11:08:35
* 类说明
*/
public interface ManageMoneyDao {
	/** 管理端-资金管理-查询用户扣款记录条目数 */
	public int findDeductionsPageCount(@Param("id")Integer id,@Param("retrieval")String retrieval);
	/** 管理端-资金管理-查询用户扣款记录 */
	public List<Map<String, Object>> findDeductions(@Param("id")Integer id,@Param("retrieval")String retrieval,@Param("pageObject")PageObject pageObject);
	/** 管理端-资金管理-查询用户冻结/解冻记录条目数 */
	public int findFreezePageCount(@Param("id")Integer id,@Param("retrieval")String retrieval);
	/** 管理端-资金管理-查询用户冻结/解冻记录 */
	public List<Map<String, Object>> findFreeze(@Param("id")Integer id,@Param("retrieval")String retrieval,@Param("pageObject")PageObject pageObject);
	/** 管理端-资金管理-查询用户提现记录 */
	public int findWithdrawalPageCount(@Param("id")Integer id,@Param("retrieval")String retrieval);
	/** 管理端-资金管理-查询用户提现记录 */
	public List<Map<String, Object>> findWithdrawal(@Param("id")Integer id,@Param("retrieval")String retrieval,@Param("pageObject")PageObject pageObject);
	/**管理端-资金管理-A端用户提现*/
	public Float FindBalance(Integer id);
	/**管理端-资金管理-更新当前余额提现*/
	public int UpdateWithdrawalCurrentBalance(Integer id) ;
	/**管理端-资金管理-A端用户提现*/
	public int AddWithdrawal(PaymentInfoEntity paymentInfoEntity);
	/**管理端-资金管理-更新当前余额*/
	public int UpdateCurrentBalance(Integer id) ;
	/**管理端-资金管理-查询用户充值记录条目数*/
	public int FindChargePageCount(@Param("id")Integer id,@Param("retrieval")String retrieval) ;
	/**管理端-资金管理-查询用户充值记录*/
	public List<Map<String, Object>> FindCharge(@Param("id")Integer id,@Param("retrieval")String retrieval,@Param("pageObject")PageObject pageObject) ;
	/**管理端-资金管理-支付订单*/
	public int AddPayOrder(PayOrderEntity order);
	/**管理端-资金管理-A端用户充值*/
	public int AddMoney(RechargeInfoEntity rechargeInfoEntity);
	/**管理端-资金管理-A端客服账户*/
	public List<Map<String, Object>> FindMoney(@Param("retrieval")String retrieval,@Param("pageObject")PageObject pageObject);
	/**管理端-资金管理-A端客服账户总条数*/
	public int FindMoneyPageCount(@Param("retrieval")String retrieval);
}
