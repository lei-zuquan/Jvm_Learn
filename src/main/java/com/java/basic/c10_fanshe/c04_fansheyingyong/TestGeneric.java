package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:29 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * day27_13使用Class对象获取泛型父类
 *
 * 获取某个类型的泛型父类信息
 *
 * Type:
 *      Type 是Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
 *
 *      参数化类型：ArrayList<String>  --> ParameterizedType
 *      类型变量：T, E, K, V
 *
 */


public class TestGeneric {
    public static void main(String[] args) {
        // 获取Son的泛型父类：Father<String, Integer>
        // (1)Son的Class对象
        Class<?> clazz = Son1.class;

        /*// (2)获取父类，没有泛型
        Class<?> parent = clazz.getSuperclass();
        System.out.println(parent); */
        // (2)获取泛型父类
        Type type = clazz.getGenericSuperclass();
        // 因为Father<String, Integer> 是参数化类型
        ParameterizedType p = (ParameterizedType)type;

        // (3)获取泛型实参 <String, Integer>
        Type[] types = p.getActualTypeArguments();
        for (Type t : types) {
            System.out.println(t);

        }
    }
}

abstract class Father<T, U>{

}

class Son1 extends Father<String, Integer>{

}
