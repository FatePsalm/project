package cn.dingd.dd.biz.backgroud.controller;

import cn.dingd.dd.biz.backgroud.service.DictionaryService;
import cn.dingd.dd.biz.common.entity.DdDictEntity;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月23日 下午1:53:31 类说明 数据字典
 */
@CrossOrigin
@RestController
@Controller
@RequestMapping("/dt/")
public class DictionaryController {
	@Autowired
	private DictionaryService dictionaryService;
	/**
	 * 时间: 2018/5/7 15:53
	 * 功能描述:根据类型查找数据字典
	 */
	@RequestMapping("selectGroup")
	public JsonResult selectGroup(Integer code) {
		if (CF.isNum(code))
		throw new NullPointerException("查询分组信息参数不正确!");
		return new JsonResult(dictionaryService.selectGroup(code));
	}
	/** 查询所有数据字典 */
	@RequestMapping("selectFull")
	public JsonResult selectFull(DdDictEntity ddDictEntity, PageObject pageObject) {
		if (CF.isPage(pageObject))
			throw new NullPointerException("分页信息参数不正确!");
		Map<String, Object> stringObjectMap = dictionaryService.selectFull(ddDictEntity, pageObject);
		return new JsonResult(stringObjectMap);
	}

	/** 启用--禁用数据字典 */
	@RequestMapping("deleteByPrimaryKey")
	public JsonResult deleteByPrimaryKey(Integer id) {
		if (CF.isNum(id)) 
			throw new NullPointerException("启用-禁用ID为(null,0)!");
		if (CF.mysqlSave(dictionaryService.deleteByPrimaryKey(id))) 
			throw new NullPointerException("更新失败!");
		return new JsonResult("更新成功!");
	}

	/** 查询数据字典-根据ID */
	@RequestMapping("selectByPrimaryKey")
	public JsonResult selectByPrimaryKey(Integer id) {
		if (CF.isNum(id)) 
			throw new NullPointerException("更新ID为(null,0)!");
		DdDictEntity selectByPrimaryKey = dictionaryService.selectByPrimaryKey(id);
		return new JsonResult(selectByPrimaryKey);
	}

	/** 数据字典更新 */
	@RequestMapping("updateByPrimaryKey")
	public JsonResult updateByPrimaryKey(DdDictEntity ddDictEntity) {
		if (CF.isNum(ddDictEntity.getId())) 
			throw new NullPointerException("更新ID为null!");
		if (CF.mysqlSave(dictionaryService.updateByPrimaryKey(ddDictEntity)))
			throw new NullPointerException("更新失败!");
		return new JsonResult("更新成功!");
	}

	/** 新增数据字典 */
	@RequestMapping("insert")
	public JsonResult insert(DdDictEntity ddDictEntity) {
		if (CF.isNum(ddDictEntity.getDictValue())) {
			throw new NullPointerException("编码为null!");
		} else if (CF.isStr(ddDictEntity.getDictName())) {
			throw new NullPointerException("内容为null!");
		} else if (CF.isNumZ(ddDictEntity.getParentId())) 
			throw new NullPointerException("父级为null!");
		if (CF.mysqlSave(dictionaryService.insert(ddDictEntity))) 
			throw new NullPointerException("保存失败!");
		return new JsonResult("保存成功!");
	}

	/** 查询数据字典-树形图 */
	@RequestMapping("selectAll")
	public JsonResult selectAll() {
		List<DdDictEntity> dictionary = dictionaryService.selectAll();
		return new JsonResult(dictionary);
	}
}
