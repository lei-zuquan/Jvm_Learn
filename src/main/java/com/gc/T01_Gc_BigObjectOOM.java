package com.gc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-08-06 15:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// GC 分析 大对象OOM
public class T01_Gc_BigObjectOOM {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<byte[]> list = new ArrayList<>();
//        list.add(new byte[_8MB]);
//        list.add(new byte[_8MB]);

        // 一个线程OOM，不会导致整个进程挂掉
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }, "Thread01").start();

        System.out.println("sleep...");
        TimeUnit.SECONDS.sleep(10);
    }
}
