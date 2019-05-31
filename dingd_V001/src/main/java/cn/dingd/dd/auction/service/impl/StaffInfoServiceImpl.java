package cn.dingd.dd.auction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dingd.dd.auction.dao.StaffInfoDao;
import cn.dingd.dd.auction.service.StaffInfoService;

/**
 * 员工service
 * @author xcd
 *
 */
@Service
public class StaffInfoServiceImpl implements StaffInfoService {

	@Resource
	private StaffInfoDao staffDao;
	
	/**
	 * 查询员工信息
	 */
	@Override
	public int regCheckUser(String uPhone) throws Exception {
		if(staffDao.regCheckUser(uPhone)==null){
			return 0;
		}
		return 1;
	}
	
	/**
	 * 获取员工的类型
	 */
	@Override
	public Integer getStaffType(String phone) {
		return staffDao.staffType(phone);
	}

	
}
