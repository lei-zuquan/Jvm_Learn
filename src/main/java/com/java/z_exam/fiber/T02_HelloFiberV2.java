package com.java.z_exam.fiber;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

import java.util.concurrent.ExecutionException;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-25 9:36
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 纤程：是用户态的线程，是线程中的线程，切换和调度不需要经过OS(操作系统)。；轻量级的线程 - 线程
public class T02_HelloFiberV2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        int size = 10000;
        Fiber<Void>[] fibers = new Fiber[size];
        for (int i = 0; i < fibers.length; i++) {
            fibers[i] = new Fiber<Void>(new SuspendableRunnable() {

                @Override
                public void run() throws SuspendExecution, InterruptedException {
                    calc();
                }
            });
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].start();
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].join();
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
