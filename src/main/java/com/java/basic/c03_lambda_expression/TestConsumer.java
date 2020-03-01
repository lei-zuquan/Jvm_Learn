package com.java.basic.c03_lambda_expression;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 一、消费型接口
 *      抽象方法：有参无返回值
 * 1、最基本的代表
 *      Consumer<T> : void accept(T t)
 * 2、其他的变形
 *      BiConsumer<T,U>: void accept(T t, U u)
 *      DoubleConsumer: void accept(double value)
 *      IntConsumer: void accept(int value)
 *      LongConsumer: void accept(long value)
 *      ObjDoubleConsumer<T>: void accept(T t, double value)
 *      ObjIntConsumer<T>: void accept(T t, int value)
 *      ObjLongConsumer<T>: void accept(T t, long value)
 *
 * 例如：集合java.util.Collection系列的集合在JDK1.8之后就增加了这样的方法
 *              default void forEach(Consumer<? super T> action)
 *
 */
public class TestConsumer {

    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("java");
        list.add("lambda");

//        // foreach循环
//        for (String str : list) {
//            System.out.println(str);
//        }

        // forEach方法就是等价于foreach循环
        list.forEach(t -> System.out.println(t));
    }
}
