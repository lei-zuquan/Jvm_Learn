package com.java.juc;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 01_SaleTicket
 * 03_SaleTicket拆分
 *
 * 1 JUC (java.util.concurrent)
 *
 *      1.1 进程/线程
 *      1.2 并发/并行
 *
 *        并发
 *            当有多个线程在操作时,如果系统只有一个CPU,则它根本不可能真正同时进行一个以上的线程，它只能把CPU运行时间划分成若干个时间段,再将时间
 *            段分配给各个线程执行，在一个时间段的线程代码运行时，其它线程处于挂起状。.这种方式我们称之为并发(Concurrent)。
 *        并行:
 *            当系统有一个以上CPU时,则线程的操作有可能非并发。当一个CPU执行一个线程时，另一个CPU可以执行另一个线程，两个线程互不抢占CPU资源，
 *               可以同时进行，这种方式我们称之为并行(Parallel)。
 *
 *       区别:   并发和并行是即相似又有区别的两个概念，并行是指两个或者多个事件在同一时刻发生; 而并发是指两个或多个事件在同一时间间隔内发生。
 *              在多道程序环境下，并发性是指在一段时间内宏观上有多个程序在同时运行，但在单处理机系统中，每一时刻却仅能有一道程序执行，
 *              故微观上这些程序只能是分时地交替执行。倘若在计算机系统中有多个处理机，则这些可以并发执行的程序便可被分配到多个处理机上，
 *              实现并行执行，即利用每个处理机来处理一个可并发执行的程序，这样，多个程序便可以同时执行
 * 2 三个包
 *      java.util.concurrent
 *      java.util.concurrent.atomic
 *      java.util.concurrent.locks
 *
 * 题目：三个售票员     卖出      30张票
 * 笔记：如何编写企业级的多线程代码
 *
 * 固写的编程套路 + 模板是什么？
 *
 * 1 在高内聚低耦合的前提下，线程     操作      资源类
 *      1.1 一言不合，先创建一个资源类
 *
 *      比如：空调有制冷、制热功能，空调将制冷、制热内制，这就属于高内聚；
 *           最后通过遥控器对外暴露，只暴露很少的，就属于低耦合
 */

class Ticket { // 资源类 = 实例变量 + 实例方法
    private int number = 30;
    // List list = new ArrayList();
    Lock lock = new ReentrantLock();

    //
    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t 还剩下：" + number);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class C_01_03_SaleTicketDemo01 {

    public static void main(String[] args) { // 主线程，一切程序的入口，后台还有一个gc线程
        /**
         * 创建线程的方式：
         * 继承Thread，此方式推荐使用：Thread(Runnable target, String name)  // Allocates a new {@code Thread} object.
         *      实现Runnable接口，接口也是特殊的类，是可以new出来的，这种方式叫做：匿名内部类
         *      如果接口new出来后，发现需要实现的方法太多，我们一般采用实现了该接口的类进行创建。这就是java的多态
         * 实现Runnable接口
         * 线程池
         */
        Ticket ticket = new Ticket();

        // java8 lambda表达式（进阿里巴巴）
        new Thread(() -> { for (int i = 0; i < 40; i++) {  ticket.sale(); } }, "A").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) {  ticket.sale(); } }, "B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) {  ticket.sale(); } }, "C").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "BBB").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "CCC").start();

        /**
         * NEW RUNNABLE BLOCKED WAITING TIMED_WAITING TERMINATED
         *
          */

    }
}



























