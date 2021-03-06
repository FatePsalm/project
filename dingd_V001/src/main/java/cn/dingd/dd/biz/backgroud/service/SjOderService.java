package cn.dingd.dd.biz.backgroud.service;

import cn.dingd.dd.biz.common.entity.CheckBillExample;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.web.PageObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 作者:CG 时间:2018年4月26日 作用:商家订单
 */

public interface SjOderService {
    Map<String, Object> selectCarImgGroup(Integer carId, Integer type);

    Map<String, Object> selectCarY(Integer id);

    Map<String, Object> selectCarX(Integer id);

    Map<String, Object> selectCarZH(Integer carID);

    List<CheckBillEntity> selectIdALL(Integer id);

    Map<String, Object> selectId(Integer id);

    Map<String, Object> selectFind(CheckBillEntity heckBillEntity, PageObject pageObject, StaffInfo staffInfo);

    /**
     * @mbggenerated 2018-04-26
     */
    int countByExample(CheckBillExample example);

    /**
     * @mbggenerated 2018-04-26
     */
    int deleteByExample(CheckBillExample example);

    /**
     * @mbggenerated 2018-04-26
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated 2018-04-26
     */
    int insert(CheckBillEntity record);

    /**
     * @mbggenerated 2018-04-26
     */
    int insertSelective(CheckBillEntity record);

    /**
     * @mbggenerated 2018-04-26
     */
    List<CheckBillEntity> selectByExample(CheckBillExample example);

    /**
     * @mbggenerated 2018-04-26
     */
    CheckBillEntity selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated 2018-04-26
     */
    int updateByExampleSelective(@Param("record") CheckBillEntity record, @Param("example") CheckBillExample example);

    /**
     * @mbggenerated 2018-04-26
     */
    int updateByExample(@Param("record") CheckBillEntity record, @Param("example") CheckBillExample example);

    /**
     * @mbggenerated 2018-04-26
     */
    int updateByPrimaryKeySelective(CheckBillEntity record);

    /**
     * @mbggenerated 2018-04-26
     */
    int updateByPrimaryKey(CheckBillEntity record);
}
