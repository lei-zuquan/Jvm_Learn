package com.jvm.t09_class_load;

import java.io.IOException;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:05 下午 2020/8/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 类加载分析 - 解析的含义 及 说明
public class T03_ClassLoad_Resolved {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = T03_ClassLoad_Resolved.class.getClassLoader();
        // 可以通过 HSDB工具进行查看：java -cp ./lib/sa-jdi.jar sun.jvm.hotspot.HSDB
        // loadClass 方法不会导致类的解析和初始化: JVM_CONSTANT_UnresolvedClass com.jvm.t09_class_load.D
        // D类没有被加载、解析
        Class<?> c = classLoader.loadClass("com.jvm.t09_class_load.C");

        // 下述会导致C类/D类的加载，JVM_CONSTANT_Class  com.jvm.t09_class_load.D
        // new C();
        System.in.read();
    }
}
// 类C
class C {
    D d = new D();
}
// 类D
class D {
    
}

























