package com.java.basic.c03_lambda_expression;

import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Lambda表达式是给函数式接口的形参或变量赋值用的。
 * 为了给这个函数式接口的抽象方法传递代码用的。
 *
 * 语法格式：
 *      （形参列表） -> {lambda体}
 *
 * （形参列表）就是函数式接口的抽象方法的形参列表。
 * {lambda体} 就是函数式接口的抽象方法的方法体。
 *
 * 说明：
 * 1、当（形参列表）是空参时，那么() 是不能省略的
 * 2、当（形参列表）是空参时，并且类型是确定的或者可以推断的，那么形参的数据类型可以省略
 * 3、当（形参列表）是空参时，并且只有一个形参，并且类型也省略了那么此时()也可以省略，如果类型没有省略，那么()也不能省略
 * 4、如果{lambda体}不止一个语句，那么{}不能省略，并且每一个语句都要;结束
 * 5、如果{lambda体}只有一个语句，那么{}和;都可以省略，{}和;要同时省略
 * 6、如果该函数式接口的抽象方法的返回值类型不是void，那么{lambda体}里面要有return 返回值语句。
 *      当如果{lambda体}中只有一个{return 返回值;}语句时，此时{}和; 和return 都同时省略
 *
 */
public class TestLambdaGrammer {
    /**
     * Collection接口从Iterable接口继承的：
     * default void forEach(Consumer<? super T> action)
     *
     * Consumer<T> : 消费型  void  accept(T t), 有参无返回值，这里是一个参数
     */
    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("java");
        list.add("lambda");

        // 用匿名内部类能Consumer接口的形参赋值
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // forEach方法就是等价于foreach循环
        //list.forEach((String t) -> { System.out.println(t); });

        // 省略数据类型
        list.forEach((t) -> { System.out.println(t); });

        // 省略()
        list.forEach(t -> { System.out.println(t); });
    }
}
