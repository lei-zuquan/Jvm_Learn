package com.java.z_exam.rpc.rpc12_hadoop_rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;


/*
 * @auther 作者：
 * @version 版本 2019年1月6日下们16:04:39
 * 类说明：
 */
public class RPCClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Bizable proxy = RPC.getProxy(Bizable.class, 1,
				new InetSocketAddress("172.19.180.41", 9527),
				new Configuration());

		String resultString = proxy.sayHi("tomcat");
		System.out.println(resultString);
		RPC.stopProxy(proxy);
	}

}
