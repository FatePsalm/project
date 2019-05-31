package cn.dingd.dd.management.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.JsonResult;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年12月13日 下午3:28:27
* 类说明
* 车辆详情
*/
public interface ManageParticularsService {
	/** 管理端-车辆详细-车辆详细 */
	public Map FindDetailed(Integer id) ;
	/** 管理端-车辆详细-电器及附件 */
	public Map FindAttachment(Integer id);
	/** 管理端-车辆详细-隐性损伤 */
	public Map<String, Object> FindRecessive(Integer id);
	/** 管理端-车辆详细-显性损伤 */
	public Map<String, Object> FindDominant(Integer id);
	/** 管理端-车辆详细-过户资料 */
	public List<Map> FindRecord(Integer id);
	/** 管理端-车辆详细-车辆特写*/
	public List<Map> FindPicture(Integer id,Integer imgType) ;
	/** 管理端-车辆详细-流拍信息 */
	public List<Map> FindAuction(int id) ;
	/** 管理端-车辆详细-车主信息/联系人信息/检测师信息 */
	public Map FindCarPerson(int id);
	/**管理端-车辆详细-车辆基本信息*/
	public TCarBasisInfoEntity CarInfo(TCarBasisInfoEntity tCarBasisInfoEntity) ;
}
