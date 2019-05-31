package cn.dingd.dd.auction.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.entity.EnchashmentEntity;
import cn.dingd.dd.common.entity.ExceptionOrderEntity;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.RechargeInfoEntity;
import net.sf.json.JSONObject;
/**
 * 支付订单service
 * @author XCD
 *
 */
public interface PayOrderService {

	/**
	 * 生成订单
	 * @param order
	 * @return
	 */
	public Map<Object,Object> addPayOrder(JSONObject jsonObject,HttpServletRequest request,HttpServletResponse response)throws Exception ;
	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	public boolean updPayOrder(PayOrderEntity order)throws Exception ;
	/**
	 * 添加充值记录
	 * @param info
	 * @return
	 */
	public boolean addRechargeInfo(RechargeInfoEntity info)throws Exception ;

	/**
	 * 添加提现记录
	 * @param enchashmentInfo
	 * @return
	 */
	public boolean addEnchashmentInfo(EnchashmentEntity enchashmentInfo)throws Exception ;

	/**
	 * 订单号
	 * @param orderNo
	 * @return
	 */
	public PayOrderEntity queryPayOrder(String orderNo)throws Exception ;
	
	/**
	 * 添加异常订单
	 * @param entity
	 * @return
	 */
	public int addExceptionOrder(ExceptionOrderEntity entity)throws Exception ;
	/**
	 * 获取账号信息
	 * @param userId
	 * @return
	 */
	public CapitalAccountEntity getUserCapitalAccount(int userId)throws Exception ;
}
