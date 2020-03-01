package com.java.meet.c25_34_javalock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 29_java锁之自旋锁代码验证
 *
 * 题目：实现一个自旋锁
 * 自旋锁好处：循环比较获取直到成功为止，没有类似wait的阻塞。
 *
 * 通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒锁，B随后进来后发现
 * 当前有线程持有锁，不是Null，所以只能通过自旋等待，直到A释放锁后B随后抢到。
 *
 */
public class C_29_SpinLockDemo {

    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in");

        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnLock");
    }

    public static void main(String[] args) {
        C_29_SpinLockDemo spinLockDemo = new C_29_SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e){  e.printStackTrace();}
            spinLockDemo.myUnlock();
        }, "AA").start();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){  e.printStackTrace();}
        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){  e.printStackTrace();}
            spinLockDemo.myUnlock();
        }, "BB").start();
    }
}
