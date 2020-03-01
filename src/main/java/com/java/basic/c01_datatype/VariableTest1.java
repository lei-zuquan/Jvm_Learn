package com.java.basic.c01_datatype;

/**
 * 基本数据类型变量间的运算：
 * 强制类型转换：将容量大的数据类型的变量转换为容量小的数据类型的变量。
 * 需要使用强转符：（）
 *
 * 注意：使用强转符，可能会损失精度
 */
public class VariableTest1 {

    public static void main(String[] args) {
        int i1 = 12;
        //byte b1 = i1;//编译不通过

        byte b1 = (byte)i1;
        System.out.println(b1);

        // 损失精度情况一
        float f1 = 12.99F;
        int i2 = (int)f1;
        System.out.println(i2);// 12

        // 损失精度情况二
        int i3 = 128;
        byte b2 = (byte)i3;
        System.out.println(b2);
    }
}
