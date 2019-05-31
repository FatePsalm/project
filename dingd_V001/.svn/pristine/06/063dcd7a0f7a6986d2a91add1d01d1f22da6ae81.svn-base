package cn.dingd.dd.common.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.web.JsonResult;


/**此注解用于标识此类为全局的异常处理类*/
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
	@ResponseBody
	public JsonResult handMethodArgumentTypeMismatchException(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException e){
		System.out.println("参数转化失败!");
		e.printStackTrace();
		return new JsonResult(new NullPointerException("参数转化失败!"));
	}
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public JsonResult handleException(SQLException e){
		System.out.println("SQL exception");
		e.printStackTrace();
		return new JsonResult(new Exception("数据库链接异常!"));
	}
	@ExceptionHandler(org.springframework.validation.BindException.class)
	@ResponseBody
	public JsonResult handleException(org.springframework.validation.BindException e){
		System.out.println("Spring exception");
		e.printStackTrace();
		return new JsonResult(new Exception("参数注入异常!") );
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult handleException(RuntimeException e){
		System.out.println("runtime exception");
		e.printStackTrace();
		return new JsonResult(e);
	}
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(Exception e){
		System.out.println("exception");
		e.printStackTrace();
		return new JsonResult(e);
	}	
}








