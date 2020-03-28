package com.java.basic.c10_fanshe.c01_classloader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:23 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestFinal {
    public static void main(String[] args) {
        System.out.println(MyClass2.INFO);
    }
}

class MyClass2{
    public static final String INFO = "test final";

    static {
        System.out.println("静态代码块");
    }
}
