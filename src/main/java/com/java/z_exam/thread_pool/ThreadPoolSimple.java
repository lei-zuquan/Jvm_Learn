package com.java.z_exam.thread_pool;

import java.time.LocalTime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:05 下午 2020/3/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC
 */
public class ThreadPoolSimple {
    public static void main(String[] args) {
        // corePoolSize 核心线程数，可长期驻留的线程数量
        // maximumPoolSize, 顾名思义，就是线程不够时能够创建的最大线程数。
        // keepAliveTime 和 TimeUnit，这两个参数指定了额外的线程能够闲置多久，显然有些线程池不需要它。
        // 工作队列，必须是BlockingQueue
        // 线程池pool的阻塞队列是ArrayBlockingQueue，ArrayBlockingQueue是一个有界的阻塞队列，ArrayBlockingQueue的容量为1。这也意味着线程池的阻塞队列只能有一个线程池阻塞等待。

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                2,
                TimeUnit.SECONDS,
                //new ThreadFactoryBuilder().setNameFormat("getP5wData-task-%d").build(),
                //new ArrayBlockingQueue<>(5));
                new LinkedBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
        // ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
        // ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
        // ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
        // 设置线程池的拒绝策略为"丢弃"

        //for (int i = 0; i < 15; i++) {
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println(
                    LocalTime.now() + "\t"
                            + "线程池中线程数目：" + executor.getPoolSize()
                            + ", 队列中等待执行的任务数目：" + executor.getQueue().size()
                            + ", 已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }

        executor.shutdown();
    }
}


class MyTask implements Runnable{

    //byte[] a = new byte[1024 * 100];  // 100KB
    private int taskNum;

    public MyTask(int taskNum) {

        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        //System.out.println("正在执行task " + taskNum);

        try {
            //Thread.currentThread().sleep(4000);
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("task " + taskNum + " 执行完毕");
    }
}