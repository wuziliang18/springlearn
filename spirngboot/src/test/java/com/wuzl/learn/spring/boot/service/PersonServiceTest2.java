package com.wuzl.learn.spring.boot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest2 {
	@Autowired
	@InjectMocks
	PersonService personService;

	@Test
	public void getDataTest() {
		System.out.println(personService.getData("123"));
	}
}
