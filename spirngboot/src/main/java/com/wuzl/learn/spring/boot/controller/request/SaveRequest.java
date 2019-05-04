package com.wuzl.learn.spring.boot.controller.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SaveRequest {
	@NotBlank(message = "姓名不可以为空")
	private String userName;
	@Min(value = 18, message = "年龄有限制成人才可以哟")
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
