package cn.dingd.dd.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.search.dao.CarInfoSearchDao;
import cn.dingd.dd.search.service.CarInfoSearchService;

/**
 * @author ZC
 * @date 上午10:19:06
 */
@RestController
@RequestMapping("/Search")
public class CarInfoSearchController {

	@Autowired
	private CarInfoSearchService carInfoSearchService;

	@Autowired
	private CarInfoSearchDao carInfoSearchDao;

	@RequestMapping("/getCarsList")
	public Object name() {
		return carInfoSearchDao.getCarList();
	}

	/**
	 * 导入车辆索引
	 */
	@RequestMapping("importCarIndex")
	public JsonResult importCarIndex() {
		try {
			return new JsonResult(carInfoSearchService.importCarsToSolr());
		} catch (Exception e) {
			return new JsonResult("失败");
		}
	}

	/**
	 * 搜索车辆
	 */
	@RequestMapping("searchCarInfo")
	public JsonResult searchCar(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		if (checkQueryEntity.getCreateTimeStart() != null && checkQueryEntity.getCreateTimeOver() != null) {
			if (checkQueryEntity.getCreateTimeStart().getTime() > checkQueryEntity.getCreateTimeOver().getTime()) {
				// 查询开始时间必须小于结束时间
				throw new NullPointerException("查询开始时间必须小于结束时间!");
			}
		}
		if (checkQueryEntity.getCarState() < 1) {
			// 车辆状态判断
			throw new NullPointerException("车辆状态为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 请传入分页信息
			throw new NullPointerException("请传入分页信息!");
		}
		return carInfoSearchService.searchCar(checkQueryEntity, pageObject);
	}

}
