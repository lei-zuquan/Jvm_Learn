package com.jvm.t05_direct;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 11:21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 禁用显式回收对直接内存的影响
 * <p>
 * 因为程序调用System.gc() 会触发full gc，可能会长时间在垃圾回收
 * <p>
 * 为了避免程序员显示调用System.gc(),  我们一般禁用显式调用System.gc()
 * 禁用显式System.gc()，会对直接内存有影响，为此，我们需要通过unSafe类的freeMemory()方法来释放直接内存
 */

public class T03_DirectMemoryGcBySystemGc {

    static int _1Gb = 1024 * 1024 * 1024;

    /*
     * -XX:+DisableExplicitGC 显式的
     */
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc(); // 显式的垃圾回收，Full GC
        System.in.read();
    }
}
