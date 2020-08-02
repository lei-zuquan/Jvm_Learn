package com.jvm.t04_stringtable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-29 11:12
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T05_TestString02 {
    //  ["ab", "a", "b"]
    public static void main(String[] args) {
        // 在串池中添加"ab"
        String x = "ab";
        // 在堆中创建一个string对象； 堆  new String("a")   new String("b") new String("ab")
        String s = new String("a") + new String("b");

        // 将此string对象中的值尝试放入StringTable，并将串池中的对象返回（并没有成功放入）
        String s2 = s.intern();

        // 将这个字符串对象尝试放入串池，如果有则并不会放入，并返回串池中的对象（字符串相等），如果没有则放入串池， 会把串池中的对象返回
        System.out.println(s2 == x); // s2 是x在串池中的对象，所以值是相等
        System.out.println(s == x);  // s 是在堆中创建的对象，x是串池中的对象，所以不相等
    }
}
