package com.java.basic.c03_lambda_expression.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream
 *
 * 一、创建Stream
 *      1、用数组创建
 *              数组工具类： java.util.Arrays
 *              static <T> Stream<T> stream(T[] array)
 *      2、用集合创建
 *              集合对象.stream()
 *      3、用Stream中的of方法
 *              Stream.of(T... values)
 *      4、无限流
 *              Stream类中
 *              Stream.generate(Supplier s)
 *              iterate(T seed, UnaryOperator<T> f)
 */
public class TestCreateStream {
    @Test
    public void test6(){
        /**
         * t是流中的数据，第一个数据是1，种子
         * 在1的基础上+2，并且不断的迭代
         * 数据流中的数据 1，3，5，7，9...
         */
        Stream<Integer> stream = Stream.iterate(1, t -> t + 2);
        // 为了看效果，加入一步中间操作
        stream.limit(100); // 必须接收，不接收就有问题
        stream.forEach(System.out::println);

    }
    @Test
    public void test5(){
        // 用Math.random来产生随机
        Stream<Double> stream = Stream.generate(() -> Math.random());
        stream.forEach(System.out::println);
    }

    @Test
    public void test3(){
        Stream<String> stream = Stream.of("hello", "world", "java");
    }

    @Test
    public void test2(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");

        Stream<String> stream = list.stream();
    }

    @Test
    public void test1(){
        String[] arr = {"hello", "world", "java"};

        // 创建一个Stream
        Stream<String> stream = Arrays.stream(arr);

        // 例如：提取用一下终结操作
        //stream.forEach(t -> System.out.println(t));
        stream.forEach(System.out::println);

    }
}
