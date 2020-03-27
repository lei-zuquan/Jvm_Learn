package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:00 下午 2020/3/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * day23_04关于泛型的其他说明
 *
 * 关于泛型的一些说明：
 *      1、泛型类，泛型接口，在运行时，不管泛型实参指定为什么，运行时类型都一样
 *      2、泛型类，泛型接口，在指定了不同的泛型实参时，编译时是按照不同的类型来处理的。
 *      3、instanceof后面的类型，不能这么用
 *          if (list2 instanceof ArrayList<Object>)
 *          只能这么写：
 *          if (list2 instanceof ArrayList)
 *
 *      4、泛型与数组
 *          1）People[] arr = new People[5]; 可以
 *             People<String>[] arr = new People[5]; 不可以
 *          2) Object[] arr = new String[5]; // 多态引用
 *              ArrayList<Object> list = new ArrayList<Integer>(); // 不能构成多态引用
 *
 *      5、异常类型不能加泛型，也不能用泛型形参
 *      try {
 *
 *      } catch(T e) { // 错误的
 *
 *      }
 *
 */

class People<T> {
    private T t;
}

public class TestGenericOther {

    @Test
    public void test5(){
        Object[] arr = new String[5];
        //ArrayList<Object> list = new ArrayList<Integer>(); // 不能构成多态引用

        System.out.println(arr); // [Ljava.lang.String;@4fe3c938

        Object[] arr2 = new Object[6]; // [Ljava.lang.Object;@5383967b
        System.out.println(arr2);

    }

    @Test
    public void test4(){
        People[] arr = new People[5];
        //People<String>[] arr = new People[5];
    }

    @Test
    public void test3(){
        ArrayList<Object> list2 = new ArrayList<>();
        /**
        if (list2 instanceof ArrayList<Object>){

        } */

        if (list2 instanceof ArrayList){

        }
    }

    @Test
    public void test2(){
        ArrayList<Object> list2 = new ArrayList<>();
        method(list2);

        ArrayList<String> list3 = new ArrayList<>();
        //method(list3); // 报错
    }

    public void method(ArrayList<Object> list){

    }

    @Test
    public void test1(){
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list2.getClass());
    }
}
