package com.fsc.fscweb.dao;

import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.entity.UserNameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserNameMapper {
    /**
     *
     * @mbggenerated 2018-07-11
     */
    int countByExample(UserNameExample example);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int deleteByExample(UserNameExample example);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int insert(UserName record);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int insertSelective(UserName record);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    List<UserName> selectByExample(UserNameExample example);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    UserName selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int updateByExampleSelective(@Param("record") UserName record, @Param("example") UserNameExample example);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int updateByExample(@Param("record") UserName record, @Param("example") UserNameExample example);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int updateByPrimaryKeySelective(UserName record);

    /**
     *
     * @mbggenerated 2018-07-11
     */
    int updateByPrimaryKey(UserName record);
}