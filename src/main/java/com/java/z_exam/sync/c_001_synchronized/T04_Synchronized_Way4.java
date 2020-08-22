package com.java.z_exam.sync.c_001_synchronized;

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

// Synchronized 修饰静态同步方法：锁对象是当前的类 Class 对象
public class T04_Synchronized_Way4 {

    private static int count = 10;

    public synchronized static void m() { // 这里等同于synchronized(FineCoarseLock.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (T04_Synchronized_Way4.class) { // 考虑一下这里写synchronized(this)是否可以？答案是不行的
            count--;
        }
    }
}

/*
    我明知道静态方法 static 是没有 this 对象的，你不需要 new 出一个对象来就能执行这个方法，
    但是如果这个上面加一个 synchronized 的话就表示 synchronized(T.class)，这里这个 synchronized(T.class) 锁的就是T类的对象。
 */