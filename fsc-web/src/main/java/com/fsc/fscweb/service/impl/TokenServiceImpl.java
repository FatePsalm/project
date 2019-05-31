package com.fsc.fscweb.service.impl;


import com.alibaba.fastjson.JSON;
import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.CookieUtil;
import com.fsc.fscweb.util.MyCustomError;
import com.fsc.fscweb.util.Variable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Service
public class TokenServiceImpl  implements TokenService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 时间： 2018/5/25 10:14
     * 功能描述:私钥
     */
    @Value("${jwt.secretKey}")
    private String jwtSecret;

    // 该方法使用HS256算法和Secret:bankgl生成signKey
    private Key getKeyInstance() {
        // We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    // 使用HS256签名算法和生成的signingKey最终的Token,claims中是有效载荷
    public String createJavaWebToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();
    }

    @Override
    public UserName getUserLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie获取用户信息
        Cookie cookie = CookieUtil.get(request, Variable.JWTTOKEN);
        if (cookie == null) {
            throw new IsConformException("请登录!");
        }
        Map<String, Object> map = parserJavaWebToken(cookie.getValue());
        if (map == null || map.size() == 0) {
            throw new IsConformException("请登录!");
        }
        String userName = (String) map.get(Variable.userName);
        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(Variable.loginToken+userName);
        if (tokenValue==null)
            throw new IsConformException("请登录!");
        HashMap hashMap = JSON.parseObject(tokenValue, HashMap.class);
        String s = hashMap.get(Variable.userName).toString();
        UserName userName1 = JSON.parseObject(s, UserName.class);
        return userName1;
    }

    @Override
    public String addToken(UserName user) {
        Map<String, Object> claims = new HashMap<>();
        String uuid = CommonUtil.getRandomString(Variable.registerLeng);
        claims.put(Variable.JWTTOKEN, uuid);
        user.setUserPassword("******");
        claims.put(Variable.userName, user);
        try {
            redisTemplate.opsForValue().set(Variable.loginToken+user.getUserName(), JSON.toJSONString(claims),Variable.LoginTime, TimeUnit.DAYS);
        } catch (Exception e) {
            e.printStackTrace();
            MyCustomError.redis();
        }
        claims.put(Variable.userName, user.getUserName());
        return createJavaWebToken(claims);
    }

    // 解析Token，同时也能验证Token，当验证失败返回null
    public Map<String, Object> parserJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims =
                    Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            return null;
        }
    }
}
