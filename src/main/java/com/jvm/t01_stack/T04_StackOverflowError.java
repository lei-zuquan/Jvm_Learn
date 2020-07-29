package com.jvm.t01_stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-28 12:48
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示栈内存溢出 java.lang.StackOverflowError
 * -Xss256k
 */

public class T04_StackOverflowError {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
