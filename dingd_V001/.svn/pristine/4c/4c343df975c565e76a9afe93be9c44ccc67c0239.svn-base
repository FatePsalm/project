package cn.dingd.dd.management.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.StaffPictureEntity;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManageStaffDao;
import cn.dingd.dd.management.service.ManageStaffService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月27日 上午11:06:27 类说明 员工管理
 */
@Service
public class ManageStaffServiceImpl implements ManageStaffService {

	@Resource
	private ManageStaffDao staffDao;

	/** 管理端-人员管理-根据ID查找员工电话 */
	public int FindStaffId(String phone) {
		return staffDao.FindStaffId(phone);
	}

	/** 管理端-人员管理-根据ID修改员工信息 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String UpdateStaff(List<StaffPictureEntity> staffPicList, StaffInfoEntity staffInfoEntity) {
		// 更新员工列表
		if (staffDao.UpdateStaff(staffInfoEntity) != 1) {
			throw new NullPointerException("员工信息修改失败!");
		}
		if (staffPicList.size() >= 0) {
			// 删除图片信息
			staffDao.DeleteStaffImg(staffInfoEntity.getId());
			// 更新图片信息
			if (staffPicList.size() != 0) {
				if (staffPicList.size() != staffDao.AddStaffImg(staffPicList)) {
					throw new NullPointerException("更新图片失败!");
				}
			}
		}
		return "修改成功!";
	}

	/** 管理端-人员管理-根据ID查找用户 */
	public Map<String, Object> FindStaff(Integer id) {
		SimpleDateFormat simUBirthday = new SimpleDateFormat("MM.dd");
		SimpleDateFormat simuTime = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = staffDao.FindStaff(id);
		if (map == null) {
			return null;
		}
		try {
			// 如果没有图片则不返回null
			List<StaffPictureEntity> list = (List<StaffPictureEntity>) map.get("imgList");
			for (StaffPictureEntity entity : list) {
				if (entity.getUrl() == null) {
					map.remove("imgList");
				}
			}
			if ((boolean) map.get("uSex")) {
				map.put("uSex", 1);
			} else {
				map.put("uSex", 0);
			}
			Date uBirthday = (Date) map.get("uBirthday");
			Date uTime = (Date) map.get("uTime");
			map.put("uBirthday", simUBirthday.format(uBirthday));
			map.put("uTime", simuTime.format(uTime));
		} catch (Exception e) {
		}
		return map;
	}

	/** 管理端-人员管理-查询员工是否存在 */
	public int FindStaffPhone(String phone) {
		return staffDao.FindStaffPhone(phone);
	}

	/** 管理端-人员管理-查询最后个员工号 */
	public String FindStaffNumber() {
		return staffDao.FindStaffNumber();
	}

	/** 管理端-人员管理-添加员工 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String AddStaff(List<StaffPictureEntity> list, StaffInfoEntity staffInfoEntity) {
		if (staffDao.AddStaff(staffInfoEntity) != 1) {
			throw new NullPointerException("添加员工失败!");
		}
		// 获取插入用户的id
		int staffId = staffInfoEntity.getId();
		int i = 1;
		for (StaffPictureEntity s : list) {
			s.setStaffId(staffId);
			s.setShowSrot(i);
			i++;
		}
		if (list.size() != 0) {
			// 写入图片信息
			int staffImg = staffDao.AddStaffImg(list);
			if (staffImg != list.size()) {
				throw new NullPointerException("写入图片信息失败!");
			}
		}
		return "添加成功!";
	}

	/** 管理端-人员管理-员工列表 */
	public Map<String, Object> FindStaffList(StaffInfoEntity staffInfoEntity, PageObject pageObject, String sort) {
		Map<String, Object> resultMap = new HashMap<>();
		List<Map<String, Object>> list = staffDao.FindStaffList(staffInfoEntity, sort, pageObject);
		for (Map<String, Object> map : list) {
			Object usex = map.get("uSex");
			if (usex != null) {
				if ((boolean) usex) {
					map.put("uSex", 1);
				} else {
					map.put("uSex", 0);
				}
			}
		}
		resultMap.put("list", list);
		// 查询分页信息
		pageObject.setRowCount(staffDao.FindStaffListRowCount(staffInfoEntity));
		resultMap.put("pageObject", pageObject);
		return resultMap;
	}

}
