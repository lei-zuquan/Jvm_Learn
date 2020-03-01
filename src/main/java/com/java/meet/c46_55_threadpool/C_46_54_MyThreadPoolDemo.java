package com.java.meet.c46_55_threadpool;

import java.util.concurrent.*;

/**
 * 46_线程池使用及优势
 * 47_线程池3个常用方式
 * 48_线程池7大参数入门简介
 * 49_线程池7大参数深入介绍
 * 50_线程池底层工作原理
 * 51_线程池的4种拒绝策略理论简介
 * 52_线程池实际中使用哪一个
 * 53_线程池的手写改造和拒绝策略
 * 54_线程池配置合理线程数
 *
 * 第4种获得/使用java多线程的方式，线程池
 *
 * 线程池做的工作主要是控制运行的线程的数量，【处理过程中将任务放入队列】，然后在线程创建后启动这些任务，【如果线程数量超过了最大
 * 数量超出数量的线程排队等候，等其它线程执行完毕，再从队列中取出任务来执行。】
 *
 * 它的主要特点为：【线程复用；控制最大并发数；管理线程】
 *
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
 * 第三：提高响应的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行
 *      统一的分配，调优和监控
 *
 * Java中的线程池是通过Executor框架实现的，该框架中用到了Executor,Executors,ExecutorService,
 * ThreadPoolExecutor这几个类
 *
 *     public ThreadPoolExecutor(int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler)
 *
 *
 *   ---------------------------
 *
 *   49_线程池7大参数深入介绍
 *
 *      1. corePoolSize: 线程池中常驻核心线程数
 *              1. 在创建了线程池后，当有请求任务来之后，就会安排池中的线程去执行请求任务，近似理解为今日当值线程
 *              2. 当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中
 *
 *      2. maximumPoolSize: 线程池能够容纳同时执行的最大线程数，此值必须大于等于1
 *
 *      3. keepAliveTime: 多余的空闲线程的存活时间。
 *              当前线程池数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，
 *              多余空闲线程会被销毁直到只剩下corePoolSize个线程为止
 *
 *      4. unit: keepAliveTime的单位
 *      5. workQueue: 任务队列，被提交但尚未被执行的任务
 *      6. threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程【一般用默认的即可】
 *      7. handler: 拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程池的最大线程数（maximumPoolSize）时如何拒绝
 *              今日当值窗口满了，加班窗口也满了，候客区也满了，启动拒绝策略
 *
 * -----------------以下重要；以下重要；以下重要；以下重要----------------
 * 1.在创建了线程池后，等待提交过来的任务请求。
 * 2.当调用execute()方法添加一个请求任务时，线程池会做如下判断：
 *      2.1 如果正在运行的线程数量小于corePoolSize，那么马上创建线程运行这个任务；
 *      2.2 如果正在运行的线程数量大于或等于corePoolSize，那么将这个任务放入队列；
 *      2.3 如果这时候队列满了且正在运行的线程数量还小于maximumPoolSize，那么还是要创建非核心线程立刻运行这个任务；
 *      2.4 如果队列满了且正在运行的线程数量大于或等于maximumPoolSize，那么线程池会启动饱和拒绝策略来执行。
 * 3.当一个线程完成任务时，它会从队列中取下一个任务来执行。
 * 4.当一个线程无事可做超过一定的时间（keepAliveTime）时，线程池会判断：
 *      如果当前运行的线程数大于corePoolSize，那么这个线程就被停掉。
 *      所以线程池的所有任务完成后它最终会收缩到corePoolSize的大小
 *
 *
 * ----------------------
 *
 * 1.线程池的拒绝策略你谈谈
 *     是什么？
 *          等待队列已经排满了，再也塞不下新任务了
 *          同时，
 *          线程池中的max线程也达到了，无法继续为新任务服务。
 *          这时候我们就需要拒绝策略机制合理的处理这个问题
 *     JDK内置的拒绝策略（以下4种内置拒绝策略均实现了RejectedExecutionHandler接口）
 *          AbortPolicy(默认)：直接抛出RejectedExecutionException异常
 *          CallerRunPolicy: "调用者运行"一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务退到调用者，从而降低新任务的流量。
 *          DiscardOldestPolicy:抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务。
 *          DiscardPolicy:直接丢弃任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种方案。
 *
 *
 * 2.你在工作中单一的/固定数的/可变的三种创建线程池的方法，你用那个多？超级大坑
 *      正确答案：一个都不用，我们生产上只能使用自定义的
 *      Executors中JDK已经给你提供了，为什么不用？
 *              【阿里巴巴Java开发手册（华山版）.pdf】
 *              3. 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
 *                  说明：线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问
 *                  题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。
 *              4. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这
 *                  样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 *                  说明：Executors 返回的线程池对象的弊端如下： 1） FixedThreadPool 和 SingleThreadPool：
 *                  允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。 2） CachedThreadPool：
 *                  允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
 *
 * 3.你在工作中是如何使用线程池的，是否自定义过线程池使用
 *          正常答案：是，我们都是自定义线程池
 *
 * 4.合理配置线程池你是如何考虑的？
 *      // 首先查看一下服务器cpu核数
 *      System.out.println(Runtime.getRuntime().availableProcessors());
 *
 *      CPU密集型：
 *              CPU密集的意思是该任务需要大时的运算，而没有阻塞，CPU一直全速运行
 *              CPU密集任务只有在真正的多核CPU上才可能得到加速（通过多线程），
 *              而在单核CPU上（悲剧吧！），无论你开几个模拟的多线程该任务都不可能得到加速，因为CPU总的运算能力就那些。
 *
 *              CPU密集型任务配置尽可能少的线程数量：
 *                  一般公式：CPU核数 + 1个线程的，线程池
 *
 *      IO密集型：2种方式
 *              第一种方式：由于IO密集型任务线程并不是一直在执行任务，则应配置尽可能多的线程，如CPU核数 * 2
 *
 *              第二种方式：（来自大厂）
 *                  IO密集型，即该任务需要大量的IO，即大量的阻塞。
 *                  在单线程上运行IO密集型的任务会导致浪费大量的CPU运算能力浪费在等待。
 *                  所以在IO密集型任务中使用多线程可以大大的加速程序运行，即使在单核CPU上，这种加速主要就是利用了被浪费掉的阻塞时间。
 *
 *                  IO密集型时，大部分线程都阻塞，故需要多配置线程数：
 *                  参考公式： CPU核数 / （1-阻塞系数）      阻塞系数在0.8~0.9之间
 *                          比如8核CPU：8 / (1-0.9) = 80个线程数
 *
 *
 */
