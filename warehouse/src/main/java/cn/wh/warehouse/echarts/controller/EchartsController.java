package cn.wh.warehouse.echarts.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wh.warehouse.echarts.service.EchartsService;


@Controller
@RequestMapping("/echarts/")
public class EchartsController {
	@Resource
	private EchartsService echartsService;
	@RequestMapping("echarts")
	public String echarts(){
		return "echarts/echarts";
	}
	@RequestMapping("doecharts")
	@ResponseBody
	public Map<String, Object> doFindPageObjects(){
		return echartsService.getSendPeople();
	}
	
}
