package com.java.z_exam.juc.c02_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: Created in 9:40 上午 2020/11/22
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// synchronized 关键字：锁可重入
public class T10 {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}


class TT extends T10 {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
