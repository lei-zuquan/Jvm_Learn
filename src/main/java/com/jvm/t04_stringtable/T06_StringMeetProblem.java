package com.jvm.t04_stringtable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-29 11:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示字符串相关面试题
 */

public class T06_StringMeetProblem {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b"; // ab
        String s4 = s1 + s2;   // new String("ab")
        String s5 = "ab";
        String s6 = s4.intern();

// 问
        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // true
        System.out.println(s3 == s6); // true

        String x2 = new String("c") + new String("d"); // new String("cd")
        x2.intern();
        String x1 = "cd";

// 问，如果调换了【最后两行代码】的位置呢，如果是jdk1.6呢
        System.out.println(x1 == x2);
    }
}
