package com.java.basic.c01_datatype;

/**
 * 基本数据类型变量间的运算：
 * 1. 自动类型提升：当容量小的数据类型变量与容量大的数据类型变量做运算时，结果为容量大的数据类型。
 * 说明：
 *      a.此时的运算只包含基本数据类型中的7种，唯独不包括boolean类型！
 *      b. byte、 short、char --> int --> long --> float --> double
 *      特别的，byte、short、char之间做运算，结果为Int型。
 *
 * 2. 强制类型转换：是自动类型提升运算的逆运算。见：VariableTest1.java
 *
 * 注意：此时的容量的大小，不是指占用内存的空间的大小，而是指表范围的大小。
 *      long(8个字节) 相较于 float(4个字节)算容量小的
 */
public class VariableTest {

    public static void main(String[] args) {

        short s1 = 10;
        int i1 = 20;
        int i2 = s1 + i1;
        System.out.println(i2);


        long l1 = 123L;
        float f1 = 123.3F;
        //long l2 = l1 + f1; // 编译不通过
        float f2 = l1 + f1;
        System.out.println(f2);

        //***************************
        char c1 = 'a'; // ascii码值为：97
        int i3 = c1 + i1;
        System.out.println(i3); // 117

        //***************************
        byte b1 = 12;
        short s2 = 20;
        //short s3 = b1 + s2; // 编译不通过
        //char c2 = b1 + c1; // 编译不通过
        //short s4 = s2 + c1; // 编译不通过
        byte b2 = 10;
        //byte b3 = b1 + b2; //编译不通过

        //*************关于常量**************
        // 整型常量，默认为int型
        short s5 = 10;
        //short i4 = s5 + 2;// 编译不通过
        int i4 = s5 + 2;
        // 浮点型常量，默认为double型
        //float f3 = s5 + 2.1;// 编译不通过
        double d1 = s5 + 2.1;

        //*************理解如下的声明**************
        long l2 = 1234L;
        System.out.println(l2);

        long l3 = 1234; // 自动类型提升
        System.out.println(l3);

        //long l4 = 2354353453432; // 编译不通过，Integer number too large
        long l4 = 2354353453432L;

        float f3 = 123.4F;
        //float f4 = 123.4; //编译不通过，浮点型常量，默认为double型
    }
}
