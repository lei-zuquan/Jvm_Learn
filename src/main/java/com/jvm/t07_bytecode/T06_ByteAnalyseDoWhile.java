package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:12 上午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：循环控制do while指令
public class T06_ByteAnalyseDoWhile {
    public static void main(String[] args) {
        int a = 0;
        do {
            a++;
        } while (a < 10);
    }
}
