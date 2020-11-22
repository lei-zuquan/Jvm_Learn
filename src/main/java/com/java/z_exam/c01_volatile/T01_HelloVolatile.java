package com.java.z_exam.c01_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: Created in 1:59 下午 2020/10/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    volatile 保证多线程可见性
 */
public class T01_HelloVolatile {
    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m start");
        while (running) {
            System.out.println("hello");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            e.printStackTrace();
        }

        t.running = false;
    }
}
