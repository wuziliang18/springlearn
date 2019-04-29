package com.wuzl.learn.spring.boot.service.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.wuzl.learn.spring.boot.controller.IndexController;

public class IndexControllerTest {
	@Test
	public void indexTest() throws Exception {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //在test中重新配置视图解析器
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
		IndexController indexController=new IndexController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(indexController).setViewResolvers(resolver).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(MockMvcResultMatchers.view().name("index"));
	}
}
