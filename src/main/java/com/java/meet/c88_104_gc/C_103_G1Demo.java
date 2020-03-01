package com.java.meet.c88_104_gc;

import java.util.Random;

/**
 * 103_GC之G1参数配置和CMS比较
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class C_103_G1Demo {

    public static void main(String[] args) {
        String str = "hello world";
        while (true){
            str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
            str.intern();
        }
    }
}
