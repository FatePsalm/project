package com.dingdang.biz.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Constant {
	// ServerStatus 1--正式服务器 2--测试服务器
	static Integer ServerStatus=2;
	private static String IPADD;
	public static String notify_url;
	static {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		ServerStatus = Integer.parseInt(resourceBundle.getString("ServerStatus"));
		if (ServerStatus == 1) {
			/** 正式服务器七牛云 */
			IPADD = "http://carimage.dingdangshifu.cn";
			// 正式服务器
			notify_url = "https://www.dingdangshifu.cn/clank/PayOrder/zfb_notify_url";
		} else if (ServerStatus == 2) {
			/** 测试服务器IP地址 */
			IPADD = "http://39.108.70.214:8080";
			// 测试服务器
			notify_url = "http://39.108.70.214/clank/PayOrder/zfb_notify_url";
		}
		System.out.println(IPADD);
	}
	/** 车辆特写图片在数据库地址 */
	public static final String PICTUREADR = IPADD + "/carImg/";
	/** 车辆特写图片上传地址 */
	public static final String UP_PATH = "/home/img/carImg/";
	/** 损伤图片地址 */
	public static final String DAMAGE = IPADD + "/damageImg/";
	/** 上传损伤图片 */
	public static final String UP_DAMAGE = "/home/img/damageImg/";
	/** 上传其他图片 */
	public static final String ELSEPICTURE = IPADD + "/elseImg/";
	/** 上传其他图片 */
	public static final String UP_ELSEPICTURE = "/home/img/elseImg/";
	/** 头像图片 */
	public static final String HEADPICTURE = IPADD + "/headImg/";
	/** 头像 */
	public static final String UP_HEADPICTURE = "/home/img/headImg/";
	/** 过户图片 */
	public static final String TRANSFER = IPADD + "/transferImg/";
	/** 过户图片 **/
	public static final String UP_TRANSFER = "/home/img/transferImg/";
	/** 身份证 */
	public static final String CARD = IPADD + "/cardImg/";
	public static final String UP_CARDIMG = "/home/img/cardImg/";
	/** 行驶证 */
	public static final String DRIVING = IPADD + "/drivingImg/";
	public static final String UP_DRIVING = "/home/img/drivingImg/";
	/** 驾驶证 */
	public static final String REGISTRATION = IPADD + "/regImg/";
	public static final String UP_REGISTRATION = "/home/img/regImg/";
	/** 登记证 */
	public static final String INSURANCE = IPADD + "/insuranceImg/";
	public static final String UP_INSURANCE = "/home/img/insuranceImg/";
	/** 保险 */
	public static final String BUSINESS = IPADD + "/businessImg/";
	public static final String UP_BUSINESS = "/home/img/businessImg/";
	/** 建档 */
	public static final String RECORD = IPADD + "/inputtingImg/";
	public static final String UP_RECORD = "/home/img/inputtingImg/";
	/** 员工存档照片 */
	public static final String STAFF = IPADD + "/staffImg/";
	public static final String UP_STAFF = "/home/img/staffImg/";
	/**
	 * 微信公众号的appid
	 */

	public static final String APP_ID = "wxe70381d66cc43c3a";
	public static final String MCH_ID = "1393357702";
	public static final String NOTIFY_URL = "http://appapi.wutongsx.com/share/userPay/wx_notify_url";

	/**
	 * 签名时的编码 必须是utf-8
	 */
	public static final String SIGN_ENCODE = "UTF-8";

	/**
	 * 公众平台申请的商户的api秘钥 不同公众号对应不同的商户号可设置相同的api密钥
	 */
	public static final String API = "ddc53450e22e1a3855b0373cfdabc3fb";

	/**
	 * 微信的统一下单接口：即获取prepayId的接口 （固定）
	 */
	public static final String GET_PREPAYID = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/**
	 * 拍卖信息
	 */
	public static int pm = 25;// 初始化第一次加价时间
	public static int tempTime = 25;// 每轮总时间
	public static Map<String, Object> result_Map = new HashMap<String, Object>();// 拍卖中信息返回
	public static Map<String, Object> map = new HashMap<String, Object>();// 用户出价记录
	public static float retentionMoney = 0;// 保留价
	public static float biddingMoney = 0;// 竞价
	public static boolean end = true;// 是否结束
	public static int light = 0;// 是否过保留价
	public static int registFee = 800;// 过户费
	/** ORC行驶证识别 */
	// public static String appcode="996b09946c064ef2abed7b0d372438f4";
	public static String appcode = "306169b3f0c443d1bbc6d50be92847b4";
	/** 短信验证码Key */
	// public static String accessKeyId = "LTAIF67MM8iUlX9v";//
	// 你的accessKeyId,参考本文档步骤2
	// public static String accessKeySecret = "1JV5F7xjsFjYq552kji8LmtOy5Ua9E";//
	// 你的accessKeySecret，参考本文档步骤2
	public static String accessKeyId = "LTAIYUYj2icKCRm6";// 你的accessKeyId,参考本文档步骤2
	public static String accessKeySecret = "oPR89IrKO2Py6yR8QrNyN7tvqD56Oj";// 你的accessKeySecret，参考本文档步骤2
	/** 短信验证码过期时间 */
	public static Integer ttiExpiry = 300;
}
