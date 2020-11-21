package com.java.z_exam.juc.c02_synchronized;

/**
 * @Author:
 * @Date: 2020-11-21 17:03
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// synchronized 关键字：同步和非同步方法是否同时调用？
public class T07 {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }
    /*new Thread( () -> t.m1(), "t1").start();
            new Thread( () -> t.m2(), "t2").start();*/
    public static void main(String[] args) {
        T07 t = new T07();


        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        });*/
    }
}
