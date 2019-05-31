package cn.dingd.dd.management.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.management.service.ManageSeckillingService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zoucong 
 * 2018年1月16日上午10:50:56 
 * 管理端-秒杀模块接口
 */
@RestController
@CrossOrigin
@RequestMapping("/mgmtSeckill/")
public class ManageSeckillingController {

	// 秒杀预展时间
	private final static long TIME_SPASE = 1000 * 60 * 3;
	
	@Autowired
	private ManageSeckillingService managerSeckillingService;

	/** 拍卖-发布管理-秒杀-添加车辆 */
	@SuppressWarnings("unchecked")
	@RequestMapping("addSeckillCars")
	public JsonResult addSeckillCars(HttpServletRequest request) {
		String string = request.getParameter("datas");
		if (string == null || string.equals("")) {
			throw new NullPointerException("未获取到数据!");
		}
		// 秒杀实体
		List<SecondKillBill> secondList = new ArrayList<SecondKillBill>();
		// 获取开拍的基准时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = System.currentTimeMillis();
		Date startTime;
		try {
			startTime = dateFormat.parse(dateFormat.format(time + TIME_SPASE));
		} catch (ParseException e) {
			e.printStackTrace();
			return new JsonResult("添加失败");
		}
		JSONArray jsonArray = JSONArray.fromObject(string);
		Iterator<Object> it = jsonArray.iterator();
		while (it.hasNext()) {
			SecondKillBill secondKillBill = new SecondKillBill();
			JSONObject ob = (JSONObject) it.next();
			if (ob.getInt("carId") <= 0) {
				return new JsonResult(new Exception("车辆id不能为空!"),1001);
			}
			if (ob.getDouble("carMoney")*10000 <= 0 || subString(ob.getString("carMoney")) > 2) {
				return new JsonResult(new Exception("输入正确的车价(有效位数为2位)"),1001);
			}
			if (ob.getInt("serverMoney") < 0 || subString(ob.getString("serverMoney"))!=0) {
				return new JsonResult(new Exception("输入正确的服务价(整数)"),1001);
			}
			secondKillBill.setCarId(ob.getInt("carId"));
			secondKillBill.setCarMoney((float) ob.getDouble("carMoney")*10000);
			secondKillBill.setServerMoney(ob.getInt("serverMoney"));
			// 开拍时间
			secondKillBill.setStartTime(startTime);				
			secondList.add(secondKillBill);
		}
		try{
			managerSeckillingService.addSeckillCars(secondList);
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(new Exception("添加失败"),1001);
		}
		return new JsonResult();
	}

	/** 拍卖-发布管理-添加车辆-查询库存车辆列表 */
	@RequestMapping("getCars")
	public JsonResult doFindCars() {
		return new JsonResult(managerSeckillingService.FindCars());
	}

	/** 拍卖-发布管理-秒杀-查询当日秒杀车辆列表 */
	@RequestMapping("findSeckillCars")
	public JsonResult getAllSeckillCars() {
		return new JsonResult(managerSeckillingService.getAllSeckillCars());
	}

	/** 拍卖-发布管理-秒杀-修改服务费 */
	@RequestMapping("updateServerMoney")
	public JsonResult updateServerMoney(Integer carId, Integer serverMoney) {
		if (carId == null || "".equals(carId)) {
			return new JsonResult(new Exception("车辆id为空"));
		}
		if (serverMoney == null || "".equals(serverMoney) 
				|| serverMoney < 0 || subString(serverMoney.toString())!=0) {
			return new JsonResult(new Exception("输入正确的服务价(整数)"),1001);
		}
		return new JsonResult(managerSeckillingService.updateServerMoney(carId, serverMoney));
	}
	
	/** 拍卖-发布管理-秒杀-修改车价 */
	@RequestMapping("updateCarMoney")
	public JsonResult updateCarMoney(Integer carId, Float carMoney) {
		if (carId == null || "".equals(carId)) {
			return new JsonResult(new Exception("车辆id不能为空!"),1001);
		}
		if (carMoney <= 0 || subString(carMoney.toString()) > 2 
				|| carMoney == null || "".equals(carMoney)) {
			return new JsonResult(new Exception("输入正确的车价(有效位数为2位)"),1001);
		}
		return new JsonResult(managerSeckillingService.updateCarMoney(carId, carMoney));
	}

	/** 拍卖-发布管理-秒杀-查询—根据车牌查询车辆 */
	@RequestMapping("findCarByCarNum")
	public JsonResult findCarByCarNum(String carNum) {
		if (carNum.length()>0) {
			carNum = carNum.replace(" ", "");
		}
		return new JsonResult(managerSeckillingService.findCarByCarNum(carNum));
	}
	
	/**
	 * 计算小数位数
	 * @param str
	 * @return
	 */
	public int  subString(String str) {
		boolean contains = str.contains(".");
		if (!contains) {
			return 0;
		}else{
			String moenyStr = str.substring(str.indexOf(".")+1);
			moenyStr = moenyStr.replaceAll("0+?$", "");//去掉后面无用的零
			if (moenyStr==null||moenyStr.equals("")) {
				return 0;
			}
			int decimalsLenth = moenyStr.length();
			return decimalsLenth;
		}
	} 
}
