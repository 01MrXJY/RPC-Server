package com.xiejy.rpc.dto;

import java.io.Serializable;

/**
 * 定义了客户端往服务端传输过来的数据的格式，做了约束，将其封装为一个类
 * @author xiejy
 * 
 */
public class RPCTransFormObj implements Serializable {
	// 序列化和反序列化时控制版本的一致性，兼容
	private static final long serialVersionUID = 2L;
	// 类的全路径名称
	private String classFullName;
	// 要调用的方法名
	private String methodName;
	// 要调用的方法所需要的参数
	private Object[] parameters;

	public String getClassFullName() {
		return classFullName;
	}

	public void setFullClassName(String classFullName) {
		this.classFullName = classFullName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

}
