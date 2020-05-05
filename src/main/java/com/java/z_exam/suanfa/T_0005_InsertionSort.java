package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:14 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 * 对于基本有序的数组最好用
 * 稳定
 *
 * 插入排序比冒泡排序快一倍
 */

public class T_0005_InsertionSort {
    public static void main(String[] args) {
        int[] a ={9,3,1,4,6,8,7,5,2};
        sort(a);
        print(a);

    }

    public static void sort (int[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && (a[j] < a[j-1]); j--) {
                //if (a[j] < a[j-1]){
                    swap(a, j, j-1);
                //}
            }
        }
    }


    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
