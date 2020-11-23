package com.java.z_exam.juc.c02_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author:
 * @Date: 2020-11-21 21:04
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
 面试题：模拟银行账户
 对业务写方法加锁
 对业务读方法不加锁
 这样行不行？

 容易产生脏读问题（dirtyRead）
 */
public class T08 {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        T08 a = new T08();
        new Thread( () -> a.set("zhangsan", 100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
    }
}
