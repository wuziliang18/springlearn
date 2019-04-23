package com.wuzl.learn.spring.boot.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 新创建对象 所有的bean都需要注入 CompanyService用的mock BankService用的spring注入 Spring
 * test默认会重用bean。如果另有一个测试也使用注入的SampleService并在这个测试之后运行，那么拿到service中的dependencyA仍然是mock对象。一般这是不期望的。所以需要用@DirtiesContext
 * 
 * @author ziliang.wu
 *
 */
@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest
public class PersonServiceTestMock {
	@Mock
	CompanyService companyService;
	// @Mock
	// Spy声明的对象，对函数的调用均执行真正部分。
	@Spy
	@Autowired
	BankService bankService;
	@InjectMocks
	PersonService personService = new PersonService(companyService);

	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this);
		when(companyService.getByName(anyString())).thenReturn("mock a");
		// when(bankService.getMoeny(anyString())).thenReturn(666666666l);//也需要mock否则报错
	}

	@Test
	public void getDataTest() {

		System.out.println(personService.getData("123"));
	}
}
