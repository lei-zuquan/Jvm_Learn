package com.java.basic.c03_lambda_expression.exer;


import java.util.ArrayList;

/**
 * 1、练习1：使用forEach(Consumer c) 方法遍历Collection系列的集合
 *
 * 创建一个ArrayList集合，保存本组学员的姓名，用上面的方法遍历显示
 *
 */
public class TestExer1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("孟令乐");
        list.add("张武林");
        list.add("刘俊峰");

        /**
         * Consumer<T> : 消费型接口   void   xxx(T t)   有参无返回值
         *
         * lambda表达式的形参列表(T t), 省略后就是一个t
         * {lambda体}，这里就是打印元素
         *
         */

        list.forEach(t -> System.out.println(t));
    }
}
