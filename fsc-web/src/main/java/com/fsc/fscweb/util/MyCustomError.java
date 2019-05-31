package com.fsc.fscweb.util;

import com.fsc.fscweb.handler.exception.IsConformException;

public class MyCustomError {
	/**
	 * 
	 * @return
	 * 数据库连接异常
	 */
	public static NullPointerException mysqlE() {
		throw new IsConformException("失败!");
	}
	/**
	  * 时间： 2018/5/25 15:25
	  * 功能描述:redis连接异常
	  */
	public static NullPointerException redis() {
		throw new NullPointerException("redis连接异常!");
	}

}
