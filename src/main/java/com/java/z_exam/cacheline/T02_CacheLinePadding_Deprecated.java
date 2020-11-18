package com.java.z_exam.cacheline;

import java.util.concurrent.CountDownLatch;

/**
 * @Author:
 * @Date: Created in 10:56 上午 2020/10/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    两个线程操作在不在同一个缓存行的数据进行叠加计算，查看时间耗时。缓存行大小64字节，一个long类型8字节
    整体耗时较demo01 短，即快很多。
    因为数据作了填充，保证两个数据不在同一个缓存行中，所以不会触发缓存一致性问题，所以也就没有需要相互通知的问题。
    x,y肯定不在同一缓存行
    JDK 1.7
 */
public class T02_CacheLinePadding_Deprecated {
    public static long COUNT = 1_0000_0000;

    // 定义p1~p7，确保x在同个缓存行
    private static class T {
        private long p1,p2,p3,p4,p5,p6,p7;
        public volatile long x = 0L;
        private long p9,p10,p11,p12,p13,p14,p15;
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
        }, "t2");

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 100_000);
    }
}
