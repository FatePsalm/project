package cn.dingd.dd.temporary.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.temporary.entity.CarInfoDom;
import cn.dingd.dd.temporary.service.CarInfoDomService;

/**
 * 临时版车辆信息control
 * 
 * @author XCD
 *
 */
@CrossOrigin
@Controller
@RequestMapping("/CarInfoDom/")
public class CarInfoDomController {

	@Resource
	private CarInfoDomService carInfoDomService;

	/**
	 * 添加车辆信息
	 * 
	 * @param carInfoDom
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("addCarInfoDom")
	@ResponseBody
	public JsonResult addCarInfoDom(CarInfoDom carInfoDom, @RequestParam MultipartFile[] files) {

		try {
			if (files.length <= 0) {
				return new JsonResult(new Exception("必须上传车辆图片信息!"));
			}
			if (carInfoDom.getMoney() < 0 || carInfoDom.getMoney() == 0) {
				return new JsonResult(new Exception("金额不能为空!"));
			}
			if (!StringUtils.isNotNullStr(carInfoDom.getCarColor())) {
				return new JsonResult(new Exception("请输入车辆颜色!"));
			}
			if (!StringUtils.isNotNullStr(carInfoDom.getCarCx())) {
				return new JsonResult(new Exception("请输入车系!"));
			}

			if (!StringUtils.isNotNullStr(carInfoDom.getSyxz())) {
				return new JsonResult(new Exception("请输入使用性质!"));
			}
			if (carInfoDom.getUpTime() == null) {
				return new JsonResult(new Exception("请输入上牌时间!"));
			}
			if (carInfoDom.getGhNum() < 0) {
				return new JsonResult(new Exception("请输入过户次数!"));
			}

			carInfoDomService.addCarInfoDom(carInfoDom, files);
			return new JsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("添加失败!"));
		}

		
	}

	/**
	 * 更新车辆信息
	 * 
	 * @param carInfoDom
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("updCarInfoDom")
	@ResponseBody
	public JsonResult updCarInfoDom(CarInfoDom carInfoDom) {

		if (carInfoDom.getMoney() < 0) {
			return new JsonResult(new Exception("金额不能为空!"));
		}
		if (!StringUtils.isNotNullStr(carInfoDom.getCarColor())) {
			return new JsonResult(new Exception("请输入车辆颜色!"));
		}
		if (!StringUtils.isNotNullStr(carInfoDom.getCarCx())) {
			return new JsonResult(new Exception("请输入车系!"));
		}

		if (!StringUtils.isNotNullStr(carInfoDom.getSyxz())) {
			return new JsonResult(new Exception("请输入使用性质!"));
		}
		if (carInfoDom.getUpTime() == null) {
			return new JsonResult(new Exception("请输入上牌时间!"));
		}
		if (carInfoDom.getGhNum() < 0) {
			return new JsonResult(new Exception("请输入过户次数!"));
		}

		try {

			carInfoDomService.updCarInfoDom(carInfoDom);
			return new JsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("更新失败!"));
		}

		
	}

	/**
	 * 更新图片
	 * 
	 * @param files
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("updCarPictureDom")
	@ResponseBody

	public JsonResult updCarPictureDom(@RequestParam MultipartFile[] files,@RequestParam int carId){
		

		try {
			
			return new JsonResult(carInfoDomService.updCarPictureDom(files, carId));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("更新失败!"));
		}



		
	}

	/**
	 * 删除图片信息
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("delCarPictureDom")
	@ResponseBody
	public JsonResult delCarPictureDom(int id) {

		try {
			carInfoDomService.delCarPictureDom(id);
			return new JsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("删除失败!"));
		}
		
	}
	

	/**
	 * 删除图片信息
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping("updCover")
	@ResponseBody
	public JsonResult updCover(int id,int carId) {

		try {
			carInfoDomService.updCover(id,carId);
			return new JsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("封面设置失败!"));
		}
		
	}

	/**
	 * 获取车辆详细信息
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("queryCarInfoDom")
	@ResponseBody
	public JsonResult queryCarInfoDom(int id) {
                        
		try {
			return null;
			//return new JsonResult(carInfoDomService.queryCarInfo(id));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("查询失败!"));
		}

	}

	/**
	 * 根据参数获取车辆信息
	 * 
	 * @param pageObject
	 * @param carCx
	 * @param money
	 * @param moneyEnd
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("queryCarInfoDomParam")
	@ResponseBody
	public JsonResult queryCarInfoDomParam(PageObject pageObject, String carCx, float money, float moneyEnd) {

		try {
			if (pageObject == null) {
				return new JsonResult(new Exception("分页页数不能为空!"));
			}
			if (pageObject.getPageSize() <= 0 || pageObject.getStartIndex() < 0) {
				return new JsonResult(new Exception("分页页数不能为空!"));
			}
			return new JsonResult(carInfoDomService.queryCarInfoParam(money, moneyEnd, carCx, pageObject));
		} catch (Exception e) {
			e.printStackTrace();
			return 	 new JsonResult(new Exception("查询失败!"));
		}

	}

	/**
	 * 删除车辆信息
	 * 
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("deleteCarInfo")
	@ResponseBody
	public JsonResult deleteCarInfo(int id) {

		try {
			return new JsonResult(carInfoDomService.deleteCarInfo(id));
		} catch (Exception e) {
			e.printStackTrace();
			return 	 new JsonResult(new Exception("删除失败!"));
		}

	}

	/**
	 * 获取车辆列表信息
	 * 
	 * @param pageObject
	 * @return
	 */
	@RequestMapping("queryCarList")
	@ResponseBody
	@CrossOrigin
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonResult queryCarList(PageObject pageObject) {
		List<Map> list = null;
		Map map = new HashMap<>();
		try {
			list = carInfoDomService.queryCarInfoList(pageObject);
			map.put("pageObject", pageObject);
			map.put("CarInfo", list);

			return new JsonResult(map);

		} catch (Exception e) {
			e.printStackTrace();
			return 	 new JsonResult(new Exception("获取车辆信息列表失败!"));
		}
		
	}

	/**
	 * 批量删除车信息
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("delCarInfoList")
	@ResponseBody
    @CrossOrigin
	public JsonResult delCarInfoList(@RequestParam String str){

		try {
			
			List ls=new ArrayList<>();
		    String[] strs = str.split(",");
		    for (String st : strs) {
		            ls.add(Integer.parseInt(st));
		    }
			carInfoDomService.delCarInfoList(ls);
			return new JsonResult("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return 	 new JsonResult(new Exception("删除失败!"));
		}

	}

}
