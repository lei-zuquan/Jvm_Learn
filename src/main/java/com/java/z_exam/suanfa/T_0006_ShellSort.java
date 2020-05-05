package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:38 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0006_ShellSort {
    public static void main(String[] args) {
        int[] a ={9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        sort(a);
        print(a);

    }

    public static void sort (int[] arr){
        // Knuth序列
        // h = 1
        // h = 3*h + 1
        int h = 1;
        while (h <= arr.length / 3){
            h = h*3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap-1)/3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j-= gap) {
                    if (arr[j] < arr[j-gap]){
                        swap(arr, j, j-gap);
                    }
                }
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
