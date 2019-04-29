package com.wuzl.learn.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	//http://localhost:8080/index?text=中文
	@RequestMapping("/index")
	public String index(@RequestParam(value = "text", required = false) String text,Model model) {
		model.addAttribute("message", "controller返回"+text);
		System.out.println(text);
		return "index";
	}

}
