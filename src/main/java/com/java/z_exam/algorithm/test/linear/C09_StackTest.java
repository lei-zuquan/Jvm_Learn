package com.java.z_exam.algorithm.test.linear;

import com.java.z_exam.algorithm.linear.C09_Stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-27 9:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C09_StackTest {
    public static void main(String[] args) {
        C09_Stack<String> stack = new C09_Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String str : stack) {
            System.out.print(str + " ");
        }

        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素：" + result);
        System.out.println(stack.size());
    }
}
