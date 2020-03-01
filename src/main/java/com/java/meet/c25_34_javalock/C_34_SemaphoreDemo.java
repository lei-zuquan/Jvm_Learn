package com.java.meet.c25_34_javalock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  34_SemaphoreDemo
 *  抢停车位
 *
 *  信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 */


public class C_34_SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); //模拟3个停车位

        for (int i = 0; i < 6; i++) { // 模拟6部汽车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    // 暂停一会儿线程
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t停车3秒后离开车位");
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}




