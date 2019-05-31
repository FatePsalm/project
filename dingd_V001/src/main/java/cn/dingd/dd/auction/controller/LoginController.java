package cn.dingd.dd.auction.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.auction.service.StaffInfoService;
import cn.dingd.dd.auction.service.UserInfoService;
import cn.dingd.dd.common.entity.AUserEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.shiro.token.LoginType;
import cn.dingd.dd.common.shiro.token.UserLoginToken;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
import net.sf.ehcache.Cache;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年9月18日 上午11:14:13 类说明 登陆验证
 */
@Controller
@CrossOrigin
@RequestMapping("/Login/")
public class LoginController {

	@Resource
	private CommonService commonServer;
	@Resource
	private Cache cache;
	@Resource
	private UserInfoService service;
	@Resource
	private StaffInfoService staffInfoService;

	/** 检测端登录控制器 */
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		System.out.println("登录控制器");
		return "backend/log";
	}
	/** 上传照片 */
	@RequestMapping("doUpload")
	public String doUpload() {
		System.out.println("登录控制器");
		return "test/upload";
	}
	/** 检查是否登录 */
	@RequestMapping("doCheckState")
	@ResponseBody
	public JsonResult doCheckState() {
		Subject currentUser = SecurityUtils.getSubject();
		return new JsonResult(currentUser.isAuthenticated());
	}
	/** 检测端登录 */
	@RequestMapping("doDetectionLogin")
	@ResponseBody
	public JsonResult doDetectionLogin(StaffInfoEntity staffInfo) {
		checkStaffInfo(staffInfo);
		StaffInfoEntity staffInfoEntity=commonServer.isExist(staffInfo.getuPhone());// 验证用户是否存在
		/*//判断用户是否是检测师
		if (!(staffInfoEntity.getuType()==1||staffInfoEntity.getuType()==3)) {
			return new JsonResult(new Exception("不是检测师账号"),1001);
		}*/
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// 把用户名和验证码封装为 UsernamePasswordToken 对象
			UserLoginToken token = new UserLoginToken(staffInfo.getuPhone(), staffInfo.getuPassword(),
			LoginType.STAFF.toString());
			//token.setRememberMe(true);
			try {
				// 登录认证 - 调用userRealm
				currentUser.login(token);
				//认证成功删除缓存中的验证码
				cache.remove(staffInfo.getuPhone());
			} catch (Exception ae) {
				throw new AuthenticationException("密码错误!");
			}
		}
		return new JsonResult(staffInfoEntity.getId());
	}
	/** 管理端登录 */
	@RequestMapping("doBackGroundLogin")
	@ResponseBody
	public JsonResult doBackGroundLogin(StaffInfoEntity staffInfo) {
		Subject currentUser = SecurityUtils.getSubject();
		StaffInfoEntity staffInfoEntity=null;
		if (!currentUser.isAuthenticated()) {
			checkStaffInfo(staffInfo);
			staffInfoEntity=commonServer.isExist(staffInfo.getuPhone());// 验证用户是否存在
			//判断用户是否是后台管理人员
			if (staffInfoEntity.getuType()==null||!(staffInfoEntity.getuType()==2||staffInfoEntity.getuType()==3)) {
				return new JsonResult(new Exception("不是后台管理账号"),1001);
			}
			// 把用户名和验证码封装为 UsernamePasswordToken 对象
			UserLoginToken token = new UserLoginToken(staffInfo.getuPhone(), staffInfo.getuPassword(), 
					LoginType.BACKGround.toString());
			System.out.println(token.toString());			      
			try {
				// 登录认证 - 调用userRealm
				currentUser.login(token);
				//认证成功删除缓存中的验证码
				cache.remove(staffInfo.getuPhone());
			} catch (Exception e) {
				e.printStackTrace();
				throw new AuthenticationException("密码错误!");
			}
		}else{
			// 检测账号规则
			if (staffInfo.getuPhone().length() != 11) {
				throw new NullPointerException("账号位数不符合");
			}
			try {
				staffInfoEntity = commonServer.isExist(staffInfo.getuPhone());// 验证用户是否存在
			} catch (Exception e) {
				return new JsonResult(new Exception("没有该用户"));
			}			
		}
		staffInfoEntity.setuPassword("******");	
		return new JsonResult(staffInfoEntity);
	}
	
	/** 拍卖端登录 */
	@SuppressWarnings({  "rawtypes" })
	@RequestMapping("doAUserLogin")
	@ResponseBody
	public JsonResult doAUserLogin(AUserEntity  auser ){
		// 检测用户名和验证码
				if (!StringUtils.isNotNullStr(auser.getAccount()) || !StringUtils.isNotNullStr(auser.getPassword())) {
					return new JsonResult(  new NullPointerException("用户名/验证码为空!"),1005);
				}
				// 检测账号规则
				if(!NumberUtil.isPhone(auser.getAccount())){
					return new JsonResult( new NullPointerException("手机格式不符合！"),1004);
				}
				Map map=service.getAUserEntity(auser.getAccount());// 验证用户是否存在
				if(map==null){
					return new JsonResult(new RuntimeException("账号不存在！"),1003);
				}
				Subject  currentUser = SecurityUtils.getSubject();
 			    if (!currentUser.isAuthenticated()) {
					// 把用户名和验证码封装为 UsernamePasswordToken 对象
					UserLoginToken token = new UserLoginToken(auser.getAccount(), auser.getPassword(),
							LoginType.AUSER.toString());
					//token.setRememberMe(true);
					try {
						// 登录认证 - 调用userRealm
						currentUser.login(token);
						//认证成功删除缓存中的验证码
						cache.remove(auser.getAccount());
					} catch (AuthenticationException ae) {
						throw new AuthenticationException("验证码错误!");
					}
				}
				return new JsonResult(map);
		
	}

	/** T端临时版 */
	@RequestMapping("doTTempUI")
	@ResponseBody
	public String doTTempUI(String user) {
		return commonServer.GetCacheNumber(user);
	}

	/** T端临时版认证 */
	@RequestMapping("doTUserCheck")
	@ResponseBody
	public JsonResult doTUserCheck(StaffInfoEntity staffInfo) {
		// 检测用户名和验证码
		if (staffInfo.getuPhone() == null || staffInfo.getuPhone().equals("") || staffInfo.getuPassword() == null
				|| staffInfo.getuPassword().equals("")) {
			throw new AuthenticationException("用户名/验证码为空!");
		}
		// 检测账号规则
		// 检查账号位数
		if (staffInfo.getuPhone().length() != 11) {
			throw new NullPointerException("账号位数不符合");
		}
		// 检查账号纯数字
		for (int i = 0; i < staffInfo.getuPhone().length(); i++) {
			if (!Character.isDigit(staffInfo.getuPhone().charAt(i))) {
				throw new NullPointerException("账号格式不正确");
			}
		}
		commonServer.isExist(staffInfo.getuPhone());// 验证用户是否存在
		Subject currentUser = SecurityUtils.getSubject();
		Serializable session=currentUser.getSession().getId();
		
		System.out.println("isAuthenticated+++++++++"+currentUser.isAuthenticated());
		if (!currentUser.isAuthenticated()) {
			// 把用户名和验证码封装为 UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(staffInfo.getuPhone(), staffInfo.getuPassword());
			try {
				// 登录认证 - 调用userRealm
				currentUser.login(token);
				
			} catch (AuthenticationException ae) {
				throw new AuthenticationException("验证码错误!");
			}
		}
		return new JsonResult(session);
	}

	
	/** A端用户注册验证码获取 */
	@RequestMapping("doACode")
	@ResponseBody
	public JsonResult doACode(AUserEntity aUserEntity) {
		try {
			if (aUserEntity == null || !StringUtils.isNotNullStr(aUserEntity.getAccount())) {
				return new JsonResult(new Exception("用户不存在!"), 1003);
			}
			if (aUserEntity.getFlag() == 1) {
				if (service.getAUserEntity(aUserEntity.getAccount()) == null) {
					return new JsonResult(new Exception("用户不存在!"), 1003);
				}
			}
			return new JsonResult(commonServer.RandomCodeOut(aUserEntity.getAccount(), 1, 1));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e);
		}
	}
	
	/**
	 * 用户未登录跳转地址
	 * @return
	 */
	@RequestMapping("unauthorized")
	@ResponseBody
	public JsonResult unauthorized() {
		return new JsonResult(new Exception("请先登录"),1404);
	}
	
	
	/**
	 * 检查员工的信息
	 * @param staffInfo
	 */
	public void checkStaffInfo(StaffInfoEntity staffInfo) {
		// 检测用户名和验证码
		if (!StringUtils.isNotNullStr(staffInfo.getuPhone()) || !StringUtils.isNotNullStr(staffInfo.getuPassword())) {
			throw new AuthenticationException("用户名/验证码为空!");
		}
		// 检测账号规则
		// 检查账号位数
		if (staffInfo.getuPhone().length() != 11) {
			throw new NullPointerException("账号位数不符合");
		}
		// 检查账号纯数字
		for (int i = 0; i < staffInfo.getuPhone().length(); i++) {
			if (!Character.isDigit(staffInfo.getuPhone().charAt(i))) {
				throw new NullPointerException("账号格式不正确");
			}
		}
	}
}
