package com.dingdang.biz.dao;

import com.dingdang.biz.entity.AUser;
import com.dingdang.biz.entity.AUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AUserMapper {
    int countByExample(AUserExample examples);

    int deleteByExample(AUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AUser record);

    int insertSelective(AUser record);

    List<AUser> selectByExample(AUserExample example);

    AUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AUser record, @Param("example") AUserExample example);

    int updateByExample(@Param("record") AUser record, @Param("example") AUserExample example);

    int updateByPrimaryKeySelective(AUser record);

    int updateByPrimaryKey(AUser record);
}