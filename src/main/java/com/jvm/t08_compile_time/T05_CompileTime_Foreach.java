package com.jvm.t08_compile_time;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:41 上午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖)——foreach
public class T05_CompileTime_Foreach {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5}; // 数组赋初值的简化写法也是语法糖哦
        for (int e : array) {
            System.out.println(e);
        }
    }
}
