package com.java.z_exam.rpc.rpc07;

import com.java.z_exam.rpc.common.IUserService;
import com.java.z_exam.rpc.common.User;

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
        IproductService service = (IproductService) Stub.getStub(IproductService.class);
        User user = service.findUserById(321);
        System.out.println(user);

    }
}
