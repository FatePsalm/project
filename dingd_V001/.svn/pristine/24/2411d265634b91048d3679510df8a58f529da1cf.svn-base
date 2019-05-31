package cn.dingd.dd.biz.backgroud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.dingd.dd.biz.common.entity.AccountRole;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.biz.common.view.StaffInfoView;

/**
* @author ZC
* @date 2018年4月27日上午9:42:49
* 员工管理类
*/
public interface StaffService {

	/**
	 * 添加员工
	 */
	void addStaff(StaffInfo staffInfo,String roles, String datas);
	
	/**
	 * 查询账号信息列表
	 * @param quaryParam
	 * @return
	 */
	List<StaffInfoView> getStaffInfos(String quaryParam);

	/**
	 * 根据员工登录账号获取员工
	 * @param account
	 * @return
	 */
	StaffInfo staffByAccount(String account);
	
	/**
	 * 跟新员工
	 * @param staffInfo
	 * @param accountRoles
	 */
	void updateStaff(StaffInfo staffInfo,String  roles, String datas);
	
	/**
	 * 是否存在
	 * @param account
	 * @return
	 */
	Boolean accountIsExist(String account);
	
	/**
	 * 禁用或者启用账号
	 * @param staffId
	 * @param flag
	 */
	Integer disableorEnableAccount(Integer staffId);
	
	/**
	 * 根据员工id查询员工信息
	 * @param accountId
	 * @return
	 */
	StaffInfoView staffByPrimaryKey(Integer staffId);
	
	/**
	 * 获取数据范围
	 * @return
	 */
	List<OrganizationInfo> dataRange();
}
