package com.java.z_exam.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:44 上午 2020/4/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


public class T03_AtomicInteger {
    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread( () -> {
                for (int j = 0; j < 10000; j++) {
                    m.incrementAndGet(); // m++
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();

        System.out.println(m);
    }
}

/*

    什么是CAS?
        compare and swap
        compare and exchange
    什么是ABA问题？
        其他线程修改数次最后值和原值相同

    CAS最终怎么保证原子性，即执行不被打断？
        最终实现
        cmpxchg = cas 修改变量值
        lock cmpxchg 指令
            cmpxchg指令在多线程下也是有可能被打断，所以在加入lock指令
            不允许其他线程访问这块内存区域的数据
 */
