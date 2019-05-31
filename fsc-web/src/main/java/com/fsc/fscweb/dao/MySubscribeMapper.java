package com.fsc.fscweb.dao;

import com.fsc.fscweb.entity.MySubscribe;
import com.fsc.fscweb.entity.MySubscribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MySubscribeMapper {
    /**
     *
     * @mbggenerated 2018-07-03
     */
    int countByExample(MySubscribeExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByExample(MySubscribeExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insert(MySubscribe record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insertSelective(MySubscribe record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    List<MySubscribe> selectByExample(MySubscribeExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    MySubscribe selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExampleSelective(@Param("record") MySubscribe record, @Param("example") MySubscribeExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExample(@Param("record") MySubscribe record, @Param("example") MySubscribeExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKeySelective(MySubscribe record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKey(MySubscribe record);
}