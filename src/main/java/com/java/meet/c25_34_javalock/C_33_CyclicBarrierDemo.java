package com.java.meet.c25_34_javalock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 33_CyclicBarrierDemo
 * 集齐7颗龙珠，神龙召唤
 *
 * 只有集齐了7颗，才可以进行；工作中经常用
 */
public class C_33_CyclicBarrierDemo {

    public static void main(String[] args) {

        // CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("*************召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 收集到第：" + tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
