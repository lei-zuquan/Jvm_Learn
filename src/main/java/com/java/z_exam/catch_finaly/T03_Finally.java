package com.java.z_exam.catch_finaly;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:49 上午 2020/5/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T03_Finally {
    public static void main(String[] args) {
        test1();

        test2();
    }

    private static void test1() {
        try {
            System.out.println("step one: -> try running");
            return;
        } catch (NullPointerException e){
            e.printStackTrace();
        } finally {
            System.out.println("step second: -> finally running");
        }

        System.out.println("step third: -> hello world");
    }

    private static void test2() {
        try {
            // do something System...
            System.out.println("step forth: -> try running");
            System.exit(1);
        } finally {
            System.out.println("step forth: -> finally running");
        }
    }
}
