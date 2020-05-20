package com.java.z_exam.design_patterns.c01_singleton;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:29 下午 2020/5/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 */
public enum Singleton_08 {

    INSTANCE;

    public void m() {}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton_08.INSTANCE.hashCode());
            }).start();
        }
    }
}
