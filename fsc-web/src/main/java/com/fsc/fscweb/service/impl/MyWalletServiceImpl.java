package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.dao.MyWalletMapper;
import com.fsc.fscweb.dao.PersonalCenterDao;
import com.fsc.fscweb.dao.UserNameMapper;
import com.fsc.fscweb.entity.*;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.MyWalletService;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MyWalletServiceImpl implements MyWalletService {
    @Autowired
    private MyWalletMapper myWalletMapper;
    @Autowired
    private UserNameMapper userNameMapper;
    @Autowired
    private MyProjectServiceImpl myProjectService;
    @Autowired
    private PersonalCenterDao personalCenterDao;

    @Override
    public List <Map> getAllTopUp(String email) {
        List <Map> allTopUp = null;
        try {
            allTopUp = personalCenterDao.getAllTopUpAndWithdrawal(email,Variable.record_type_cz,Variable.record_wc);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return allTopUp;
    }

    @Override
    public List <Map> getAllWithdrawal(String email) {
        List <Map> allTopUp = null;
        try {
            allTopUp = personalCenterDao.getAllTopUpAndWithdrawal(email,Variable.record_type_tx,Variable.record_wc);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return allTopUp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean topUp(String email, Integer number) {
        UserNameExample u = new UserNameExample();
        u.createCriteria().andUserNameEqualTo(email);
        List <UserName> userNames = userNameMapper.selectByExample(u);
        if (userNames.size() != Variable.uniquenessOne)
            throw new IsConformException("用户不存在,请查证后再充值!");
        UserName userName = userNames.get(0);
        MyWalletExample m = new MyWalletExample();
        m.createCriteria().andUserNameIdEqualTo(userName.getId());
        List <MyWallet> myWallets = myWalletMapper.selectByExample(m);
        if (myWallets.size() != Variable.uniquenessOne)
            throw new IsConformException("获取资金账户失败,请联系数据库管理员!");
        MyWallet myWallet = myWallets.get(0);
        MyWallet my = new MyWallet();
        my.setId(myWallet.getId());
        my.setMoneyUsable(myWallet.getMoneyUsable() + number);
        my.setMoneyOverall(myWallet.getMoneyOverall() + number);
        int i = myWalletMapper.updateByPrimaryKeySelective(my);
        if (i != Variable.uniquenessOne)
            throw new IsConformException("充值失败,未能更新资金账户!");
        //充值记录
        //写入操作日志
        MyRecord record = new MyRecord();
        record.setUserNameId(userName.getId());
        record.setRecordState(Variable.record_wc);
        record.setMoneyUsable(my.getMoneyUsable());
        record.setMoneyOverall(my.getMoneyOverall());
        record.setMoneyFreeze(myWallet.getMoneyFreeze());
        record.setRecordType(Variable.record_type_cz);
        record.setMoneyNumber(number);
        myProjectService.mySubscriptionLog(record);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean withdrawal(String email, Integer number) {
        UserNameExample u = new UserNameExample();
        u.createCriteria().andUserNameEqualTo(email);
        List <UserName> userNames = userNameMapper.selectByExample(u);
        if (userNames.size() != Variable.uniquenessOne)
            throw new IsConformException("用户不存在,请查证后再提现!");
        UserName userName = userNames.get(0);
        MyWalletExample m = new MyWalletExample();
        m.createCriteria().andUserNameIdEqualTo(userName.getId());
        List <MyWallet> myWallets = myWalletMapper.selectByExample(m);
        if (myWallets.size() != Variable.uniquenessOne)
            throw new IsConformException("获取资金账户失败,请联系数据库管理员!");
        MyWallet myWallet = myWallets.get(0);
        MyWallet my = new MyWallet();
        my.setId(myWallet.getId());
        if (myWallet.getMoneyUsable()<number)
            throw new IsConformException("提现余额不足!");
        my.setMoneyUsable(myWallet.getMoneyUsable() -number);
        my.setMoneyOverall(myWallet.getMoneyOverall() - number);
        int i = myWalletMapper.updateByPrimaryKeySelective(my);
        if (i != Variable.uniquenessOne)
            throw new IsConformException("提现失败,未能更新资金账户!");
        //提现记录
        //写入操作日志
        MyRecord record = new MyRecord();
        record.setUserNameId(userName.getId());
        record.setRecordState(Variable.record_wc);
        record.setMoneyUsable(my.getMoneyUsable());
        record.setMoneyOverall(my.getMoneyOverall());
        record.setMoneyFreeze(myWallet.getMoneyFreeze());
        record.setRecordType(Variable.record_type_tx);
        record.setMoneyNumber(number);
        myProjectService.mySubscriptionLog(record);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean freeze(String email, Integer number) {
        UserNameExample u = new UserNameExample();
        u.createCriteria().andUserNameEqualTo(email);
        List <UserName> userNames = userNameMapper.selectByExample(u);
        if (userNames.size() != Variable.uniquenessOne)
            throw new IsConformException("用户不存在,请查证后再冻结!");
        UserName userName = userNames.get(0);
        MyWalletExample m = new MyWalletExample();
        m.createCriteria().andUserNameIdEqualTo(userName.getId());
        List <MyWallet> myWallets = myWalletMapper.selectByExample(m);
        if (myWallets.size() != Variable.uniquenessOne)
            throw new IsConformException("获取资金账户失败,请联系数据库管理员!");
        MyWallet myWallet = myWallets.get(0);
        MyWallet my = new MyWallet();
        my.setId(myWallet.getId());
        if (myWallet.getMoneyUsable()<number)
            throw new IsConformException("冻结可用余额不足!");
        my.setMoneyUsable(myWallet.getMoneyUsable() -number);
        my.setMoneyFreeze(myWallet.getMoneyFreeze()+number);
        int i = myWalletMapper.updateByPrimaryKeySelective(my);
        if (i != Variable.uniquenessOne)
            throw new IsConformException("冻结失败,未能更新资金账户!");
        //提现记录
        //写入操作日志
        MyRecord record = new MyRecord();
        record.setUserNameId(userName.getId());
        record.setRecordState(Variable.record_wc);
        record.setMoneyUsable(my.getMoneyUsable());
        record.setMoneyOverall(myWallet.getMoneyOverall());
        record.setMoneyFreeze(my.getMoneyFreeze());
        record.setRecordType(Variable.record_type_dj);
        record.setMoneyNumber(number);
        myProjectService.mySubscriptionLog(record);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean thaw(String email, Integer number) {
        UserNameExample u = new UserNameExample();
        u.createCriteria().andUserNameEqualTo(email);
        List <UserName> userNames = userNameMapper.selectByExample(u);
        if (userNames.size() != Variable.uniquenessOne)
            throw new IsConformException("用户不存在,请查证后再解冻!");
        UserName userName = userNames.get(0);
        MyWalletExample m = new MyWalletExample();
        m.createCriteria().andUserNameIdEqualTo(userName.getId());
        List <MyWallet> myWallets = myWalletMapper.selectByExample(m);
        if (myWallets.size() != Variable.uniquenessOne)
            throw new IsConformException("获取资金账户失败,请联系数据库管理员!");
        MyWallet myWallet = myWallets.get(0);
        MyWallet my = new MyWallet();
        my.setId(myWallet.getId());
        if (myWallet.getMoneyFreeze()<number)
            throw new IsConformException("解冻余额不足!");
        my.setMoneyUsable(myWallet.getMoneyUsable() +number);
        my.setMoneyFreeze(myWallet.getMoneyFreeze()-number);
        int i = myWalletMapper.updateByPrimaryKeySelective(my);
        if (i != Variable.uniquenessOne)
            throw new IsConformException("冻结失败,未能更新资金账户!");
        //提现记录
        //写入操作日志
        MyRecord record = new MyRecord();
        record.setUserNameId(userName.getId());
        record.setRecordState(Variable.record_wc);
        record.setMoneyUsable(my.getMoneyUsable());
        record.setMoneyOverall(myWallet.getMoneyOverall());
        record.setMoneyFreeze(my.getMoneyFreeze());
        record.setRecordType(Variable.record_type_jd);
        record.setMoneyNumber(number);
        myProjectService.mySubscriptionLog(record);
        return true;
    }
}
