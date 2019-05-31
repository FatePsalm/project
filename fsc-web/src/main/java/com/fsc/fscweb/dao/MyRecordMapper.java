package com.fsc.fscweb.dao;

import java.util.List;

import com.fsc.fscweb.entity.MyRecord;
import com.fsc.fscweb.entity.MyRecordExample;
import org.apache.ibatis.annotations.Param;

public interface MyRecordMapper {
    /**
     *
     * @mbggenerated 2018-07-04
     */
    int countByExample(MyRecordExample example);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int deleteByExample(MyRecordExample example);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int insert(MyRecord record);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int insertSelective(MyRecord record);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    List<MyRecord> selectByExample(MyRecordExample example);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    MyRecord selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int updateByExampleSelective(@Param("record") MyRecord record, @Param("example") MyRecordExample example);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int updateByExample(@Param("record") MyRecord record, @Param("example") MyRecordExample example);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int updateByPrimaryKeySelective(MyRecord record);

    /**
     *
     * @mbggenerated 2018-07-04
     */
    int updateByPrimaryKey(MyRecord record);
}