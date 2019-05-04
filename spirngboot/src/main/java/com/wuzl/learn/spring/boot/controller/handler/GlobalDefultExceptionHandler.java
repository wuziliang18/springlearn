package com.wuzl.learn.spring.boot.controller.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常拦截器 拦截页面请求的 当前会和@RestControllerAdvice冲突 考虑在request里做处理+个启动扫描response注解的排除
 * 
 * @author ziliang.wu
 *
 */
//@ControllerAdvice
public class GlobalDefultExceptionHandler {

	/**
	 * 处理@RequestParam必传参数缺失异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingServletRequestParameterException(MissingServletRequestParameterException e,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		/* 定义视图的名字 */
		modelAndView.setViewName("error");
		modelAndView.addObject("param", e.getParameterName());
		modelAndView.addObject("error", e.getMessage());
		/* 返回视图，视图为error.ftl */
		return modelAndView;
	}

}
