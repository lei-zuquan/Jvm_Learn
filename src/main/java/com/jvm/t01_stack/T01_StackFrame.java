package com.jvm.t01_stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-28 11:33
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示栈帧，先进后出
 */

public class T01_StackFrame {
    public static void main(String[] args) throws InterruptedException {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int c = a + b;
        return c;
    }
}
