package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月18日 下午2:43:04 类说明
 * 车辆品牌系列
 */
public class CarSeriesInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1839974434728106966L;
	/** 车系列表ID */
	private Integer id;
	/** 车系ID */
	private String seriesId;
	/** 品牌ID */
	private String brandsId;
	/** 车系名 */
	private String seriesName;
	/** 指导价 */
	private String guideMoney;
	/** 车系展示图 */
	private String seriesImg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	public String getBrandsId() {
		return brandsId;
	}

	public void setBrandsId(String brandsId) {
		this.brandsId = brandsId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getGuideMoney() {
		return guideMoney;
	}

	public void setGuideMoney(String guideMoney) {
		this.guideMoney = guideMoney;
	}

	public String getSeriesImg() {
		return seriesImg;
	}

	public void setSeriesImg(String seriesImg) {
		this.seriesImg = seriesImg;
	}

	@Override
	public String toString() {
		return "CarModelInfoEntity [id=" + id + ", seriesId=" + seriesId + ", brandsId=" + brandsId + ", seriesName="
				+ seriesName + ", guideMoney=" + guideMoney + ", seriesImg=" + seriesImg + "]";
	}

}
