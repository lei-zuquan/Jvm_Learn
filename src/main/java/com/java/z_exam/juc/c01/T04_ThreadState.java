package com.java.z_exam.juc.c01;

/**
 * @Author:
 * @Date: 2020-11-14 22:18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 多线程与高并发：常见的线程状态
public class T04_ThreadState {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        // 怎么样得到这个线程的状态呢？就是通过getState() 这个办法
        System.out.println(t.getState()); // 它是一个new 状态

        t.start(); // 到这个start完了之后，是Runnable 的状态

        try {
            t.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // 然后join 之后，结束了是一个Terminated 状态
        System.out.println(t.getState());
    }
}
