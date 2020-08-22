package com.java.z_exam.sync.c_001_synchronized;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-29 9:15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * synchronized关键字
 * 对某个对象加锁
 */

// Synchronized 修饰普通同步方法：锁对象当前实例对象
public class T03_Synchronized_Way3 {

    private int count = 10;

    public synchronized void m() { // 等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}


/*

如果你要是锁定当前对象，你也可以写成synchronized 方法名()，这个和synchronized(this)是等值的。

 */