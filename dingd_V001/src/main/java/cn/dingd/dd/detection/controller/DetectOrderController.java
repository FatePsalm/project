package cn.dingd.dd.detection.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dingd.dd.common.entity.CarBrandsInfoEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.entity.CarModelInfoEntity;
import cn.dingd.dd.common.entity.CarPictureEntity;
import cn.dingd.dd.common.entity.CarSeriesInfoEntity;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.CityMapEntiyt;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.Commons;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.FileUtils;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.detection.service.DetectOrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月17日 上午10:34:22
 * @category 检测订单
 */
@Controller
@CrossOrigin // 跨域
@RequestMapping("/DetectOrder/")
public class DetectOrderController {
	@Resource
	private DetectOrderService detectOrderService;
	@Resource
	private CommonService commonService;

	/** 上传车辆检测订单 */
	@RequestMapping("DoCheckUpload")
	@ResponseBody
	public JsonResult DoCheckUpload(HttpServletRequest request, MultipartFile[] file) {
		// 获取损伤数据-显性损伤
		String dominantText = request.getParameter("dominant");
		// 获取损伤数据-隐性损伤
		String recessiveText = request.getParameter("recessive");
		// 获取车辆检数据
		String otherText = request.getParameter("otherText");
		// 转换损伤数据为JSON-显性损伤
		JSONObject dominanTextJson = JSONObject.fromObject(dominantText);
		// 转换损伤数据为JSON-隐性损伤
		JSONObject recessiveTextJson = JSONObject.fromObject(recessiveText);
		// 转换车辆检测数据为JSON
		JSONObject otherTextJson = JSONObject.fromObject(otherText);
		// 上传检测端车辆基本信息
		TCarBasisInfoEntity tCarBasisInfoEntity = null;
		// 显性损伤
		List<CarDominantEntity> carDominantList;
		// 隐性损伤
		List<CarDamageEntity> carDamageList;
		// 证件+写真图片
		List<CarPictureEntity> carPictureList;
		try {
			// 返回为车辆信息
			tCarBasisInfoEntity = TCarBasisInfoEntityJson(otherTextJson);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException(e.getMessage());
		}
		// 当车牌号VIN重复不能上传
		if (detectOrderService.findVIN(tCarBasisInfoEntity.getCarNumber(), tCarBasisInfoEntity.getVinNumber()) != 0) {
			throw new NullPointerException("车牌/VIN重复!");
		}
		try {
			// 显性损伤
			carDominantList = carDominant(dominanTextJson, file, new ArrayList<>());
			// 获取隐性损伤
			carDamageList = carDamage(recessiveTextJson, new ArrayList<>());
			// 获取图片
			carPictureList = getCarPictures(file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException("解析损伤JSON失败!");
		}
		try {
			detectOrderService.CheckUpload(tCarBasisInfoEntity, carDominantList, carDamageList, carPictureList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException("保存检测信息异常!");
		}
		return new JsonResult("上传成功.");
	}

	/** 行驶证识别 */
	@RequestMapping("doAddImg")
	@ResponseBody
	public JsonResult doAddImg(MultipartFile[] file) {
		if (file == null || file.length == 0) {
			throw new NullPointerException("上传图片为空!");
		}
		Map<String, Object> map = commonService.GetVehicleORC(file);
		return new JsonResult(map);
	}

	/** 解析损伤部位-隐性损伤 */
	List<CarDamageEntity> carDamage(JSONObject recessiveText, List<CarDamageEntity> list) {
		Iterator<String> iterator = recessiveText.keys();
		while (iterator.hasNext()) {
			// 获得key
			String key = iterator.next();
			String value = recessiveText.getString(key);
			Integer valueCheck = recessiveText.getInt(key);
			if (valueCheck == null || valueCheck == 1) {
				continue;
			}
			int[] typeAndValue = getTypeAndValue(key);
			CarDamageEntity carDamageEntity = new CarDamageEntity();
			carDamageEntity.setDamageType(String.valueOf(typeAndValue[0]));
			carDamageEntity.setTypeNumber(String.valueOf(typeAndValue[1]));
			carDamageEntity.setRecessive(value);
			list.add(carDamageEntity);
		}
		return list;
	}

	/**
	 * 解析损伤部位-显性损伤
	 * 
	 * @throws Exception
	 */
	List<CarDominantEntity> carDominant(JSONObject damageText, MultipartFile[] file,
			List<CarDominantEntity> resultsList) {
		Map<String, Object> map = damageText;
		Map<String, String> imgPars = new HashMap<>();
		List<MultipartFile> list = new ArrayList<>();
		try {
			list.addAll(ImageClassification(file, "appearance"));
			list.addAll(ImageClassification(file, "skeleton"));
			list.addAll(ImageClassification(file, "interior"));
			imgPars = imgPars(list, new HashMap<>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NullPointerException("显性损伤图片解析失败!");
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object Value = entry.getValue();
			// 解析value
			JSONArray fromObject = JSONArray.fromObject(Value);
			Iterator<Object> it = fromObject.iterator();
			int sort = 0;
			while (it.hasNext()) {
				CarDominantEntity carDominantEntity = new CarDominantEntity();
				// 解析key
				carDominantEntity.setImgRemark(key);
				JSONObject ob = (JSONObject) it.next();
				carDominantEntity.setDominant(ob.getString("dominant"));
				carDominantEntity.setDamageType(ob.getInt("damageType"));
				carDominantEntity.setTypeNumber(ob.getInt("typeNumber"));
				carDominantEntity.setCarDescribe(ob.getInt("carDescribe"));
				carDominantEntity.setXy(ob.getString("xy"));
				carDominantEntity.setSort(sort);
				// 损伤类型_损伤位置_排序
				carDominantEntity.setTag(carDominantEntity.getDamageType().toString()
						+ carDominantEntity.getTypeNumber().toString() + carDominantEntity.getSort());
				// 获取url
				carDominantEntity.setImgUrl(imgPars != null ? imgPars.get(carDominantEntity.getTag()) : "");
				resultsList.add(carDominantEntity);
				sort++;
			}
		}
		return resultsList;
	}

	/** 修改检测订单 */
	@RequestMapping("setOrderState")
	@ResponseBody
	public JsonResult setOrderState(CheckBillEntity checkBillEntity) {
		return new JsonResult(
				detectOrderService.setCheckState(checkBillEntity.getId(), checkBillEntity.getCheckStatus()));
	}

	/** 查询检测单图片属性 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("DoGetImgInfo")
	@ResponseBody
	public JsonResult DoGetImgInfo(String code) {
		List ls = new ArrayList<>();
		ls.add(code);
		try {
			return new JsonResult(commonService.GetImgInfo(ls));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e, 1003);
		}
	}

	/** 城市ID查询下属地区 */
	@RequestMapping("DoGetAreaId")
	@ResponseBody
	public JsonResult DoGetAreaId(CityMapEntiyt cityMapEntiyt) {
		return new JsonResult(commonService.GetAreaId(cityMapEntiyt));
	}

	/** 验证码授权检测车辆验证码匹配 */
	@RequestMapping("DoFindAuthorizationCheck")
	@ResponseBody
	public JsonResult DoFindAuthorizationCheck(CheckBillEntity checkBillEntity, String password) {
		try {
			return new JsonResult(detectOrderService.FindAuthorizationCheck(checkBillEntity, password));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e);
		}
	}

	/** 根据联系人信息发送验证码授权 */
	@RequestMapping("DoFindAuthorization")
	@ResponseBody
	public JsonResult DoFindAuthorization(CheckBillEntity checkBillEntity) {
		return new JsonResult(detectOrderService.FindAuthorization(checkBillEntity));
	}

	/** 根据车辆ID获取配置 */
	@RequestMapping("DoFindCarIDInfo")
	@ResponseBody
	public JsonResult DoFindCarIDInfo(CarModelInfoEntity carModelInfoEntity) {
		return new JsonResult(detectOrderService.FindCarIDInfo(carModelInfoEntity));
	}

	/** 根据车辆ID查询车型款式信息 */
	@RequestMapping("DoFindCarModelInfo")
	@ResponseBody
	public JsonResult DoFindCarModelInfo(CarSeriesInfoEntity carSeriesInfoEntity) {
		return new JsonResult(detectOrderService.FindCarModelInfo(carSeriesInfoEntity));
	}

	/** 根据品牌ID查询车系列信息 */
	@RequestMapping("DoFindCarSeriesInfo")
	@ResponseBody
	public JsonResult DoFindCarSeriesInfo(CarBrandsInfoEntity carBrandsInfoEntity) {
		return new JsonResult(detectOrderService.FindCarSeriesInfo(carBrandsInfoEntity));
	}

	/** 返回所有的车辆品牌 */
	@RequestMapping("DoCarInfoAll")
	@ResponseBody
	public JsonResult DoCarInfoAll(CarBrandsInfoEntity carBrandsInfoEntity) {
		return new JsonResult(detectOrderService.CarInfoAll(carBrandsInfoEntity));
	}

	/** 我的订单中心 */
	@RequestMapping("DoMyDetectOrder")
	@ResponseBody
	public JsonResult DoMyDetectOrder(StaffInfoEntity staffInfo, PageObject pageObject, Integer checkStatus) {
		return new JsonResult(detectOrderService.MyDetectOrder(staffInfo, pageObject, 1));
	}

	/** 我的订单中心待上传订单 */
	@RequestMapping("DoMyDetectOrderWait")
	@ResponseBody
	public JsonResult DoMyDetectOrderWait(StaffInfoEntity staffInfo, PageObject pageObject, Integer checkStatus) {
		return new JsonResult(detectOrderService.MyDetectOrder(staffInfo, pageObject, 2));
	}

	/** 我的订单中心完成订单 */
	@RequestMapping("DoMyDetectOrderOver")
	@ResponseBody
	public JsonResult DoMyDetectOrderOver(StaffInfoEntity staffInfo, PageObject pageObject, Integer checkStatus) {
		return new JsonResult(detectOrderService.MyDetectOrder(staffInfo, pageObject, 3));
	}

	/** 根据检测订单查询是否重复提交信息 */
	public int detectUpload(int checkBillId) {
		return detectOrderService.detectUpload(checkBillId);
	}

	/** 我的订单中心修改订单时间 */
	@RequestMapping("DoUpdateTime")
	@ResponseBody
	public JsonResult DoUpdateTime(CheckBillEntity checkBillEntity) {
		if (detectOrderService.UpdateTime(checkBillEntity) == 0) {
			throw new NullPointerException("更新失败!");
		}
		return new JsonResult("更新成功!");
	}

	/** 提取车辆信息 */
	public TCarBasisInfoEntity TCarBasisInfoEntityJson(JSONObject json) throws Exception {
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		// =====================================开始提取属性
		if (!StringUtils.isNotNullStr(json.getString("checkBillId"))) {
			// 检测单ID
			throw new Exception("检测单ID为空!");
		} else {
			int checkBillIdId = detectOrderService.getcheckBillId(json.getString("checkBillId"));
			if (detectUpload(checkBillIdId) > 1) {
				// 车辆信息已存在
				throw new Exception("车辆信息已存在!");
			}
			tCarBasisInfoEntity.setCheckBillId(checkBillIdId);
		}
		if (!StringUtils.isNotNullStr(json.getString("aOrB"))) {
			// 选择发布端状态(A端/B端)
		} else {
			tCarBasisInfoEntity.setaOrB(json.getInt(("aOrB")));
		}
		if (!StringUtils.isNotNullStr(json.getString("retentionMoney"))
				&& Float.parseFloat(json.getString("retentionMoney")) > 0) {
			// 保留价格(万元)
			throw new Exception("保留价为空!");
		} else {
			// 保留价万元转换为元
			tCarBasisInfoEntity.setRetentionMoney((Float.parseFloat(json.getString("retentionMoney"))) * 10000);
		}
		if (json.get("masterType") == null || json.getString("masterType").trim().equals("")) {
			// 车主信息1(个人)2(企业)3(机构)
			throw new Exception("车主性质为空!");
		} else {
			tCarBasisInfoEntity.setMasterType(json.getInt("masterType"));
		}
		if (!StringUtils.isNotNullStr(json.getString("master"))) {
			// 车主/联系人
			throw new Exception(" 车主/联系人为空!");
		} else {
			tCarBasisInfoEntity.setMaster(json.getString("master"));
		}
		if (tCarBasisInfoEntity.getMasterType() == 1) {
			// 车主/联系人/身份证
			tCarBasisInfoEntity.setCard(json.getString("card"));
		}
		if (!StringUtils.isNotNullStr(json.getString("phone"))) {
			// 车主/联系人/联系方式
			throw new Exception(" 车主/联系人/联系方式为空!");
		} else {
			tCarBasisInfoEntity.setPhone(json.getString("phone"));
		}
		if (!StringUtils.isNotNullStr(json.getString("province"))) {
			// 所在省份
			// throw new NullPointerException(" 所在省份为空!");
		} else {
			tCarBasisInfoEntity.setProvince(json.getString("province"));
		}
		if (!StringUtils.isNotNullStr(json.getString("city"))) {
			// 所在市
			// throw new NullPointerException(" 所在市为空!");
		} else {
			tCarBasisInfoEntity.setCity(json.getString("city"));
		}
		if (!StringUtils.isNotNullStr(json.getString("zone"))) {
			// 所在区
			// throw new NullPointerException(" 所在区为空!");
		} else {
			tCarBasisInfoEntity.setZone(json.getString("zone"));
		}
		if (!StringUtils.isNotNullStr(json.getString("detail"))) {
			// 详细地址
			// throw new NullPointerException(" 详细地址为空!");
		} else {
			tCarBasisInfoEntity.setDetail(json.getString("detail"));
		}
		// 机构或者企业执行下列代码
		// ============================================
		if (json.getInt("masterType") != 1) {
			if (!StringUtils.isNotNullStr(json.getString("enterprise"))) {
				// 车主姓名/企业名称/机构名称
				throw new Exception(" 车主姓名/企业名称/机构名称为空!");
			} else {
				tCarBasisInfoEntity.setEnterprise(json.getString("enterprise"));
			}
			if (!StringUtils.isNotNullStr(json.getString("etpCard"))) {
				// 营业执照/三合一
				throw new Exception(" 营业执照/三合一为空!");
			} else {
				tCarBasisInfoEntity.setEtpCard(json.getString("etpCard"));
			}
		}
		// ==============================================行驶证
		if (!StringUtils.isNotNullStr(json.getString("vinNumber"))) {
			// VIN码
			throw new NullPointerException(" VIN码为空!");
		} else {
			tCarBasisInfoEntity.setVinNumber(json.getString("vinNumber"));
		}
		if (!StringUtils.isNotNullStr(json.getString("carNumber"))) {
			// 车牌号
			throw new NullPointerException(" 车牌号为空!");
		} else {
			tCarBasisInfoEntity.setCarNumber(json.getString("carNumber"));
		}
		if (!StringUtils.isNotNullStr(json.getString("engineNum"))) {
			// 发动机号
			throw new NullPointerException(" 发动机号为空!");
		} else {
			tCarBasisInfoEntity.setPowerNumber(json.getString(("engineNum")));
		}
		if (!StringUtils.isNotNullStr(json.getString("vehicleType"))) {
			// 车辆类型
			throw new NullPointerException(" 车辆类型为空!");
		} else {
			tCarBasisInfoEntity.setCarType(json.getString("vehicleType"));
		}
		if (!StringUtils.isNotNullStr(json.getString("useCharacter"))) {
			// 使用性质
			throw new NullPointerException(" 使用性质为空!");
		} else {
			tCarBasisInfoEntity.setCarUseType(json.getString(("useCharacter")));
		}
		if (!StringUtils.isNotNullStr(json.getString("registerDate"))) {
			throw new NullPointerException(" 注册时间为空!");
		} else {
			try {
				tCarBasisInfoEntity.setReTime(DateUtils.stringToDate(json.getString("registerDate"), "yyyy-MM-dd"));
			} catch (Exception e) {
				throw new NullPointerException(" 注册时间转换异常!");
			}
		}
		if (!StringUtils.isNotNullStr(json.getString("yearTime"))) {
			throw new NullPointerException("发证时间为空!");
		} else {
			try {
				tCarBasisInfoEntity.setYearTime(DateUtils.stringToDate(json.getString("registerDate"), "yyyy-MM-dd"));
			} catch (Exception e) {
				throw new NullPointerException("发证时间转换异常!");
			}
		}
		// ==================================购车信息判断
		if (!StringUtils.isNotNullStr(json.getString("changeNumber"))) {
			// 过户次数
			throw new NullPointerException("过户次数为空!");
		} else {
			tCarBasisInfoEntity.setChangeNumber(json.getInt(("changeNumber")));
		}
		if (!StringUtils.isNotNullStr(json.getString("changeMoney"))) {
			// 上次过户价格
		} else {
			tCarBasisInfoEntity.setChangeMoney((json.getDouble(("changeMoney"))) * 10000);
		}
		if (!StringUtils.isNotNullStr(json.getString("paper"))) {
			// 票据
		} else {
			tCarBasisInfoEntity.setPaper(json.getInt(("paper")));
		}
		if (StringUtils.isNotNullStr(json.getString("changeTime"))) {
			try {
				tCarBasisInfoEntity.setChangeTime(DateUtils.stringToDate(json.getString("changeTime"), "yyyy-MM-dd"));
			} catch (Exception e) {
				throw new NullPointerException("过户时间获取异常!");
			}
		}
		// ==============================================基本配置
		if (!StringUtils.isNotNullStr(json.getString("carName"))) {
			// 车型选择(品牌)
			throw new NullPointerException(" 车型选择(品牌)为空!");
		} else {
			tCarBasisInfoEntity.setCarName(json.getString(("carName")));
		}
		if (!StringUtils.isNotNullStr(json.getString("cars"))) {
			// 车型选择(车系)
			throw new NullPointerException(" 车型选择(车系)为空!");
		} else {
			tCarBasisInfoEntity.setCars(json.getString(("cars")));
		}
		if (!StringUtils.isNotNullStr(json.getString("carModel"))) {
			// 车型选择(车型款式)
			throw new NullPointerException(" 车型选择(车型款式)为空!");
		} else {
			tCarBasisInfoEntity.setCarModel(json.getString(("carModel")));
		}
		if (!StringUtils.isNotNullStr(json.getString("carModel"))) {
			// 动力类型
			// throw new NullPointerException("动力类型为空!");
		} else {
			tCarBasisInfoEntity.setPowerType(json.getString(("powerType")));
		}

		if (json.get("motorPower") == null) {
			// 电机功率
			// throw new NullPointerException("动力类型为空!");
		} else {
			tCarBasisInfoEntity.setMotorPower(json.getString(("motorPower")));
		}
		// ==================================================
		if (!StringUtils.isNotNullStr(json.getString("displacement"))) {
			// 排量
			// throw new NullPointerException("排量为空!");
		} else {
			tCarBasisInfoEntity.setDisplacement(json.getString(("displacement")));
		}
		if (!StringUtils.isNotNullStr(json.getString("turbo"))) {
			// 是否涡轮增压0自吸 1增压
			tCarBasisInfoEntity.setTurbo(0);
		} else {
			tCarBasisInfoEntity.setTurbo(1);
		}
		if (!StringUtils.isNotNullStr(json.getString("transmission"))) {
			// 变速箱类型
			// throw new NullPointerException("变速箱类型为空!");
		} else {
			tCarBasisInfoEntity.setTransmission(json.getString(("transmission")));
		}
		if (!StringUtils.isNotNullStr(json.getString("skylight"))) {
			// 天窗类型
			// throw new NullPointerException("天窗类型为空!");
		} else {
			tCarBasisInfoEntity.setSkylight(json.getString(("skylight")));
		}
		if (!StringUtils.isNotNullStr(json.getString("color"))) {
			// 车辆颜色
			throw new NullPointerException("车辆颜色为空!");
		} else {
			tCarBasisInfoEntity.setColor(json.getString(("color")));
		}
		if (!StringUtils.isNotNullStr(json.getString("keyS"))) {
			// 钥匙数量
			// throw new NullPointerException("钥匙数量为空!");
		} else {
			tCarBasisInfoEntity.setKeys(json.getInt(("keyS")));
		}
		if (!StringUtils.isNotNullStr(json.getString("manufacture"))) {
			// 出厂日期
			// throw new NullPointerException("出厂日期为空!");
		} else {
			try {
				tCarBasisInfoEntity.setManufacture(DateUtils.stringToDate(json.getString("manufacture"), "yyyy-MM-dd"));
			} catch (Exception e) {
				throw new NullPointerException("出厂日期转换异常!");
			}
		}
		if ((json.get("mileage")==null)) {
			// 行驶里程
			throw new NullPointerException("行驶里程/格式不正确!");
		} else {
			tCarBasisInfoEntity.setMileage((json.getDouble("mileage"))*10000);
		}
		if (StringUtils.isNotNullStr(json.getString("consistent"))) {
			// 被保人是否与车主一致
			tCarBasisInfoEntity.setConsistent(json.getInt("consistent"));
		}
		// 交强险到期时间
		if (StringUtils.isNotNullStr(json.getString("insuranceTime"))) {
			try {
				tCarBasisInfoEntity
						.setInsuranceTime(DateUtils.stringToDate(json.getString("insuranceTime"), "yyyy-MM-dd"));
			} catch (Exception e) {
				throw new NullPointerException("交强险到期时间转换异常!");
			}
		} else {
			throw new NullPointerException("交强险到期时间空!");
		}
		if (StringUtils.isNotNullStr(json.getString("business"))) {
			tCarBasisInfoEntity.setBusiness(json.getString("business"));
			// 商业险是否
			if (tCarBasisInfoEntity.getBusiness().equals("1")) {
				// 商业险到期时间
				if (StringUtils.isNotNullStr(json.getString("bOverTime"))
						&& StringUtils.isNotNullStr(json.getString("bMoney"))) {
					try {
						tCarBasisInfoEntity.setbMoney(json.getDouble("bMoney"));
						tCarBasisInfoEntity
								.setbOverTime(DateUtils.stringToDate(json.getString("bOverTime"), "yyyy-MM-dd"));
					} catch (Exception e) {
						throw new NullPointerException("商业险到期时间转换异常!");
					}
				} else {
					throw new NullPointerException("商业险到期时间空/商业险金额为空!");
				}
			}
		}
		// ============================================综合评测
		if (!StringUtils.isNotNullStr(json.getString("synthesise"))) {
			// 综合评价重要损伤
			// throw new NullPointerException("综合评价重要损伤为空!");
		} else {
			tCarBasisInfoEntity.setSynthesise(json.getString(("synthesise")));
		}
		if (!StringUtils.isNotNullStr(json.getString("conditionId"))) {
			// 综合评价综合车况评级
			throw new NullPointerException("综合评价综合车况评级为空!");
		} else {
			tCarBasisInfoEntity.setConditionId(json.getString(("conditionId")));
		}
		if (!StringUtils.isNotNullStr(json.getString("maintenance"))) {
			// 评价维护成本评价
			throw new NullPointerException("评价维护成本评价为空!");
		} else {
			tCarBasisInfoEntity.setMaintenance(json.getInt(("maintenance")));
		}
		if (!StringUtils.isNotNullStr(json.getString("remarks"))) {
			// 综合评测
			throw new NullPointerException("综合评测为空!");
		} else {
			tCarBasisInfoEntity.setRemarks(json.getString(("remarks")));
		}
		if (!StringUtils.isNotNullStr(json.getString("mortgage"))) {
			// throw new NullPointerException("抵押不能为空!");
		} else {
			tCarBasisInfoEntity.setMortgage(json.getInt("mortgage"));
		}

		// 内饰/车窗/座椅/方向盘/多功能按键检查
		tCarBasisInfoEntity.setAcoustics(json.get("acoustics") == null ? null : json.getString("acoustics"));
		tCarBasisInfoEntity
				.setAcousticsRemark(json.get("acousticsRemark") == null ? null : json.getString("acousticsRemark"));
		tCarBasisInfoEntity
				.setSkylightCheck(json.get("skylightCheck") == null ? null : json.getString(("skylightCheck")));
		tCarBasisInfoEntity
				.setSkylightRemark(json.get("skylightRemark") == null ? null : json.getString(("skylightRemark")));
		tCarBasisInfoEntity.setDoor(json.get("door") == null ? null : json.getString(("door")));
		tCarBasisInfoEntity.setDoorRemark(json.get("doorRemark") == null ? null : json.getString(("doorRemark")));
		tCarBasisInfoEntity.setLighting(json.get("lighting") == null ? null : json.getString(("lighting")));
		tCarBasisInfoEntity
				.setLightingRemark(json.get("lightingRemark") == null ? null : json.getString(("lightingRemark")));
		tCarBasisInfoEntity.setElectric(json.get("electric") == null ? null : json.getString(("electric")));
		tCarBasisInfoEntity
				.setElectricRemark(json.get("electricRemark") == null ? null : json.getString(("electricRemark")));
		tCarBasisInfoEntity.setHot(json.get("hot") == null ? null : json.getString(("hot")));
		tCarBasisInfoEntity.setHotRemark(json.get("hotRemark") == null ? null : json.getString(("hotRemark")));
		tCarBasisInfoEntity.setSteering(json.get("steering") == null ? null : json.getString(("steering")));
		tCarBasisInfoEntity
				.setSteeringRemark(json.get("steeringRemark") == null ? null : json.getString(("steeringRemark")));
		tCarBasisInfoEntity.setSafety(json.get("safety") == null ? null : json.getString(("safety")));
		tCarBasisInfoEntity.setSafetyRemark(json.get("safetyRemark") == null ? null : json.getString(("safetyRemark")));
		tCarBasisInfoEntity.setAirbag(json.get("airbag") == null ? null : json.getString(("airbag")));
		tCarBasisInfoEntity.setAirbagRemark(json.get("airbagRemark") == null ? null : json.getString(("airbagRemark")));
		tCarBasisInfoEntity.setParking(json.get("parking") == null ? null : json.getString(("parking")));
		tCarBasisInfoEntity
				.setParkingRemark(json.get("parkingRemark") == null ? null : json.getString(("parkingRemark")));
		tCarBasisInfoEntity
				.setMortgagePeriod(json.get("mortgagePeriod") == null ? null : json.getString("mortgagePeriod"));// 抵押周期

		tCarBasisInfoEntity.setBooster(json.get("booster") == null ? null : json.getString(("booster")));
		tCarBasisInfoEntity.setStart(json.get("start") == null ? null : json.getString(("start")));
		tCarBasisInfoEntity.setCooling(json.get("cooling") == null ? null : json.getString("cooling"));
		tCarBasisInfoEntity.setJack(json.get("jack") == null ? null : json.getString(("jack")));
		tCarBasisInfoEntity.setSpare(json.get("spare") == null ? null : json.getString(("spare")));
		tCarBasisInfoEntity.setAttrition(json.get("attrition") == null ? null : json.getString(("attrition")));
		tCarBasisInfoEntity.setTools(json.get("tools") == null ? null : json.getString(("tools")));
		tCarBasisInfoEntity.setExtinguisher(json.get("extinguisher") == null ? null : json.getString(("extinguisher")));
		tCarBasisInfoEntity.setPlacard(json.get("placard") == null ? null : json.getString(("placard")));
		tCarBasisInfoEntity.setStall(json.get("stall") == null ? null : json.getString(("stall")));
		tCarBasisInfoEntity.setSpeed(json.get("speed") == null ? null : json.getString(("speed")));
		tCarBasisInfoEntity.setBurning(json.get("burning") == null ? null : json.getString(("burning")));
		tCarBasisInfoEntity.setDamping(json.get("damping") == null ? null : json.getString(("damping")));
		tCarBasisInfoEntity.setClutch(json.get("clutch") == null ? null : json.getString(("clutch")));
		tCarBasisInfoEntity.setMuffler(json.get("muffler") == null ? null : json.getString("muffler"));
		tCarBasisInfoEntity.setSuspension(json.get("suspension") == null ? null : json.getString(("suspension")));
		// 优先级
		tCarBasisInfoEntity.setPriorityLevel(0);
		// 计算起拍价
		tCarBasisInfoEntity
				.setAskingPrice(Commons.getCarMoney(Float.parseFloat(json.getString("retentionMoney"))) * 10000);
		// 设置车辆状态
		tCarBasisInfoEntity.setCarState(1);
		tCarBasisInfoEntity
				.setBoosterRemark(json.get("boosterRemark") == null ? null : json.getString(("boosterRemark")));
		tCarBasisInfoEntity.setStartRemark(json.get("startRemark") == null ? null : json.getString(("startRemark")));
		tCarBasisInfoEntity
				.setCoolingRemark(json.get("coolingRemark") == null ? null : json.getString(("coolingRemark")));
		tCarBasisInfoEntity.setJackRemark(json.get("jackRemark") == null ? null : json.getString(("jackRemark")));
		tCarBasisInfoEntity.setSpareRemark(json.get("spareRemark") == null ? null : json.getString(("spareRemark")));
		tCarBasisInfoEntity
				.setAttritionRemark(json.get("attritionRemark") == null ? null : json.getString(("attritionRemark")));
		tCarBasisInfoEntity.setToolsRemark(json.get("toolsRemark") == null ? null : json.getString(("toolsRemark")));
		tCarBasisInfoEntity.setExtinguisherRemark(
				json.get("extinguisherRemark") == null ? null : json.getString(("extinguisherRemark")));
		tCarBasisInfoEntity
				.setPlacardRemark(json.get("placardRemark") == null ? null : json.getString(("placardRemark")));
		tCarBasisInfoEntity.setStallRemark(json.get("stallRemark") == null ? null : json.getString(("stallRemark")));
		tCarBasisInfoEntity.setSpeedRemark(json.get("speedRemark") == null ? null : json.getString(("speedRemark")));
		tCarBasisInfoEntity
				.setBurningRemark(json.get("burningRemark") == null ? null : json.getString(("burningRemark")));
		tCarBasisInfoEntity
				.setDampingRemark(json.get("dampingRemark") == null ? null : json.getString(("dampingRemark")));
		tCarBasisInfoEntity.setClutchRemark(json.get("clutchRemark") == null ? null : json.getString(("clutchRemark")));
		tCarBasisInfoEntity
				.setMufflerRemark(json.get("mufflerRemark") == null ? null : json.getString(("mufflerRemark")));
		tCarBasisInfoEntity.setSuspensionRemark(
				json.get("suspensionRemark") == null ? null : json.getString(("suspensionRemark")));
		return tCarBasisInfoEntity;
	}

	/** 上传特写图片和其他证件图片 */
	public List<CarPictureEntity> getCarPictures(MultipartFile[] file) throws Exception {
		List<CarPictureEntity> list = new ArrayList<>();
		int i = 1;
		String newFileName = null;
		for (MultipartFile m : file) {
			CarPictureEntity carPicture = new CarPictureEntity();
			String filename = getImgName(m);
			if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("img".toUpperCase())) {// 特写
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_PATH, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 获取上传后的图片地址
				carPicture.setUrl(Constant.PICTUREADR + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(1);
				carPicture.setDdDictId(Integer.parseInt(filename.replaceAll("[a-zA-Z]", "").trim()));
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("caridImg".toUpperCase())) {// 身份证
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_CARDIMG, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.CARD + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(1);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("drivingDown".toUpperCase())) {// 行驶证
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_DRIVING, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.DRIVING + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(3);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("drivingUp".toUpperCase())) {
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_DRIVING, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.DRIVING + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(2);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("drivingVice".toUpperCase())) {
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_DRIVING, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.DRIVING + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(4);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("registration".toUpperCase())) {// 登记证
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_REGISTRATION, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.REGISTRATION + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(5);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("paperUrl".toUpperCase())) {// 票据
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_ELSEPICTURE, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.ELSEPICTURE + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(6);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("insurance".toUpperCase())) {// 交强险
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_INSURANCE, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.INSURANCE + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(7);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("business".toUpperCase())) {// 商业险
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_BUSINESS, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.BUSINESS + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(7);
				carPicture.setDdDictId(8);
				list.add(carPicture);
			} else if (filename.replaceAll("\\d", "").trim().toUpperCase().equals("other".toUpperCase())) {// 其他
				// carPicture.setCarId(carId);
				carPicture.setPriture(filename);
				carPicture.setShowSrot(i++);
				newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(m.getOriginalFilename());// 文件扩展名
				try {
					FileUtils.byte2File(m.getBytes(), Constant.UP_ELSEPICTURE, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				carPicture.setUrl(Constant.ELSEPICTURE + newFileName);
				carPicture.setCover(0);
				carPicture.setImgType(2);
				carPicture.setDdDictId(Integer.parseInt(filename.replaceAll("[a-zA-Z]", "").trim()));
				list.add(carPicture);
			}
		}
		return list;
	}

	/** 根据传入损伤类型字符串,返回对应的损伤类型 */
	public int[] getTypeAndValue(String strType) {
		String type = strType.replaceAll("[\\d,_]", "").trim().toUpperCase();
		String value = strType.replaceAll("[a-zA-Z,_]", "").trim();
		int[] result = new int[2];
		result[1] = Integer.parseInt(value);
		// int valueNum = Integer.parseInt(value);
		if (type.equals("APPEARANCE")) {
			// 外观
			result[0] = 1;
		} else {
			// 内饰
			result[0] = 2;
		}
		return result;
	}

	/** 获取损伤图片 */
	Map<String, String> imgPars(List<MultipartFile> file, Map<String, String> map) {
		for (MultipartFile multipartFile : file) {
			// 获取图片名字
			String imgName = getImgName(multipartFile);
			// 将图片名字拆分
			String[] split = imgName.split("_");
			// 定义外观损伤
			String appearance = "appearance".toUpperCase();
			// 定义骨架损伤
			String skeleton = "skeleton".toUpperCase();
			// 定义内饰损伤
			String interior = "interior".toUpperCase();
			// 损伤类型
			String damageType = split[0].toUpperCase();
			// 损伤检测位
			String typeNumber = split[1];
			// 损伤标记位
			String sort = split[2];
			// 损伤类型_检测位_标记为标签
			String tag = null;
			if (damageType.equals(appearance)) {
				tag = ("1" + typeNumber + sort).trim();
			} else if (damageType.equals(skeleton)) {
				tag = ("2" + typeNumber + sort).trim();
			} else if (damageType.equals(interior)) {
				tag = ("3" + typeNumber + sort).trim();
			}
			map.put(tag, SaveImg(multipartFile));
		}
		return map;
	}

	/**
	 * 图片分类
	 * 
	 * @param file
	 * @throws Exception
	 */
	public List<MultipartFile> ImageClassification(MultipartFile[] file, String imgClass) throws Exception {
		try {
			List<MultipartFile> list = new ArrayList<>();
			for (MultipartFile m : file) {
				// 如果包含指定类型图片则加入list
				if (getImgName(m).replaceAll("[\\d,_]", "").trim().toUpperCase().equals(imgClass.toUpperCase())) {
					list.add(m);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("图片分类失败！");
		}
	}

	/** 给定文件返回.jpg之前的文字 */
	public String getImgName(MultipartFile file) {
		return file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
	}

	/** 保存图片并返回生成的图片地址 */
	public String SaveImg(MultipartFile mFile) {
		File dest;// 目标文件(上传以后存储的文件)
		// 1.获取文件名字
		String oFileName = mFile.getOriginalFilename();
		// 2.生成新的文件名字加后缀名
		String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(oFileName);// 文件扩展名
		// 3.上传地址+文件名字
		String realPath = Constant.UP_PATH + newFileName;
		// 4.新建一个文件
		dest = new File(realPath);
		// 5.获取文件
		File parent = dest.getParentFile();
		// 6.判断文件是否存在
		if (!parent.exists()) {
			// 7.新建文件
			parent.mkdirs();
		}
		try {
			// 8.复制文件
			mFile.transferTo(dest);
			// 修改文件other可读属性
			dest.setReadable(true, false);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 返回图片链接地址
		return Constant.PICTUREADR + newFileName;
	}
}
