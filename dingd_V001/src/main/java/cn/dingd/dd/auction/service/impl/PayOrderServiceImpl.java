package cn.dingd.dd.auction.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.internal.util.AlipaySignature;

import cn.dingd.dd.auction.dao.PayOrderDao;
import cn.dingd.dd.auction.service.PayOrderService;
import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.entity.EnchashmentEntity;
import cn.dingd.dd.common.entity.ExceptionOrderEntity;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.RechargeInfoEntity;
import cn.dingd.dd.common.util.AlipayConfig;
import cn.dingd.dd.common.util.Commons;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.HttpGetOrPost;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.RequestHandler;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.util.XMLUtil;
import net.sf.json.JSONObject;

/**
 * 支付订单
 * @author XCD
 *
 */
@Service
public class PayOrderServiceImpl implements PayOrderService{
	
	@Resource
    private PayOrderDao dao;
	

	/**
	 * 生成订单
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Map<Object,Object> addPayOrder(JSONObject jsonObject ,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<Object,Object> map = new HashMap<Object,Object>();
		try {
				int userId = 0;
				float price;
				int type = 0;
				int payType = 0;
				String title = null;
				if(jsonObject.get("money")!=null && jsonObject.get("mtype")!=null && jsonObject.get("mchannel")!=null) {
					price = Float.parseFloat(jsonObject.get("money").toString());
					type = Integer.parseInt(jsonObject.get("mtype").toString());	//类型	0：充值余额
					payType = Integer.parseInt(jsonObject.get("mchannel").toString());	//支付方式 pay 1：微信2：支付宝
			        userId= Integer.parseInt(jsonObject.get("auserId").toString());
				} else {
					throw new Exception("获取第三方返回参数失败！");
				}

					title = "叮当--充值";
				//订单号规则  yyyyMMddHHmmss+6位随机数
					
				String order_no = null;
				try {
					order_no = DateUtils.getShortYMD() + StringUtils.autoGenericCode(RedisClient.getSequence("orderno"), 4);
				} catch (Exception e) {
					e.printStackTrace();
				}
				PayOrderEntity order = new PayOrderEntity();
				order.setAuserId(userId);
				order.setMtype(type);
				order.setTitle(title);
				order.setMnumber(order_no);
				order.setMoney(price);
				order.setMchannel(payType);
				order.setMstate(0);
				order.setMtime(new Date());
				order.setCarId(0);
				
				if(payType == 1) {	//微信
					String  out_trade_no = Commons.getRandomString(10);//商品订单号
					String prepayId = getPrepayId(request, response, Constant.APP_ID, Constant.MCH_ID, price,Constant.NOTIFY_URL, title, out_trade_no);
					//第二次签名：获取调用微信支付时需要的签名paySign  最后参与签名的参数有appId, timeStamp, nonceStr, package, prepayid, partnerid
					//PayOrderEntity worder = dao.queryPayOrder(order_no);
					//if(worder != null) {
						order.setThreeNo(out_trade_no);
						if(dao.addPayOrder(order)<=0) {
							throw new Exception("订单生成失败！");
						}	//微信支付存入第三方订单（也是自己这边订单号），回掉函数会返回，通过他查询order订单
					//}
					Map<String,String> params = new TreeMap<String,String>();
					
					params.put("appid", Constant.APP_ID);
					params.put("timestamp",Commons.create_timestamp());
					params.put("noncestr", Commons.getRandomString(32));
					params.put("package", "Sign=WXPay");
					params.put("prepayid",prepayId);
					params.put("partnerid", Constant.MCH_ID);
					
					RequestHandler reqHandler = new RequestHandler(request, response);
					String paySign =  reqHandler.createSign(params);
					params.put("sign", paySign);
				    //将数据组装返回给页面 调用微信支付*/	
					map.put("resultThree", params);
				} else if(payType == 2) {	//支付宝
					if(dao.addPayOrder(order)<=0) {
						throw new Exception("订单生成失败！");
					}
					Map<String,String> mapParams = new TreeMap<String,String>();
					Map<String,String> mapBiz = new TreeMap<String,String>();
					mapBiz.put("subject", title);
					mapBiz.put("out_trade_no", order_no);
					mapBiz.put("total_amount", String.valueOf(price));
					mapBiz.put("product_code", "QUICK_MSECURITY_PAY");
					
					mapParams.put("app_id", AlipayConfig.app_id);
					mapParams.put("method", AlipayConfig.method);
					mapParams.put("charset", AlipayConfig.input_charset);
					mapParams.put("sign_type", AlipayConfig.sign_type);
					mapParams.put("timestamp", DateUtils.getTodayString("yyyy-MM-dd HH:mm:ss"));
					mapParams.put("version", "1.0");
					mapParams.put("notify_url", AlipayConfig.notify_url);
					
					JSONObject paramList = JSONObject.fromObject(mapBiz);
					mapParams.put("biz_content", paramList.toString());
					
					String sign = AlipaySignature.rsaSign(mapParams, AlipayConfig.private_key, AlipayConfig.input_charset);
					mapParams.put("sign", sign);
					
					StringBuffer sb = new StringBuffer();
					Set es = mapParams.entrySet();
					Iterator  it = es.iterator();
					while (it.hasNext()) {
						Map.Entry entry = (Map.Entry) it.next();
						String k = (String) entry.getKey();
						String v = (String) entry.getValue();
						if (null != v && !"".equals(v)
						&& !"sign".equals(k) && !"key".equals(k)) {
							sb.append(k + "=" + URLEncoder.encode(v,AlipayConfig.input_charset) + "&");
						}
					}
					
					sb.append("sign=" + URLEncoder.encode(sign,AlipayConfig.input_charset));
					map.put("resultThree", sb.toString());
				}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
   /**
    * 修改订单信息
 * @throws Exception 
    */
	@SuppressWarnings("null")
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean updPayOrder(PayOrderEntity order) throws Exception {
         
		try {
		
				//添加资金账户
				CapitalAccountEntity accountEntity=dao.getUserCapitalAccount(order.getAuserId());
				if(accountEntity==null){
					accountEntity=new CapitalAccountEntity();
					accountEntity.setAuserId(order.getAuserId());
					accountEntity.setBalance(order.getMoney());
					dao.addCapitalAccountEntity(accountEntity);
				}else{
					accountEntity.setBalance(NumberUtil.add(accountEntity.getBalance(),order.getMoney()));
					dao.updCapitalAccountEntity(accountEntity);
				}
				RechargeInfoEntity recharge = new RechargeInfoEntity();
				recharge.setAuserId(order.getAuserId());
				recharge.setMoney(order.getMoney());
				recharge.setPayOrderId(order.getId());
				recharge.setCreateTime(new Date());
				recharge.setCurrentBalance(accountEntity.getBalance());
				if (dao.addRechargeInfo(recharge) <= 0) {
					throw new Exception("充值失败！");
				}
			
				if (dao.updPayOrder(order.getId(),order.getMstate(),order.getPayTime(),order.getThreeNo()) != 1) {
					ExceptionOrderEntity exceptionOrder = dao.getExceptionOrder(order.getMnumber());
					if (exceptionOrder != null) {
						exceptionOrder.setStatus(1);
						if(dao.updateExceptionOrder(exceptionOrder)<=0){
							throw new Exception("充值失败！");
						}
					}
				}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("订单修改失败！");
		}
	}



	/**
	 * 添加提现信息
	 * @throws Exception 
	 */
	@Override
	public boolean addEnchashmentInfo(EnchashmentEntity enchashmentInfo) throws Exception {

          try {
			if (dao.addEnchashment(enchashmentInfo) <= 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();			
			throw new Exception("获取第三方返回参数失败！");
		}
	}

	
	 /***
		 * 获取prepay_id 
		 * @return
		 * @throws IOException 
		 * @throws JDOMException 
		 */
		//生成订单信息 获取prepay_id
		@SuppressWarnings("rawtypes")
		public  String 	getPrepayId (HttpServletRequest request, HttpServletResponse response,
				String  appId, String mchId, double price, String notify_url, String title, String out_trade_no) throws IOException, JDOMException{
			  //---------------需要的参数-----  中文参数 签名会失败-----//
		      String  device_info = "WEB";
		      String  nonce_str = Commons.getRandomString(32);//随机字符串  
		      String  trade_type = "APP";  //取值如下：JSAPI，NATIVE，APP，WAP   为网页支付JSAPI 时 openid必填
		      double prices = price*100;
		      int total_fee = (int) prices;
		      //----------需要的参数---end----------//
		      //将参数转换为xml数据格式
		      RequestHandler reqHandler = new RequestHandler(request, response);
		      reqHandler.setParameter("appid", appId);
		      reqHandler.setParameter("mch_id", mchId);
		      reqHandler.setParameter("device_info", device_info);
		      reqHandler.setParameter("nonce_str", nonce_str);
		      reqHandler.setParameter("body", title);
		      reqHandler.setParameter("out_trade_no", out_trade_no);
		      reqHandler.setParameter("total_fee", String.valueOf(total_fee));
		      reqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());
		      reqHandler.setParameter("notify_url", notify_url);
		      reqHandler.setParameter("trade_type", trade_type);
		      String  xmlData =   reqHandler.getXmlData();
			  //请求：统一支付接口
			  //请求接口获取返回的数据xml格式：
		      Map  orderMap = XMLUtil.doXMLParse(HttpGetOrPost.sendPost(xmlData)); 
			  String prepay_id = (String) orderMap.get("prepay_id");
			  
			  return prepay_id;
			  
		}

		/**
		 * 查询订单
		 * @throws Exception 
		 */
		@Override
		public PayOrderEntity queryPayOrder(String orderNo) throws Exception {
			
			try {
				return dao.queryPayOrder(orderNo,null,0,0);
			} catch (Exception e) {
				e.printStackTrace();			
				throw new Exception("获取失败！");
			}
			
		}
        /**
         * 添加充值信息
         * @throws Exception 
         */
		@Override
		public boolean addRechargeInfo(RechargeInfoEntity info) throws Exception {
			
			try {
				if (dao.addRechargeInfo(info) == 1) {
					return true;
				} else{
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();			
				throw new Exception("获取失败！");
			}
		
		}
        /**
         * 添加异常信息
         * @throws Exception 
         */
		@Override
		public int addExceptionOrder(ExceptionOrderEntity entity) throws Exception {

             try {
				return dao.addExceptionOrder(entity);
			} catch (Exception e) {
				e.printStackTrace();			
				throw new Exception("获取失败！");
			}
		
		}

		/**
		 * 获取账号信息
		 */
		@Override
		public CapitalAccountEntity getUserCapitalAccount(int userId) throws Exception {
			 
			try {
				return dao.getUserCapitalAccount(userId);
			} catch (Exception e) {
				e.printStackTrace();			
				throw new Exception("获取失败！");
			}
		}
		
		

	
		
		
}
