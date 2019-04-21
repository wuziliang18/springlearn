package com.wuzl.learn.spring.boot.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AopConfig {
	//使用切点可以复用
	@Pointcut("execution(* com.wuzl.learn.spring.boot.service.*.*(..))")
	public void pointcut() {
		
	}
	//所有bean都拦截
//	@Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..))")
	//只拦截personservice的和不拦截persionservice的  不生效? 需要去掉引号
//	@Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..)) and bean(personService)")
//	@Before("execution(* com.wuzl.learn.spring.boot.service.*.*(..)) and !bean(personService)")
	//使用切点
	@Before("pointcut()")
	public void before() {
		System.out.println("before");
	}
}
