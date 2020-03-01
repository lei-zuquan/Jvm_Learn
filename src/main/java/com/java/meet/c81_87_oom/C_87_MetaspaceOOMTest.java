package com.java.meet.c81_87_oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 87_OOM之Metaspace
 *
 * 使用java -XX:+PrintFlagsInitial命令查看本机的初始化参数，-XX:Metaspacesize为21810376B(大约20.8M)
 *
 * JVM参数
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *
 * Java 8及之后的版本使用Metaspace来替代永久代。
 *
 * Metaspace是方法区在HotSpot中的实现，它与持久代最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存
 * 也即在java8中，classe metadata (the virtual machines internal presentation of java class)，被存储在叫做
 * Metaspace的native memory
 *
 * 永久代（java8后被原空间Metaspace取代了）存放了以下信息：
 *      虚拟机加载的类信息
 *      常量池
 *      静态变量
 *      即时编译后的代码
 *
 * 模拟Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小的
 *
 * java.lang.OutOfMemoryError: Metaspace
 *
 */
public class C_87_MetaspaceOOMTest {

    static class OOMTest{

    }

    /**
     * 需要在pom.xml中导入
     *         <dependency>
     *             <groupId>cglib</groupId>
     *             <artifactId>cglib</artifactId>
     *             <version>2.2.2</version>
     *         </dependency>
     *         <dependency>
     *             <groupId>asm</groupId>
     *             <artifactId>asm</artifactId>
     *             <version>3.1</version>
     *         </dependency>
     * @param args
     */
    public static void main(String[] args) {
        int i = 0; // 模拟计数多少次以后发生异常

        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e){
            System.out.println("*************多少次后发生异常：" + i);
            e.printStackTrace();
        }
    }
}
