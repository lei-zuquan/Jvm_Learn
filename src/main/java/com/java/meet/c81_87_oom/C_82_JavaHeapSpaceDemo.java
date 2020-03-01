package com.java.meet.c81_87_oom;


import java.util.Random;

/**
 * 82_OOM之Java heap space
 */
public class C_82_JavaHeapSpaceDemo {

    /**
     * 需要在idea -> run -> vm options中添加：-Xms10m -Xmx10m
     * JVM最大最小10m
     *
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[80 * 1024 * 1024];
        String str = "hello world";

        while (true){
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }

    }
}
