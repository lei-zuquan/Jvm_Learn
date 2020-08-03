package com.jvm.t05_direct;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 11:25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 直接内存分配的底层原理：Unsafe
 *
 * 虚引用关联的对象被回收了，就会触发虚引用对象的clean方法，续而调用Unsafe的freeMemory() 方法
 *
 * 6.3 分配和回收原理
 *
 * 使用了UnSafe对象完成直接内存的分配回收，并且回收需要主动调用freeMemory方法
 *
 * ByteBuffer的实现类内部，使用了Cleaner（虚引用）来监测ByteBuffer对象，一旦ByteBuffer对象被垃圾回收，
 * 那么就会由ReferenceHandler线程通过Cleaner的clean方法调用freeMemory来释放直接内存
 */

public class T04_DirectMemoryGcByUnsafe {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        // 分配内存
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base, _1Gb, (byte) 0);
        System.in.read();

        // 释放内存
        unsafe.freeMemory(base);
        System.in.read();
    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
