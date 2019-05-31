package cn.dingd.dd.common.service.impl;

import cn.dingd.dd.common.dao.CommonDao;
import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.orc.HttpUtils;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.Constant;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月11日 上午11:45:29 类说明 通用方法
 */

@Service
@Component
public class CommonServiceImpl implements CommonService {
	@Resource
	private CommonDao commonDao;
	@Resource
	private Cache cache;
	

	/** 获取车辆状态 */
	public int findCarState(Integer carId) {
		return commonDao.findCarState(carId);
	}

	/** A端账户提现修改资金表 */
	public int subtractionBalance(Integer id, Integer money) {
		return commonDao.subtractionBalance(id, money);
	}

	/** A端账户充值修改资金表 */
	public int UpdateBalance(Integer id, Integer money) {
		return commonDao.UpdateBalance(id, money);
	}

	/** 查询当日开始场次数据 */
	public List<AuctionSessionEntity> firstFieldAll() {
		return commonDao.firstFieldAll();
	}

	/** 检查建档时重复提交 */
	public int checkOrderRepetition(int carId) {
		return commonDao.checkOrderRepetition(carId);
	}

	/** 修改拍卖订单状态 */
	public int UpdateOrder(int id, int state, String remarks) {
		return commonDao.UpdateOrder(id, state, remarks);
	}

	/** 修改场次状态 */
	public int UpdateFirstField(int id, int state) {
		return commonDao.UpdateFirstField(id, state);
	}

	/** 查询当日开始场次第一条数据 */
	public AuctionSessionEntity firstField() {
		return commonDao.firstField();
	}

	/** 统计车辆流拍次数 */
	public Map<Object, Object> statisticalCars() {
		List<Map> listMap = commonDao.statisticalCars();
		Map<Object, Object> resultMap = new HashMap<>();
		for (Map map : listMap) {
			resultMap.put(map.get("carId"), map.get("count"));
		}
		return resultMap;
	}

	/** 修改车辆状态 */
	public int UpdateCarState(TCarBasisInfoEntity tCarBasisInfoEntity) {
		if (tCarBasisInfoEntity.getId() < 1) {
			throw new NullPointerException("修改车辆id为空!");
		}
		if (tCarBasisInfoEntity.getCarState() < 1) {
			throw new NullPointerException("修改车辆状态参数不正确!");
		}
		return commonDao.UpdateCarState(tCarBasisInfoEntity);
	}

	/** 把文件转换为base64String */
	public String GetBase64(MultipartFile file) {
		byte[] files;
		try {
			files = file.getBytes();
		} catch (IOException e) {
			throw new NullPointerException("读取文件异常!");
		}
		return new String(Base64.encodeBase64(files));
	}

