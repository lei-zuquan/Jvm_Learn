package com.java.meet.c81_87_oom;


import java.util.concurrent.TimeUnit;

/**
 * 85_OOM之unable to create native thread 故障演示
 * 86_OOM之unable to create native thread 上限调整
 *
 * 高并发请求服务器时，经常出现如下异常：java.lang.OutOfMemoryError: unable to create new native thread
 * 准确地讲该native thread异常与对应的平台有关
 *
 * 导致原因：
 *      1.你的应用创建了太多线程了，一个应用进程创建多个线程，超过系统承载极限；
 *      2.你的服务器并不允许你的应用程序创建这么多线程，linux系统默认允许单个进程可以创建的线程数是1024个，
 *          你的应用创建超过这个数量，就会报java.lang.OutOfMemoryError: unable to create new native thread
 *
 * 解决办法：
 *      1.想办法降低你应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是，改代码将线程数降到最低
 *      2.对于有的应用，确实需要创建很多线程，远超过linux系统的默认1024个线程的限制，可以通过修改linux服务器配置，扩大linux默认限制
 *
 *
 * 非root用户登陆Linux系统测试（root用户没有上限，可以一直new）
 * 服务器级别调参调优
 *      ulimit -u   查看linux最高线程数限制
 *      vi /etc/security/limits.d/90-nproc.conf
 *      打开后发现除了root，其他账户都限制在1024个，root用户无上限
 *      假如我们想要张三这个用户运行，希望他生成的线程我一些，我们可以如下配置
 *      *       soft    nproc   1024
 *      root    soft    nproc   unlimited
 *      z3      soft    nproc   20000
 */
public class C_85_86_UnableCreateNewThreadDemo {

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     *
     */
    public static void main(String[] args) {
        //new Thread().start();
        for (int i = 1; ; i++) {
            System.out.println(("******************* i = " + i));

            new Thread(() -> {
                try {
                    // 暂停一会儿线程
                    try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e){  e.printStackTrace();}
                }catch (Exception e){
                    e.printStackTrace();
                }
            },""+i).start();
        }
    }
}
