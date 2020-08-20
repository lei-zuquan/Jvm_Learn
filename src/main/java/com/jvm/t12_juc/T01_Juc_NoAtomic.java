package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:19 下午 2020/8/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// java 内存模型 —— 没有保证原子性问题演示
public class T01_Juc_NoAtomic {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                i++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                i--;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);
    }
}
