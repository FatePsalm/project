package cn.dingd.dd.biz.backgroud.dao;


import cn.dingd.dd.biz.common.entity.DdDictEntity;
import cn.dingd.dd.common.web.PageObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DictionaryDao {
     List<Map<String,Object>> selectGroup(Integer code);
	List<DdDictEntity> selectFull(@Param("dd") DdDictEntity ddDictEntity,@Param("pg") PageObject pageObject);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dd_dict
     *
     * @mbggenerated Tue Apr 24 10:47:12 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. 
     * @mbggenerated Tue Apr 24 10:47:12 CST 2018
     */
    int insert(DdDictEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dd_dict
     *
     * @mbggenerated Tue Apr 24 10:47:12 CST 2018
     */
    DdDictEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dd_dict
     *
     * @mbggenerated Tue Apr 24 10:47:12 CST 2018
     */
    List<DdDictEntity> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dd_dict
     *
     * @mbggenerated Tue Apr 24 10:47:12 CST 2018
     */
    int updateByPrimaryKey(DdDictEntity record);
}