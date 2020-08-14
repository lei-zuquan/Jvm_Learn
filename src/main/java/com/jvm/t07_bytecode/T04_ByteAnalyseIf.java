package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:39 下午 2020/8/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：条件判断指令
public class T04_ByteAnalyseIf {
    public static void main(String[] args) {
        int a = 0;
        if (a == 0) {
            a = 10;
        } else {
            a = 20;
        }
    }
}
