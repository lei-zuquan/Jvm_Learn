package com.java.meet.c25_34_javalock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 25_Java锁之公平和非公平锁
 * 26_Java锁之可重入锁和递归锁理论知识
 * 28_Java锁之自旋锁理论知识
 *
 *
 * 公平锁/非公平锁/可重入锁/递归锁/自旋锁谈谈你的理解？请手写一个自旋锁
 *      公平锁和非公平锁

 *
 * 公平和非公平锁
 *      是什么
 *          公平锁     是指多个线程按照申请锁的顺序来获取锁，类似排队打饭，先来后到。
 *          非公平锁    是指多个线程获取乐的顺序并不是按照申请锁的顺序，有可能后申请的线程比先申请的线程优先获取锁
 *                     在高并发的情况下，有可能会造成优先级反转或者饥饿现象
 *
 *      两者区别
 *          公平锁/非公平锁
 *          并发包ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或者非公平锁 默认是非公平锁
 *
 *          关于两者区别：
 *          公平锁：Threads acquire a fait lock in the order in which they requested it
 *          公平锁，就是很公平，在并发环境中，每个线程在获取锁时会先查看此锁维护的等待队列，如果为空，或者当前线程是等待队列的第一个，
 *          就占有锁，否则就会加入到等待队列中，以后会按照FIFO的规则 从队列中取到自己
 *
 *          非公平锁：a nonfair lock permits barging: threads requesting a lock can jump ahead of the queue of waiting threads if the lock
 *          happens to be available when it is requested.
 *          非公平锁比较粗鲁，上来就直接尝试占用锁，如果尝试失败，就再采用类似公平锁那种方式。
 *      题外话
 *          Java ReentrantLock而言，
 *          通过构造函数指定该锁是否是公平锁，默认是非公平锁。非公平锁的优点在于吞吐量比公平锁大。
 *
 *          对于Synchronized而言，也是一种非公平锁
 *
 *
 *  可重入锁（又名递归锁）
 *        是什么
 *            可重入锁（也叫做递归锁）
 *            指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *            在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 *            也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 *        ReentrantLock/Synchronized就是一个典型的可重入锁
 *        可重入锁最大的作用是避免死锁
 *        ReentrantLockDemo 参考1、参考2
 *  自旋锁（spinlock）
 *      是指尝试获取的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程上下文的消耗，缺点是循环会消耗CPU
         public final int getAndAddInt(Object var1, long var2, int var4) {
             int var5;
             do {
                var5 = this.getIntVolatile(var1, var2);
             } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

             return var5;
         }
 *
 *  独占锁（写）/共享锁（读）/互斥锁
 *
 *  读写锁
 */
public class C_25_28_T1 {

    volatile int n = 0;

    public void add(){
        n++;
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
    }
}
