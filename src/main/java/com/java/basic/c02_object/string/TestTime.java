package com.java.basic.c02_object.string;

public class TestTime {

    public static void main(String[] args) {
        testStringBuilder();
        testStringBuffer();
        testString();
    }

    public static void testString(){
        long start = System.currentTimeMillis();
        String s = new String("0");
        for (int i = 0; i < 10000; i++) {
            s += i;
        }

        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println("String拼接+用时：" + (end - start));
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("String拼接+memory:" + memory);
    }

    public static void testStringBuilder(){
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("0");
        for (int i = 0; i < 10000; i++) {
            s.append(i);
        }

        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder拼接+用时：" + (end - start));
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuilder拼接+memory:" + memory);
    }

    public static void testStringBuffer(){
        long start = System.currentTimeMillis();
        StringBuffer s = new StringBuffer("0");
        for (int i = 0; i < 10000; i++) {
            s.append(i);
        }

        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer拼接+用时：" + (end - start));
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("StringBuffer拼接+memory:" + memory);
    }
}
