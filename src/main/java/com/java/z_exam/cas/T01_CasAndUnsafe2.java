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

// 多线程，并发情况下对volatile int m变量进行累加，出现的数据被写覆盖。说明volatile 不保证原子性

public class T01_CasAndUnsafe2 {

    private static volatile int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    m++;
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        System.out.println(m);
    }
}
