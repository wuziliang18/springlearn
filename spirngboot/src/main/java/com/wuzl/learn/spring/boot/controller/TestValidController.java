package com.wuzl.learn.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuzl.learn.spring.boot.controller.request.SaveRequest;

@RestController

public class TestValidController {
	@RequestMapping("/valid")
//	//http://localhost:8080//valid?userName=121&age=18
//	public Object testValid(@Valid SaveRequest request,BindingResult bindingResult) {
//		Map<String,Object> result=new HashMap<>();
//		if(bindingResult.hasErrors()){
//			result.put("success", false);
//			result.put("error", bindingResult.getFieldError().getDefaultMessage());
//		}else {
//			result.put("success", true);
//		}
//		return result;
//	}
	
	//http://localhost:8080//valid?userName=121&age=18
		//交给统一异常处理
		public Object testValid(@Valid SaveRequest request) {
			Map<String,Object> result=new HashMap<>();
			result.put("success", true);
			return result;
		}
}
