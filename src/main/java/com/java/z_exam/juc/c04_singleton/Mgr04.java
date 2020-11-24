package com.java.z_exam.juc.c04_singleton;

/**
 * @Author:
 * @Date: 2020-11-24 19:06
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    lazy loading
    也称懒汉式
    虽然达到了按需初始化的目的，但却能带来线程不安全的问题
    可以通过synchronized 解决，但也带来了效率下降

 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Mgr04();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
        }
    }
}
