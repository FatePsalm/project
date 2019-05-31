package com.fsc.fscweb.dao;

import java.util.List;

import com.fsc.fscweb.entity.MyProject;
import com.fsc.fscweb.entity.MyProjectExample;
import org.apache.ibatis.annotations.Param;

public interface MyProjectMapper {
    /**
     *
     * @mbggenerated 2018-07-03
     */
    int countByExample(MyProjectExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByExample(MyProjectExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insert(MyProject record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insertSelective(MyProject record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    List<MyProject> selectByExample(MyProjectExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    MyProject selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExampleSelective(@Param("record") MyProject record, @Param("example") MyProjectExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExample(@Param("record") MyProject record, @Param("example") MyProjectExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKeySelective(MyProject record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKey(MyProject record);
}