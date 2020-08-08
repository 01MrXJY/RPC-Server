package com.xiejy.rpc.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * 实体类 定义服务端函数返回的数据格式
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private int id;

	public UserDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	

}
