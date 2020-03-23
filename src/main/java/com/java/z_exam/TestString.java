package com.java.z_exam;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-23 9:37
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TestString {
    public static void main(String[] args) {
        String x = "helloworld";
        String y = "helloworld";
        String z = new String("helloworld");

        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(y == z);
        System.out.println(x.equals(y));
    }
}
