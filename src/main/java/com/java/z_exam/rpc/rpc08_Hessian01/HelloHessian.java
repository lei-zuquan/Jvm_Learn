package com.java.z_exam.rpc.rpc08_Hessian01;

import com.java.z_exam.rpc.common.User;

import java.io.ByteArrayOutputStream;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:35 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class HelloHessian {
    public static void main(String[] args) throws Exception {
        User u = new User(1, "zhangSan");

    }

    /*public static byte[] serialize(Object o) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new Hessian2Output(baos);
    }*/
}
