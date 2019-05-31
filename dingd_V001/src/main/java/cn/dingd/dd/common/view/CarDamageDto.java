package cn.dingd.dd.common.view;

import java.util.List;

import cn.dingd.dd.common.entity.CarDominantEntity;

/**
* @author zoucong
* @date 2018年3月10日 下午2:27:13
* @description 车辆损伤视图对象
*/
public class CarDamageDto {
	
	/**
	 * 
	 */

	/** ID */
	private Integer id;
	/** 文本值 */
	private String dictName;
	/** 文本code */
	private Integer dictValue;
	/** 排列顺序 */
	private Integer dictOrder;
	/** 序号(编码） */
	private  String code;
	/** 描述 */
	private String dictDesc;
	
	private List<CarDominantEntity> carDominantEntities;
	
	public List<CarDominantEntity> getCarDominantEntities() {
		return carDominantEntities;
	}
	public void setCarDominantEntities(List<CarDominantEntity> carDominantEntities) {
		this.carDominantEntities = carDominantEntities;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public Integer getDictValue() {
		return dictValue;
	}
	public void setDictValue(Integer dictValue) {
		this.dictValue = dictValue;
	}
	public Integer getDictOrder() {
		return dictOrder;
	}
	public void setDictOrder(Integer dictOrder) {
		this.dictOrder = dictOrder;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDictDesc() {
		return dictDesc;
	}
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	@Override
	public String toString() {
		return "CarDictionaryEntity [id=" + id + ", dictName=" + dictName + ", dictValue=" + dictValue + ", dictOrder="
				+ dictOrder + ", code=" + code + ", dictDesc=" + dictDesc + "]";
	}
}    