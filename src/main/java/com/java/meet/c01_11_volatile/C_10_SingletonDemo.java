package com.java.meet.c01_11_volatile;

/**
 * 10_单例模式在多线程环境下可能存在多线程安全问题
 *
 */
public class C_10_SingletonDemo {

    /**
     * 多线程环境下，单例模式下，需要DCL机制 + volatile禁止指令重排
     */
    //private static C_10_SingletonDemo instance = null;
    private static volatile C_10_SingletonDemo instance = null;

    private C_10_SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法SingletonDemo()");
    }

    //public static synchronized SingletonDemo getInstance(){
//    public static SingletonDemo getInstance(){
//        if (instance == null){
//            instance = new SingletonDemo();
//        }
//
//        return instance;
//    }
    // DCL (Double Check Lock双端检锁机制)，还是有问题，可能运行1000万次，才出一次问题

    /**
     * DCL(双端检锁) 机制不一定线程安全,原因是有指令重排的存在,加入volatile可以禁止指令重排
     *
     * 原因在于某一个线程在执行到第一次检测,读取到的instance不为null时,instance的引用对象可能没有完成初始化.
     *
     * instance=new SingletonDem(); 可以分为以下步骤(伪代码)
     *
     * memory=allocate();//1.分配对象内存空间
     *
     * instance(memory);//2.初始化对象
     *
     * instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null
     *
     * 步骤2和步骤3不存在数据依赖关系.而且无论重排前还是重排后程序执行的结果在单线程中并没有改变,因此这种重排优化是允许的.
     *
     * memory=allocate();//1.分配对象内存空间
     *
     * instance=memory;//3.设置instance的指向刚分配的内存地址,此时instance!=null 但对象还没有初始化完.
     */
    public static C_10_SingletonDemo getInstance(){
        if (instance == null){
            synchronized (C_10_SingletonDemo.class){
                if (instance == null){
                    instance = new C_10_SingletonDemo();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        // 单线程（main线程的操作动作...）
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                C_10_SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }

    }
}
