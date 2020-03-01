package com.java.meet.c35_45_blockqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 45_Callable接口
 *
 * 多线程中，第3种获得多线程的方式
 *
         Java多线程实现方式主要有四种：
                 1. 继承Thread类
                 2. 实现Runnable接口、（没有返回值，不会抛异常）
                 3. 实现Callable接口通过FutureTask包装器来创建Thread线程、（有返回值，会抛异常）
                 4. 使用ExecutorService、Callable、Future实现有返回结果的多线程。
                        其中前两种方式线程执行完后都没有返回值，后两种是带返回值的。
 *
 *
 * 企业中几乎都是使用线程池，第三种有时也会被使用
 *
 */

class MyThread01 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread02 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "************** come in Callable");
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e){  e.printStackTrace();}
        return 1024;
    }
}

public class C_45_CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // m1
        // m2
        // m3

        // 两个线程，一个main线程，一个是AA:futureTask

        // 适配者模式
        // Thread构造方法中需要传入Callable接口
        // Thread(Runnable target, String name) // Allocates a new {@code Thread} object.
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread02());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread02());

        new Thread(futureTask, "AA").start();
        // AA线程已经在计算，BB将复用AA计算的结果
        new Thread(futureTask2, "BB").start();

        System.out.println(Thread.currentThread().getName()+"*************************");

        int result01 = 100;
        // 建议尽可能地放在最后；要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，值得计算完成
        // int result02 = futureTask.get(); // 简陋的写法，最好的写法是算完就去get
        while (!futureTask.isDone()){

        }
        int result02 = futureTask.get();

        System.out.println("******* result:" + (result01 + result02));
    }

}
