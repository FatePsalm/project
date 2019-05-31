package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* A端用户资金管理
*/

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManageMoneyService;

@Controller
@CrossOrigin
@RequestMapping("/mgmtMo/")
public class ManageMoneyController {
	@Resource
	private ManageMoneyService manageMoneyService;
	
	
	/** 管理端-资金管理-查询用户扣款记录 */
	@RequestMapping("doFindDeductions")
	@ResponseBody
	public JsonResult doFindDeductions(Integer id, String retrieval, PageObject pageObject) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageMoneyService.findDeductions(id, retrieval, pageObject));
	}
	/** 管理端-资金管理-查询用户冻结/解冻记录 */
	@RequestMapping("doFindFreeze")
	@ResponseBody
	public JsonResult doFindFreeze(Integer id, String retrieval, PageObject pageObject) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageMoneyService.findFreeze(id, retrieval, pageObject));
	}

	/** 管理端-资金管理-查询用户提现记录 */
	@RequestMapping("doFindWithdrawal")
	@ResponseBody
	public JsonResult doFindWithdrawal(Integer id, String retrieval, PageObject pageObject) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageMoneyService.findWithdrawal(id, retrieval, pageObject));
	}

	/** 管理端-资金管理-查询用户充值记录 */
	@RequestMapping("doFindCharge")
	@ResponseBody
	public JsonResult doFindCharge(Integer id, String retrieval, PageObject pageObject) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageMoneyService.FindCharge(id, retrieval, pageObject));
	}

	/** 管理端-资金管理-A端用户提现 */
	@RequestMapping("doWithdrawal")
	@ResponseBody
	public JsonResult doWithdrawal(Integer id, Integer money) {
		if (id == null || id < 1) {
			// 用户ID
			throw new NullPointerException("用户id不正确!");
		}
		if (money == null || money < 1) {
			// 分页信息
			throw new NullPointerException("金额不正确!");
		}
		if (!(manageMoneyService.FindBalance(id) >= money)) {
			throw new NullPointerException("余额不足!");
		}
		if (manageMoneyService.AddWithdrawal(id, money) != 1) {
			throw new NullPointerException("提现失败!");
		}
		return new JsonResult("提现成功!");
	}

	/** 管理端-资金管理-A端用户充值 */
	@RequestMapping("doAddMoney")
	@ResponseBody
	public JsonResult doAddMoney(Integer id, Integer money) {
		if (id == null || id < 1) {
			// 用户ID
			throw new NullPointerException("用户id不正确!");
		}
		if (money == null || money < 1) {
			// 分页信息
			throw new NullPointerException("金额不正确!");
		}
		if (manageMoneyService.AddMoney(id, money,"线下充值!",5,"0",0) != 1) {
			throw new NullPointerException("充值失败!");
		}
		return new JsonResult("充值成功!");
	}

	/** 管理端-资金管理-A端客服账户 */
	@RequestMapping("doFindMoney")
	@ResponseBody
	public JsonResult doFindMoney(String retrieval, PageObject pageObject) {
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageMoneyService.FindMoney(retrieval, pageObject));
	}
}
