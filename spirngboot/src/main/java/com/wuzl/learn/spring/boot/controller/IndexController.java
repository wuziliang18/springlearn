package com.wuzl.learn.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	 @RequestMapping("/hello")
	    public String index() {
	        return "Hello World";
	    }
}
