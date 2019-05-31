package cn.dingd.dd.auction.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.auction.service.StaffInfoService;
import cn.dingd.dd.auction.service.UserInfoService;
import cn.dingd.dd.common.entity.AUserEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月10日 下午2:21:26 类说明 注册相关
 */
@CrossOrigin
@Controller
@RequestMapping("/Registration/")
public class RegistrationController {
	@Resource
	private CommonService common;
	@Resource
	private StaffInfoService staffService;
	@Resource
	private UserInfoService userInfoService;

	/** 短信测试 */
	@RequestMapping("doSMS")
	@ResponseBody
	public JsonResult doSMS(AUserEntity aUserEntity) {
		return new JsonResult(common.RandomCodeOut(aUserEntity.getAccount(), 1, 0));
	}

	/** 注册账号查询 */
	@RequestMapping("doAUserNameCheck")
	public JsonResult doAUserNameCheck(AUserEntity aUserEntity) {
		if (aUserEntity == null) {
			throw new NullPointerException("用户为空!");
		}
		return new JsonResult(common.UserNameCheck(aUserEntity.getAccount()));
	}

	/** 注册推荐人查询 */
	@RequestMapping("doARecommendCheck")
	@ResponseBody
	public JsonResult doARecommendCheck(AUserEntity aUserEntity) {
		if (aUserEntity == null) {
			throw new NullPointerException("用户为空!");
		}
		return new JsonResult("");
	}

	/** 拍卖端用户 注册账号 */
	@RequestMapping("doAUserReg")
	@ResponseBody
	public JsonResult doAUserReg(AUserEntity aUserEntity, Integer isRmd) {

		try {
			if (!StringUtils.isNotNullStr(aUserEntity.getAccount())) {
				return new JsonResult(new NullPointerException("手机号为空!"), 1008);
			}
			if (userInfoService.getAUserEntityId(aUserEntity.getAccount()) > 0) {
				return new JsonResult(new NullPointerException("你已注册！"), 1010);
			}
			if (NumberUtil.isPhone(aUserEntity.getAccount())) {
				aUserEntity.setNickname(aUserEntity.getAccount().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));// 保护隐私
																													// 默认昵称
			} else {
				return new JsonResult(new NullPointerException("手机号格式不正确!"), 1003);
			}

			if (!StringUtils.isNotNullStr(aUserEntity.getPassword())) {
				return new JsonResult(new NullPointerException("验证码不能为空!"), 1005);
			}
			if (isRmd == null) {
				return new JsonResult(new NullPointerException("是否有推荐人!"), 1009);
			}
			if (isRmd == 0) {
				if (!StringUtils.isNotNullStr(aUserEntity.getRecommend())) {
					return new JsonResult(new NullPointerException("推荐人手机号为空!"), 1006);
				}
				if (!NumberUtil.isPhone(aUserEntity.getRecommend())) {
					return new JsonResult(new NullPointerException("推荐人手机号格式不正确!"), 1004);
				}
				int sid = staffService.regCheckUser(aUserEntity.getRecommend());
				if (sid <= 0) {
					int uid = userInfoService.getAUserEntityId((aUserEntity.getRecommend()));
					if (uid <= 0) {
						return new JsonResult(new NullPointerException("没有此推荐人！"), 1007);
					}
				}
				aUserEntity.setFlag(1);
			} else {
				aUserEntity.setFlag(2);
			}
			// 匹配验证
			if (!common.RandomCodeCheck(aUserEntity.getAccount(), aUserEntity.getPassword())) {
				return new JsonResult(new NullPointerException("验证码错误!"), 1002);
			}
			aUserEntity.setRegisterTime(new Date());
			aUserEntity.setuPhone(aUserEntity.getAccount());
			aUserEntity.setSex(2);
			/** 是否具备注册条件 */
			int id = userInfoService.aUserRegistration(aUserEntity);
			if (id > 0) {
				return new JsonResult();
			} else {
				return new JsonResult(new Exception("注册失败！"), 1001);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception(e.getMessage()), 1001);
		}

	}

}
