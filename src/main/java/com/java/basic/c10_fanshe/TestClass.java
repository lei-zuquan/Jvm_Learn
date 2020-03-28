package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:19 下午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * day27_02类的加载结果Class对象以及如何获取Class对象
 *
 * 无论如何，类的加载的结果：在方法区有一个唯一的Class对象来代表一个类型。
 * 每一种类型都有一个Class对象。
 *
 * java.lang.Class:
 *      （1）Class 类的实例表示正在运行的Java 应用程序中的类和接口。
 *      （2）枚举是一种类，注释（注解）是一种接口。
 *      （3）每个数组属于被映射为Class 对象的一个类，所有具有相同元素类型和维数的数组者都共享该Class 对象。 --> 不同的元素类型或不同的维度就是不同的Class对象。
 *      （4）基本的Java 类型（boolean、byte、char、short、int、long、float 和 double) 和关键字 void 也表示为Class对象。
 *
 * 如何在程序中获取，拿到这个类型的Class对象呢？（重点）
 *      （1）类型名.class
 *              说明：
 *                  基本数据类型和void，只能通过这种方式
 *      （2）对象.getClass()    : 获取对象的运行时类型
 *              说明：
 *                  只能用于引用数据类型
 *      （3）【使用最多】Class.forName("类的全名称")
 *              类的全名称：包.类名
 *
 *      （4）类加载器对象.loadClass("类的全名称")
 *
 *      四种方式，看当前可以用哪一种，就用哪一种
 */
public class TestClass {

    @Test
    public void test6() throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> c = loader.loadClass("java.lang.String");

        System.out.println(c);
    }

    @Test
    public void test5() throws ClassNotFoundException {
        /*Class<?> c1 = Class.forName("int"); // 错误的
        Class<?> c1 = Class.forName("int[]"); // 错误的
        Class<?> c1 = Class.forName("String[]"); // 错误的

         */
        Class<?> c2 = Class.forName("[Ljava.lang.String;");
        System.out.println(c2);

        Class<?> c3 = Class.forName("[I");
        System.out.println(c3);

    }

    @Test
    public void test4() throws ClassNotFoundException {
        Class<?> c = Class.forName("java.lang.String");
        System.out.println(c);
    }

    @Test
    public void test3(){
        Object num = 12; // class java.lang.Integer

        Class<?> c = num.getClass();
        System.out.println(c);
    }
    @Test
    public void test2(){
        Object str = "hello";

        Class<?> c = str.getClass();
        System.out.println(c);
    }


    @Test
    public void test1(){
        Class c1 = Object.class; // 类
        Class c11 = Object.class;
        System.out.println(c1 == c11);

        Class c2 = Comparable.class; // 接口
        Class c22 = Comparable.class;
        System.out.println(c2 == c22);

        Class c3 = ElementType.class; // 枚举
        Class c4 = Single.class;

        Class c5 = Override.class; // 注解

        Class c6 = int[].class;
        Class c7 = int[][].class;
        Class c8 = String[].class;
        System.out.println(c6 == c7); // 维度不同
        System.out.println(c6 == c8); // 元素的类型不同
    }
}

enum Single{
    INSTANCE
}












