package com.java.z_exam.juc.c02_synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2020-11-15 21:54
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：既保证了原子性，又保证可见性
public class T05 implements Runnable {

    private /*volatile*/ int count = 100; // volatile 保证多线程可见性

    @Override
    public /*synchronized*/ void run() { // 加锁，序列化执行，性能有下降
        count--;
        //System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        T05 t = new T05();
        System.out.println("Start:" + t.count);
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(t, "Thread:" + i);
            list.add(thread);
            thread.start();
        }

        // 等待所有工作线程执行完成
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Finish:" + t.count + " spend:" + (end - start));
    }
}
