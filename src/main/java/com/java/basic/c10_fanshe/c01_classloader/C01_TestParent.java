package com.java.basic.c10_fanshe.c01_classloader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:01 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestParent {
    public static void main(String[] args) {
        Son.test();
    }
}


class Parent{
    static{
        System.out.println("父类的静态代码块");
   }
}

class Son extends Parent{
    static {
        System.out.println("子类的静态代码块");
    }

    public static void test(){
        System.out.println("子类的静态方法");
    }
}