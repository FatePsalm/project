package cn.dingd.dd.auction.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.entity.EnchashmentEntity;
import cn.dingd.dd.common.entity.ExceptionOrderEntity;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.PaymentInfoEntity;
import cn.dingd.dd.common.entity.RechargeInfoEntity;

/**
 * 支付订单dao
 * @author XCD
 *
 */
public interface PayOrderDao {

	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	public int addPayOrder(PayOrderEntity order);
	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	public int updPayOrder(@Param("id")int id,@Param("mstate")int mstate,@Param("payTime")String payTime,@Param("threeNo")String  threeNo);
	/**
	 * 添加充值记录
	 * @param info
	 * @return
	 */
	public int addRechargeInfo(RechargeInfoEntity  info);

	
	/**
	 * 添加付款记录
	 * @param info
	 * @return
	 */
	public int addPaymentInfo(PaymentInfoEntity info);

	
	/**
	 * 添加提现信息
	 * @param enchashmentInfo
	 * @return
	 */
	public int addEnchashment(EnchashmentEntity enchashmentInfo);
	

	/**
	 * 获取支付订单
	 * @param orderNo
	 * @param three_no
	 * @param userId
	 * @param type
	 * @return
	 */
	public PayOrderEntity queryPayOrder(@Param("orderNo")String orderNo,@Param("threeNo")String threeNo,@Param("userId")int userId,@Param("type")int type);
	
	/**
	 * 获取支付订单
	 * @param orderNo
	 * @param three_no
	 * @param userId
	 * @param type
	 * @return
	 */
	public PayOrderEntity getPayOrderWithhold(@Param("orderNo")String orderNo,@Param("threeNo")String threeNo,@Param("userId")int userId,@Param("type")int type,@Param("auStatus")int  auStatus,@Param("newDate")Date newDate);
	
	/**
	 * 获取异常订单
	 * @param threeNo
	 * @return
	 */
	public ExceptionOrderEntity getExceptionOrder(String orderNo);
	
	/**
	 * 修改异常订单
	 * @param entity
	 * @return
	 */
	public int updateExceptionOrder(ExceptionOrderEntity entity);
	
	/**
	 * 添加异常订单
	 * @param entity
	 * @return
	 */
	public int addExceptionOrder(ExceptionOrderEntity entity);

    /**
     * 添加资金账户信息
     * @return
     */
    public int addCapitalAccountEntity(CapitalAccountEntity capitalAccountEntity);
    /**
     * 添加资金账户信息
     * @return
     */
    public int updCapitalAccountEntity(CapitalAccountEntity capitalAccountEntity);
    /**
     * 获取资金账户
     * @param userId
     * @return
     */
    public CapitalAccountEntity getUserCapitalAccount(int userId);
    
    
    
}
