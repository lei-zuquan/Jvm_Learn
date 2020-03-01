package com.java.basic.c03_lambda_expression.exer;

import org.junit.Test;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 方法引用和构造器引用，是对Lambda表达式的再次简化的一个语法
 *
 * 当Lambda表达式的Lambda体满足一些情况时，可以使用方法引用或构造器引用再次简化：
 *      1）当Lambda体是通过调用一个先有的类、对象的先有的方法来完成功能时，
 *      2）并且这个方法的形参列表和返回值类型，与该Lambda表达式所赋值的函数式接口的抽象方法的形参列表和返回值类型对应。
 *
 * 语法格式：
 *      类名或对象名:: 方法名/new
 *
 * 形式：
 *      1）对象::实例方法名
 *      2）类名::静态方法名
 *      3）类名::实例方法名
 *      4）类名::new --> 构造器引用
 *      5）数组类型::new --> 特殊的构造器引用，数组的构造器引用
 */
public class TestMethodReference {

    /**
     * 自定义方法，功能：可以创建一个数组对象，但是要求这个数组的长度必须是2的n次方
     * 你指定length为数组的长度，如果length本身就是2的次方，那么就用length，否则纠正为最近的 > length 的2的n次方
     */
    public <R> R[] createArray(Function<Integer, R[]> fun, int length){
        int n = length - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ? 1: n+1;
        return fun.apply(length);
    }

    /**
     * Function<T,R>: 功能型接口 抽象方法，有参数返回值 R apply(T t)
     *
     * Function<Integer,R[]> : T是Integer类型，R是R[]数组类型
     */
    @Test
    public void test6(){
        //String[] arr = createArray((length) -> new String[length], 9);
        //数组构造引用
        String[] arr = createArray(String[]::new, 9);
        System.out.println(arr.length);
    }

    /**
     * 自定义方法
     */
    public <T> T method(Supplier<T> s){
        return s.get();
    }

    @Test
    public void test5(){
        /**
         * 现在我要调用method方法
         *
         * Supplier<T> 是供给型接口，T get()
         *
         * Lambda体是通过new 一个对象来完成的
         */

        method(() -> new String());

        // 可以用构造器引用
        method(String::new);
    }

    @Test
    public void test4(){
        /**
         * 数据流
         * java.util.stream包下Stream类
         *      static <T> Stream<T> generate(Supplier<T> s)
         * 函数式接口：Supplier<T> 供给型接口，抽象方法 T get() 无参有返回值
         *
         * 现在lambda体通过调用Math.random()来完成
         *
         * 因为lambda体通过调用Math类的先有的方法来完成的，并且形参列表和返回值类型对识破，都是无参，有返回值
         *
         */

        //Stream<Double> stream = Stream.generate(() -> Math.random());

        //方法引用
        Stream<Double> stream = Stream.generate(Math::random); // 类名::静态方法名

        stream.forEach(System.out::println);
    }


    @Test
    public void test3(){
        /**
         * 要按照字符串的大小写排序，忽略大小写
         *
         * 传入Comparaptor: int compare(T t1, T t2)
         *
         * t1是函数式接口的抽象方法的第一个形参，正好是调用compareToIgnoreCase的对象
         * 然后t2是函数式接口的抽象方法的第二个形参（剩下的形参），正好给compareToIgnoreCase方法的实参
         *
         * 并且返回值类型可以对应，都是int
         *
         */
        //TreeSet<String> set = new TreeSet<String>((t1,t2) -> t1.compareToIgnoreCase(t2));

        // 用方法引用
        TreeSet<String> set = new TreeSet<String>(String::compareToIgnoreCase); // 类名::实例方法名

        set.add("tom");
        set.add("Jack");
        set.add("irene");
        set.add("Leo");

        set.forEach(System.out::println);
    }

    @Test
    public void test1(){
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

        /**
         * 观察刚才的lambda表达式，是通过一个现有的方法的完成的
         * 通过调用out对象的println方法来完成，
         * 并且out对象的，void println(T t)
         * Consumer的抽象方法，void xxx(T t)
         * 可以改写为方法引用
         */
        list.forEach(System.out::println); // 对象::实例方法名
    }
}
