package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:16 上午 2020/8/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 从字节码角度分析  a++ 相关题目
 */
public class T03_ByteAnalyseAPlusPlus {
    public static void main(String[] args) {
        int a = 10;
        int b = a++ + ++a + a--;
        System.out.println(a);
        System.out.println(b);
    }
}
