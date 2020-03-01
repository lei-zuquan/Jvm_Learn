package com.java.meet.c72_80_reference;


import java.lang.ref.WeakReference;

/**
 *
 * 74_弱引用WeakReference
 * 75_软引用和弱引用的适用场景
 *
 * 弱引用需要用java.lang.ref.WeekReference类来实现，它比软引用的生存期更短
 *
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的内存
 *
 * 软引用和弱引用的适用场景
 *      假如有一个应用需要读取大量的本地图片：
 *              1.如果每次读取图片都从硬盘读取则会严重影响性能
 *              2.如果一次性全部加载到内存中又可能造成内存溢出
 *      此时使用软引用可以解决这个问题。
 *              设计思路是：用一个HashMap来保存图片的路径和相应图片对象关联的软引用之间的映射关系，
 *              在内存不足时，JVM会自动回收这些缓存图片对象占用的空间，从而有效地避免了OOM的问题。
 *              Map<String, SoftReference<BitMap>> imageCache = new HashMap<String, SoftReference<BitMap>>();
 *
 *
 * 你知道弱引用的话，能谈谈WeakHashMap吗？
 *
 */
public class C_74_75_WeekReferenceDemo {



    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println("=========================");

        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}
