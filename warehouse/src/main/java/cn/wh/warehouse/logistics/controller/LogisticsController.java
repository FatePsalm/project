package cn.wh.warehouse.logistics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/logistics/")
@Controller
public class LogisticsController {
	
	@RequestMapping("indexUI")
	public String indexUI(){
		return "index";
	}
	
}













