package com.java.meet.c35_45_blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    // volatile修饰，值被修改，所有线程可见
    private volatile boolean FLAG = true; // 默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger(); // 默认0
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 大老板叫停了，表示FLAG=false,生产动作结束");
    }

    public void myConsumer()throws Exception{
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列蛋糕" + result + "成功");
        }
    }

    public void stop() throws Exception{
        this.FLAG = false;
    }
}

/**
 * 44_线程通信之生产者消费者阻塞队列版
 *
 * volatile/ CAS / atomicInter / BlockQueue /线程交互 / 原子引用
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
 * 很多消息中间件都是采用类似的设计，不再调用await，signal等操作了
 */
public class C_44_ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        //MyResource myResource = new MyResource(new LinkedBlockingDeque<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        System.out.println();
        System.out.println();
        System.out.println();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e){  e.printStackTrace();}

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到，大老板main线程叫停，活动结束");

        myResource.stop();
    }
}
