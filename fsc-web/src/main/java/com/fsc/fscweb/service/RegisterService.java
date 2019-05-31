package com.fsc.fscweb.service;

import com.fsc.fscweb.entity.UserName;

public interface RegisterService {
    /**
     * 作者: Solace
     * 时间: 2018/7/1 1:22
     * 功能: 注册
     * 参数:
     */
     Boolean register(UserName userName, String code);
     Boolean retrievePwd(UserName userName, String code);
}
