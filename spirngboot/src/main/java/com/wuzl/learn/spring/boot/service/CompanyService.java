package com.wuzl.learn.spring.boot.service;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	public String getByName(String name) {
		System.out.println("CompanyService getByName");
		return name + "有限公司";
	}
}
