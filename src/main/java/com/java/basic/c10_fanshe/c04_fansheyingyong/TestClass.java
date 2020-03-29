package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:40 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day27_09解释Class对象
 *
 * 从继承的角度来说：
 *      Object是Class的父在
 *
 * 从内存的表示方式来说：
 *      所有的类型都用Class对象表示
 *
 *
 */
public class TestClass {

    public static void main(String[] args) {
        // Class被加载到内存后，也是用一个Class对象表示
        Class<?> clazz = Class.class;

        // Class的父类是Object
        Class<?> parent = clazz.getSuperclass();
        System.out.println(parent);

        // Object类型被加载后，又用Class对象表示
        Class<?> cl = Object.class;
    }

}
