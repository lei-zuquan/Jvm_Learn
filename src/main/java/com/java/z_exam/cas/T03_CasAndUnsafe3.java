package com.java.z_exam.cas;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-25 11:26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 多线程，并发情况下对 int m变量进行累加，数据回写使用synchronized进行同步加锁; 实现了数据的一致性

public class T03_CasAndUnsafe3 {

    private static /*volatile*/ int m = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (o) {
                    for (int j = 0; j < 10000; j++) {
                        m++;
                    }
                    latch.countDown();
                }
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        System.out.println(m);

        long end = System.currentTimeMillis();

        long spend = end - start;
        System.out.println("spend:" + spend + " ms");
    }
}
