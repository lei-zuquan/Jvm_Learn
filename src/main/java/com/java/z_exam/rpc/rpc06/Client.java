package com.java.z_exam.rpc.rpc06;

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
        IUserService service = (IUserService) Stub.getStub(IUserService.class);
        System.out.println(service.findUserById(123));
    }
}
