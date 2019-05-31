 package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 员工管理
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.StaffPictureEntity;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.FileUtils;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManageStaffService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@CrossOrigin
@RequestMapping("/mgmtSta/")
public class ManageStaffController {
	@Resource
	private ManageStaffService manageStaffService;

	/** 管理端-人员管理-根据ID修改员工信息 */
	@RequestMapping("doUpdateStaff")
	@ResponseBody
	public JsonResult doUpdateStaff(HttpServletRequest request, MultipartFile[] file) {
		String Text = request.getParameter("Text");
		JSONObject TextJson = JSONObject.fromObject(Text);
		JSONArray TextList = JSONArray.fromObject(TextJson.get("imgList"));
		StaffInfoEntity staffInfoEntity = new StaffInfoEntity();
		if (!StringUtils.isNotNullStr(TextJson.getString("id"))) {
			// id
			throw new NullPointerException("id为空!");
		} else {
			staffInfoEntity.setId(TextJson.getInt(("id")));
		}
		if (StringUtils.isNotNullStr(TextJson.getString("uPhone"))) {
			// 查找电话是否被占用如果被占用,查看电话是不是自己的!
			staffInfoEntity.setuPhone(TextJson.getString(("uPhone")));
			if (manageStaffService.FindStaffPhone(staffInfoEntity.getuPhone()) != 0) {
				if ((manageStaffService.FindStaffId(staffInfoEntity.getuPhone())) != staffInfoEntity.getId()) {
					throw new NullPointerException("账号已存在!");
				}
				staffInfoEntity.setuPhone("");
			}
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uTime"))) {
			// 入职时间
			throw new NullPointerException("入职时间为空!");
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
			try {
				staffInfoEntity.setuTime(simpleDateFormat.parse(TextJson.getString("uTime")));
			} catch (ParseException e) {
				throw new NullPointerException("入职时间转换失败!");
			}
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uDuty"))) {
			// 职位
			throw new NullPointerException("职位为空!");
		} else {
			staffInfoEntity.setuDuty(TextJson.getInt(("uDuty")));
		}
		List<StaffPictureEntity> staffPicList = new ArrayList<>();
		// 遍历图片修改JSON
		Iterator<Object> it = TextList.iterator();
		while (it.hasNext()) {
			JSONObject ob = (JSONObject) it.next();
			StaffPictureEntity staffPictureEntity = new StaffPictureEntity();
			if (StringUtils.isNotNullStr(ob.getString("sort"))) {
				staffPictureEntity.setShowSrot(ob.getInt("sort"));
			}
			if (StringUtils.isNotNullStr(ob.getString("url"))) {
				staffPictureEntity.setUrl(ob.getString("url"));
			}
			staffPictureEntity.setStaffId(TextJson.getInt("id"));
			staffPicList.add(staffPictureEntity);
		}
		// 获取图片信息
		List<String> list = new ArrayList<>();
		for (MultipartFile e : file) {
			String FileName = e.getOriginalFilename();
			list.add(FileName.substring(0, FileName.indexOf(".")));
		}
		// 其他证件list
		for (MultipartFile myFile : file) {
			String FileName = myFile.getOriginalFilename();
			String mFileName = FileName.substring(0, FileName.indexOf("."));
			String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(FileName);// 文件扩展名
			// 判断是否有寸照
			if (list.contains("headImg")) {
				if (mFileName.equals("headImg")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setuHeadImg(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("寸照上传失败!");
					}
				}
			}
			// 上传身份证正面
			if (list.contains("cardImgUp")) {
				if (mFileName.equals("cardImgUp")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setCardImgUp(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("身份证正面上传失败!");
					}
				}
			}
			// 上传身份证反面
			if (list.contains("cardImgDwon")) {
				if (mFileName.equals("cardImgDwon")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setCardImgDwon(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("身份证正面上传失败!");
					}
				}
			}
			// 上传其他
			Integer index = Integer.parseInt(mFileName.replaceAll("[a-zA-Z]", "").trim());
			for (StaffPictureEntity entity : staffPicList) {
				if (entity.getShowSrot() == index) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						entity.setUrl(Constant.STAFF + newFileName);
						entity.setPriture(mFileName);
					} catch (Exception e) {
						throw new NullPointerException("其他证件上传失败!");
					}
				}
			}
		}
		return new JsonResult(manageStaffService.UpdateStaff(staffPicList, staffInfoEntity));
	}

	/** 管理端-人员管理-根据ID查找用户 */
	@RequestMapping("doFindStaff")
	@ResponseBody
	public JsonResult doFindStaff(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageStaffService.FindStaff(id));
	}

	/** 管理端-人员管理-添加员工 */
	@RequestMapping("doAddStaff")
	@ResponseBody
	public JsonResult doAddStaff(HttpServletRequest request, MultipartFile[] file) {
		String Text = request.getParameter("Text");
		JSONObject TextJson = JSONObject.fromObject(Text);
		StaffInfoEntity staffInfoEntity = new StaffInfoEntity();
		if (!StringUtils.isNotNullStr(TextJson.getString("uPhone"))) {
			// 手机号
			throw new NullPointerException("手机号为空!");
		} else {
			staffInfoEntity.setuPhone(TextJson.getString(("uPhone")));
			if (manageStaffService.FindStaffPhone(staffInfoEntity.getuPhone()) != 0) {
				throw new NullPointerException("账号已存在!");
			}
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uName"))) {
			// 用户名
			throw new NullPointerException("用户名为空!");
		} else {
			staffInfoEntity.setuName(TextJson.getString(("uName")));
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uSex"))) {
			// 性别
			throw new NullPointerException("性别为空!");
		} else {
			staffInfoEntity.setuSex(TextJson.getInt(("uSex")));
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uCard"))) {
			// 身份证
			throw new NullPointerException("身份证为空!");
		} else {
			staffInfoEntity.setuCard(TextJson.getString(("uCard")));
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uBirthday"))) {
			// 生日
			throw new NullPointerException("生日为空!");
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd");
			try {
				staffInfoEntity.setuBirthday(simpleDateFormat.parse(TextJson.getString("uBirthday")));
			} catch (ParseException e) {
				throw new NullPointerException("生日时间转换失败!");
			}
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uTime"))) {
			// 入职时间
			throw new NullPointerException("入职时间为空!");
		} else {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
			try {
				staffInfoEntity.setuTime(simpleDateFormat.parse(TextJson.getString("uTime")));
			} catch (ParseException e) {
				throw new NullPointerException("入职时间转换失败!");
			}
		}
		if (!StringUtils.isNotNullStr(TextJson.getString("uDuty"))) {
			// 职位
			throw new NullPointerException("职位为空!");
		} else {
			staffInfoEntity.setuDuty(TextJson.getInt(("uDuty")));
		}
		// 判断是否上传身份证
		List<String> list = new ArrayList<>();
		for (MultipartFile e : file) {
			String FileName = e.getOriginalFilename();
			list.add(FileName.substring(0, FileName.indexOf(".")));
		}
		if (!list.contains("cardImgUp")) {
			throw new NullPointerException("身份证正面未上传!");
		}
		if (!list.contains("cardImgDwon")) {
			throw new NullPointerException("身份证反面为上传!");
		}
		// 生成员工编号
		String StaffNumber = manageStaffService.FindStaffNumber();
		if (StaffNumber == null) {
			staffInfoEntity.setuNumber("DD000101");
		} else {
			char[] StaffChar = StaffNumber.toCharArray();
			int number = 0;
			for (int i = 2; i < StaffChar.length; i++) {
				if (StaffChar[i] != '0') {
					number = i;
					break;
				}
			}
			int tem = Integer.parseInt(StaffNumber.substring(number, StaffNumber.length()));
			tem++;
			String temStr = String.valueOf(tem);
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < 6 - temStr.length(); i++) {
				sb.append("0");
			}
			staffInfoEntity.setuNumber("DD" + sb + temStr);
		}
		// 其他证件list
		List<StaffPictureEntity> spList = new ArrayList<>();
		for (MultipartFile myFile : file) {
			String FileName = myFile.getOriginalFilename();
			String mFileName = FileName.substring(0, FileName.indexOf("."));
			String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(FileName);// 文件扩展名
			// 判断是否有寸照
			if (list.contains("headImg")) {
				if (mFileName.equals("headImg")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setuHeadImg(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("寸照上传失败!");
					}
				}
			}
			// 上传身份证正面
			if (list.contains("cardImgUp")) {
				if (mFileName.equals("cardImgUp")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setCardImgUp(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("身份证正面上传失败!");
					}
				}
			}
			// 上传身份证反面
			if (list.contains("cardImgDwon")) {
				if (mFileName.equals("cardImgDwon")) {
					try {
						FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
						staffInfoEntity.setCardImgDwon(Constant.STAFF + newFileName);
						continue;
					} catch (Exception e) {
						throw new NullPointerException("身份证正面上传失败!");
					}
				}
			}
			// 上传其他
			try {
				FileUtils.byte2File(myFile.getBytes(), Constant.UP_STAFF, newFileName);
				StaffPictureEntity staffPictureEntity = new StaffPictureEntity();
				staffPictureEntity.setUrl(Constant.STAFF + newFileName);
				staffPictureEntity.setPriture(mFileName);
				spList.add(staffPictureEntity);
			} catch (Exception e) {
				throw new NullPointerException("其他证件上传失败!");
			}
		}
		return new JsonResult(manageStaffService.AddStaff(spList, staffInfoEntity));
	}

	/** 管理端-人员管理-员工列表 */
	@RequestMapping("doFindStaffList")
	@ResponseBody
	public JsonResult doFindStaffList(StaffInfoEntity staffInfoEntity, PageObject pageObject, String sort) {
		if (pageObject.getPageSize() < 1) {
			// 检查分页信息
			throw new NullPointerException("分页信息为空!");
		}
		Map<String, Object> map = null;
		try {
			map = manageStaffService.FindStaffList(staffInfoEntity, pageObject, sort);
		} catch (Exception e) {
			throw new NullPointerException("查询失败!");
		}
		return new JsonResult(map);
	}
}
