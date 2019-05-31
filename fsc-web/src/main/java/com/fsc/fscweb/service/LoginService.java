package com.fsc.fscweb.service;


import com.fsc.fscweb.entity.UserName;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

    UserName login(UserName user, HttpServletResponse response);
    void logout(Cookie cookie, HttpServletResponse response);
    Boolean updatePassword(String oldPwd, String newPwd);
}
