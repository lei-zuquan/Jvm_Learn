package com.java.meet.c25_34_javalock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {
    public synchronized void sendSMS() throws  Exception{
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail() throws  Exception{
        System.out.println(Thread.currentThread().getName() + "\t #######invoked sendEmail()");
    }


    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        //lock.lock(); // 添加两层lock，编译成功，运行成功；只要配对即可
        try {
            // 线程可以进入任何一个它已经拥有的锁所同步着的代码块
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
            //lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t #######invoked set()");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 27_java锁之重入锁和递归代码验证
 *
 * 可重入锁（也叫做递归锁）
 *
 *            可重入锁（也叫做递归锁）
 *            指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *            在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 *            也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 */
public class C_27_ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e){
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e){
                e.printStackTrace();
            }
        }, "t2").start();


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e){  e.printStackTrace();}

        Thread t3 = new Thread(phone,"T3");
        Thread t4 = new Thread(phone,"T4");

        t3.start();
        t4.start();
    }
}


/**
 * 案例1 synchronized
 t1	 invoked sendSMS()
 t1	 #######invoked sendEmail()
 t2	 invoked sendSMS()
 t2	 #######invoked sendEmail()

    案例2
    ReentrantLock就是一个典型的可重入锁
 */