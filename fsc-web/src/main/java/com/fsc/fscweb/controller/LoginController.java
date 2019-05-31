package com.fsc.fscweb.controller;


import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.LoginService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.CookieUtil;
import com.fsc.fscweb.util.JsonResult;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者: Solace
 * 时间: 2018/6/30 22:50  
 * 功能: 登录/登出
 * 参数: 
 */
@RestController
@CrossOrigin
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 作者: Solace
     * 时间: 2018/6/30 22:51
     * 功能: 修改密码
     * 参数:
     */
    @RequestMapping("updatePassword")
    public JsonResult updatePassword(String oldPwd, String newPwd) {
        if (CommonUtil.checkStr(oldPwd)||oldPwd.length()<6)
            throw new IsConformException("原始密码强度弱!");
        if (CommonUtil.checkStr(newPwd)||newPwd.length()<6)
            throw new IsConformException("新密码强度弱!");
        Boolean aBoolean = loginService.updatePassword(oldPwd, newPwd);
        return new JsonResult(aBoolean);
    }
    /**
     * 作者: Solace
     * 时间: 2018/6/30 22:51  
     * 功能: 登录
     * 参数: 
     */
    @RequestMapping("login")
    public JsonResult login(UserName user, HttpServletResponse response) {
        if (CommonUtil.checkEmail(user.getUserName()))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkStr(user.getUserPassword())||user.getUserPassword().length()<6)
            throw new IsConformException("密码强度弱!");
        UserName login = loginService.login(user, response);
        return new JsonResult(login);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/1 16:26
     * 功能: 登出
     * 参数:
     */
    @RequestMapping("/logout")
    public JsonResult logout(HttpServletRequest request, HttpServletResponse response) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, Variable.JWTTOKEN);
        if (cookie != null) {
            loginService.logout(cookie, response);
        }else {
            throw new IsConformException("请携带Cookie!");
        }

        return new JsonResult("退出成功!");
    }
}
