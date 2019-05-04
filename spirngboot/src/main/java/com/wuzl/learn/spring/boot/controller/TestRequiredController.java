package com.wuzl.learn.spring.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestRequiredController {
	@RequestMapping("/required")
	// 这种方法不可以 拦截不到403
	// http://localhost:8080//required?userName=121
	public @ResponseBody Object testRequired(@RequestParam String userName) {
		Map<String, Object> result = new HashMap<>();
		// if(error.hasErrors()){
		// result.put("success", false);
		// result.put("error", error.getFieldError().getDefaultMessage());
		// }else {
		// result.put("success", true);
		// }
		result.put("success", true);
		return result;
	}

	@RequestMapping("/requiredView")
	public String testRequiredView(@RequestParam String userName) {
		return "index";
	}
}
