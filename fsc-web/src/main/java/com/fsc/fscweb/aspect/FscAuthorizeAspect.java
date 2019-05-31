package com.fsc.fscweb.aspect;

import com.alibaba.fastjson.JSON;
import com.fsc.fscweb.controller.LoginController;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.CookieUtil;
import com.fsc.fscweb.util.Variable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class FscAuthorizeAspect {
    @Autowired
    private  LoginController loginController;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TokenService tokenService;

    @Pointcut("execution(public * com.fsc.fscweb.controller.*.*(..))" +
            "&& !execution(public * com.fsc.fscweb.controller.LoginController.login(..))"+
            "&& !execution(public * com.fsc.fscweb.controller.LoginController.logout(..))"+
            "&& !execution(public * com.fsc.fscweb.controller.RegisterController.*(..))"+
            "&& !execution(public * com.fsc.fscweb.controller.MyProjectController.getNewProject(..))"+
            "&& !execution(public * com.fsc.fscweb.controller.MyProjectController.participate(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        //查询cookie获取用户信息
        Cookie cookie = CookieUtil.get(request, Variable.JWTTOKEN);
        if (cookie == null) {
            throw new IsConformException("请登录!");
        }
        String token = cookie.getValue();
        //解析token失败
        Map<String, Object> claims = tokenService.parserJavaWebToken(token);
        if (claims == null) {
            throw new IsConformException("请登录!");
        }
        String s1 = String.valueOf(claims.get(Variable.JWTTOKEN));
        String s = String.valueOf(claims.get(Variable.userName));
        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(Variable.loginToken+s);
        Long expire = redisTemplate.getExpire(Variable.loginToken+s, TimeUnit.DAYS);
        if (CommonUtil.checkStr(tokenValue)) {
            throw new IsConformException("请登录!");
        }
        HashMap hashMap = JSON.parseObject(tokenValue, HashMap.class);
        String s2 = String.valueOf(hashMap.get(Variable.JWTTOKEN));
        if (!s1.equals(s2)){
            CookieUtil.set(response, Variable.JWTTOKEN, null, 0);
            throw new IsConformException("其他用户已登录!");

        }
        //查询过期时间,如果小于规定的时间,刷新redis时间
        if (expire <= Variable.LoginTime%2) {
            redisTemplate.expire(Variable.loginToken+s, Variable.LoginTime, TimeUnit.DAYS);
        }
    }
}
