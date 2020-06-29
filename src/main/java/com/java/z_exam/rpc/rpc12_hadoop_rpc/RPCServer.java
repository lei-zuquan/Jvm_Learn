package com.java.z_exam.rpc.rpc12_hadoop_rpc;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

import java.io.IOException;

//import org.apache.hadoop.ipc.RPC.Builder;

/*
 * windows运行步骤说明：
 * 1.先启动server
 * 2.再启动client
 *
 * 另外，可以将client打包成可运行jar包，放到linux下运行:
 * 打包过程：Runnable JAR File，选择RPCClient及目目录
 * Launch configuration选择主方法名
 *
 * windows运行server，并打断点sayHi方法
 *
 * 在linux下运行RPCClient.jar
 * java -jar RPCClient.jar
 *
 * 可看到windows端server的sayHi进行断点
 */

// RPC通信，不同进程间的方法调用，其底层还是socket通信
// 即不同节点上的不同进程可以使用RPC进行方法调用
// 比如：node-01节点上的进程调用node-02节点上进程的方法

// 服务端与客户端远程调用接口

/*
 * 在2台linux服务器上运行
 * 打包过程：Runnable JAR File，选择RPCClient及目录；选择RPCServer.jar及目目录
 * Launch configuration选择主方法名
 *
 * 先node-02启动： java -jar RPCServer.jar
 * 再在node-01启动：java -jar RPCClient.jar
 *
 * 结果：在node-01上会打印出node-02上返回的sayHi方法的返回值
 */


public class RPCServer implements Bizable {

	@Override
	public String sayHi(String name) {
		return "Hi!, " + name;
	}

	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Server server = new RPC.Builder(conf).setProtocol(Bizable.class)
				.setInstance(new RPCServer()).setBindAddress("172.19.180.41").setPort(9527).build();

		server.start();
	}

}
