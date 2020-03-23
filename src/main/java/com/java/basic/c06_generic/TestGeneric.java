package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:31 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * day22_11泛型的概念
 *
 * 泛型：JDK1.5
 *      泛化的类型，参数化的类型。
 *
 * 1、问？为什么要泛型
 *      最早设计比较器、集合等的时候，是没有泛型的，因为集合是个容器，用来装对象的，那么为了能够装任意类型的对象，
 *      所以集合中全部用Object处理。
 *   这么处理（用Object处理）的问题是什么？
 *      1）拿到的值都是Object，如果要再用，还得类型转换
 *      2）无法阻止逻辑意义上不符合类型的对象 --> 不安全
 *
 *   JDK1.5 之后，有了泛型？
 *      1）不需要类型转换               --> 简洁
 *      2）不符合类型的对象，无法接受     --> 安全
 *
 * 2、如何设计的泛型
 *      类比：设计方法时，在实现方法功能有未知的数据，用形参表示
 *          设计类或接口等时，某个属性的类型或者方法形参的类型等类型不知道时，把这个类型设计为泛型，我们称为类型形参。
 * 形参：
 * public int getMax(int a, int b){}    -> a,b称为数据形参
 *      getMax(5,6)                     -> 5,6称为数据实参。
 * MyArrayList<E>:                      --> <E> 称为类型形参
 *      MyArrayList<String> list;       --> <String> 称为类型实参
 *
 * 生活中比喻：泛型就好比是标签等。例如：例如：生产瓶子的厂商，不知道用来装什么。
 *                                      酱油厂用来装酱油，那么就粘上酱油的标签
 *                                      白酒厂用来装酱油，那么就粘上白酒的标签
 *                                      药品厂用来装酱油，那么就粘上药品的标签
 *
 */

class MyArrayList<E> {
    private E[] arr;
}

public class TestGeneric {

    /**
     * 这个方法的作用：返回两个整数中的最大值
     * 要完在这个功能，这两个整数的值是不知道的，但是如何求最大值的逻辑步骤知道，
     * 设计方法时，把这两个整数，用两个形参表示，a, b，a和b就代表两个未知的整数
     */
    public int getMax(int a, int b){
        return a>b ? a : b;
    }

    @Test
    public void test2(){
        // 希望这个集合只装字符串，例如姓名
        ArrayList<String> list = new ArrayList();
        list.add("zhangsan");
        // list.add(1); // 这里可以阻止非String进来
        for (Object object : list) {
            System.out.println(object);
        }

        String string = list.get(0);
    }

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add("zhangsan");
        list.add(1);
        for (Object object : list) {
            System.out.println(object);
        }

        Object object = list.get(0);
    }
}
