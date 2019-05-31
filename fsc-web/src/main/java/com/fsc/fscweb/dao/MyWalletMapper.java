package com.fsc.fscweb.dao;

import com.fsc.fscweb.entity.MyWallet;
import com.fsc.fscweb.entity.MyWalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyWalletMapper {
    /**
     *
     * @mbggenerated 2018-07-03
     */
    int countByExample(MyWalletExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByExample(MyWalletExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insert(MyWallet record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int insertSelective(MyWallet record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    List<MyWallet> selectByExample(MyWalletExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    MyWallet selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExampleSelective(@Param("record") MyWallet record, @Param("example") MyWalletExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByExample(@Param("record") MyWallet record, @Param("example") MyWalletExample example);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKeySelective(MyWallet record);

    /**
     *
     * @mbggenerated 2018-07-03
     */
    int updateByPrimaryKey(MyWallet record);
}