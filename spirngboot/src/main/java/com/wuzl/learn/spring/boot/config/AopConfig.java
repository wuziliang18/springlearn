package com.wuzl.learn.spring.boot.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	// 使用切点可以复用
	@Pointcut("execution(* com.wuzl.learn.spring.boot.service.*.*(..))")
	public void pointcut() {

	}
	
	@Pointcut("execution(* com.wuzl.learn.spring.boot.service.*.*(String)) && args(stringParam)")
	public void pointcutParam(String stringParam) {

	}

	// 所有bean都拦截
	// @Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..))")
	// 只拦截personservice的和不拦截persionservice的 不生效? 需要去掉引号
	// @Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..)) and
	// bean(personService)")
	// @Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..)) and
	// !bean(personService)")
	// 使用切点
	@Before("pointcutParam(stringParam)")
	public void before(String stringParam) {
		System.out.println("before:>>param:" + stringParam);
	}

	@Before("pointcut()")
	public void before() {
		System.out.println("before");
	}

}
