package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:32 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0004_BubbleSort {
    public static void main(String[] args) {
        int[] a ={9,3,1,4,6,8,7,5,2};
        sort(a);
        print(a);

    }

    private static void sort (int[] a){
        for (int i = a.length -1; i > 0; i-- ) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) //swap(a, j, j+1);
                    findMax(a, i);
            }
        }
    }

    private static void findMax(int[] a, int n){
        for (int j = 0; j < n; j++) {
            if (a[j] > a[j+1]) swap(a, j, j+1);
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
