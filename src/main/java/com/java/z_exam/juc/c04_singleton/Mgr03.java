package com.java.z_exam.juc.c04_singleton;

/**
 * @Author:
 * @Date: 2020-11-24 18:58
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    懒汉式单例; 不能满足多线程安全问题
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
