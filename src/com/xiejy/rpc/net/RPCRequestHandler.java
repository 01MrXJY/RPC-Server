package com.xiejy.rpc.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.xiejy.rpc.dispatch.ServiceDispatch;
import com.xiejy.rpc.dto.RPCTransFormObj;

/**
 * 和客户端进行网络通信
 * 
 * @author xiejy
 *
 */
public class RPCRequestHandler implements Runnable {
	private Socket socket;

	// 通过构造注入的方式，将获取到的socket客户端传入
	public RPCRequestHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 声明一个对象输入流
		ObjectInputStream ois = null;
		// 声明一个对象输出流
		ObjectOutputStream oos = null;
		Object retObject = null;
		try {
			// 通过得到的socket客户端获取输入流，再将其包装为对象输入流
			ois = new ObjectInputStream(socket.getInputStream());
			// 通过readObject()方法进行反序列化，我们期望得到RPCTransFormObj类型对象，readObject()返回的是Object对象，所以这里进行强转
			RPCTransFormObj rpcTransFormObj = (RPCTransFormObj) ois.readObject();

			/**
			 * 这里是代码运行时，测试是否从客户端获取到数据
			 * System.out.println("已读取到rpcTransFormObj"+rpcTransFormObj); for (int i =
			 * 0;i<rpcTransFormObj.getParameters().length;i++) {
			 * System.out.println(rpcTransFormObj.getParameters()[i]); }
			 */

			// 调用服务分发方法
			retObject = ServiceDispatch.dispatch(rpcTransFormObj);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(retObject);
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
