package com.xiejy.rpc.dispatch;

import java.lang.reflect.Method;

import com.xiejy.rpc.dto.RPCTransFormObj;

/**
 * 负责完成服务的分发
 * 客户端通过网络通信（socket通信）将数据传输到服务端socket，服务端socket调用服务分发，服务分发从服务端socket拿到数据对象，
 * 根据规则将数据进行解析，分别拿到目标类的全路径名、要调用的方法名、需要的参数，之后通过jdk的反射机制拿到目标类的实例，实现
 * 服务的调用，返回结果
 * @author xiejy
 */
public class ServiceDispatch {
	// 这里为了更通用，所以返回值类型定义为Object
	// dispatch方法接收的肯定是按照RPCTransFormObj规范包装好的数据
	public static Object dispatch(RPCTransFormObj obj) {
		String classFullName = obj.getClassFullName();
		String methodName = obj.getMethodName();
		Object[] parameters = obj.getParameters();
		Class[] parameterTypes = new Class[parameters.length];
		Object retObject = null;
		// 根据拿到的参数获取参数对应的字节码对象
		for(int i = 0;i<parameters.length;i++) {
			parameterTypes[i] = parameters[i].getClass();
		}
		
		try {
			// 通过反射拿到该类对应的字节码对象
			Class clazz = Class.forName(classFullName);
			// 拿到要调用的方法实例
			Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
			// 调用方法，拿到返回值
			retObject = method.invoke(clazz.newInstance(), parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retObject;
	}
}
