package com.java.meet.c01_11_volatile;

import java.util.concurrent.atomic.AtomicInteger;

class MyNumber {
    volatile int number = 0;

    // 请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
    public void addPlusPlus(){
        number++;
    }

    // 使用JDK提供的原子类，可以解决volatile不保证原子性问题，采用CAS比较并交换
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

public class C_03_Volatile_NotSupportAtomic {

    public static void main(String[] args) { // main是一切方法的运行入口
        notSupportAtomicByVolatile();
    }

    // volatile 不保证原子性 及 使用JDK Atomic原子类解决volatile不保证原子性问题
    private static void notSupportAtomicByVolatile() {
        MyNumber res = new MyNumber();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    res.addPlusPlus();
                    res.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少？
        while (Thread.activeCount() > 2){
            Thread.yield(); // yield我不执行，让其他的线程更好地执行
        }

        System.out.println(Thread.currentThread().getName() + "\t int type,finally number value:" + res.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type,finally number value:" + res.atomicInteger);
    }
}

