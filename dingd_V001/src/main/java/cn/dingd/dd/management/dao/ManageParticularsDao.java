package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.view.CarDamageDto;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午4:00:54
* 类说明
* 车亮详细
*/
public interface ManageParticularsDao {
	/** 管理端-车辆详细-车辆详细 */
	public Map FindDetailed(Integer id);
	/** 管理端-车辆详细-电器及附件 */
	public Map FindAttachment(@Param("id")Integer id) ;
	/** 管理端-车辆详细-显性损伤 */
	public List<Map> FindDominant(@Param("id")Integer id,@Param("code")Integer code,@Param("damageType")Integer damageType);
	/** 管理端-车辆详细-显性损伤 -多图*/
	public List<CarDamageDto> FindDominant2(@Param("id")Integer id,@Param("code")Integer code,@Param("damageType")Integer damageType);
	/** 管理端-车辆详细-隐形损伤 */
	public List<Map> FindRecessive(@Param("id")Integer id,@Param("code")Integer code,@Param("damageType")Integer damageType);
	/** 管理端-车辆详细-过户资料 */
	public List<Map> FindRecord(@Param("id")Integer id);
	/** 管理端-车辆详细-车辆特写*/
	public List<Map> FindPicture(@Param("id")Integer id,@Param("imgType")Integer imgType);
	/** 管理端-车辆详细-流拍信息 */
	public List<Map> FindAuction(@Param("id")int id) ;
	/** 管理端-车辆详细-车主信息/联系人信息/检测师信息 */
	public Map FindCarPerson(@Param("id")int id) ;
	/**管理端-车辆详细-车辆基本信息*/
	public TCarBasisInfoEntity CarInfo(TCarBasisInfoEntity tCarBasisInfoEntity);
}
