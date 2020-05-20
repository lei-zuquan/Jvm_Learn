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
 */
public class Singleton_06 {
    private static volatile Singleton_06 INSTANCE;

    // 构造方法私有
    private Singleton_06() {}


    public static Singleton_06 getInstance() {
        if (INSTANCE == null) {
            // 双重检查
            synchronized (Singleton_06.class) {
                if (INSTANCE == null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton_06();
                }
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
                System.out.println(Singleton_06.getInstance().hashCode());
            }).start();
        }
    }
}
