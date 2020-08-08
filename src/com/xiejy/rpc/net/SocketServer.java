package com.xiejy.rpc.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
	public static void startServer(int port) {
		// 创建线程池
		ExecutorService executorService = Executors.newFixedThreadPool(300);
		try {
			// 服务端socket通信，启动时需传入要监听的接口
			ServerSocket serverSocket = new ServerSocket(port);
			// 因为需要接收的请求肯定不止一个，所以这里需要一直监听
			while(true) {
				// 阻塞地等待客户端的连接，一旦执行成功会得到一个客户端socket连接对象
				Socket socket = serverSocket.accept();
//				socket.getInputStream();
				
				// 如果有很多的客户端请求连接，没有线程池的话，只能一个一个进行处理
				// 这里使用BIO方式，阻塞式 交给一个新的线程去处理  M:N 线程池
				// execute这里意思就是当传入的是runnable任务时，就会使用executorService里面的一个线程去执行runnable对象里面的run方法
				executorService.execute(new RPCRequestHandler(socket));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
