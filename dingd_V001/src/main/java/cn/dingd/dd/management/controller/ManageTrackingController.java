package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 专员跟踪
*/

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.management.service.MamageTrackingService;

@Controller
@CrossOrigin
@RequestMapping("/mgmtTk/")
public class ManageTrackingController {
	@Resource
	private MamageTrackingService mamageTrackingService;
	
	/**提醒已过保留价*/
	@RequestMapping("doRemind")
	@ResponseBody
	public JsonResult doRemind() {
		return new JsonResult(mamageTrackingService.Remind());
	}
	/**专员跟踪*/
	@RequestMapping("doTracking")
	@ResponseBody
	public JsonResult doTracking() {
		return new JsonResult(mamageTrackingService.Tracking());
	}
}
