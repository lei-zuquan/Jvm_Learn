package com.java.basic.c02_object;

/**
 * 题目：
 *      1）用匿名内部类的形式创建一个Object的子类，
 *      2）并且在子类中声明一个方法public void test(){}
 *              打印一句话
 *      3）调用这个方法
 */
public class TestMeetObject2 {
    public static void main(String[] args) {
        /**
        // 多态引用，编译时，看父类
        Object obj = new Object(){
            public void test(){
                System.out.println("xxx");
            }
        };
        obj.test();*/

        // 用匿名内部类的匿名对象.方法
        new Object(){
            public void test(){
                System.out.println("XXX");
            }
        }.test();
    }
}
