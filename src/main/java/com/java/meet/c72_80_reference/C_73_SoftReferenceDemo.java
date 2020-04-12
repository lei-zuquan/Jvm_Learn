package com.java.meet.c72_80_reference;

import java.lang.ref.SoftReference;

/**
 * 73_软引用SoftReference
 *
 *      软引用
         *              软引用是一种相对强引用弱化了一些的引用，需要用java.lang.ref.SoftReference类来实现，可以让对象豁免一些垃圾收集。
         *
         *              对于只有软引用的对象来说，
         *                      当系统内存充足时它       不会      被回收
         *                      当系统内存不足时它         会      被回收
         *              软引用通常用在对内存敏感的程序中，比如高速缓存就有用到软引用，内存够用的时候就保留，不够用就回收！
 *
 */

public class C_73_SoftReferenceDemo {

    /**
     * 内存够用的时候就保留，不够用就回收！
     */
    public static void softRef_Memory_Enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让它内存不够用了导致OOM，看软引用的回收情况
     * 运行此接口时，需要先在idea -> run -> vm_option中输入：
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        // System.gc(); // 本次不需要手动gc，需要让jvm自动gc

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }


    public static void main(String[] args) {
        // softRef_Memory_Enough();
        softRef_Memory_NotEnough();

    }
}
