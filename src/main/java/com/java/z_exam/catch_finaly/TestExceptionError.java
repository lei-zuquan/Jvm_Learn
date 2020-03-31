package com.java.z_exam.catch_finaly;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-27 9:39
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TestExceptionError {

    public static void main(String[] args) {
        test();
    }

    private static int test() {
        int i = 0;
        try {
            i++;
            System.out.println("try block, i = " + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
        } finally {
            i++;
            System.out.println("finally block i = " + i);
        }

        return i;
    }
}
