package com.java.z_exam.sync.c_001;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-29 9:18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */


public class T04 {

    private static int count = 10;

    public synchronized static void m() { //这里等同于synchronized(FineCoarseLock.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (T04.class) { //考虑一下这里写synchronized(this)是否可以？
            count--;
        }
    }

}