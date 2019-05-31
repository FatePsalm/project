package com.fsc.fscweb.handler;

import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.util.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class GlobalException {
    /**
     * 时间:  2018/5/13 9:29
     * 功能描述:日常参数判断
     */
    @ExceptionHandler(IsConformException.class)
    public JsonResult isConformException(IsConformException e) {
        e.printStackTrace();
        return new JsonResult(e);
    }
    /**
     * 时间:  2018/5/13 9:29
     * 功能描述:参数绑定异常
     */
    @ExceptionHandler(org.springframework.validation.BindException.class)
    public JsonResult BindException(org.springframework.validation.BindException e) {
        System.out.println("参数绑定异常!");
        e.printStackTrace();
        return new JsonResult(new NullPointerException("参数绑定异常!"));
    }
    @ExceptionHandler(org.springframework.data.redis.RedisConnectionFailureException.class)
    public JsonResult redisException(org.springframework.data.redis.RedisConnectionFailureException e) {
        System.out.println("redis连接错误!");
        e.printStackTrace();
        return new JsonResult(new NullPointerException("redis连接错误!"));
    }
}
