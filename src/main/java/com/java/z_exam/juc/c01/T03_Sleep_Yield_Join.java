package com.java.z_exam.juc.c01;

/**
 * @Author:
 * @Date: 2020-11-14 20:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 多线程与高并发：认识几个线程的方法
public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
        //testSleep();
        //testYield();
        testJoin();
    }

    /*
    Sleep，意思就是睡觉，当前线程暂停一段时间让给别的线程去运行。
    Sleep是怎么复活的？由你的睡眠时间而定，等睡眠到规定的时间自动复活
     */
    static void testSleep() {
        new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }

        }).start();
    }

    /*
    Yield，就是当前线程正在执行的时候停止下来进入等待队列，在系统的调度
    算法里头，还是依然可能把你刚回去的这个线程拿回来继续执行；
    当然，更大的可能性是把原来等待的那些拿出一个来执行，所以yield的意思是我让出一下CPU,
    后面你们能不能抢到那我不管
     */
    static void testYield() {
        new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();

        new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("-----------B" + i);
                if (i%10 == 0) Thread.yield();
            }
        }).start();
    }

    /*
    join，意思就是在自已当前线程加入你调用join的线程（），本线程等待。等调用的线程运行
    完了，自己再去执行。t1和t2两个线程。在t1的某个点上调用了t2.join，它会跑到t2去运行，
    t1等待t2运行完毕继续t1运行（自己join自己没有意义）
     */
    static void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // 等待t1线程完成，再继续执行
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            for (int i = 0; i < 50; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
