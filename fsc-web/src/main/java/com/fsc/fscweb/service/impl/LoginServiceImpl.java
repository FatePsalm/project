package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.dao.UserNameMapper;
import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.entity.UserNameExample;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.LoginService;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.CookieUtil;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserNameMapper userNameMapper;
    @Value("${jwt.secretKey}")
    private String salt;
    @Override
    public UserName login(UserName user, HttpServletResponse response) {
        UserNameExample userNameExample = new UserNameExample();
        List<UserName> userNames = null;
        try {
            userNameExample.createCriteria().andUserNameEqualTo(user.getUserName()).andUserPasswordEqualTo(CommonUtil.encoderByMd5(user.getUserPassword()+salt));
           userNames = userNameMapper.selectByExample(userNameExample);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            MyCustomError.mysqlE();
        }
        if (userNames.size()!=Variable.uniquenessOne)
            throw new IsConformException("账号/密码错误!");
        UserName userName1 = userNames.get(0);
        String s = tokenService.addToken(userName1);
        UserName userName = new UserName();
        userName.setId(userNames.get(0).getId());
        userName.setLatelyLoginTime(new Date());
        int i = userNameMapper.updateByPrimaryKeySelective(userName);
        CookieUtil.set(response,Variable.JWTTOKEN,s,Variable.LoginTime*24*60*60);
        userName1.setUserPassword("******");
        return userName1;
    }

    @Override
    public void logout(Cookie cookie, HttpServletResponse response) {
        String token = cookie.getValue();
        Map<String, Object> claims = tokenService.parserJavaWebToken(token);
        try {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(Variable.loginToken+claims.get(Variable.userName).toString());
        } finally {
            //3. 清除cookie
            CookieUtil.set(response, Variable.JWTTOKEN, null, 0);
        }
    }

    @Override
    public Boolean updatePassword(String oldPwd, String newPwd) {
        UserName userLogin = tokenService.getUserLogin();
        UserNameExample userNameExample = new UserNameExample();
        try {
            userNameExample.createCriteria().andUserNameEqualTo(userLogin.getUserName()).andUserPasswordEqualTo(CommonUtil.encoderByMd5(oldPwd+salt));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<UserName> userNames = userNameMapper.selectByExample(userNameExample);
        if (userNames==null||userNames.size()==0) {
            throw new IsConformException("原始密码错误!");
        }else {
            UserName userName = new UserName();
            userName.setId(userNames.get(0).getId());
            try {
                userName.setUserPassword(CommonUtil.encoderByMd5(newPwd+salt));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int i = userNameMapper.updateByPrimaryKeySelective(userName);
            if (i!=Variable.uniquenessOne)
                throw new IsConformException("密码修改失败!");
        }
        //2. 清除redis
        redisTemplate.opsForValue().getOperations().delete(Variable.loginToken+userLogin.getUserName());
        return true;
    }
}