	/** ORC图像识别行驶证 */
	public Map<String, Object> GetVehicleORC(MultipartFile[] file) {
		Map<String, Object> map = new HashMap<>();
		int number = 1;
		for (MultipartFile i : file) {
			String host = "https://dm-53.data.aliyun.com";
			String path = "/rest/160601/ocr/ocr_vehicle.json";
			String method = "POST";
			String appcode = Constant.appcode;
			Map<String, String> headers = new HashMap<String, String>();
			// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
			headers.put("Authorization", "APPCODE " + appcode);
			// 根据API的要求，定义相对应的Content-Type
			headers.put("Content-Type", "application/json; charset=UTF-8");
			Map<String, String> querys = new HashMap<String, String>();
			String bodys = "{\"inputs\":[{\"image\":{\"dataType\":50,\"dataValue\":\"" + GetBase64(i) + "\"}}]}";
			JSONObject dataValueJson = null;
			try {
				/**
				 * 重要提示如下: HttpUtils请从
				 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
				 * 下载
				 *
				 * 相应的依赖请参照
				 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
				 */
				HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
				String str = EntityUtils.toString(response.getEntity());
				// 判断是否识别成功
				JSONArray outputsJson = (JSONArray) JSONObject.fromObject(str).get("outputs");
				JSONObject outputValueJson = (JSONObject) JSONObject.fromObject(outputsJson.getJSONObject(0))
						.get("outputValue");
				dataValueJson = (JSONObject) JSONObject.fromObject(outputValueJson).get("dataValue");
			} catch (Exception e) {
				throw new NullPointerException("OCR识别错误!");
			}
			// if (dataValueJson.getString("owner").equals("")) {
			// throw new NullPointerException("ORC姓名获取失败!");
			// }
//			if (dataValueJson.getString("plate_num").equals("")) {
//				throw new NullPointerException("ORC车牌获取失败!");
//			}
//			if (dataValueJson.getString("model").equals("")) {
//				throw new NullPointerException("ORC品牌型号获取失败!");
//			}
//			if (dataValueJson.getString("vin").equals("")) {
//				throw new NullPointerException("ORCvin获取失败!");
//			}
//			if (dataValueJson.getString("use_character").equals("")) {
//				throw new NullPointerException("ORC使用性质获取失败!");
//			}
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
			String issueDate=dataValueJson.getString("issue_date");
			if (!issueDate.equals("")) {
				try {
					simpleDateFormat.parse(issueDate);
				} catch (ParseException e) {
					dataValueJson.put("issue_date", "");
				}
			}
//			if (dataValueJson.getString("vehicle_type").equals("")) {
//				throw new NullPointerException("ORC车辆类型获取失败!");
//			}
//			if (dataValueJson.getString("vehicle_type").equals("")) {
//				throw new NullPointerException("ORC车辆类型获取失败!");
//			}
//			if (dataValueJson.getString("engine_num").equals("")) {
//				throw new NullPointerException("ORC发动机号获取失败!");
//			}
			String registerDate=dataValueJson.getString("register_date");
			if (!issueDate.equals("")) {
				try {
					simpleDateFormat.parse(registerDate);
				} catch (ParseException e) {
					dataValueJson.put("register_date", "");
				}
			}
//			if (dataValueJson.getString("register_date").equals("")) {
//				throw new NullPointerException("ORC注册日期获取失败!");
//			}
			// 获取response的body
			// System.out.println("获取response的body:" + string2)
			map.put((number++) + "", dataValueJson);

		}
		return map;
	}

	/** 城市ID查询下属地区 */
	public List<CityMapEntiyt> GetAreaId(CityMapEntiyt cityMapEntiyt) {
		return commonDao.GetAreaId(cityMapEntiyt);
	}

	/** 查询缓存中的验证码 */
	public String GetCacheNumber(String username) {
		if (username == null || username.equals("")) {
			throw new AuthenticationException("验证码查询,未传参数!");
		}
		Element element = cache.get(username);
		if (element != null && (String) element.getValue() != null) {
			return element.getValue().toString();
		}
		throw new AuthenticationException("验证码查询,验证码不存在!");
	}

	/** 查询员工信息 */
	public StaffInfoEntity isExist(String username) {
		if (commonDao.isExist(username) == null) {
			throw new AuthenticationException("用户不存在!");
		}
		return commonDao.isExist(username);
	}

	/** 短信验证码匹配 */
	public Boolean RandomCodeCheck(String userName, String PassWord) {
		Element element = cache.get(userName);
		if (element != null && (String) element.getValue() != null) {
			if (element.getValue().toString().equals(GetMD5(PassWord))) {
				// 认证成功删除缓存中的验证码
				cache.remove(userName);
				return true;
			}
		}
		return false;
	}

	/**
	 * 短信验证码 
	 * 第一个时间控制访问后生存时间 
	 * 第二个参数时间控制生成后生存时间 
	 * account 手机号码 
	 * messageTemplate 模板样式
	 * MD5State 0-不加密 1-MD5加密
	 */
	public String RandomCodeOut(String account, Integer messageTemplate, Integer MD5State) {
		/** 获取验证码缓存 */
		Element element = cache.get(account);
		if (element != null && (String) element.getValue() != null) {
			throw new NullPointerException("短信验证码已存在!");
		} else {
			String randomCode = RandomCode();
			VerificationCode verificationCode = FindSmsTemplate(messageTemplate);
			verificationCode.setPhoneNumbers(account);
			verificationCode.setTemplateParam("{\"code\":\"" + randomCode + "\"}");
			System.out.println("========" + verificationCode);
			try {
				Map<String, Object> map = doPostCode(verificationCode);
				if (map.get("请求的状态码:").equals("OK")) {
					if (MD5State == 1) {
						randomCode = GetMD5(randomCode);
					}
					//发送验证码成功以后将验证码写入缓存
					cache.put(new Element(account, randomCode, false, 0, Constant.ttiExpiry));
				}
			} catch (ClientException e) {
				throw new NullPointerException("短信发送失败");
			}
			return "验证码已发送到:" + account;
		}
	}

