package com.jvm.t01_stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-28 11:54
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 局部变量的线程安全问题
 * <p>
 * 因为变量就方法内局部变量，x是线程私有的，不存在线程安全问题
 */
public class T02_StackSafeProblem {

    // 多个线程同时执行此方法
    static void m1() {
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
