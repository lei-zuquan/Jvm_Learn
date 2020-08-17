package com.jvm.t09_class_load;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:55 下午 2020/8/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 类加载分析 - 类初始化示例
public class T04_ClassLoad_Init {
    static {
        // main 方法所在的类，总会被首先初始化
        System.out.println("main init");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 不会导致类初始化的情况
        // 1、静态常量不会触发初始化
        System.out.println(B.b);
        // 2、类对象.class 不会触发初始化
        System.out.println(B.class);
        // 3、创建该类的数组不会触发初始化
        System.out.println(new B[0]);
        // 4、不会初始化类 B，但会加载 B、A
        ClassLoader c1 = Thread.currentThread().getContextClassLoader();
        c1.loadClass("com.jvm.t09_class_load.B");
        // 5、不会初始化类 B，但会加载 B、A
        ClassLoader c2 = Thread.currentThread().getContextClassLoader();
        Class.forName("com.jvm.t09_class_load.B", false, c2);

        // 导致类初始化的情况
        // 1、首次访问这个类的静态变量或静态方法时
        System.out.println(A.a);
        // 2、子类初始化，如果父类还没有初始化，会引发
        System.out.println(B.c);
        // 3、子类访问父类静态变量，只触发父类初始化
        System.out.println(B.a);
        // 4、会初始化类 B，并先初始化类 A
        Class.forName("com.jvm.t09_class_load.B");
    }
}

class A {
    static int a = 0;
    static {
        System.out.println("a init");
    }
}

class B extends A {
    final static double b = 5.0;
    static boolean c = false;
    static {
        System.out.println("b init");
    }
}
