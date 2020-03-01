package com.java.basic.c01_datatype;

/**
 * 计算机常用的进制的使用说明：
 *
 * 对于整数，有四种表示方式：
 * 二进制（binary）:0,1，满2进1，以ob或0B开头。
 * 十进制 (decimal):0-9，满10进1.
 * 八进制 (octal):0-7，满8进1，以数字0开头表示。
 * 十六进制 (hex):0-9及A-F，满16进1，以0x或0X开头表示
 *
 */
public class BinaryTest {

    public static void main(String[] args) {
        int i1 = 0b10;
        int i2 = 10;
        int i3 = 010;
        int i4 = 0x10;

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);
    }
}
