package com.java.z_exam.design_patterns.c01_singleton;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:29 下午 2020/5/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.concurrent.TimeUnit;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过 synchronized 解决，但也带来效率下降
 * 通过减少 synchronized 同步锁粒度，发现多线程不安全问题依然存在
 */
public class Singleton_05 {
    private static Singleton_05 INSTANCE;

    // 构造方法私有
    private Singleton_05() {}


    public static Singleton_05 getInstance() {
        if (INSTANCE == null) {
            // 妄图通过减少同步代码块的方式提高效率，然后不可能
            synchronized (Singleton_05.class) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (Exception e){
                    e.printStackTrace();
                }
                INSTANCE = new Singleton_05();
            }

        }

        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_05.getInstance().hashCode());
            }).start();
        }
    }
}
