package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:34 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_TestArray {
    public static void main(String[] args) {
        MyClass3[] arr = new MyClass3[5]; // 只是创建了数组对象，没有MyClass的对象
        // 数组对象的类型 MyClass[]
        // 数组元素的类型 MyClass
        System.out.println(arr.getClass());
        // class [Lcom.java.basic.c10_fanshe.MyClass3;
    }
}

class MyClass3{
    static {
        System.out.println("静态代码块");
    }
}
