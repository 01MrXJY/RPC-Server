package com.xiejy.rpc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 为了能更加灵活地获取要调用的服务端实现类的全路径，定义了注解
 * @Retention 定义的是这个注解在什么情况下还会保留（保留策略）
 * @Target 定义的是该注解是给谁用的
 * @Target(ElementType.Type)就是说不管是在接口还是类上都可以使用该注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceMapped {
	// annotation中拥有的一个属性
	String mapped();

}
