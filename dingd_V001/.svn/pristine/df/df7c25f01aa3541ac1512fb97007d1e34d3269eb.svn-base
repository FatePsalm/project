package cn.dingd.dd.auction.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.auction.service.PayOrderService;
import cn.dingd.dd.auction.service.UserInfoService;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.web.BaseController;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;

/**
 * 用户
 * @author xcd
 *
 */
@CrossOrigin
@Controller
@RequestMapping("/auser/")
public class UserController extends BaseController { 
    @Resource
	private PayOrderService orderService;
    @Resource
	private UserInfoService infoService;
	
    /**
     * 获取用户信息及资金信息
     * @param userId
     * @return
     */
    @RequestMapping("queryUserInfo")
	@ResponseBody
   public JsonResult queryUserInfo(Integer userId){
	   try {
		   if(userId==null){
			   return new  JsonResult(new Exception("参数错误！"),1404);
		   }
		return new JsonResult(infoService.queryUserinfo(userId));
	} catch (Exception e) {
		e.printStackTrace();
		return new JsonResult(e,1003);
	}
   }
   
   /**
    * 获取用户信息
    * @param userId
    * @return
    */
    @RequestMapping("getUserInfo")
	@ResponseBody
   public JsonResult getUserInfo(Integer userId){
	   try {
		   if(userId==null){
			   return new  JsonResult(new Exception("参数错误！"),1404);
		   }
		return new JsonResult(infoService.getUserInfo(userId));
	} catch (Exception e) {
		e.printStackTrace();
		return new JsonResult(e,1003);
	}
   }
    
   /**
    * 获取用户资金消费信息
    * @param userId
    * @return
    */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("getUserCapitlAccount")
   	@ResponseBody
    public JsonResult getUserCapitlAccount(Integer userId,PageObject pageObject){
    	try {
			if (userId == null) {
				return new JsonResult(new Exception("参数错误！"),1404);
			}
			if (pageObject == null) {
				return new JsonResult(new Exception("分页页数不能为空!"),1005);
			}
			if (pageObject.getPageCurrent() <= 0 ) {
				return new JsonResult(new Exception("当前页数不能为空!"),1004);
			}
			pageObject.setPageSize(10);
			pageObject.setRowCount(infoService.getUserInfoPage(userId));
			List<Map> ls= infoService.getUserCapitlAccount(userId,pageObject);
			String  dt=DateUtils.getDateOperation(new Date(),-1);//系统时间
			String day=null;//系统某天
			String zday=null;//之前某天
			String moth=null;//系统某月
			String zmoth=null;//之前的某月
			String year=null;//系统某年
			String zyear=null;//之前的某年
			String createTime=null;//消费时间
			
			for(int i=0;i<ls.size();i++){
			    createTime=ls.get(i).get("createTime").toString();
				zday=createTime.substring(8,10);
				day=dt.substring(8,10);
				zmoth=createTime.substring(5,7);
				moth=dt.substring(5,7);
				year=DateUtils.toStringDate(new Date()).substring(0,4);
				zyear=createTime.substring(0,4);
				if(Integer.parseInt(year)>Integer.parseInt(zyear) ){
					ls.get(i).put("time",createTime.substring(5,10));
					ls.get(i).put("name",createTime.substring(0,4));
					
				}else if(Integer.parseInt(day)==Integer.parseInt(zday) && Integer.parseInt(moth)==Integer.parseInt(zmoth)) {
					ls.get(i).put("time",createTime.substring(11,16));
					ls.get(i).put("name","昨天");
					
				}else if(Integer.parseInt(day)<Integer.parseInt(zday) && Integer.parseInt(moth)==Integer.parseInt(zmoth)){
					ls.get(i).put("time",createTime.substring(11,16));
					ls.get(i).put("name","今天");
					
				}else if(Integer.parseInt(year)==Integer.parseInt(zyear)){
					ls.get(i).put("time",createTime.substring(11,16));
					ls.get(i).put("name",createTime.substring(5,10));
					
				}
			}
			 
			Map map=infoService.getAUserInfo(userId);
			Map resMap=new HashMap<>();
			resMap.put("Capitls", ls);
		    resMap.put("money",map.get("money"));//支出
			resMap.put("balance",map.get("balance"));//余额
			resMap.put("freeze",map.get("freeze"));//冻结
			resMap.put("withdraw",map.get("withdraw"));//提现
			resMap.put("pageObject", pageObject);
			return new JsonResult(resMap);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e,1003);
		}
    }
   
    
}
