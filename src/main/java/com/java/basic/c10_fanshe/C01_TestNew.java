package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:53 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestNew {
    public static void main(String[] args) {
        new MyClass();
    }
}

class MyClass{
    {
        System.out.println("非静态代码块");
    }
    static{
        System.out.println("静态代码块");
    }
}
