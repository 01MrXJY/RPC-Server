package com.xiejy.rpc.main;

import com.xiejy.rpc.net.SocketServer;

public class MainTest {
	public static void main(String[] args) {
		System.out.println("服务已经启动。。。");
		SocketServer.startServer(10000);
	}
}
