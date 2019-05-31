package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.dao.*;
import com.fsc.fscweb.entity.*;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.PersonalCenterService;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonalCenterServiceImpl implements PersonalCenterService {
    @Autowired
    private PersonalCenterDao personalCenterDao;
    @Autowired
    private MyRecordMapper myRecordMapper;
    @Autowired
    private UserNameMapper userNameMapper;
    @Autowired
    private MyWalletMapper myWalletMapper;
    @Autowired
    private TokenService tokenService;

    @Override
    public Boolean checkCardNo( UserName userName) {
        UserName userLogin = tokenService.getUserLogin();
        UserName userDao = userNameMapper.selectByPrimaryKey(userLogin.getId());
        if (  userDao.getIscheck()==Variable.cardNo) {
            throw new IsConformException("已验证!");
        }
        userName.setId(userDao.getId());
        userName.setSex((byte) Variable.cardNo);
        int i = userNameMapper.updateByPrimaryKeySelective(userName);
        if (i!=Variable.uniquenessOne){
            throw new IsConformException("更新失败!");
        }
        return true;
    }

    @Override
    public List <Map <String, Object>> mySubscribe(UserName userName) {
       /* MySubscribeExample mySubscribeExample = new MySubscribeExample();
        mySubscribeExample.createCriteria().andUserNameIdEqualTo(userName.getId());
        mySubscribeExample.setOrderByClause("create_time DESC");*/
        List <Map <String, Object>> mySubscribes = null;
        try {
            mySubscribes = personalCenterDao.mySubscribe(userName);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return mySubscribes;
    }

    @Override
    public List <MyRecord> myTopUp(UserName userName) {
        MyRecordExample myRecordExample = new MyRecordExample();
        myRecordExample.createCriteria().andUserNameIdEqualTo(userName.getId()).andRecordStateEqualTo(Variable.record_wc)
                .andRecordTypeEqualTo(Variable.record_type_cz);
        myRecordExample.setOrderByClause("create_time DESC");
        List <MyRecord> myRecords = null;
        try {
            myRecords = myRecordMapper.selectByExample(myRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return myRecords;
    }

    @Override
    public List <MyRecord> myWithdrawal(UserName userName) {
        MyRecordExample myRecordExample = new MyRecordExample();
        myRecordExample.createCriteria().andUserNameIdEqualTo(userName.getId()).andRecordStateEqualTo(Variable.record_wc)
                .andRecordTypeEqualTo(Variable.record_type_tx);
        myRecordExample.setOrderByClause("create_time DESC");
        List <MyRecord> myRecords = null;
        try {
            myRecords = myRecordMapper.selectByExample(myRecordExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return myRecords;
    }

    @Override
    public Map <String, Object> myInvitation(UserName userName) {
        UserNameExample userNameExample = new UserNameExample();
        userNameExample.createCriteria().andInvitationCodePidEqualTo(userName.getInvitationCode());
        int i = 0;
        try {
            i = userNameMapper.countByExample(userNameExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        Map <String, Object> map = new HashMap <>();
        map.put("InvitationCode", userName.getInvitationCode());
        map.put("myInvitation", i);
        return map;
    }

    @Override
    public MyWallet myMoney(UserName userName) {
        MyWalletExample myWalletExample = new MyWalletExample();
        myWalletExample.createCriteria().andUserNameIdEqualTo(userName.getId());
        List<MyWallet> myWallets = null;
        try {
            myWallets = myWalletMapper.selectByExample(myWalletExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return myWallets.get(0);
    }

    @Override
    public UserName myCardNo(UserName userName) {
        UserName userName1 = null;
        try {
            userName1 = userNameMapper.selectByPrimaryKey(userName.getId());
            userName1.setUserPassword("******");
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return userName1;
    }

    @Override
    public List<UserName> myCardNoAll(String email) {
        UserNameExample userNameExample = new UserNameExample();
        if (email!=null) {
            userNameExample.createCriteria().andUserNameLike("%" + email + "%");
        }
        List<UserName> userNames = null;
        try {
            userNames = userNameMapper.selectByExample(userNameExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return userNames;
    }


}
