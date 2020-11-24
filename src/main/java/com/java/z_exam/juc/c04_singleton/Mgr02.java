package com.java.z_exam.juc.c04_singleton;

/**
 * @Author:
 * @Date: 2020-11-24 14:30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    跟01 是一个意思
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {
    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }

}
