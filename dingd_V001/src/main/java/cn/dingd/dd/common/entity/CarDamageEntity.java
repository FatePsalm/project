package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
 * 
 * @author cancer
 *@version 创建时间：2018年3月10日 下午3:27:31 
 *@category 隐性损伤列表
 */
public class CarDamageEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4071332447238268946L;
	//隐性损伤
    private Integer id;
    //车辆
    private Integer carId;
    //隐性损伤
    private String recessive;
    //损伤类型(外观-1/骨架-2)
    private String damageType;
    //检测位(数据字典)
    private String typeNumber;
    //备注
    private String imgRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRecessive() {
		return recessive;
	}

	public void setRecessive(String recessive) {
		this.recessive = recessive;
	}

	public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType == null ? null : damageType.trim();
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber == null ? null : typeNumber.trim();
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark == null ? null : imgRemark.trim();
    }

	@Override
	public String toString() {
		return "CarDamageEntity [id=" + id + ", carId=" + carId + ", recessive=" + recessive + ", damageType="
				+ damageType + ", typeNumber=" + typeNumber + ", imgRemark=" + imgRemark + "]";
	}
    
}