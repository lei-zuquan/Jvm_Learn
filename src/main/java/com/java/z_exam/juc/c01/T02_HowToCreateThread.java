package com.java.z_exam.juc.c01;

import java.util.concurrent.*;

/**
 * @Author:
 * @Date: 2020-11-14 18:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 多线程与高并发：创建线程的几种方式
public class T02_HowToCreateThread {
    // 方式一：继承自Thread 类
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    // 方式二：实现Runnable 接口
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    // 方式三：Executors.newCachedThreadPool()或者FutureTask + Callable.
    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall!");
            return "success";
        }
    }

    // 启动线程的5种方式
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread( () -> {
            System.out.println("Hello Lambda!");
        }).start();

        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute( () -> {
            System.out.println("Hello ThreadPoll!");
        });
        service.shutdown();

    }
}
