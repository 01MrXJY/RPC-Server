package com.xiejy.rpc.api;

import com.xiejy.rpc.dto.UserDTO;

/**
 * 公共接口，定义了服务应该遵守的规范
 * 
 * @author xiejy
 */
// 此处的注解指明了实现该接口的类的全路径
@ServiceMapped(mapped = "com.xiejy.rpc.impl.UserServiceImpl")
public interface IUserService {
	public abstract UserDTO insertUser(String name, Integer age);
}
