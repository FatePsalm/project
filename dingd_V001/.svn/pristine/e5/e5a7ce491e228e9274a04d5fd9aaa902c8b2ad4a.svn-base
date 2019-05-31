package cn.dingd.dd.management.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.auction.dao.PayOrderDao;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.PaymentInfoEntity;
import cn.dingd.dd.common.entity.RechargeInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManageMoneyDao;
import cn.dingd.dd.management.service.ManageMoneyService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月8日 上午11:07:53 类说明
 */
@Service
public class ManageMoneyServiceImpl implements ManageMoneyService {
	@Resource
	private ManageMoneyDao manageMoneyDao;
	@Resource
	private CommonService commonService;
	@Resource
	private PayOrderDao payOrderDao;
	
	/** 管理端-资金管理-查询用户扣款记录 */
	public Map<String, Object> findDeductions(Integer id, String retrieval, PageObject pageObject){
		List<Map<String, Object>> list=manageMoneyDao.findDeductions(id, retrieval, pageObject);
		pageObject.setRowCount(manageMoneyDao.findDeductionsPageCount(id, retrieval));
		Map<String, Object> map=new HashMap<>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/** 管理端-资金管理-查询用户冻结/解冻记录 */
	public Map<String, Object> findFreeze(Integer id, String retrieval, PageObject pageObject){
		List<Map<String, Object>> list=manageMoneyDao.findFreeze(id, retrieval, pageObject);
		pageObject.setRowCount(manageMoneyDao.findFreezePageCount(id, retrieval));
		Map<String, Object> map=new HashMap<>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/** 管理端-资金管理-查询用户提现记录 */
	public Map<String, Object> findWithdrawal(Integer id, String retrieval, PageObject pageObject) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = manageMoneyDao.findWithdrawal(id, retrieval, pageObject);
		pageObject.setRowCount(manageMoneyDao.findWithdrawalPageCount(id, retrieval));
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}

	/** 管理端-资金管理-A端用户提现 */
	public float FindBalance(Integer id) {
		Float balance = manageMoneyDao.FindBalance(id);
		if (balance == null) {
			balance = 0f;
		}
		return balance;
	}

	/** 管理端-资金管理-A端用户提现 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public int AddWithdrawal(Integer id, Integer money) {
		Date date = new Date();
		// 生成支付订单
		PayOrderEntity order = new PayOrderEntity();
		String order_no = null;
		try {
			order_no = DateUtils.getShortYMD() + StringUtils.autoGenericCode(RedisClient.getSequence("orderno"), 4);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		order.setMtype(2);
		order.setMnumber(order_no);
		order.setMtime(date);
		order.setMoney(money);
		order.setMchannel(4);
		order.setMstate(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setPayTime(sdf.format(date));
		order.setThreeNo("0");
		order.setAuserId(id);
		order.setTitle("线下提现.");
		if (manageMoneyDao.AddPayOrder(order) != 1) {
			throw new NullPointerException("提现支付订单失败!");
		}
		// 写入用户支付信息表
		PaymentInfoEntity paymentInfoEntity = new PaymentInfoEntity();
		paymentInfoEntity.setAuserId(id);
		paymentInfoEntity.setMoney(money);
		paymentInfoEntity.setCreateTime(date);
		paymentInfoEntity.setPayOrderId(order.getId());
		paymentInfoEntity.setComments("线下提现金额");
		if (manageMoneyDao.AddWithdrawal(paymentInfoEntity) != 1) {
			throw new NullPointerException("提现失败!");
		}
		// 更新资金账户
		if (commonService.subtractionBalance(id, money) != 1) {
			throw new NullPointerException("资金表更新失败!");
		}
		// 更新当前余额
		int UpdateWithdrawalCurrentBalance = manageMoneyDao.UpdateWithdrawalCurrentBalance(paymentInfoEntity.getId());
		if (UpdateWithdrawalCurrentBalance != 1) {
			throw new NullPointerException("当前余额更新失败!");
		}
		return UpdateWithdrawalCurrentBalance;
	}

	/** 管理端-资金管理-查询用户充值记录 */
	public Map<String, Object> FindCharge(Integer id, String retrieval, PageObject pageObject) {
		Map<String, Object> map = new HashMap<>();
		pageObject.setRowCount(manageMoneyDao.FindChargePageCount(id, retrieval));
		map.put("list", manageMoneyDao.FindCharge(id, retrieval, pageObject));
		map.put("pageObject", pageObject);
		return map;
	}

	/** 管理端-资金管理-A端用户充值 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public int AddMoney(Integer id, Integer money,String note,Integer mtype,String orderId,Integer carId) {
		Date date = new Date();
		// 更新支付订单
		PayOrderEntity order = new PayOrderEntity();
		String order_no = null;
		try {
			order_no = DateUtils.getShortYMD() + StringUtils.autoGenericCode(RedisClient.getSequence("orderno"), 4);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		order.setMtype(mtype);
		order.setMnumber(order_no);
		order.setMtime(date);
		order.setMoney(money);
		order.setMchannel(3);
		order.setMstate(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setPayTime(sdf.format(date));
		order.setThreeNo(orderId);
		order.setAuserId(id);
		order.setTitle(note);
		order.setCarId(carId);
		if (manageMoneyDao.AddPayOrder(order) != 1) {
			throw new NullPointerException("充值支付订单失败!");
		}
		RechargeInfoEntity rechargeInfoEntity = new RechargeInfoEntity();
		// 插入资金账户
		rechargeInfoEntity.setAuserId(id);
		rechargeInfoEntity.setMoney(money);
		rechargeInfoEntity.setCreateTime(date);
		rechargeInfoEntity.setPayOrderId(order.getId());
		if (manageMoneyDao.AddMoney(rechargeInfoEntity) != 1) {
			throw new NullPointerException("充值失败!");
		}
		// 修改资金账户余额
		if (commonService.UpdateBalance(id, money) != 1) {
			throw new NullPointerException("资金表更新失败!");
		}
		// 更新当前余额
		int UpdateCurrentBalance = manageMoneyDao.UpdateCurrentBalance(rechargeInfoEntity.getId());
		if (UpdateCurrentBalance != 1) {
			throw new NullPointerException("更新当前余额失败!");
		}
		return UpdateCurrentBalance;
	}

	/** 管理端-资金管理-A端客服账户 */
	public Map<String, Object> FindMoney(String retrieval, PageObject pageObject) {
		List<Map<String, Object>> list = manageMoneyDao.FindMoney(retrieval, pageObject);
		Map<String, Object> map = new HashMap<>();
		pageObject.setRowCount(manageMoneyDao.FindMoneyPageCount(retrieval));
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
}
