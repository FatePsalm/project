package cn.dingd.dd.common.dao;

import cn.dingd.dd.common.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年10月11日 下午1:03:50
* 类说明
*/
public interface CommonDao {
	/** 获取车辆状态 */
	public Integer findCarState(Integer carId);
	/**A端账户提现修改资金表*/
	public int subtractionBalance(@Param("id")Integer id,@Param("money")Integer money);
	/**A端账户充值修改资金表*/
	public int UpdateBalance(@Param("id")Integer id,@Param("money")Integer money);
	/**查询当日开始场次数据*/
	public List<AuctionSessionEntity> firstFieldAll();
	/**检查建档时重复提交*/
	public int checkOrderRepetition(@Param("carId")int carId) ;
	/**修改拍卖订单状态*/
	public int UpdateOrder(@Param("id")int id,@Param("state")int state,@Param("remarks")String remarks);
	/**修改场次状态*/
	public int UpdateFirstField(@Param("id")int id,@Param("state")int state);
	/**查询当日开始场次第一条数据*/
	public AuctionSessionEntity firstField();
	/**统计车辆流拍次数*/
	public List<Map> statisticalCars();
	/**修改车辆状态*/
	public int UpdateCarState(TCarBasisInfoEntity tCarBasisInfoEntity);
	/**城市ID查询下属地区*/
	public List<CityMapEntiyt> GetAreaId(CityMapEntiyt cityMapEntiyt) ;
	/**检查A端账号是否存在*/
	public Integer UserNameCheck(String account);
	/**查找短信模板*/
	public VerificationCode FindSmsTemplate(Integer id);
	/**检查A端用户推荐人*/
	public Integer ARecommendCheck (String Recommend);
	/**查询员工信息*/
	public StaffInfoEntity isExist(String username);
	/** 查询检测单图片属性 */
	public List<CarDictionaryEntity> GetImgInfo(@Param("codes")List codes);
	/**获取需要执行的订单*/
	public List<AuctionOrderEntity> getAuctionOrders(@Param("status")int status,@Param("abortTime")Date abortTime);
	
}
