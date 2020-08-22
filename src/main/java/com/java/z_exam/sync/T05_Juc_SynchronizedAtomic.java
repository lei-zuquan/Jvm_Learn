package com.java.z_exam.sync;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:22 下午 2020/8/22
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// Java 并发 —— Synchronized 关键字和锁升级 【争取小白也能看懂】
// 线程操作资源类 - 共享资源
class TrainTicketSale {
    // 火车票剩余张数
    int remainTicketNum = 1_000;

    // 卖火车票，卖一张少一张，返回true 表示售票成功，返回false 表示售票失败
    public synchronized boolean sale() {
        if (remainTicketNum > 0 ) {
            // 模拟网络延时
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + "\t剩：" + --remainTicketNum);
            return true;
        }

        return false;
    }

    // 获取还剩下多少张火车票
    public int getRemainTicketNum() {
        return remainTicketNum;
    }
}
public class T05_Juc_SynchronizedAtomic {

    public static void main(String[] args) throws Exception {
        TrainTicketSale sale = new TrainTicketSale();

        // 运行结果：火车票还剩下：-1 张
        System.out.println("火车票还剩下：" + sale.getRemainTicketNum() + " 张");

        Vector<Thread> vector = new Vector<>(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    if (!sale.sale()) break;
                }
            }, "线程名：" + i);
            vector.add(thread);
            thread.start();
        }

        // 等待售票线程卖票完毕
        for (Thread thread : vector) {
            thread.join();
        }

        // 运行结果：如果没有加 synchronized 关键字，票会出现超卖现象；添加了synchronized 关键字测不会出现超卖
        System.out.println(" Finally 火车票还剩下：" + sale.getRemainTicketNum() + " 张");
    }
}
