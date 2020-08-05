package com.java.meet.c01_11_volatile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 单例模式：volatile版本
 *
 */
public class C_10_SingletonDemo {

    /**
     * 多线程环境下，单例模式下，需要DCL机制 + volatile禁止指令重排
     */
    //private static C_10_SingletonDemo instance = null;         // 在非常高的并发情况下，可能获取的对象不是同一个
    private static volatile C_10_SingletonDemo instance = null;   // 在非常高的并发情况下，DCL双端检查 + volatile 可以保证获取的是同一个对象

    // 单例类构造方法私有化
    private C_10_SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法SingletonDemo()");
    }

    // 如果单纯依靠 DCL (Double Check Lock双端检锁机制)，还是有问题，可能运行1000万次，才出一次问题
    /**
     * DCL(双端检锁) 机制不一定线程安全，原因是有指令重排的存在，加入volatile可以禁止指令重排
     *
     * 原因在于某一个线程在执行到第一次检测，读取到的instance不为null时，instance的引用对象可能没有完成初始化.
     *
     * instance=new SingletonDem(); 可以分为以下步骤(伪代码)
     *
     * memory=allocate(); //1.分配对象内存空间
     *
     * instance(memory);  //2.初始化对象
     *
     * instance=memory;   //3.设置instance的指向刚分配的内存地址,此时instance!=null
     *
     * 步骤2和步骤3不存在数据依赖关系.而且无论重排前还是重排后程序执行的结果在单线程中并没有改变,因此这种重排优化是允许的.
     *
     * memory=allocate();  //1.分配对象内存空间
     *
     * instance=memory;    //3.设置instance的指向刚分配的内存地址,此时instance!=null 但对象还没有初始化完.
     */
    public static C_10_SingletonDemo getInstance(){
        if (instance == null){
            synchronized (C_10_SingletonDemo.class){
                if (instance == null){
                    instance = new C_10_SingletonDemo();
                }
            }
        }

        if (instance == null) {
            System.out.println("----");
        }

        return instance;
    }

    // List本身是不安全的, 使用以下才安全
    public static List<C_10_SingletonDemo> list = Collections.synchronizedList(new ArrayList<C_10_SingletonDemo>());

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(C_10_SingletonDemo.getInstance());
            }, String.valueOf(i)).start();
        }

        // 等待上述操作完成
        TimeUnit.SECONDS.sleep(2);

        boolean oneSingleObject = true;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) != list.get(j)) {
                    System.out.println("此单例，创建了不同的对象实例！！！\t"  + i + " "+ list.get(i) + "\t" + list.get(j));
                    oneSingleObject = false;
                }
            }
        }

        if (oneSingleObject) {
            System.out.println("通过单例类获取：" + list.size() + " 次依然是同一个对象！");
        }
    }
}
