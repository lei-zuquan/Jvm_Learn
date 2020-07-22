package com.java.meet.c35_45_blockqueue;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 35_阻塞队列理论
 * 36_阻塞队列接口和实现类
 * 37_阻塞队列api之抛出异常
 * 38_阻塞队列api之返回布尔
 * 39_阻塞队列api之阻塞和超时控制
 *
 * ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序
 * LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO(先进先出)排序元素，吞吐量通常要高于ArrayBlockingQueue
 * SynchronousQueue: 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于
 *
 * 1 队列
 *
 * 2 阻塞队列
 *      2.1 阻塞队列有没有好的一面
 *
 *      2.2 不得不阻塞，你如何管理
 *
 * 阻塞队列，顾名思义，首先它是一个队列，而一个阻塞队列在数据结构中所起的作用大致如下图所示：
 *
 *      Thread1     PUT  --> BlockingQueue --> TAKE     Thread
 * 如：线程1往阻塞队列中添加元素，而线程2从阻塞队列中移除元素
 *
 * 当阻塞队列是空时，从队列中获取元素的操作将会被阻塞
 * 当阻塞队列是满时，往队列里添加元素的操作将会被阻塞
 *
 * 试图从空的阻塞队列中添加获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。
 * 同样
 * 试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程从队列中移除一个或者多个元素或者完全清空
 * 队列使队列重新变得空闲起来并后续新增
 *
 *
 *
 * 为什么用？有什么好处？
 * =======================
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
 *
 *
 * 为什么需要BlockingQueue
 * ------------------------
 * 好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，因为这一切BlockingQueue都给你一手包办了
 *
 * 在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节，尤其还要兼顾效率和线程安全，
 * 这会给我们的程序带来不小的复杂度。
 *
 * 蛋糕店的前台。如果蛋糕满了，员工阻塞；如果没了蛋糕，顾客阻塞
 *
 * -----------------------------------------
 * 重点：ArrayBlockingQueue：由数组结构组成的有界阻塞队列。
 * 重点：LinkedBlockingQueue：由链表结构组成的有界（但大小默认值为Integer.MAX_VALUE）阻塞队列，慎用。默认大小太大了
 *      PriorityBlockingQueue：支持优先级排序的无界阻塞队列。
 *      DelayQueue：使用优先级队列实现的延迟无界阻塞队列
 * 重点：SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列
 *      LinkedTransferQueue：由链表结构组成的无界阻塞队列
 *      LinkedBlockingDeque：由链表结构组成的双向阻塞队列（双向）
 *
 *
 * -----------------------------
 * 37.阻塞队列api之抛出异常
 *  抛出异常有：
 *          插入add、移除remove、检查element
 *  特殊值有：插入方法，成功true，失败false; 移除方法，成功返回出队列的元素，队列里面没有就返回null
 *          offer(e)、poll、peek
 *  阻塞：当阻塞队列满时，生产者线程继续往队列里put元素，队列会一直阻塞生产线程直到put数据or响应中断退出
 *       当阻塞队列空时，消费者线程试图从队列里take元素，队列会一直阻塞消费者线程直到队列可用
 *          put(e)、take()、不可用
 *  超时：当阻塞队列满时，队列会阻塞生产者线程一定时间，超过后限时后生产者线程会退出
 *          offer(e,time,unit)、poll(time, unit)、不可用
 *
 */
public class C_35_39_BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        waiting();
    }

    private static void timeout() throws InterruptedException {
        // 第四种：超时型
        List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d",2L, TimeUnit.SECONDS));
    }

    private static void waiting() throws InterruptedException {
        //List list = new ArrayList();
        // 第三组：阻塞
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("=========================");
        blockingQueue.put("x");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    private static void returnBoolean() {
        // 第二组：返回boolean型
        List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    private static void throwException() {
        // 第一组：抛异常
        //        List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // 当阻塞队列满时，再往队列里add插入元素会抛IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("x"));

        System.out.println(blockingQueue.element());

        // 当阻塞队列空时，再往队列里remove移除元素会抛NoSuchElementException
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }
}
