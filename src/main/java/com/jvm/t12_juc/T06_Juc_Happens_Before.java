package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:30 上午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// java 内存模型 —— happens-before
public class T06_Juc_Happens_Before {
    static int x;

    public static void main(String[] args) {
        Thread t2 =  new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(x);
                    break;
                }
            }
        }, "t2");
        t2.start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            x = 10;
            t2.interrupt();
        }, "t1").start();

        while (!t2.isInterrupted()) {
            Thread.yield();
        }
        System.out.println(x);
    }
//    static int x;
//    static Object m = new Object();
//
//    public static void main(String[] args) {
//        new Thread(() -> {
//            synchronized (m) {
//                x = 10;
//            }
//        }, "t1").start();
//
//        new Thread(() -> {
//            synchronized (m) {
//                System.out.println(x);
//            }
//        }, "t2").start();
//    }
}
