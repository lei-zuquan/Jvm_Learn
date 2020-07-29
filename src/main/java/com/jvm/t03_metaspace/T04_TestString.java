package com.jvm.t03_metaspace;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-29 11:02
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示字符串字面量也是【延迟】成为对象的
 */

public class T04_TestString {
    public static void main(String[] args) {
        int x = args.length;
        System.out.println(); // 字符串个数 3066

        System.out.print("1");
        System.out.print("2");
        System.out.print("3");
        System.out.print("4");
        System.out.print("5");
        System.out.print("6");
        System.out.print("7");
        System.out.print("8");
        System.out.print("9");
        System.out.print("0");
        System.out.print("1"); // 字符串个数 3077
        System.out.print("2");
        System.out.print("3");
        System.out.print("4");
        System.out.print("5");
        System.out.print("6");
        System.out.print("7");
        System.out.print("8");
        System.out.print("9");
        System.out.print("0");
        System.out.print(x); // 字符串个数
    }
}
