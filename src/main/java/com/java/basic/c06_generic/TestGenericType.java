package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:17 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * day22_12泛型形式一：泛型类与泛型接口
 *
 * 泛型有两种形式：
 * 1、泛型类、泛型接口
 * 2、泛型方法
 *
 * 一、泛型类、泛型接口
 *  语法格式：
 *  【修饰符】class/interface 类型名<泛型形参列表> {
 *
 *  }
 *
 *  泛型形参列表：
 *      1）泛型形参可能有多个
 *          例如：Map<K, V>
 *              ArrayList<E>
 *              BiFunction<T, U, R>
 *              Comparator<T>
 *      2）泛型形参一般都是一个大写的字母
 *          T: Type
 *          K: key
 *          V: value
 *          E: Element元素的类型
 *          R: 返回值类型
 *          U: 类型，因为T用过了，那么换个字母
 *          ...
 *      3）泛型实参必须是引用数据类型，不能是基本数据类型
 *          如果是基本数据类型，请使用包装类。
 *
 *      不支持基本数据类型的问题：
 *          a.集合
 *          b.泛型
 *          等不支持基本数据类型
 *
 *      4）泛型类或泛型接口上的泛型形参，可以在该类或该接口中当做
 *          属性的类型、方法的形参类型、方法的返回值类型、局部变量的类型都可以
 *          但是，不能用作 "静态" 成员的相关类型
 *
 *      5）泛型类或泛型接口上的泛型形参, 什么时候具体化，即什么时候指定泛型实参？
 *          第一种：创建对象，实例化
 *          ArrayList<String> list = new ArrayList<String>();
 *
 *          第二种：在实现接口，或继承类的时候，可以把泛型实际化
 *          class Student implements Comparable<Student> {
 *              public int compareTo(Student stu){
 *
 *              }
 *          }
 *
 *      6）泛型形参还可以设置上限
 *      【修饰符】class/interface 类型名<泛型形参列表> {}
 *      说明这个T只能指定为上限类型本身或它的子类
 *      例如：   class XueYuan<T extends Number>{
 *                  private T score; // 成绩
 *              }
 *            这个T只参指定为Number或Number的子类（Integer, Double, Short, Float...）
 *
 */
public class TestGenericType {

    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(1); // 自动装箱为Integer对象

        for (Object object : list) {
            System.out.println(object.getClass());
        }
    }
}


class MyClass<T> {
    private T t;
//    private static T other;
//    public static void test(T t){
//
//    }

    public MyClass(T t) {
        super();
        this.t = t;
    }

    public MyClass() {
        super();
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}

// 这个T代表成绩的类型，有一个要求，这个成绩必须是数字类型，例如：Integer, Double, Short, Float等
class XueYuan<T extends Number>{
    private T score; // 成绩
}

class TestXueYuan {
    public void test(){
        // XueYuan<String> x = new XueYuan<>();
        XueYuan<Integer> x1 = new XueYuan<>();
        XueYuan<Double> x2 = new XueYuan<>();
        XueYuan<Short> x3 = new XueYuan<>();
        XueYuan<Float> x4 = new XueYuan<>();

    }
}