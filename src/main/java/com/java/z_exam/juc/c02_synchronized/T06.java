package com.java.z_exam.juc.c02_synchronized;

/**
 * @Author:
 * @Date: 2020-11-15 22:14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：既保证了原子性，又保证可见性2
public class T06 implements Runnable {
    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T06 t = new T06();
        for (int i = 0; i < 5; i++) {
            new Thread(t, "Thread"+i).start();
        }
    }
}
