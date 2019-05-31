package cn.dingd.dd.biz.backgroud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.biz.backgroud.service.PermissionService;
import cn.dingd.dd.biz.backgroud.service.StaffService;
import cn.dingd.dd.biz.common.entity.AccountInfo;
import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.biz.common.view.StaffInfoView;
import cn.dingd.dd.common.shiro.token.LoginType;
import cn.dingd.dd.common.shiro.token.UserLoginToken;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;

/**
* @author ZC
* @date 2018年4月19日下午5:11:00
* 商家端后台管理登录控制器
*/
@CrossOrigin
@RestController
@RequestMapping("/biz")
public class BizLoginController {
	
	@Autowired
	private StaffService staffService;
	
	/**
	 * 商家端后台管理系统登录
	 * @param staffInfo
	 * @param code
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("bizBackGroudLogin")
	public JsonResult bizBackGroudLogin(StaffInfo staffInfo,String code,HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				staffInfo = (StaffInfo)subject.getSession().getAttribute("bizAccount");
				return new JsonResult(staffInfo);
			}
			if (!checkValidateCode(session,code)) {
				return new JsonResult(new Exception("验证码不正确"),1008);
			};
			if (StringUtils.isNotNullApp(staffInfo.getAccount())&&StringUtils.isNotNullApp(staffInfo.getuPassword())) {
				StaffInfo sysUser = staffService.staffByAccount(staffInfo.getAccount());
				if (sysUser==null) {
					return new JsonResult(new Exception("账号不存在"));
				}
				if (sysUser.getuState()!=1) {
					return new JsonResult(new Exception("该账号已被禁用"),1003);
				}
				UserLoginToken token = new UserLoginToken(staffInfo.getAccount(), staffInfo.getuPassword(), 
						LoginType.BIZBACKGroud.toString());	
				try {
					session.setAttribute("bizAccount", sysUser);
					subject.login(token);
					staffInfo = sysUser;
				} catch (Exception e) {
					e.printStackTrace();
					throw new AuthenticationException("账号或密码错误!");
				}
			}else {
				return new JsonResult(new Exception("账号或密码为空"),1002);
			}
		return new JsonResult(staffInfo);
	}
	
	/**
	 * 登出
	 * @return
	 */
	@ResponseBody
	@RequestMapping("bizBackGroudLogout")
	public JsonResult logout() {
		SecurityUtils.getSubject().logout();
		return new JsonResult("退出成功！");
	}
	
	
	/**
	 * 发送随机验证码
	 * @param session
	 * @return
	 */
	@RequestMapping("getValidateCode")
	@ResponseBody
	public JsonResult sendValidateCode(HttpSession session) {
		try {
			String code = StringUtils.generateCode(4);
			session.setAttribute("validateCode", code);
			return new JsonResult(code);
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("验证码获取失败！"));
		}	
	}
	
	/**
	 * 验证商家端后台验证码
	 * @param session
	 * @param code
	 * @return
	 */
	public Boolean checkValidateCode(HttpSession session,String code){
		String sessionCode = (String) session.getAttribute("validateCode");
		if (!StringUtils.ignoreCaseEquals(sessionCode, code)) {
			return false;
		}
		session.removeAttribute("validateCode");
		return true;
	}
	
	
	
}
