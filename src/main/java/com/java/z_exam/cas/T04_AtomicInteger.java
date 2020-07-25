package com.java.z_exam.cas;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-25 11:26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 多线程，并发情况下对 AtomicInteger m变量进行累加， 实现了数据的一致性

public class T04_AtomicInteger {

    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    m.getAndIncrement(); // m++;
                }
                latch.countDown();
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
