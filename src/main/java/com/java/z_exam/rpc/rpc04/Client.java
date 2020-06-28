package com.java.z_exam.rpc.rpc04;

import com.java.z_exam.rpc.common.IUserService;

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
        IUserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
    }
}
