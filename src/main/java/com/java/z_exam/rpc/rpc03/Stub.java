package com.java.z_exam.rpc.rpc03;

import com.java.z_exam.rpc.common.IUserService;
import com.java.z_exam.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:20 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 而且Client的调用显得不是很合理（Stub里只有findById的代码）， 如果有个findByName的新方法，那么就又得修改代理Stub
 下面这种写法解决了方法增加的问题
 */
public class Stub {
    public static IUserService getStub() throws Exception {
        // InvocationHandler 调用方法处理器
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123);

                s.getOutputStream().write(baos.toByteArray());
                s.getOutputStream().flush();

                DataInputStream dis = new DataInputStream(s.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                dos.close();
                s.close();

                return user;
            }
        };

        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(),
                new Class[]{IUserService.class}, h);

        // 打印出动态接口实现类XXX
        System.out.println(o.getClass().getName());
        // 打印出动态实现了哪些接口
        System.out.println(o.getClass().getInterfaces()[0]);
        return (IUserService)o;
    }
}
