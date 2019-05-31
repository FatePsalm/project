package com.fsc.fscweb.service;

import com.fsc.fscweb.entity.UserName;

import java.util.Map;

public interface TokenService {
    /**
     * 时间： 2018/5/25 16:27
     * 功能描述:通过token获取登录信息
     */
    UserName getUserLogin();
    /**
     * 时间： 2018/5/25 9:59
     * 功能描述:生成token并保存进redis
     */
    String addToken(UserName userName);
    /**
     * 时间： 2018/5/25 10:00
     * 功能描述:解析token
     */
    Map<String, Object> parserJavaWebToken(String jwt);
}
