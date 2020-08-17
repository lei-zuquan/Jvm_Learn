package com.jvm.t09_class_load;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:20 下午 2020/8/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 类加载分析 - 练习
public class T05_ClassLoad_Practice {
    public static void main(String[] args) {
        System.out.println(E.a);
        System.out.println(E.b);
        System.out.println(E.c);
    }
}

class E {
    // a, b 是静态常量，一个是整型，一个字符串常量。是在类链接的准备阶段就已经完成了赋值
    public static final int a = 10;
    public static final String b = "hello";
    // c 是包装类型，20进行装箱，c 是在初始化阶段完成赋值
    public static final Integer c = 20; // Integer.valueOf(20)
    static {
        System.out.println("init E");
    }
}
