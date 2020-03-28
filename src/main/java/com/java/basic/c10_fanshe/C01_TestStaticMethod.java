package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:56 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestStaticMethod {
    public static void main(String[] args) {
        //System.out.println(MyClass1.num);

        MyClass1.test();

    }
}

class MyClass1{
    public static int num = 10;

    static {
        System.out.println("静态代码块");
    }

    public static void test(){
        System.out.println("静态方法");
    }
}
