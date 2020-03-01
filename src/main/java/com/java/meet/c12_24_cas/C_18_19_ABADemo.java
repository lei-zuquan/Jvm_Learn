package com.java.meet.c12_24_cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 18_AtomicStampedReference版本号原子引用
 * 19_ABA问题的解决
 *
 */
public class C_18_19_ABADemo {
    
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        System.out.println("================以下是ABA问题的产生");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "T1").start();

        new Thread(() -> {
            // 暂停1秒钟t2线程，保证上面的t1线程完成了一次ABA操作
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){  e.printStackTrace();}
            System.out.println(Thread.currentThread().getName() +"\t" + atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
        }, "T2").start();

        System.out.println("================以下是ABA问题的解决");

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +"\t第1次版本号：" + atomicStampedReference.getStamp());
            // 暂停1秒钟t3线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){  e.printStackTrace();}
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() +"\t第2次版本号：" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        }, "T3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"\t第1次版本号：" + atomicStampedReference.getStamp());
            // 暂停3秒钟t4线程，保证上面的t3线程完成了一次ABA操作
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e){  e.printStackTrace();}
            boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() +"\t修改成功否：" + result + "\t当前最新实际版本号：" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前实际最新值：" + atomicStampedReference.getReference());
        }, "T4").start();
    }
}
