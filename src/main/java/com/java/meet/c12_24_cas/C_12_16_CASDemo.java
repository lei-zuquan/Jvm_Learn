package com.java.meet.c12_24_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 12_CAS是什么
 * 13_CAS底层原理1
 * 14_CAS底层原理2
 * 15_CAS缺点
 * 16_ABA问题
 *
 * 1. CAS是什么？===> compareAndSet
 *      1.比较并交换（先比较后交换成功，有点类似SVN提交前先检查是否需要更新）
 *
 *      2.CAS底层原理？如果知道，谈谈你对UnSafe的理解
 *              atomicInter.getAndIncrement();
 *              UnSafe
 *              CAS是什么
 *                  CAS的全称为Compare-And-Swap，它是一条CPU并发原语。
 *                  它的功能是判断内存某个位置的值是否为预期值，如果是则更改为新的值，这个过程是原子的。
 *
 *                  CAS并发原语体现在JAVA语言中就是sun.misc.Unsafe类中的各个方法。调用UnSafe类中的CAS方法，JVM会帮我们实现出CAS汇
 *                  编指令。这是一种完全依赖于硬件的功能，通过它实现了原子操作。再次强调，由于CAS是一种系统原语，原语属于操作系统用语
 *                  范筹，是由若干条指令组成的，用于完成某个功能的一个过程，并且原语的执行必须是连续的，在执行过程中不允许被中断，也就
 *                  是说CAS是一条CPU的原子指令，不会造成所谓的数据不一致问题。
 *
 *                 unsafe.getAndAddInt
 *                  底层汇编
 *                      Unsafe类中的compareAndSwapInt，是一个本地方法，该方法的实现位于unsafe.cpp中
 *
 *                      1.Unsafe
 *                          是CAS核心类，由于Java方法无法直接访问底层系统，需要能过本地（native）方法来访问，Unsage相当于一个后门，基于该类
 *                          可以直接操作特定内存的数据。Unsafe类存在于sun.misc包中，其内部方法操作可以像C的指针一样直接操作内存，因为Java中
 *                          CAS操作的执行依赖于Unsafe类的方法。
 *                          注意Unsafe类中的所有方法都是native修饰的，也就是说Unsafe类中的方法都直接调用系统底层资源执行相应任务
 *                      2.变量valueOffset，表示该变量值在内存中的偏移地址，因为Unsafe就是根据内存偏移地址获取数据的
 *                      3.变量value用volatile修饰，保证了多线程之间的内存可见性。
 *                  简单版小总结
 *                      CAS(CompareAndSwap)
 *                      比较当前工作内存中的值和主内存中的值，如果相同则执行规定操作，
 *                      否则继续比较直到主内存和工作内存中的值一致为止。
 *
 *                      CAS应用
 *                      CAS有3个操作数，内存值V，旧的预期值A，要修改的更新值B。
 *                      当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
 *      3.CAS缺点（自旋锁）
 *              循环时间长开销很大
 *                  我们可以看到getAndInt方法执行时，有个do while，如果CAS失败，会一直进行尝试。
 *                  如果CAS长时间一直不成功，可能会给CPU带来很大的开销。
 *              只能保证一个共享变量
 *              引出来ABA问题？
 *
 *  CAS ---> UnSafe ---> CAS底层思想 ---> ABA ---> 原子引用更新 ---> 如何规避ABA问题
 *      * ABA：狸猫换太子
 *
 *      ABA问题怎么产生的？
 *      CAS会导致"ABA问题"   理解原子引用 + 新增一种机制，那就是修改版本号（类似时间戳）
 *          CAS不够？？？
 *
 *      CAS算法实现一个重要前提需要取出内存中某时刻的数据并在当下时刻比较并替换，那么在这个时间差类会导致数据的变化。
 *
 *      比如说一个线程one从内存位置V中取出A，这时候另一个线程two从内存中取出A，并且线程two进行了一些操作将值变成了B，
 *      然后线程two又将V位置的数据变成A，这时候线程one进行CAS操作发现内存中仍然是A，然后线程one操作成功。
 *
 *      尽管线程one的CAS操作成功，但是不代表这个过程就是没有问题的。
 *
 */
public class C_12_16_CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // main do thing...

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data:" + atomicInteger.get());

    }
}
