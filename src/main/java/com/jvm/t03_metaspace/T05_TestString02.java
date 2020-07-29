package com.jvm.t03_metaspace;

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

        String x = "ab";
        String s = new String("a") + new String("b");

        // 堆  new String("a")   new String("b") new String("ab")
        String s2 = s.intern(); // 将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则放入串池， 会把串池中的对象返回

        System.out.println(s2 == x);
        System.out.println(s == x);
    }

}
