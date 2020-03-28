package com.java.basic.c10_fanshe.c01_classloader;



/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:28 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestFather {
    public static void main(String[] args) {
        System.out.println(Son3.num); // 只会导致声明它（num) 的类初始化
    }
}

class Father3{
    public static int num = 10;
    static {
        System.out.println("父类的静态代码块");
    }
}

class Son3 extends Father3 {
    static {
        System.out.println("子类的静态代码块");
    }
}
