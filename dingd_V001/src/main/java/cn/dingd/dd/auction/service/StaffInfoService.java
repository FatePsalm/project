package cn.dingd.dd.auction.service;

import cn.dingd.dd.common.entity.StaffInfoEntity;

/**
 * 员工信息
 * @author xcd
 *
 */
public interface StaffInfoService {

	/**
	 * 获取员工信息
	 * @param staffEntity
	 * @return
	 * 
	 */
	public int regCheckUser(String uPhone)throws Exception ;

	/**
	 * 获取员工的类型
	 * @param phone
	 * @return
	 */
	public Integer getStaffType(String phone) ;
}
