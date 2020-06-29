package com.java.z_exam.rpc.rpc12_hadoop_rpc;

/*
 * @auther 作者
 * @version 版本 2019年1月6日下午15:55:14
 * 类说明：
 */
public interface Bizable {
	// 这一个版本号是必须要有的，hadoop2.0版本后必须指版本号
	public static final long versionID = 1L;

	public String sayHi(String name);
}
