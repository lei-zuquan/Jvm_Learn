package com.jvm.t12_juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:17 下午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// java 内存模型 —— CAS 原子类
public class T09_Juc_Cas_Atomic {
    // 创建原子整数对象
    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndIncrement(); // 获取并且自增 i++
                // i.incrementAndGet(); // 自增并且获取 ++i
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndDecrement(); // 获取并且自减 i--
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }
}
