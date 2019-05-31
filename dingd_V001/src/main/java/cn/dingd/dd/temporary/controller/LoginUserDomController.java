package cn.dingd.dd.temporary.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.temporary.entity.UserDom;
import cn.dingd.dd.temporary.service.UserDomService;

/**
 * 临时版登录用户control
 * @author XCD
 *
 */
@Controller
@RequestMapping("/LoginDom/")
public class LoginUserDomController {

	/**
	 * userDomService
	 */
	@Resource
	private UserDomService domService;
	
	@RequestMapping("loginUserDom")
	@ResponseBody
	@CrossOrigin
	public JsonResult loginUserDom(String password,String account){
		
		if(!StringUtils.isNotNullStr(password)){
			return new JsonResult("请输入密码!");
		}
		if(!StringUtils.isNotNullStr(account)){
			return new JsonResult("请输入用户名!");
		}
		UserDom dom= domService.loginUser(password, account);
		return new JsonResult(dom);
	}
	
	
	
	
	
}
