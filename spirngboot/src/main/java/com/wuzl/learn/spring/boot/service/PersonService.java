package com.wuzl.learn.spring.boot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class PersonService {
	private CompanyService companyService;

	@Autowired
	public PersonService(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@Autowired
	private BankService bankService;

	public Map<String, Object> getData(String personId) {
		System.out.println("PersonService get");
		Map<String, Object> dto = new HashMap<>();
		dto.put("personId", personId);
		dto.put("personName", "用户" + personId);
		dto.put("companyName", companyService.getByName("测试"));
		dto.put("money", bankService.getMoeny(personId));
		return dto;
	}
}
