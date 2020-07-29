package com.jvm.t01_stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-28 14:07
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示 cpu 占用过高
 */

public class T06_StackHighCpuUsage {
    public static void main(String[] args) {
        new Thread(null, () -> {
            System.out.println("1...");
            while (true) {

            }
        }, "thread1").start();


        new Thread(null, () -> {
            System.out.println("2...");
            try {
                Thread.sleep(1000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();

        new Thread(null, () -> {
            System.out.println("3...");
            try {
                Thread.sleep(1000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3").start();
    }
}

/*
1. 用top定位哪个进程对cpu的占用过高
2. ps H -eo pid,tid,%cpu     查看linux所有进程、线程、CPU消耗情况
3. ps H -eo pid,tid,%cpu | grep 进程id    用ps命令进一步定位哪个线程引起的CPU占用过高
4. jstack 进程pid        需要将十进制的线程id转成16进制
    可以根据线程id找到有问题的线程，进一步定位问题代码的源码行号
 */