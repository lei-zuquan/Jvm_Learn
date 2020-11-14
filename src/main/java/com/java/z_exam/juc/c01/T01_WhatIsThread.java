package com.java.z_exam.juc.c01;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: 2020-11-14 17:51
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 多线程与高并发：什么是线程？
public class T01_WhatIsThread {
    // 定义一个T1 线程类
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        // new T1().run()
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
