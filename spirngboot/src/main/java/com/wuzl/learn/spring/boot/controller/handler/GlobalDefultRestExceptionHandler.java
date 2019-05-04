package com.wuzl.learn.spring.boot.controller.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常拦截器 拦截json的
 * 
 * @author ziliang.wu
 *
 */
@RestControllerAdvice
public class GlobalDefultRestExceptionHandler {

	/**
	 * 处理@RequestParam必传参数缺失异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Map<String, Object> handleMissingServletRequestParameterException(
			MissingServletRequestParameterException e) {
		Map<String, Object> result = new HashMap<>();
		result.put(e.getParameterName(), e.getParameterType());
		return result;
	}

	/**
	 * 处理requestbody 的model验证异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidationBodyException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		for (ObjectError s : e.getBindingResult().getAllErrors()) {

			result.put("Invalid_Request_Parameter", s.getObjectName() + ": " + s.getDefaultMessage());
		}
		return result;
	}

	/**
	 * 处理普通请求的model验证异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public Map<String, Object> handleBindException(BindException e) {
		Map<String, Object> result = new HashMap<>();
		result.put("error", e.getFieldError().getDefaultMessage());
		return result;
	}

	/**
	 * 处理业务异常
	 */

	/**
	 * 处理未知异常
	 */

}