public class C_46_54_MyThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 30; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                // 暂停一会儿线程
                //try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e){  e.printStackTrace();}
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        // 查看底层cpu核数（计算机专业）
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Array    Arrays
        // Collection   Collections
        // Executor     Executors
        // 线程池也有自己实现的工具类
        // ThreadPoolExecutor
        // Executors.newScheduledThreadPool()
        // 共5种实现方式
        // （了解：2种）java8新出  Executors.newWorkStealingPool(int)  --  java8 新增，使用目前机器上可用的处理器作为它的并行级别
        // 【重点3种实现方式】
        /**
         * Executors.newFixedThreadPool(int)    执行长期的任务, 固定数线程
         *      1.创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
         *      2.newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的。
         *          它使用的LinkedBlockingQueue
         * Executors.newSingleThreadExecutor()    一个任务一个，一池一线程
         *      1.创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指下顺序执行。
         *      2.newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，
         *          它使用的LinkedBlockingQueue
         * Executors.newCachedThreadPool()      适用：执行很多短期异步任务，一池多线程
         *      1.创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
         *      2.newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE,
         *          使用的SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程
         *
         * 底层使用的是：ThreadPoolExecutor
         */

        // 只要是池子，关闭比使用更重要。
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); // 一池5个处理线程。类似银行前台5个工作人员
        //ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一池N个处理线程


        // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                // 暂停一会儿线程
                //try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e){  e.printStackTrace();}
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
