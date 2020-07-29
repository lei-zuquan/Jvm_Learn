package com.jvm.t01_stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-28 11:57
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 局部变量的线程安全问题
 * <p>
 * 如果方法内局部变量没有逃离方法的作用访问，它是线程安全的
 * 如果是局部变量引用了对象，并逃离方法的作用方法，需要考虑线程安全
 */

public class T03_StackSafeProblem {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(() -> {
            m2(sb);
        }).start();
    }

    public static void m1() {
        // 因为变量就方法内局部变量，x是线程私有的，不存在线程安全问题
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m2(StringBuilder sb) {
        // sb是通过方法接口传入进来的,sb是线程共享的变量，就有可能被其他线程访问，所以不是线程安全；
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static StringBuilder m3() {
        // sb通过方法返回了，那就有可能被其他线程拿到sb对象，然后对其进行操作，所以不是线程安全；
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }

}
