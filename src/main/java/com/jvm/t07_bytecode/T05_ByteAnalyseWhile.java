package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:12 上午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：循环控制指令
public class T05_ByteAnalyseWhile {
    public static void main(String[] args) {
        int a = 0;
        while (a < 10) {
            a++;
        }
    }
}
