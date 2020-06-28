package com.java.z_exam.rpc.rpc07;

//import com.java.z_exam.rpc.common.IUserService;
//import com.java.z_exam.rpc.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 但是这里仅仅实现了findByUserId的方法代理，如果要实现其他方法的代理该怎么做呢？
 这里就要从协议层做出改进

 服务器端也要做出对应处理
 */
public class Stub {
    public static Object getStub(Class clazz) throws Exception {
        // InvocationHandler 调用方法处理器
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String clazzName = clazz.getName();
                String methodName = method.getName();
                Class[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(clazzName);
                // 方法名
                oos.writeUTF(methodName);
                // 方法参数类型，解决方法重载问题
                oos.writeObject(parameterTypes);
                // 参数
                oos.writeObject(args);
                oos.flush();

                ObjectInputStream ojs = new ObjectInputStream(s.getInputStream());
                Object o = ojs.readObject();

                oos.close();
                s.close();
                return o;
            }
        };

        Object o = Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, h);

        // 打印出动态接口实现类XXX
        //System.out.println(o.getClass().getName());
        // 打印出动态实现了哪些接口
        //System.out.println(o.getClass().getInterfaces()[0]);
        return o;
    }
}
