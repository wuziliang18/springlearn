package com.wuzl.learn.spring.boot.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
	@Mock
	CompanyService companyService;
	@Autowired
	@InjectMocks
	PersonService personService;

	@Test
	public void getDataTest() {
		when(companyService.getByName(anyString())).thenReturn("mock a");
		System.out.println(personService.getData("123"));
	}
}
