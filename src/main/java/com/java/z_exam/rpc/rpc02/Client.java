package com.java.z_exam.rpc.rpc02;

import com.java.z_exam.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:03 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Stub stub = new Stub();
        System.out.println(stub.findUserById(123));
    }
}
