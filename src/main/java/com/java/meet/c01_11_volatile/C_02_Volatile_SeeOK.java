package com.java.meet.c01_11_volatile;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

class MyResource {
    //int number = 0; // 此行代码在多线程环境下，变量修改后不可见
    volatile int number = 0; // 此行代码在多线程环境下，变量修改后可见，因为变量被 volatile修饰

    public void addT060(){
        this.number = 60;
    }

}

public class C_02_Volatile_SeeOK {

    public static void main(String[] args) { // main是一切方法的运行入口
        seeOkByVolatile();
    }

    // volatile 可以保证可见性，及时通知其它线程，主物理内存的值已经被修改。
    // volatile 是通过内存屏障实现
    private static void seeOkByVolatile() {
        MyResource res = new MyResource(); // 资源类

        new Thread(() -> {
            System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "线程\t当前值为:" + res.number);
            // 暂停一会儿线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e){  e.printStackTrace();}
            res.addT060();
            System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "线程\t当前值为:" + res.number);
        }, "AAAA").start();

        // 第2个线程就是我们的main线程
        while(res.number == 0){
            // main线程就一直在这里等待循环，走到number值不再等于零
        }
        System.out.println(LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "线程\t当前值为" + res.number);
    }

}

