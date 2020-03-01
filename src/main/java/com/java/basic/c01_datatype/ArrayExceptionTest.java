package com.java.basic.c01_datatype;

/**
 * 数据中的常见异常
 *
 * 1. 数组角标越界的界常：ArrayIndexOutOfBoundsException
 *
 * 2. 空指针异常：NullPointerException
 *
 * 程序一旦执行中出现异常，就不再继续向下执行。
 *
 */
public class ArrayExceptionTest {

    public static void main(String[] args) {
        // 1. 数组角标越界的异常
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //System.out.println(arr[5]);
        //System.out.println(arr[-1]);

        //2. 空指针异常
        // 举例1
        //int[] arr1 = new int[4];
        //arr1 = null;
        //System.out.println(arr1[0]);

        // 举例2
        //int[][] arr2 = new int[3][];
        //System.out.println(arr2[1][0]);

        // 举例3
        String[] arr3 = new String[3];
        System.out.println(arr3[0].toString());
    }
}
