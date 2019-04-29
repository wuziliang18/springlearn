package com.wuzl.learn.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wuzl.learn.spring.boot.service.PersonService;

@RestController
public class TestController {
	@Autowired
	private PersonService personService;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/get")
	public Object get() {
		return personService.getData("666");
	}
}
