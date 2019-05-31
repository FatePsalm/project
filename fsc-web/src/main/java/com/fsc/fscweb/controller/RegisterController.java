package com.fsc.fscweb.controller;


import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.EmailService;
import com.fsc.fscweb.service.RegisterService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者: Solace
 * 时间: 2018/6/30 23:33
 * 功能: 注册/找回密码
 * 参数:
 */
@RestController
@CrossOrigin
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private RegisterService registerService;
    /**
     * 作者: Solace
     * 时间: 2018/7/1 2:37
     * 功能: 找回密码
     * 参数:
     */
    @RequestMapping("retrievePwd")
    public JsonResult retrievePwd(UserName userName, String code) {
        if (CommonUtil.checkEmail(userName.getUserName()))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkStr(userName.getUserPassword())||userName.getUserPassword().length()<6)
            throw new IsConformException("密码强度弱!");
        if (CommonUtil.checkStr(code))
            throw new IsConformException("请输入验证码!");
        Boolean aBoolean = registerService.retrievePwd(userName, code);
        return new JsonResult(aBoolean);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/1 1:15
     * 功能: 注册
     * 参数:
     */
    @RequestMapping("register")
    public JsonResult register(UserName userName, String code) {
      if (CommonUtil.checkEmail(userName.getUserName()))
          throw new IsConformException("邮箱地址格式不正确!");
      if (CommonUtil.checkStr(userName.getUserPassword())||userName.getUserPassword().length()<6)
          throw new IsConformException("密码强度弱!");
      if (CommonUtil.checkStr(code))
          throw new IsConformException("请输入验证码!");
        Boolean register = registerService.register(userName,code);
        return new JsonResult(register);
    }
    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:33
     * 功能: 注册验证码
     * 参数:
     */
    @RequestMapping("registerCode")
    public JsonResult registerCode(String email) {
       if (CommonUtil.checkEmail(email))
           throw new IsConformException("邮箱地址格式不正确!");
        Boolean result = emailService.registerCode(email);
        return new JsonResult(result==true?"发送成功,验证码有效期5分钟!":"发送失败!");
    }

}
