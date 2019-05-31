package com.fsc.fscweb.service;

import com.fsc.fscweb.entity.MyRecord;
import com.fsc.fscweb.entity.MyWallet;
import com.fsc.fscweb.entity.UserName;

import java.util.List;
import java.util.Map;

public interface PersonalCenterService {
    Boolean checkCardNo(UserName userName);
    List<Map<String, Object>> mySubscribe(UserName userName);
    List<MyRecord>  myTopUp(UserName userName);
    List<MyRecord>  myWithdrawal(UserName userName);
    Map<String,Object> myInvitation(UserName userName);
    MyWallet myMoney(UserName userName) ;
    UserName myCardNo(UserName userName) ;
    List<UserName> myCardNoAll( String email) ;
}
