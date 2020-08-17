package com.jvm.t08_compile_time;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:52 下午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖) —— 匿名内部类
public class T11_Compile_HideInnerClass {
    public static void test(final int x) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok:" + x);
            }
        };
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
    }
}
