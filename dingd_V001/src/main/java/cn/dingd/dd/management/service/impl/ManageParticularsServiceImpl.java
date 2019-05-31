package cn.dingd.dd.management.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.entity.CarDictionaryEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.management.dao.ManageParticularsDao;
import cn.dingd.dd.management.service.ManageParticularsService;

/**
 * 车辆详情
 */
@Service
public class ManageParticularsServiceImpl implements ManageParticularsService {
	@Resource
	private ManageParticularsDao manageParticularsDao;
	@Resource
	private AuctionSessionService auctionSessionService;

	/** 管理端-车辆详细-车辆详细 */
	public Map FindDetailed(Integer id) {
		Map map = manageParticularsDao.FindDetailed(id);
		// 获取超时扣款时间
		Date abortTime = (Date) map.get("abortTime");
		// 获取订单生成时间
		Date orderTime = (Date) map.get("orderTime");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orderTime);
		// 时间规则/过期时间
		calendar.add(Calendar.HOUR_OF_DAY, DateUtils.OUTTIME);
		// 计算扣款时间
		Date date = DateUtils.getTimeout(calendar);
		// 现在扣款时间对比计算扣款时间
		if (abortTime.getTime() > date.getTime()) {
			map.put("modify", true);
		} else {
			map.put("modify", false);
		}
		return map;
	}

	/** 管理端-车辆详细-电器及附件 */
	public Map FindAttachment(Integer id) {
		return manageParticularsDao.FindAttachment(id);
	}

	/** 管理端-车辆详细-隐性损伤 */
	public Map<String, Object> FindRecessive(Integer id) {
		Map<String, Object> map = new HashMap<>();
		// 查询外观损伤
		List<Map> appearance = manageParticularsDao.FindRecessive(id, 6, 1);
		// 查询骨架损伤
		List<Map> skeleton = manageParticularsDao.FindRecessive(id, 4, 2);
		map.put("appearance", appearance);
		map.put("skeleton", skeleton);
		return map;
	}

	/** 管理端-车辆详细-显性损伤 */
	public Map<String, Object> FindDominant(Integer id) {
		Map<String, Object> map = new HashMap<>();
		// 查询外观损伤
		List<Map> appearance = manageParticularsDao.FindDominant(id, 3, 1);
		// 查询骨架损伤
		List<Map> skeleton = manageParticularsDao.FindDominant(id, 4, 2);
		// 查询内饰损伤
		List<Map> interior = manageParticularsDao.FindDominant(id, 5, 3);
		map.put("appearance", appearance);
		map.put("skeleton", skeleton);
		map.put("interior", interior);
		return map;
	}

	/** 管理端-车辆详细-过户资料 */
	public List<Map> FindRecord(Integer id) {
		return manageParticularsDao.FindRecord(id);
	}

	/** 管理端-车辆详细-车辆特写 */
	public List<Map> FindPicture(Integer id, Integer imgType) {
		return manageParticularsDao.FindPicture(id, imgType);
	}

	/** 管理端-车辆详细-流拍信息 */
	public List<Map> FindAuction(int id) {
		return manageParticularsDao.FindAuction(id);
	}

	/** 管理端-车辆详细-车主信息/联系人信息/检测师信息 */
	public Map FindCarPerson(int id) {
		return manageParticularsDao.FindCarPerson(id);
	}

	/** 管理端-车辆详细-车辆基本信息 */
	public TCarBasisInfoEntity CarInfo(TCarBasisInfoEntity tCarBasisInfoEntity) {
		return manageParticularsDao.CarInfo(tCarBasisInfoEntity);
	}
}
