package cn.wh.warehouse.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wh.warehouse.system.service.UserService;



@Controller
public class IndexController {
	@Resource
	private UserService userService;
	//首页。。
	@RequestMapping("/indexUI")
	public String indexUI(){
		return "index";
	}
	
}













