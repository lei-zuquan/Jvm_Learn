package com.java.meet.c46_55_threadpool;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t自己持有："+lockA + ", 尝试获得：" + lockB);

            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e){  e.printStackTrace();}
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t自己持有："+lockB+ ", 尝试获得：" + lockA);
            }
        }
    }
}

/**
 * 55_死锁编码及定位分析
 *
 *
 * ---------------------
 * 10.死锁编码及定位分析
 *      是什么？产生死锁主要原因
 *              死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力干涉那它们都将无法推进下去，
 *              如果系统资源充足，进程的资源请求都能够得到满足，死锁出现的可能性就很低，否则就会因争夺有限的资源而陷入死锁。
 *      代码
 *
 *      解决: idea下有个Terminal，输入jps -l，然后 jstack 9636
 *              JAVA_HOME/bin/下：jps.exe / jstack.exe    ls -l
 *              linux   ps -ef | grep xxx
 *              window下的java运行程序 也有类似ps的查看进程的命令，但是目前我们需要查看的只是java
 *                      jps = java ps           jps -l
 *              1. jps 命令定位进程号
 *
 *              2. jstack找到死锁查看
 *
 *
 *
 *
 * -------------------
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力干涉那它们都将无法推进下去
 */

public class C_55_DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA), "ThreadBBB").start();

    }
}
