package com.fsc.fscweb.service;

import java.util.List;
import java.util.Map;

public interface MyWalletService {
    List <Map> getAllTopUp(String email);
    List <Map> getAllWithdrawal(String email);
    /**
      * 作者:  CG
      * 时间： 2018/7/4 11:44
      * 功能描述:充值
      */
    Boolean topUp(String email, Integer number);
    /**
      * 作者:  CG
      * 时间： 2018/7/4 11:44
      * 功能描述:提现
      */
    Boolean withdrawal(String email, Integer number);
    /**
      * 作者:  CG
      * 时间： 2018/7/4 11:44
      * 功能描述:冻结
      */
    Boolean freeze(String email, Integer number);
    /**
      * 作者:  CG
      * 时间： 2018/7/4 11:44
      * 功能描述:解冻
      */
    Boolean thaw(String email, Integer number);

}
