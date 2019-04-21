package com.wuzl.learn.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

    public static void main(String[] args) {
        // http://localhost:8080/
        SpringApplication.run(Application.class, args);
    }
}
