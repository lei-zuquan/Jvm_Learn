package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:59 下午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// java 内存模型 —— synchronized - 轻量级锁
public class T10_Juc_Synchronized {
    static Object obj = new Object();
    public static void method1() {
        synchronized (obj) {
            // 同步块 A
            method2();
        }
    }
    public static void method2() {
        synchronized (obj) {
            // 同步块 B
        }
    }
}
