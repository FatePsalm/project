package cn.dingd.dd.biz.backgroud.dao;

import cn.dingd.dd.biz.common.entity.CheckBillExample;
import cn.dingd.dd.common.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SjOderMapper {
    List<CarPictureEntity> selectCarImgGroup(@Param("carId") Integer carId, @Param("type") Integer type);

    List<CarDamageEntity> selectCarY(Integer id);

    List<CarDominantEntity> selectCar(Integer id);

    Map<String, Object> selectCarZH(Integer carID);

    List<CheckBillEntity> selectIdALL(Integer id);

    /**
     * 时间: 2018/4/28 14:33
     * 功能描述:查询用户详细
     */
    AUserEntity selectAuseId(Integer id);

    /**
     * 时间: 2018/4/28 14:34
     * 功能描述:查询员工详细
     */
    StaffInfoEntity selectStaffId(Integer id);

    /**
     * 时间: 2018/4/28 14:32
     * 功能描述:更具ID查询检测订单详细
     */
    Map<String, Object> selectId(Integer id);

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

    List<Map<String, Object>> selectFind(@Param("checkBillEntity") CheckBillEntity checkBillEntity, @Param("s") String s);
}