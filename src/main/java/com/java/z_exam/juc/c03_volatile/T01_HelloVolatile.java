package com.java.z_exam.juc.c03_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: 2020-11-23 17:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    volatile 关键字，使一个变量在多个线程可见
    A B 线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道。
    使用volatile 关键字，会让所有线程都会读到变量的修改值

    在下面的代码中，running 是存在于堆内存的t对象中
    当线程t1开始运行的时候，会把running 值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy，并不会每次都去
    读取堆内存，这样，当线程修改running 的值之后，t1线程感知不到，所以不会停止运行

    使用volatile ，将会强制所有线程都会去堆内存中读取running的值

    可以阅读这个文章加深理解
    http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html

    volatile 并不能保证多个线程共同修改running 变量时所带来的不一致问题，也就是说volatile 不能替代synchronized

 */
public class T01_HelloVolatile {
    /*volatile*/ boolean running = true; // 对比一下有无volatile 的情况下，整个程序运行的结果的区别

    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}






































