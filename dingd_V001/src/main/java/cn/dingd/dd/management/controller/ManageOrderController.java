package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 管理端拍卖订单
*/

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.FileUtils;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.MamageOrderService;
import net.sf.json.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@CrossOrigin
@RequestMapping("/mgmtDd/")
public class ManageOrderController {
	@Resource
	private MamageOrderService mamageOrderService;
	@Resource
	private CommonService commonService;
	@Resource
	private AuctionSessionService auctionSessionService;

	/** 管理端-拍卖管理-修改时间 */
	@RequestMapping("doUpdateOrderTime")
	@ResponseBody
	public JsonResult doUpdateOrderTime(AuctionOrderEntity auctionOrderEntity) {
		// 判断订单id
		if (auctionOrderEntity.getId() < 1) {
			throw new NullPointerException("订单id为空!");
		}
		// 扣款时间
		if (auctionOrderEntity.getAbortTime() == null) {
			throw new NullPointerException("扣款时间为空!");
		}
		// 判断是不是第一次修改时间
		Date orderTime = mamageOrderService.FindAbortTime(auctionOrderEntity.getId(), 2);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(orderTime);
		// 生成订单时间+1天
		Calendar today = Calendar.getInstance();
		today.setTime(orderTime);
		today.add(Calendar.DATE, 1);
		// 计算过期时间+4小时
		calendar.add(Calendar.HOUR_OF_DAY, DateUtils.OUTTIME);
		// 计算过期时间
		Date timeOut = DateUtils.getTimeout(calendar);
		// 获取当前过期时间 状态1-截止付款时间 2-生成时间
		Date abortTime = mamageOrderService.FindAbortTime(auctionOrderEntity.getId(), 1);
		if (abortTime == null) {
			throw new NullPointerException("未获取到过期时间!");
		}
		if (abortTime.getTime() > timeOut.getTime()) {
			throw new NullPointerException("时间已经修改过一次了!");
		}
		// 判断时间超过24小时
		if (auctionOrderEntity.getAbortTime().getTime() > today.getTimeInMillis()) {
			throw new NullPointerException("修改时间超过24小时!");
		}
		// 修改时间必须大于扣款时间
		if (timeOut.getTime() >= auctionOrderEntity.getAbortTime().getTime()) {
			throw new NullPointerException("修改时间必须大于扣款时间!");
		}
		// 保存修改时间
		if (mamageOrderService.UpdateOrderTime(auctionOrderEntity) != 1) {
			throw new NullPointerException("更新时间失败!");
		}
		// 重新定时扣款时间
		try {
			QuartzTime.getQuartz(auctionOrderEntity.getAbortTime(), "order" + auctionOrderEntity.getId(), 2);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NullPointerException("更新时间失败!");
		}
		return new JsonResult("更新时间成功!");
	}

	/** 管理端-拍卖管理-操作记录判断 */
	public void isAuctionOrderTimeEntity(AuctionOrderEntity auctionOrderEntity,
			AuctionOrderTimeEntity auctionOrderTimeEntity) throws RuntimeException {
		// 判断订单id
		if (auctionOrderEntity.getId() < 1) {
			throw new NullPointerException("拍卖订Id为空!");
		}
		// 判断订单状态
		if (auctionOrderEntity.getOrderState() < 1) {
			throw new NullPointerException("拍卖订单状态为空!");
		}
		// 判断车辆id
		if (auctionOrderEntity.getCarId() < 1) {
			throw new NullPointerException("车辆ID为空!");
		}
		// 操作人类型
		if (auctionOrderTimeEntity.getPersonType() == null || auctionOrderTimeEntity.getPersonType() < 1) {
			throw new NullPointerException("发起人类型参数不正确!");
		}
		// 操作人ID
		if (auctionOrderTimeEntity.getPerson() == null || auctionOrderTimeEntity.getPerson() < 1) {
			throw new NullPointerException("发起人ID不正确!");
		}
		// 仲裁备注
		if (auctionOrderEntity.getOrderState() == 6) {
			if (auctionOrderTimeEntity.getRemark() == null || auctionOrderTimeEntity.getRemark().equals("")) {
				throw new NullPointerException("仲裁备注为空!");
			}
			// 责任方
			if (auctionOrderTimeEntity.getResponsibility() == null
					|| auctionOrderTimeEntity.getResponsibility().equals("")) {
				throw new NullPointerException("责任方为空!");
			}
			// 仲裁前状态记录
			if (auctionOrderTimeEntity.getTypeOld() == null || auctionOrderTimeEntity.getTypeOld() < 1) {
				throw new NullPointerException("仲裁前状态记录为空!");
			}
		}
		// 判断状态==4 备注是否为空
		if (auctionOrderEntity.getOrderState() == 4) {
			if (auctionOrderEntity.getRemarks() == null || auctionOrderEntity.getRemarks().equals("")) {
				throw new NullPointerException("拍卖订备注为空!");
			}
			Integer freeze = auctionOrderTimeEntity.getFreeze();
			if (freeze == null || freeze < 1 || freeze > 2) {
				throw new NullPointerException("冻结参数不正确!");
			}
		}
	}

