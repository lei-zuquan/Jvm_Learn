package com.java.meet.c72_80_reference;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 77_虚引用简介
 * 78_ReferenceQueue引用队列介绍
 *
 * 虚引用需要java.lang.ref.PhantomRefence类来实现
 *
 * 顾名思义，就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期。
 * 如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都被垃圾回收器回收，它不能单独使用也不能通过它访问
 * 对象，虚引用必须和引用队列（ReferenceQueue）联合使用。
 *
 * 虚引用的主要作用是跟踪以象被垃圾回收的状态。仅仅是提供了一种确保对象被finalize以后，做某些事情的机制。
 * PhantomReference的get方法总是返回null,因此无法访问对应的引用对象。其意义在于说明一个对象已经进入finalization阶段，
 * 可以被gc回收，用来实现比finalization机制更灵活的回收操作。
 *
 * 换句话说，设置虚引用关联的唯一目的，就是在这个对象被收集器回收的时候收到一个系统通知或者后续添加进一步的处理。
 * Java技术允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。
 *
 *
 */
public class C_77_78_ReferenceQueueDemo {


    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        // 引用队列，需要将引用队列传入弱引用
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=================");

        o1 = null;
        System.gc();
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){  e.printStackTrace();}

        System.out.println(o1);
        System.out.println(weakReference.get());
        // 我被回收前需要被引用队列保存下。
        System.out.println(referenceQueue.poll());
    }




}
