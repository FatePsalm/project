package cn.dingd.dd.biz.backgroud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.biz.backgroud.service.StaffService;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
/**
 * 
 * @author zoucong
 * 账号管理类
 */
@RestController
@CrossOrigin
@RequestMapping("/staffManage")
public class StaffManageController {
	
	@Autowired
	private StaffService staffService;
	
	/**
	 * 新增账号
	 * @param accountInfo 账号id
	 * @param roleId	账号权限
	 * @param oringinID	数据范围
	 * @return
	 */
	@RequestMapping("addStaff")
	public JsonResult addAccount(StaffInfo staffInfo,String roles,String datas) {
		try {
			if (staffInfo.getAccount().length()<6) {
				throw new Exception("账号长度不小于6位");
			}
			if (!StringUtils.isNumberOrLetter(staffInfo.getAccount())) {
				throw new Exception("账号为字母或数字");
			}
			if (!StringUtils.isNumberOrLetter(staffInfo.getuPassword())) {
			throw new Exception("密码为字母或数字");
		}
			if (staffInfo.getuPassword().length()<6) {
			throw new Exception("密码长度不小于6位");
		}
			if (staffService.accountIsExist(staffInfo.getAccount())) {
			throw new Exception("账号已存在");
		}
			try {
				checkAccountInfo(staffInfo);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(e);
			}
			staffService.addStaff(staffInfo,roles,datas);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("添加失败"));
		}
		return new JsonResult("添加成功");
	}
	
	/**
	 * 账号信息列表
	 * @param quaryParam 查询参数
	 * @param page 页数	
	 * @param pageSize 每页显示条数
	 * @return
	 */
	@RequestMapping("staffs")
	public JsonResult getAccounts(String quaryParam,@RequestParam(defaultValue="1")Integer page ,
			@RequestParam(defaultValue="10")Integer pageSize) {
		try {
			return new JsonResult(staffService.getStaffInfos(quaryParam));
		}catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("数据获取失败"));
		}
	}
	
	/**
	 * 编辑账号信息
	 * @param accountInfo
	 * @return
	 */
	@RequestMapping("editStaff")
	public JsonResult updateAccount(StaffInfo staffInfo,String roles,String datas) {
		try {
			try {
				checkAccountInfo(staffInfo);
			} catch (Exception e) {
				e.printStackTrace();
				return new JsonResult(e);
			}
			staffService.updateStaff(staffInfo, roles, datas);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("修改失败"));
		}
		return new JsonResult("修改成功");
	}
	
	/**
	 * 禁用或者启用账户信息
	 * @param staffId 员工id
	 * @return
	 */
	@RequestMapping("overturnState")
	public JsonResult disableorEnableAccount(Integer staffId) {
		try {
			staffService.disableorEnableAccount(staffId);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("修改失败"));
		}
		return new JsonResult("修改成功");
	}
	
	/**
	 * 获取某个账号的信息
	 * @param accountInfo
	 * @return
	 */
	@RequestMapping("staff")
	public JsonResult getAccountByAccountId(Integer staffId) {
		try {
			return new JsonResult(staffService.staffByPrimaryKey(staffId));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("获取失败"));
		}
	}
	
	/**
	 * 获取数据范围
	 * @return
	 */
	@RequestMapping("/dataRange")
	public JsonResult dataRange() {
		try {
			List<OrganizationInfo> dataRange = staffService.dataRange();
			return new JsonResult(dataRange);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("获取数据失败"));
		}
	}

	/**
	 * 检测账号信息
	 * @param accountInfo
	 * @throws Exception
	 */
	public void checkAccountInfo(StaffInfo accountInfo) throws Exception {
		if (!StringUtils.isChinese(accountInfo.getuName())) {
			throw new Exception("用户名必须为中文");
		}
		if (!NumberUtil.isPhone(accountInfo.getuPhone())) {
			throw new Exception("电话号码格式错误");
		}
		if (accountInfo.getuSex()==null) {
			throw new Exception("性别必填");
		}
	}
}
