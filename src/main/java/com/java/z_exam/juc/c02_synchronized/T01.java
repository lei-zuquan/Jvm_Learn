package com.java.z_exam.juc.c02_synchronized;

import java.util.Vector;

/**
 * @Author:
 * @Date: 2020-11-15 17:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：对某个对象加锁
public class T01 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized(o) { // 任何线程要想执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T01 t01 = new T01();
        Vector vector = new Vector();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                t01.m();
            });
            vector.add(thread);
            thread.start();
        }

        // 等待所有工作线程执行完成
        for (int i = 0; i < vector.size(); i++) {
            Thread t = (Thread)vector.get(i);
            t.join();
        }

        System.out.println("All thread run finished!");
    }
}
