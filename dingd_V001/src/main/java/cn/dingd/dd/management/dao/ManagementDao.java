package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午4:00:54
* 类说明
* T管理端DAO
*/
public interface ManagementDao {
	public int NewField(AuctionSessionEntity auctionSessionEntity);
	/**根据查询条件查询条目数*/
	public int getRowCount(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity) ;
	/**
	 * 查询检测师
	 */
	public List<StaffInfoEntity>  FindDetect();
	/**检测PC新建订单*/
	public int NewOrderPc(CheckBillEntity checkBillEntity) ;

	/**管理端-检测订单-查询
	 * CheckQueryEntity前段页面需要查询的条件
	 * PageObject 分页信息
	 * */
	public List<Map> FindPageObjects(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity,@Param("pageObject")PageObject pageObject);
	/**检测APP新建订单*/
	public int NewOrder(CheckBillEntity checkBillEntity) ;
	/**根据电话查询对应的员工*/
	public int GetStaff(@Param("staffInfoEntity")String staffInfoEntity);
	/**
	 * 修改车辆信息
	 * @param carId
	 * @param carMoney
	 * @return
	 */
	public Integer updateCarMoney(@Param("carId")int carId,@Param("money")Float money);

}
