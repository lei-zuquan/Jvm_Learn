package com.java.z_exam.jvm_gc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:31 下午 2020/3/23
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T04_MyMath {
    public static void main(String[] args) {
        method01(); // java.lang.StackOverflowError
    }

    public static void method01() {
        int[] arr = new int[1000000000];
        method01();
    }
}
