package com.java.z_exam.sync.c_001;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-29 9:13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */


public class T02 {

    private int count = 10;

    public void m() {
        synchronized (this) { //任何线程要执行下面的代码，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}

/*
我们来谈一下synchronized的一些特性。如果说你每次都定义一个锁的对象Object o，把它new出来，那加锁的时候太麻烦，
每次都要new一个新的对象出来。所以呢，最简单的方式就是synchronized(this)，锁定当前对象就行。

 */