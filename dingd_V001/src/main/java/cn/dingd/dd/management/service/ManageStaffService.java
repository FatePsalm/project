package cn.dingd.dd.management.service;

import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.StaffPictureEntity;
import cn.dingd.dd.common.web.PageObject;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 员工管理
*/
public interface ManageStaffService {
	/** 管理端-人员管理-根据电话查找员工id */
	public int FindStaffId(String phone);
	/** 管理端-人员管理-根据ID修改员工信息 */
	public String UpdateStaff(List<StaffPictureEntity> staffPicList, StaffInfoEntity staffInfoEntity);
	/** 管理端-人员管理-根据ID查找用户 */
	public Map<String, Object> FindStaff(Integer id);
	/** 管理端-人员管理-查询员工是否存在 */
	public int FindStaffPhone(String phone);
	/** 管理端-人员管理-查询最后个员工号 */
	public String FindStaffNumber();
	/** 管理端-人员管理-员工列表 */
	public Map<String, Object> FindStaffList(StaffInfoEntity staffInfoEntity,PageObject pageObject,String sort);
	/** 管理端-人员管理-添加员工 */
	public String AddStaff(List<StaffPictureEntity> list,StaffInfoEntity staffInfoEntity);
	
}
