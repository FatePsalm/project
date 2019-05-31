package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月20日 上午10:15:15 类说明
 * 城市地区类
 */
public class CityMapEntiyt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5926823532535421562L;
	/**常见的地区名称ID*/
	private Long commonDistrictId;
	/**常见的地区名称*/
	private String commonDistrictName;
	/**省州ID*/
	private int provinceId;
	/**省州*/
	private int provinceState;
	/**城市ID*/
	private Long cityId;
	/**城市国家*/
	private int cityState;
	public Long getCommonDistrictId() {
		return commonDistrictId;
	}
	public void setCommonDistrictId(Long commonDistrictId) {
		this.commonDistrictId = commonDistrictId;
	}
	public String getCommonDistrictName() {
		return commonDistrictName;
	}
	public void setCommonDistrictName(String commonDistrictName) {
		this.commonDistrictName = commonDistrictName;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getProvinceState() {
		return provinceState;
	}
	public void setProvinceState(int provinceState) {
		this.provinceState = provinceState;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public int getCityState() {
		return cityState;
	}
	public void setCityState(int cityState) {
		this.cityState = cityState;
	}
	@Override
	public String toString() {
		return "CityMapEntiyt [commonDistrictId=" + commonDistrictId + ", commonDistrictName=" + commonDistrictName
				+ ", provinceId=" + provinceId + ", provinceState=" + provinceState + ", cityId=" + cityId
				+ ", cityState=" + cityState + "]";
	}
	
	

}
