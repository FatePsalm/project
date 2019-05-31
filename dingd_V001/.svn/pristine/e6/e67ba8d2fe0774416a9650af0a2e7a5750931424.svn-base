package cn.dingd.dd.management.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.auction.dao.TCarBasisInfoDao;
import cn.dingd.dd.common.dao.CommonDao;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManagementDao;
import cn.dingd.dd.management.service.ManagementService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月27日 下午3:56:44 类说明
 */
@Service
public class ManagementServiceImpl implements ManagementService {
	@Resource
	private ManagementDao managementDao;
	@Resource
	private CommonDao commonDao;
	@Resource
	private TCarBasisInfoDao tCarBasisInfoDao;
	/**
	 * 查询检测师
	 */
	public List<StaffInfoEntity> FindDetect() {
		return managementDao.FindDetect();
	}
	/** 检测PC新建订单 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String NewOrderPc(CheckBillEntity checkBillEntity) {
		//预约时间
		if(checkBillEntity.getAppointmentTime().getTime()<System.currentTimeMillis()) {
			throw new NullPointerException("预约时间必须大于当前时间!");
		}
		checkBillEntity.setCheckAccount("JC" + System.currentTimeMillis());
		checkBillEntity.setCheckStatus(2);
		// 插入检测单数据是否成功
		if (managementDao.NewOrderPc(checkBillEntity) != 1) {
			throw new NullPointerException("新建检测单失败!");
		}
		return "新建检测订单成功!";
	}
	/** 检测APP新建订单 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String NewOrder(CheckBillEntity checkBillEntity) {
		String checkAccount = "JC" + System.currentTimeMillis();
		checkBillEntity.setCheckAccount(checkAccount);
		// 如果数据插入成功则关联用户
		if (managementDao.NewOrder(checkBillEntity) != 1) {
			throw new NullPointerException("新建检测单失败!");
		}
		return checkAccount;
	}
	/** 根据电话查询对应的员工 */
	@Override
	public int GetStaff(String staffInfoEntity) {
		return managementDao.GetStaff(staffInfoEntity);
	}
	/**
	 * 管理端-检测订单-查询 CheckQueryEntity前段页面需要查询的条件 PageObject 分页信息
	 */
	public Map<String, Object> FindPageObjects(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		// 存储返回的超找内容
		List<Map> list = managementDao.FindPageObjects(checkQueryEntity, pageObject);
		Map<String, Object> map = new HashMap<>();
		pageObject.setRowCount(managementDao.getRowCount(checkQueryEntity));
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/** 根据查询条件查询条目数 */
	public int getRowCount(CheckQueryEntity checkQueryEntity) {
		return managementDao.getRowCount(checkQueryEntity);
	}
	/**
	 * 修改车辆保留价
	 */
	@Override
	public boolean updCarMoney(Integer carId, Float money) throws Exception{
		try {
			TCarBasisInfoEntity basisInfoEntity = tCarBasisInfoDao.getTCarBasisInfoEntityId(carId);
			if (basisInfoEntity == null) {
				throw new Exception("车辆信息不存在！");
			}
			basisInfoEntity.setRetentionMoney(money);
			if (managementDao.updateCarMoney(carId, money) != 1) {
				throw new Exception("修改失败！");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("修改失败！");
		}
		return true;
	}
}
