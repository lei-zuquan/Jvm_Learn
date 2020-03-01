package com.java.meet.c25_34_javalock;

import java.util.concurrent.CountDownLatch;

/**
 * 32_CountDownLatch
 * 火箭发射倒计时
 *
 * 让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
 *
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，调用线程会被阻塞
 * 其它线程调用countDown方法会将计数器减1（调用countDown方法的线程不会阻塞），
 * 当计数器的值变为零时，因调用await方法被阻塞的线程会被唤醒，继续执行。
 *
 *
 * 教室有6位同学，班长需要等同学走了后再走；如果使用普通的方法无法保证班长走时，教室里没人
 */
public class C_32_CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"~~~~\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t****************秦帝国，一统华夏");

        System.out.println();
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());



    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t****************班长最后走，关灯走人");

    }
}
