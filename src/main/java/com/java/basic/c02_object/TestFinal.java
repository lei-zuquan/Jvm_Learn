package com.java.basic.c02_object;

/**
 * final: 最终
 * final是一个修饰符
 *
 * final可以修饰：
 * 1）类：包括内部类和外部类
 * 2）方法
 * 3）变量：包括属性和局部变量
 *
 * 1、final修饰类
 * 表示这个类不能被继承，是个太监类， 没有子类
 *
 * 2、final修饰方法
 * 表示这个方法可以被子类继承，但是不能被子类重写
 *
 * 3、final修饰变量
 * 表示它是一个常量，值不能被修改
 * 常量建议大写
 *
 * 学习修饰符：
 * 1）它可以修饰什么？
 * 2）它修饰后有什么不同？
 */
public class TestFinal {

    public static void main(String[] args) {
        final int NUM = 10;

        final  MyClass my = new MyClass();
        my.i = 10;
    }
}


class MyClass {
    int i;
}
