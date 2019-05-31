package com.fsc.fscweb.handler.exception;

/**
 * 作者: Solace
 * 时间: 2018/7/1 0:07
 * 功能:判断日常参数是否合法
 * 参数:
 */
public class IsConformException extends RuntimeException {

    public IsConformException() {
        super();
    }


    public IsConformException(String s) {
        super(s);
    }

}
