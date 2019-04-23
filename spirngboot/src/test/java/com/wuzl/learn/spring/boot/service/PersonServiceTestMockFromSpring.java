package com.wuzl.learn.spring.boot.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 使用spring注入的bean 只有需要的bean才需要mock
 * 
 * @author ziliang.wu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTestMockFromSpring {
	// @Mock
	// CompanyService companyService;
	@Autowired
	PersonService personService;

	@MockBean
	BankService bankService;

	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this);
		// when(companyService.getByName(anyString())).thenReturn("mock a");
		when(bankService.getMoeny(anyString())).thenReturn(666666666l);
	}

	@Test
	public void getDataTest() {

		System.out.println(personService.getData("123"));
	}
}
