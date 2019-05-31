package cn.dingd.dd.biz.backgroud.controller;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.biz.backgroud.service.PermissionService;
import cn.dingd.dd.biz.common.entity.AccountInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.shiro.realm.BizBackGroundRealm;
import cn.dingd.dd.common.web.JsonResult;

/**
* @author ZC
* @date 2018年4月24日上午10:15:54
* 权限(菜单)管理
*/
@RestController
@CrossOrigin
@RequestMapping("permission")
public class PermissionManageController {
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private BizBackGroundRealm bizBackGroundRealm;
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	@RequestMapping("menuList")
	public JsonResult menuList() {
		try {
			return new JsonResult(permissionService.menuList());
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult("获取信息失败");
		}
	}
	
	/**
	 * 获取用户菜单
	 * @return
	 */
	@RequestMapping("userMenuList")
	public JsonResult menuListByUserid(HttpSession session) {
		try {
			StaffInfo attribute = (StaffInfo)session.getAttribute("bizAccount");
			return new JsonResult(permissionService.userPermission(attribute.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("获取信息失败"));
		}
	}
	
	
	
	/**
	 * 清理缓存
	 * @param id
	 * @return
	 */
	@RequestMapping("clearCache")
	public JsonResult clearAuthorized(Integer id) {
		try {
			 Integer [] integers = {id};
			bizBackGroundRealm.clearUserAuthByUserId(integers);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("缓存清理失败"));
		}
		return new JsonResult("缓存清理成功");
	}
	
	/**
	 * 未授权跳转
	 * @return
	 */
	@RequestMapping("unauthorized")
	public JsonResult unauthorizedUrl() {
		JsonResult jsonResult = new JsonResult(new Exception("权限不足请联系管理员！"),401);
		return jsonResult;
	}
	
	/**
	 * 未认证跳转
	 * @return
	 */
	@RequestMapping("unauthenzed")
	public JsonResult unauthenzed() {
		return new JsonResult(new Exception("请先登录!"),1404);
	}
}
