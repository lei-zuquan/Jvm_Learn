package com.java.meet.c01_11_volatile;

/**
 * 02_volatile是什么
 * 03_JMM内存模型之可见性
 * 04_可见性代码验证说明
 * 05_volatile不保证原子性
 * 06_volatile不保证原子理论解释
 * 07_volatile不保证原子性问题解决
 * 08_volatile指令重排案例1
 * 09_volatile指令重排案例2
 *
 *
 * 并发与并行的区别
 *
 * 1. 请谈谈你对volatile的理解
 *      1.volatile是Java虚拟机提供的轻量级的同步机制
 *              1.1保证可见性
 *              1.2不保证原子性
 *              1.3禁止指令重排
 *      2.JMM你谈谈
 *              2.1可见性
 *                      通过前面对JMM的介绍,我们知道
 *                      各个线程对主内存中共享变量的操作都是各个线程各自拷贝到自己的工作内存操作后再写回主内存中的.
 *
 *                      这就可能存在一个线程AAA修改了共享变量X的值还未写回主内存中时 ,另外一个线程BBB又对内存中的
 *                      一个共享变量X进行操作,但此时A线程工作内存中的共享比那里X对线程B来说并不不可见.
 *                      这种工作内存与主内存同步延迟现象就造成了可见性问题.
 *              2.2原子性   number++在多线程下是非线程安全的，如何不加synchronized解释
 *              2.3VolatileDemo代码演示可见性 + 原子性代码
 *              2.4有序性  (类似高考，先做会做的，再做不会的)
 *                      计算机在执行程序时,为了提高性能,编译器和处理器常常会做指令重排,一把分为以下3中
 *                      单线程环境里面确保程序最终执行结果和代码顺序执行的结果一致.
 *                      处理器在进行重新排序是必须要考虑指令之间的数据依赖性
 *
 *                      【重点】多线程环境中线程交替执行,由于编译器优化重排的存在,两个线程使用的变量能否保持一致性是无法确定的,结果无法预测
 *
 *                      . 重排1
 *                      . 重排2
 *                      . 禁止指令重排小总结
 *                              volatile实现禁止指令重排优化，从而避免多线程环境下程序出现乱序执行的现象
 *
 *                              先了解一个概念，内存屏障（Memory Barrier）又称内存栅栏，是一个CPU指令，它的作用有两个：
 *                                  一是保证特定操作的执行顺序，
 *                                  二是保证某些的内存可见性（利用该特性实现volatile的内存可见性）
 *                              由于编译器和处理器都能执行指令重排优化。如果在指令插入一条Memory Barrier则会告诉编译器和CPU，不管什么指令都不能
 *                              和这条Memory Barrier指令重排序，也就是说通过插入内存屏障禁止在内存屏障前后的指令执行重排序优化。内存屏障另外一个作
 *                              用是强制刷出各种CPU的缓存数据，因此任何CPU上的线程都能读取到这些数据的最新版本。
 *                                  对volatile变量进行写操作时，会在写操作后加入一条store屏障指令，将工作内存中的共享变量值刷新回到主内存
 *                                  对volatile变量进行读操作时，会在读操作前加入一条load屏障指令，从主内存中读取共享变量
 *
 *                              线程安全性获得保证
 *                                  工作内存与主内存同步延迟现象导致的可见性问题
 *                                  可以使用synchronized或volatile关键字解决，它们都可以使一个线程修改后的变量立即对其他线程可见。
 *
 *                                  对于指令重排导致的可见性问题和有序性问题
 *                                  可以利用volatile关键字解决，因为volatile的另外一个作用就是禁止重排序优化。
 *      3.你在哪些地方用到过volatile?
 *          3.1单例模式DCL代码
 *          3.2单例模式volatile分析
 *
 * 2. cas你知道吗？
 * 3. 原子类AtomicInteger的ABA问题谈谈？原子更新引用知道吗？
 * 4. 我们知道ArrayList是线程不安全，请编码写一个不安全的案例并给出解决方案
 * 5. 公平锁、非公平锁、可重入锁、递归锁、自旋锁、谈谈你的理解？请手写一个自旋锁
 * 6. CountDownLatch/CyclicBarrier/Semaphore使用过吗？
 * 7. 阻塞队列知道吗？
 * 8. 线程池用过吗？ThreadPoolExecutor谈谈你的理解？
 * 9. 线程池用过吗？生产上你如何设置合理参数
 * 10. 死锁编码及定位分析
 * 11. Java里面锁请谈谈你的理解，能说多少说多少
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
JMM(Java内存模型Java Memory Model,简称JMM)本身是一种抽象的概念 并不真实存在,它描述的是一组
 规则或规范通过规范定制了程序中各个变量(包括实例字段,静态字段和构成数组对象的元素)的访问方式.

        JMM关于同步规定:
            1.线程解锁前,必须把共享变量的值刷新回主内存
            2.线程加锁前,必须读取主内存的最新值到自己的工作内存
            3.加锁解锁是同一把锁

    由于JVM运行程序的实体是线程,而每个线程创建时JVM都会为其创建一个工作内存(有些地方成为栈空间),工作内存是每个线程
    的私有数据区域,而Java内存模型中规定所有变量都存储在主内存,主内存是共享内存区域,所有线程都可访问,但线程对变量
    的操作(读取赋值等)必须在工作内存中进行,首先要将变量从主内存拷贝到自己的工作空间,然后对变量进行操作,操作完成再
    将变量写回主内存,不能直接操作主内存中的变量,各个线程中的工作内存储存着主内存中的变量副本拷贝,因此不同的线程无
    法访问对方的工作内存,此案成间的通讯(传值) 必须通过主内存来完成,其简要访问过程如下图
*/

class MyData { // MyData.java ====> MyData.class ===> 字节码
    //int number = 0;
    volatile int number = 0;

    public void addT060(){
        this.number = 60;
    }

    // 请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
    public void addPlusPlus(){
        number++;
    }

    // 解决volatile不保证原子性
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证volatile的可见性
 *      1.1 假如 int number = 0; number变量之前根本没有添加volatile关键字修饰; 没有可见性
 *      1.2 添加volatile，可以解决可见性问题。
 * 2. 验证volatile不保证原子性
 *      2.1 原子性指的是什么意思？
 *          不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整
 *          要么同时成功，要么同时失败。
 *      2.2 volatile不保证原子性的案例演示
 *
 *      2.3 why
 *
 *      2.4 如何解决原子性？
 *          * 加synchronized
 *          * 使用我们的juc 下AtomicInteger
 */
public class C_02_09_VolatileDemo {

    public static void main(String[] args) { // main是一切方法的运行入口
        seeOkByVolatile();
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少？
        while(Thread.activeCount() > 2){
            Thread.yield(); // yield我不执行，让其他的线程更好地执行
        }

        System.out.println(Thread.currentThread().getName() + "\t int type,finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type,finally number value:" + myData.atomicInteger);
    }

    // volatile可以保存证可见生，及时通知其它线程，主物理内存的值已经被修改。
    private static void seeOkByVolatile() {
        MyData myData = new MyData(); // 资源类

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\tcome in");
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e){  e.printStackTrace();}
            myData.addT060();
            System.out.println(Thread.currentThread().getName() + "\tupdated number value:" + myData.number);
        }, "AAAA").start();

        // 第2个线程就是我们的main线程
        while(myData.number == 0){
            // main线程就一直在这里等待循环，走到number值不再等于零
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over" + myData.number);
    }
}
