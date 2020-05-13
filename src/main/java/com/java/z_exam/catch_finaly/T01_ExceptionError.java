package com.java.z_exam.catch_finaly;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-27 9:39
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T01_ExceptionError {

    public static void main(String[] args) {

        test();

        List<String> list = test2();
        list.forEach(value -> System.out.println(value));
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

    private static List<String> test2() {
        List<String> list = new ArrayList<>();
        try {
            list.add("step try");
            System.out.println("try block");
            return list;
        } catch (Exception e){
            list.add("step catch");
            System.out.println("catch block");
            return list;
        } finally {
            list.add("step finally");
            System.out.println("finally block");
        }
    }
}
