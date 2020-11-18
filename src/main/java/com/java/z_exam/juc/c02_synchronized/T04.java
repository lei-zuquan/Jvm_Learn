package com.java.z_exam.juc.c02_synchronized;

/**
 * @Author:
 * @Date: 2020-11-15 21:44
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：同步静态方法
public class T04 {
    private static int count = 10;

    public synchronized static void m() { // 这里等同于synchronized(T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void m2() {
        synchronized (T04.class) { // 考虑一下这里写 synchronized(this) 是否可以？
            count--;
        }
    }
}