	/** 管理端-拍卖管理-建档 */
	@RequestMapping("doUPdateInputting")
	@ResponseBody
	public JsonResult doUPdateInputting(HttpServletRequest request, MultipartFile[] file) {
		if (file == null || file.length == 0) {
			throw new NullPointerException("未获取到图片!");
		}
		// 获取数据
		String JSONText = request.getParameter("JSONText");
		if (JSONText == null || JSONText.equals("")) {
			throw new NullPointerException("未获取到数据!");
		}
		// 将数据转换为JSON
		JSONObject JSON = JSONObject.fromObject(JSONText);
		// 实例化对象
		RecordEntity recordEntity = new RecordEntity();
		// 获取车辆id
		if (JSON.getString("carId") == null || JSON.getString("carId").equals("")) {
			throw new NullPointerException("车辆id为空!");
		}
		recordEntity.setCarId(JSON.getInt("carId"));
		// 拍卖订单id
		if (JSON.getString("id") == null || JSON.getString("id").equals("")) {
			throw new NullPointerException("拍卖订单ID为空!");
		}
		recordEntity.setId(JSON.getInt("id"));
		// 建档人员
		if (JSON.getString("staffId") == null || JSON.getString("staffId").equals("")) {
			throw new NullPointerException("建档人员ID为空!");
		}
		recordEntity.setStaffId(JSON.getInt("staffId"));
		// 地区
		if (JSON.getString("region") == null || JSON.getString("region").equals("")) {
			throw new NullPointerException("建档人员ID为空!");
		}
		recordEntity.setRegion(JSON.getInt("region"));
		// 检车重复提交(一个车辆id只能建立一个档案)
		if (commonService.checkOrderRepetition(JSON.getInt("carId")) > 0) {
			throw new NullPointerException("车辆建档已存在!");
		}
		// 将图片分类上传到服务器
		List<RecordPictureEntity> list = new ArrayList<>();
		for (MultipartFile mFile : file) {
			RecordPictureEntity recordPictureEntity = new RecordPictureEntity();
			String string = mFile.getOriginalFilename().replaceAll("\\d", "");
			String fileName = string.substring(0, string.indexOf("."));
			if (fileName.toUpperCase().equals("INVOICE")) {
				// 发票
				recordPictureEntity.setTypeNumber(1);
			} else if (fileName.toUpperCase().equals("INTERIM")) {
				// 新行驶证/临时号牌
				recordPictureEntity.setTypeNumber(2);
			} else {
				// 登记证书/大档照片
				recordPictureEntity.setTypeNumber(3);
			}
			// 上传照片
			String newFileName = UUID.randomUUID().toString() + "."
					+ FilenameUtils.getExtension(mFile.getOriginalFilename());// 文件扩展名
			try {
				FileUtils.byte2File(mFile.getBytes(), Constant.UP_RECORD, newFileName);
			} catch (Exception e) {
				throw new NullPointerException("上传图片失败!");
			}
			recordPictureEntity.setUrl(Constant.RECORD + newFileName);
			list.add(recordPictureEntity);
		}
		// 建档
		mamageOrderService.addRecord(JSON.getInt("id"), recordEntity, list);
		return new JsonResult("建档成功!");
	}

	/** 管理端-拍卖管理-订单状态修改 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中 7-继续交易 */
	@RequestMapping("doUPdateOrder")
	@ResponseBody
	public JsonResult doUPdateOrder(AuctionOrderEntity auctionOrderEntity,
			AuctionOrderTimeEntity auctionOrderTimeEntity) {
		// 写入操作判断
		isAuctionOrderTimeEntity(auctionOrderEntity, auctionOrderTimeEntity);
		auctionOrderTimeEntity.setAuctionOrderId(auctionOrderEntity.getId());
		auctionOrderTimeEntity.setOperatingState(1);
		auctionOrderTimeEntity.setType(auctionOrderEntity.getOrderState());
		if (mamageOrderService.UPdateOrder(auctionOrderEntity, auctionOrderTimeEntity) != 1) {
			throw new NullPointerException("更新失败!");
		}
		return new JsonResult("更新状态成功!");
	}

	/** 管理端-拍卖管理-拍卖订单查询 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中 */
	@RequestMapping("doFindOrder")
	@ResponseBody
	public JsonResult doFindOrder(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		if (checkQueryEntity.getStartTime() != null && checkQueryEntity.getOverTime() != null) {
			if (checkQueryEntity.getStartTime().getTime() > checkQueryEntity.getOverTime().getTime()) {
				throw new NullPointerException("开始时间需要小于结束时间!");
			}
		}
		if (checkQueryEntity.getOrderState() < 1) {
			throw new NullPointerException("拍卖订单状态为空!");
		}
		if (pageObject.getPageSize() < 1) {
			throw new NullPointerException("分页信息为空!");
		}
		Map<String, Object> map = null;
		try {
			map = mamageOrderService.FindOrder(checkQueryEntity, pageObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(map);
	}

}
