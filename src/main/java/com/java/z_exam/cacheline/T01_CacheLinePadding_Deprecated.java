package com.java.z_exam.cacheline;

import java.util.concurrent.CountDownLatch;

/**
 * @Author:
 * @Date: Created in 10:45 上午 2020/10/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    两个线程操作在同一个缓存行的数据进行叠加计算，查看时间耗时。缓存行大小64字节，一个long类型8字节
    根据缓存一致性协议，当同一缓存行数据更改了，必须通知其他线程，所以时间都花在了通知上面去了
 */
public class T01_CacheLinePadding_Deprecated {
    public static long COUNT = 1_0000_10000L;

    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        }, "t1");

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start)/100_1000);
    }
}
