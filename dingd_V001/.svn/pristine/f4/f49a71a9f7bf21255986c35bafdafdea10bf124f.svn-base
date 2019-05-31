package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 管理端-检测订单
*/

import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.util.Variable;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 检测端
 * 
 * @author caogang
 *
 */
@Controller
@CrossOrigin
@RequestMapping("/mgmt/")
public class ManagementController {
	@Resource
	private ManagementService managementService;

	/**
	 * 管理端-检测订单-查询 CheckQueryEntity前段页面需要查询的条件 PageObject 分页信息
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		if (checkQueryEntity == null || pageObject.getPageSize() < 1) {
			throw new NullPointerException("查询信息或分页信息为空!");
		}
		if (checkQueryEntity.getCheckStatus() == 0) {
			throw new NullPointerException("订单状态参数为传入!");
		}
		if (checkQueryEntity.getRetrieval() != null && !checkQueryEntity.getRetrieval().equals("")) {
			// 去除搜索框内的空格
			checkQueryEntity.setRetrieval(checkQueryEntity.getRetrieval().trim());
		}
		if (pageObject.getPageSize() < 1) {
			throw new NullPointerException("分页信息不合法!");
		}
		Map<String, Object> map = managementService.FindPageObjects(checkQueryEntity, pageObject);
		System.out.println(map);
		return new JsonResult(map);
	}

	/** 根据电话查询对应的员工 */
	@RequestMapping("doGetStaff")
	@ResponseBody
	public JsonResult doGetStaff(StaffInfoEntity staffInfoEntity) {
		if (staffInfoEntity == null) {
			throw new NullPointerException("传入参数为空!");
		}
		return new JsonResult(managementService.GetStaff(staffInfoEntity.getuPhone()));
	}

	/** 检测APP新建订单 */
	@RequestMapping("doNewOrder")
	@ResponseBody
	public JsonResult doNewOrder(CheckBillEntity checkBillEntity) {
		if (checkBillEntity.getPerson() == null || checkBillEntity.getPerson() .equals("")) {
			throw new NullPointerException("联系人为空!");
		}
		if (checkBillEntity.getTelephone() == null || checkBillEntity.getTelephone() .equals("")) {
			throw new NullPointerException("联系人电话为空!");
		}
		if (checkBillEntity.getCreatePerson() <1) {
			throw new NullPointerException("创建人为空!");
		}
		checkBillEntity.setCheckType(Variable.checkBill_JC);
		checkBillEntity.setCheckStatus(2);
		checkBillEntity.setAddress("成都市金牛区蜀西路55号附5号");
		checkBillEntity.setCarName("品牌");
		checkBillEntity.setCars("车系");
		checkBillEntity.setCarModel("型号");
		checkBillEntity.setStaffId(checkBillEntity.getCreatePerson());
		return new JsonResult(managementService.NewOrder(checkBillEntity));
	}

	/** 检测PC新建订单 */
	@RequestMapping("doNewOrderPc")
	@ResponseBody
	public JsonResult doNewOrderPc(CheckBillEntity checkBillEntity) {

		if (checkBillEntity.getPerson() == null || checkBillEntity.getPerson().equals("")) {
			throw new NullPointerException("联系人为空!");
		}
		if (checkBillEntity.getTelephone() == null || checkBillEntity.getTelephone().equals("")) {
			throw new NullPointerException("联系人电话为空!");
		}
		if (checkBillEntity.getCarNumber() == null || checkBillEntity.getCarNumber().equals("")) {
			throw new NullPointerException("车牌号码为空!");
		}
		if (checkBillEntity.getAppointmentTime() == null) {
			throw new NullPointerException("预约时间为空!");
		}
		if (checkBillEntity.getAddress() == null || checkBillEntity.getAddress().equals("")) {
			throw new NullPointerException("地址为空!");
		}
		if (checkBillEntity.getCreatePerson()<1) {
			throw new NullPointerException("创建人为空!");
		}
		if (checkBillEntity.getStaffId()<1) {
			throw new NullPointerException("检测师为空!");
		}
		checkBillEntity.setAddress("成都市金牛区蜀西路55号附5号");
		checkBillEntity.setCheckType(Variable.checkBill_PC);
		return new JsonResult(managementService.NewOrderPc(checkBillEntity));
	}

	/**
	 * 查询检测师
	 */
	@RequestMapping("doFindDetect")
	@ResponseBody
	public JsonResult doFindDetect() {
		return new JsonResult(managementService.FindDetect());
	}
	/**
	 * 修改车辆保留价
	 * @param carId
	 * @param money
	 * @return
	 */
	@RequestMapping("updCarMoney")
	@ResponseBody
	public JsonResult updCarMoney(Integer carId,Float money){
		try {
			if(carId==null || carId<=0){
				return  new JsonResult(new Exception("车辆id为空!"),1005);
			}
			if(money==null || money<=0){
				return  new JsonResult(new Exception("保留价为空!"),1005);
			}
			if (managementService.updCarMoney(carId, money)) {
				return new JsonResult();
			}else{
			   return new JsonResult(new Exception("修改失败!"), 1003);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e,1004);
		}
	}
	
}
