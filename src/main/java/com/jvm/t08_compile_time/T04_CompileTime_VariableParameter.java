package com.jvm.t08_compile_time;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:20 上午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖)——可变参数
public class T04_CompileTime_VariableParameter {
    public static void foo(String... args) {
        String[] array = args; // 直接赋值
        System.out.println(array);
    }

    public static void main(String[] args) {
        foo("hello", "world");
    }
}
