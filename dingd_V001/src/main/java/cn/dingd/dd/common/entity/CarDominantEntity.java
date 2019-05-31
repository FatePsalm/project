package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
 * 
 * @author cancer
 *@version 创建时间：2018年3月10日 下午3:27:31 
 *@category 显性损伤列表
 */
public class CarDominantEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8441500814461881753L;
	//显性损伤ID
    private Integer id;
    //车辆
    private Integer carId;
    //显性(样式:1,2,3)
    private String dominant;
    //损伤类型(外观-1/骨架-2/内饰-3)
    private Integer damageType;
    //检测位(数据字典)
    private Integer typeNumber;
    //损伤程度(严重/轻微
    private Integer carDescribe;
    //坐标
    private String xy;
    //图片链接
    private String imgUrl;
    //标记排序,当只有一条数据时sort从1开始依次叠加
    private Integer sort;
    //备注
    private String imgRemark;
    //图片识别标记
    private String tag;

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

    public String getDominant() {
        return dominant;
    }

    public void setDominant(String dominant) {
        this.dominant = dominant == null ? null : dominant.trim();
    }

    public Integer getDamageType() {
        return damageType;
    }

    public void setDamageType(Integer damageType) {
        this.damageType = damageType;
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }

    public Integer getCarDescribe() {
        return carDescribe;
    }

    public void setCarDescribe(Integer carDescribe) {
        this.carDescribe = carDescribe;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy == null ? null : xy.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImgRemark() {
        return imgRemark;
    }

    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark == null ? null : imgRemark.trim();
    }

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "CarDominantEntity [id=" + id + ", carId=" + carId + ", dominant=" + dominant + ", damageType="
				+ damageType + ", typeNumber=" + typeNumber + ", carDescribe=" + carDescribe + ", xy=" + xy
				+ ", imgUrl=" + imgUrl + ", sort=" + sort + ", imgRemark=" + imgRemark + ", tag=" + tag + "]";
	}

	
    
}