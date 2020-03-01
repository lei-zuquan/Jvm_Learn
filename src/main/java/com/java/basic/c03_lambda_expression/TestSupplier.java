package com.java.basic.c03_lambda_expression;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 二、供给型接口
 *      抽象方法：无参有返回值
 *
 * 1、最基本的代表
 *      Supplier<T> : T get()
 *
 * 2、其他变形
 *      BooleanSupplier boolean getAsBoolean()
 *      DoubleSupplier double getAsDouble()
 *      IntSupplier int getAsInt()
 *      LongSupplier long getAsLong()
 *
 * StreamAPI:
 *      Stream是一个数据流
 *      java.util.stream包stream类型
 *          static <T> Stream<T> generate(Supplier<T> s)
 */
public class TestSupplier {

    @Test
    public void test(){
        // generate 产生
        // Math.random(): 随机产生
        Stream<Double> stream = Stream.generate(() -> Math.random());

        stream.forEach(t -> System.out.println(t));
    }
}
