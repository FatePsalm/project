package cn.dingd.dd.auction.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.auction.service.PayOrderService;
import cn.dingd.dd.common.entity.EnchashmentEntity;
import cn.dingd.dd.common.entity.ExceptionOrderEntity;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.util.AlipayConfig;
import cn.dingd.dd.common.util.AlipayNotify;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.DesUtil;
import cn.dingd.dd.common.util.XMLUtil;
import cn.dingd.dd.common.web.BaseController;
import cn.dingd.dd.common.web.JsonResult;
import net.sf.json.JSONObject;

/**
 * 支付类
 * 
 * @author XCD
 *
 */
@CrossOrigin
@Controller
@RequestMapping("/PayOrder/")
public class PayOrderController extends BaseController {

	@Resource
	private PayOrderService payOrderService;
	
	/**
	 * 添加提现
	 * @param entity
	 * @return
	 */
	@RequestMapping("addEnchashmentInfo")
	@ResponseBody
	public JsonResult addEnchashmentInfo(EnchashmentEntity entity){
		
		 try {
			if(payOrderService.addEnchashmentInfo(entity)){
				return new  JsonResult();
			}else{
				return new JsonResult(new Exception("添加失败！"), 1002);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("添加失败！"), 1002);
		}
	}


	/**
	 * 添加支付订单
	 * @param order
	 * @return
	 */
	@RequestMapping("addPayOrder")
	@ResponseBody
	public JsonResult addPayOrder(String data){
		try {
			JSONObject jsonObject =JSONObject.fromObject(new String(DesUtil.decrypt(data, AlipayConfig.key)));
            return new JsonResult(payOrderService.addPayOrder(jsonObject, request, response));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("添加失败！"), 1002);
		}
	}
	
	
	/**
	 * 微信回掉 wx_notify_url 返回参数判断订单是否成功 如果成功就修改订单状态， 否则返回失败码
	 * 
	 * @throws IOException
	 *@throws JDOMException
	 */
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("wx_notify_url")
	@ResponseBody
	public void wx_notify_url() {

		try {
			InputStream inStream = request.getInputStream();
			ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buffer)) != -1) {
				outSteam.write(buffer, 0, len);
			}
			outSteam.close();
			inStream.close();
			String result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息
			Map<Object, Object> map =XMLUtil.doXMLParse(result);
			if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) { // 判断交易是否成功
				PayOrderEntity order = payOrderService.queryPayOrder(map.get("out_trade_no").toString());
				if (order != null) {
					if (order.getMstate() != 1) {
						order.setMstate(1);						
						order.setPayTime(DateUtils.getTodayString("yyyy-MM-dd HH:mm:ss"));
						if(payOrderService.updPayOrder(order)){
							response.getWriter().write(setXML("SUCCESS", "")); // 告诉微信服务器，我收到信息了，不要再调用回调action了
						}
					}	
				}
							
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("参数错误！");
		}

	}

	
	
	
	/**
	 * 支付宝回调
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("zfb_notify_url")
	@ResponseBody
	public void zfb_notify_url() {
		try {
			Map<String, String> params = new HashMap<String, String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				}
				params.put(name, valueStr);
			}
			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			String trade_no = request.getParameter("trade_no"); // 支付宝交易号
			String order_no = request.getParameter("out_trade_no"); // 获取订单号
			String trade_status = request.getParameter("trade_status"); // 交易状态
			// 异步通知ID
			String notify_id = request.getParameter("notify_id");
			// sign
			String sign = request.getParameter("sign");
			if (notify_id != "" && notify_id != null) {
				if (AlipayNotify.verifyResponse(notify_id).equals("true"))// 判断成功之后使用getResponse方法判断是否是支付宝发来的异步通知。
				{
					if (AlipayNotify.getSignVeryfy(params, sign))// 使用支付宝公钥验签
					{
						// 请在这里加上商户的业务逻辑程序代码
						if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
							PayOrderEntity order = payOrderService.queryPayOrder(order_no);
							if (order != null) {
								if (order.getMstate() ==0) {
									order.setMstate(1);
									order.setThreeNo(trade_no); // 第三方订单
									order.setPayTime(DateUtils.getTodayString("yyyy-MM-dd HH:mm:ss"));
									if(payOrderService.updPayOrder(order)){
										response.getWriter().write("SUCCESS");
									}
								}
							} else {
								response.getWriter().write("FAIL");
							}
						} else {
							ExceptionOrderEntity exceptionOrder = new ExceptionOrderEntity();
							exceptionOrder.setOrderNo(order_no);
							exceptionOrder.setThreeNo(trade_no);
							exceptionOrder.setCreateTime(new Date());
							exceptionOrder.setStatus(0);
							if (payOrderService.addExceptionOrder(exceptionOrder) == 1) {
								response.getWriter().write("SUCCESS");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("回掉失败！");
		}
	}

	public static String setXML(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
				+ "]]></return_msg></xml>";
	}
}
