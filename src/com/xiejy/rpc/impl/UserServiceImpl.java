package com.xiejy.rpc.impl;

import java.util.Random;

import com.xiejy.rpc.api.IUserService;
import com.xiejy.rpc.dto.UserDTO;

/**
 * 实现类，对接口里面的方法做具体的实现
 * @author xiejy
 */
public class UserServiceImpl implements IUserService {

	@Override
	public UserDTO insertUser(String name, Integer age) {
		// TODO Auto-generated method stub
		// 模拟业务逻辑
		UserDTO userDTO = new UserDTO(name, age);
		userDTO.setId(new Random().nextInt(1000000));
		return userDTO;
	}
	
}