	/** 生成随机验证码 */
	public String RandomCode() {
		return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
	}

	/** 检查A端账号是否存在 */
	public Boolean UserNameCheck(String account) {
		if (account == null || account.equals("")) {
			throw new NullPointerException("推荐人为空");
		}
		// 检查账号位数
		if (account.length() != 11) {
			throw new NullPointerException("账号位数不符合");
		}
		// 检查账号纯数字
		for (int i = 0; i < account.length(); i++) {
			if (!Character.isDigit(account.charAt(i))) {
				throw new NullPointerException("账号格式不正确");
			}
		}
		if (commonDao.ARecommendCheck(account) == 0) {
			return false;
		}
		return true;
	}

	/** 初始化SMS短信验证码模板 */
	public VerificationCode InitializationVerificationCodeTemplate(VerificationCode verificationCode) {
		verificationCode.setPhoneNumbers(verificationCode.getPhoneNumbers());
		verificationCode.setCode(RandomCode());
		verificationCode.setTemplateParam("{\"code\":\"" + verificationCode.getCode() + "\"}");
		System.out.println("verificationCode=============>" + verificationCode);
		// {\"name\":\"Tom\",\"car\":\"car\", \"code\":\"123\"}
		return verificationCode;
	}

	/**
	 * 发送短信到阿里云
	 * 
	 * @throws ClientException
	 */
	public Map<String, Object> doPostCode(VerificationCode verificationCode) throws ClientException {
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient需要的几个参数
		final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
		// 替换成你的AK
		final String accessKeyId = Constant.accessKeyId;// 你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = Constant.accessKeySecret;// 你的accessKeySecret，参考本文档步骤2
		// 初始化ascClient,暂时不支持多region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(verificationCode.getPhoneNumbers());
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(verificationCode.getSignName());
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(verificationCode.getTemplateCode());
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证 码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam(verificationCode.getTemplateParam());
		// 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			// System.out.println("手机:" + verificationCode.getPhoneNumbers() +
			// "发送成功!");
		}else {
			throw  new NullPointerException("短信发送失败,请核实手机号码!");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("请求的ID:", sendSmsResponse.getRequestId());
		map.put("请求的状态码:", sendSmsResponse.getCode());
		map.put("请求的状态码描述:", sendSmsResponse.getMessage());
		map.put("请求的回执ID:", sendSmsResponse.getBizId());
		System.out.println("发送验证码状态" + map);
		return map;
	}

	/** 查找短信模板 */
	public VerificationCode FindSmsTemplate(Integer id) {
		return commonDao.FindSmsTemplate(id);
	}

	/** MD5加密 */
	public String GetMD5(String password) {
		String algorithmName = "MD5";
		Object source = password;
		Object salt = "e1$dYHxW*OdEiUOu";
		int hashIterations = 1024;
		String result = new SimpleHash(algorithmName, source, salt, hashIterations).toString();
		return result;
	}

	/** 查询检测单图片属性 
	 * @throws Exception */
	public List<CarDictionaryEntity> GetImgInfo(List codes) throws Exception {
		try {
			return commonDao.GetImgInfo(codes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取损伤图片失败！");
		}
	}

	/**
	 * 获取需要执行的订单
	 */
	@Override
	public List<AuctionOrderEntity> getAuctionOrders() throws Exception{

		try {
			return commonDao.getAuctionOrders(1, new Date());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取订单失败！");
		}
	}
}
