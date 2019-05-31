package com.fsc.fscweb.dao;

import com.fsc.fscweb.entity.UserName;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonalCenterDao {
    List<Map<String,Object>> mySubscribe(UserName userName);
    /**
      * 作者:  CG
      * 时间： 2018/7/10 16:19
      * 功能描述:获取所有的充值记录/提现记录
      */
    List<Map> getAllTopUpAndWithdrawal(@Param("email") String email,@Param("type") int type,@Param("state") int state);
}
