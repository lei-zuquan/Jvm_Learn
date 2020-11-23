package com.java.z_exam.juc.c02_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: 2020-11-21 21:21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
  一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁。
  也就是说synchronized 获得锁是可重入的
 */
public class T09 {

    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new T09().m1();
    }


}
