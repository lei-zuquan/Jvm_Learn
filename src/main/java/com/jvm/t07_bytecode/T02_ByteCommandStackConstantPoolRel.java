package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:26 上午 2020/8/10
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    演示 字节码指令 和 操作数栈、常量池的关系

    最终使用: javap -v T02_ByteCommandStackConstantPoolRel.class
 */

public class T02_ByteCommandStackConstantPoolRel {
    public static void main(String[] args) {
        int a = 10;
        int b = Short.MAX_VALUE + 1;
        int c = a + b;
        System.out.println(c);
    }
}
