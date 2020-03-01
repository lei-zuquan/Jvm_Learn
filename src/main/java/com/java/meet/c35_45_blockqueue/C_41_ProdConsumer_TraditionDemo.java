package com.java.meet.c35_45_blockqueue;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 资源类
class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            // 1 判断，多线程判断必须使用while，不能使用if判断；2个线程可以使用if
            while (number != 0){
                // 等待，不能生产
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            // 1 判断，多线程判断必须使用while，不能使用if判断
            while (number == 0){
                // 等待，不能生产
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 41_线程通信之生产者消费者传统版
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 *
 * 1    线程  操作（方法）  资源类
 * 2    判断  干活  通知
 * 3    防止虚假唤醒
 *

 */
public class C_41_ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
