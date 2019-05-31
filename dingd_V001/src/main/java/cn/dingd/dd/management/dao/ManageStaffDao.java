package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.StaffPictureEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 员工管理
*/
public interface ManageStaffDao {
	/** 管理端-人员管理-根据ID查找员工电话 */
	public int FindStaffId(@Param("phone")String phone);
	/** 管理端-人员管理-根据ID修改员工信息 */
	public int UpdateStaff(@Param("staffInfoEntity")StaffInfoEntity staffInfoEntity);
	/** 管理端-人员管理-根据ID删除员工图片 */
	public int DeleteStaffImg(@Param("id")Integer id);
	/** 管理端-人员管理-根据ID查找用户 */
	public Map<String, Object> FindStaff(@Param("id")Integer id);
	/** 管理端-人员管理-查询员工是否存在 */
	public int FindStaffPhone(@Param("phone")String phone);
	/** 管理端-人员管理-查询最后个员工号 */
	public String FindStaffNumber() ;
	/** 管理端-人员管理-添加员工 */
	public int AddStaff(StaffInfoEntity staffInfoEntity) ;
	/** 管理端-人员管理-添加员工图片 */
	public int AddStaffImg(@Param("list")List<StaffPictureEntity> list) ;
	/** 管理端-人员管理-员工列表分页信息 */
	public int FindStaffListRowCount(@Param("staffInfoEntity")StaffInfoEntity staffInfoEntity) ;
	/** 管理端-人员管理-员工列表 */
	public List<Map<String, Object>> FindStaffList(@Param("staffInfoEntity")StaffInfoEntity staffInfoEntity,@Param("sort")String srot,@Param("pageObject")PageObject pageObject);

}
