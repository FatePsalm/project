package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.dao.MyWalletMapper;
import com.fsc.fscweb.dao.UserNameMapper;
import com.fsc.fscweb.entity.MyWallet;
import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.entity.UserNameExample;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.RegisterService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserNameMapper userNameMapper;
    @Autowired
    private MyWalletMapper myWalletMapper;
    @Value("${jwt.secretKey}")
    private String salt;

    @Override
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public Boolean register(UserName userName, String code) {
        UserNameExample userNameExample = new UserNameExample();
        userNameExample.createCriteria().andUserNameEqualTo(userName.getUserName());
        //查找用户是否注册
        if (userNameMapper.countByExample(userNameExample) != Variable.uniqueness)
            throw new IsConformException("用户已存在!");
        //验证码
        String s = redisTemplate.opsForValue().get(Variable.registerCodeRedis + userName.getUserName());
        if (s == null || !s.toUpperCase().equals(code.toUpperCase())) {
            throw new IsConformException("验证码不正确!");
        }
        //查询邀请码是否正确
        String invitationCodePid = userName.getInvitationCodePid();
        if (invitationCodePid != null && !invitationCodePid.equals("")) {
            UserNameExample userNameExample1 = new UserNameExample();
            userNameExample1.createCriteria().andInvitationCodeEqualTo(userName.getInvitationCodePid());
            if (userNameMapper.countByExample(userNameExample1) != Variable.uniquenessOne)
                throw new IsConformException("邀请码不正确!");
        }
        userName.setInvitationCode(CommonUtil.getRandomString(Variable.invitationCode));
        //添加用户
        try {
            userName.setUserPassword(CommonUtil.encoderByMd5(userName.getUserPassword() + salt));
            userName.setUserType(Variable.userType);
            int insert = userNameMapper.insert(userName);
            if (insert != Variable.uniquenessOne)
                MyCustomError.mysqlE();
            myWalletInitialize(userName);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        return true;
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/3 22:56
     * 功能: 初始化钱包
     * 参数:
     */
    public void myWalletInitialize(UserName user) throws Exception{
        MyWallet myWallet = new MyWallet();
        myWallet.setUserNameId(user.getId());
        myWallet.setMoneyFreeze(Variable.money);
        myWallet.setMoneyOverall(Variable.money);
        myWallet.setMoneyUsable(Variable.money);
        myWalletMapper.insert(myWallet);
    }
    @Override
    public Boolean retrievePwd(UserName userName, String code) {
        UserNameExample userNameExample = new UserNameExample();
        userNameExample.createCriteria().andUserNameEqualTo(userName.getUserName());
        List<UserName> userNames = userNameMapper.selectByExample(userNameExample);
        if (userNames == null || userNames.size() != 1)
            throw new IsConformException("用户不存在!");
        String s = redisTemplate.opsForValue().get(Variable.registerCodeRedis + userName.getUserName());
        if (s == null || !s.equals(code)) {
            throw new IsConformException("验证码不正确!");
        }
        try {
            UserName userName1 = new UserName();
            userName1.setId(userNames.get(0).getId());
            userName1.setUserPassword(CommonUtil.encoderByMd5(userName.getUserPassword() + salt));
            if (userNameMapper.updateByPrimaryKeySelective(userName1) != Variable.uniquenessOne)
                throw new IsConformException("找回密码失败!");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        redisTemplate.delete(Variable.loginToken+userName.getUserName());
        redisTemplate.delete(Variable.registerCodeRedis + userName.getUserName());
        return true;
    }
}
