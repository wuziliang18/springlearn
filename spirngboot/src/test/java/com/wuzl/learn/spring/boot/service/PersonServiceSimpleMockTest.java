package com.wuzl.learn.spring.boot.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceSimpleMockTest {
	@Mock
	CompanyService companyService;
	@InjectMocks
	PersonService personService = new PersonService(companyService);
	@Mock
	BankService bankService;

	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this);//和@RunWith(MockitoJUnitRunner.class)二选一
		when(companyService.getByName(anyString())).thenReturn("mock a");
		when(bankService.getMoeny(anyString())).thenReturn(666666666l);
	}

	@Test
	public void getDataTest() {
		System.out.println(personService.getData("123"));
	}
}
