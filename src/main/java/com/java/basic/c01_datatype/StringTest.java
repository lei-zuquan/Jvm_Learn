package com.java.basic.c01_datatype;

/**
 * String: 字符串
 * 1、String属于引用数据类型中的类，不是基本数据类型
 * 2、使用一对""来声明
 * 3、String可以与8种基本数据类型的变量做连接（+）运算。运算的结果为：String型
 *
 * 不能将基本数据类型直接赋值为String类型
 * 不能将字符串类型强转为基本数据类型
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello World中国";
        String s2 = "";
        String s3 = "h";
        String s4 = "123";

        System.out.println(s1);

        int i1 = 1;
        String s5 = s4 + i1;
        System.out.println(s5);

        boolean b1 = true;
        String s6 = s1 + b1;
        System.out.println(s6);// Hello World123中国true

    }

}
