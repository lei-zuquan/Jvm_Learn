package com.java.z_exam.fiber;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-25 9:36
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 线程：是操作系统资源调度的基本单位，cpu分配的基本单位
public class T01_HelloFiber {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                calc();
            }
        };

        int size = 10000;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    private static void calc() {
        int result = 0;
        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < 200; i++) {
                result += i;
            }
        }
    }
}
