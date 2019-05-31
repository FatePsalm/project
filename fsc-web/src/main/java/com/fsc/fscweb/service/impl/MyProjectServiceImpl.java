package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.dao.*;
import com.fsc.fscweb.entity.*;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.MyProjectService;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MyProjectServiceImpl implements MyProjectService {
    @Autowired
    private MyProjectMapper myProjectMapper;
    @Autowired
    private MyProjectDao myProjectDao;
    @Autowired
    private MyWalletMapper myWalletMapper;
    @Autowired
    private MyRecordMapper myRecordMapper;
    @Autowired
    private MySubscribeMapper mySubscribeMapper;

    @Override
    public Boolean updateProject(MyProject myProject) {
        int insert = 0;
        try {
            insert = myProjectMapper.updateByPrimaryKeySelective(myProject);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        if (insert != Variable.uniquenessOne)
            throw new IsConformException("失败!");
        return true;
    }

    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:37
     * 功能: 更新项目信息
     * 参数:
     */
    @Override
    public Boolean addProject(MyProject myProject) {
        int insert = 0;
        try {
            insert = myProjectMapper.insert(myProject);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        if (insert != Variable.uniquenessOne)
            throw new IsConformException("失败!");
        return true;
    }

    @Override
    public MyProject getNewProject() {
        MyProjectExample myProjectExample = new MyProjectExample();
        myProjectExample.setOrderByClause("creation_time DESC LIMIT 1");
        List<MyProject> myProjects = null;
        try {
            myProjects = myProjectMapper.selectByExample(myProjectExample);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return myProjects.get(0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean mySubscription(UserName userName, MyProject myProject, Integer myNumber) {
        //查询用户钱包
        MyWalletExample myWalletExample = new MyWalletExample();
        myWalletExample.createCriteria().andUserNameIdEqualTo(userName.getId());
        List<MyWallet> myWallets = myWalletMapper.selectByExample(myWalletExample);
        if (myWallets.size() != Variable.uniqueness) {
            MyWallet myWallet = myWallets.get(0);
            if (myWallet.getMoneyUsable() < myNumber)
                throw new IsConformException("可用余额不足,请及时充值!");
            MyWallet wallet = new MyWallet();
            wallet.setId(myWallet.getId());
            wallet.setMoneyUsable(myWallet.getMoneyUsable() - myNumber);
            wallet.setMoneyOverall(myWallet.getMoneyOverall() - myNumber);
            myWalletMapper.updateByPrimaryKeySelective(wallet);
            //写入操作日志
            MyRecord record = new MyRecord();
            record.setUserNameId(userName.getId());
            record.setRecordState(Variable.record_wc);
            record.setRecordState(Variable.record_wc);
            record.setMoneyUsable(wallet.getMoneyUsable());
            record.setMoneyOverall(wallet.getMoneyOverall());
            record.setMoneyFreeze(myWallet.getMoneyFreeze());
            record.setRecordType(Variable.record_type_rg);
            record.setMoneyNumber(myNumber);
            mySubscriptionLog(record);
        } else {
            throw new IsConformException("未获取到用户资金信息!");
        }
        //插入认购记录
        MySubscribe m = new MySubscribe();
        m.setUserNameId(userName.getId());
        m.setProjectId(myProject.getId());
        m.setMoneyType(myProject.getMoneyType());
        m.setSubscribeNumber(myNumber);
        m.setMoneyNumber(myNumber);
        mySubscription(m);
        //更新项目信息
        MySubscribeExample mySubscribeExample = new MySubscribeExample();
        mySubscribeExample.createCriteria().andProjectIdEqualTo(myProject.getId());
        int i = mySubscribeMapper.countByExample(mySubscribeExample);
        MyProject p = new MyProject();
        p.setId(myProject.getId());
        p.setProjectTarget(myProject.getProjectTarget() - myNumber);
        p.setSupportNumber(i);
        p.setCollectionNumber(myProject.getCollectionNumber() + myNumber);
        updateProject(p);
        return true;
    }

    @Override
    public List <Map<String, Object>> participate() {
        //获取最新的项目信息
        MyProject newProject = getNewProject();
        List <Map <String, Object>> participate = null;
        try {
            participate = myProjectDao.participate(newProject);
            for (Map <String, Object> index:participate
                 ) {
                String userName = String.valueOf(index.get("userName"));
                StringBuffer stringBuffer = new StringBuffer(userName);
                StringBuffer replace = stringBuffer.replace(1, stringBuffer.indexOf("@")-1, "********");
                StringBuffer replace1 = replace.replace(replace.indexOf("@")+1, replace.length(), "******");
                index.put("userName",replace1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return participate;
    }

    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:51
     * 功能: 插入认购信息
     * 参数:
     */
    public Boolean mySubscription(MySubscribe mySubscribe) {
        mySubscribe.setCreateTime(new Date());
        int insert = 0;
        try {
            insert = mySubscribeMapper.insert(mySubscribe);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        if (insert != Variable.uniquenessOne)
            throw new IsConformException("认购操作失败!");
        return true;
    }

    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:00
     * 功能: 写入操作日志
     * 参数:
     */
    public Boolean mySubscriptionLog(MyRecord myRecord) {
        myRecord.setCreateTime(new Date());
        int insert = myRecordMapper.insert(myRecord);
        if (insert != Variable.uniquenessOne)
            throw new IsConformException("操作日志插入失败!");
        return true;
    }

    /**
     * 作者: Solace
     * 时间: 2018/7/1 23:38
     * 功能: 每天凌晨自动减少项目一天时间
     * 参数:
     */
    @Scheduled(cron = "0 0 0 * * ?")  //每1秒执行一次
    public void projectTask() {
        System.out.println("定时刷新任务");
        myProjectDao.updateDays();
    }
}
