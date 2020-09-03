package com.java.z_exam.design_patterns.c05_proxy.dynamic_proxy;

/**
 * @Author:
 * @Date: Created in 10:49 下午 2020/9/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao target = new TeacherDao();
        // 给目标对象，创建代理对象，可以转成 ITeacherDao
        ITeacherDao proxyInstance =  (ITeacherDao)new ProxyFactory(target).getProxyInstance();

        // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance=" + proxyInstance.getClass());

        // 通过代理对象，调用目标对象的方法
        //proxyInstance.teach();
        proxyInstance.sayHello("tom");
    }
}
