package com.java.z_exam.juc.c02_synchronized;

/**
 * @Author:
 * @Date: 2020-11-15 21:38
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：同步方法等同于synchronized(this)
public class T03 {
    private int count = 10;

    public synchronized void m() { // 等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
