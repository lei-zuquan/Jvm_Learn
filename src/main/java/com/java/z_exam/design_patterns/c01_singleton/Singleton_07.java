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
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 *
 * 完美写法之一，比第一种要好一些
 */
public class Singleton_07 {

    // 构造方法私有
    private Singleton_07() {}

    private static class Singleton_07_Holder {
        private final static Singleton_07 INSTANCE = new Singleton_07();
    }

    // 不但实现了懒加载，而且只加载一次
    // Singleton_07如果实例化了，Singleton_07_Holder也不会实例化，只有在getInstance被调用时才加载
    public static Singleton_07 getInstance() {
        return Singleton_07_Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_07.getInstance().hashCode());
            }).start();
        }
    }
}
