package cn.dingd.dd.management.service;

import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午12:21:36
* 类说明
* 管理端检测订单接口
*/
public interface ManagementService {
	
	/**管理端-检测订单-查询
	 * CheckQueryEntity前段页面需要查询的条件
	 * PageObject 分页信息
	 * */
	public Map<String, Object> FindPageObjects(CheckQueryEntity checkQueryEntity,PageObject pageObject) ;
	/**根据电话查询对应的员工*/
	public int GetStaff(String staffInfoEntity);
	/**检测APP新建订单*/
	public String NewOrder(CheckBillEntity checkBillEntity) ;
	/**检测PC新建订单*/
	public String NewOrderPc(CheckBillEntity checkBillEntity) ;
	/**
	 * 查询检测师
	 */
	public List<StaffInfoEntity>  FindDetect();
	/**
	 * 修改车辆保留价
	 * @param carId
	 * @param money
	 * @return
	 */
	public boolean updCarMoney(Integer carId,Float money)throws Exception;
}
