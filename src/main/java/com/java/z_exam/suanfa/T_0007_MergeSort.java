package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:21 下午 2020/5/8
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0007_MergeSort {
    public static void main(String[] args) {
        // int[] arr = {5,3,6,8,1,7,9,4,2};
        int[] arr = {1,4,7,8,3,6,9};
        sort(arr);
    }

    public static void sort(int[] arr){
        merge(arr);
    }

    private static void merge(int[] arr){
        int mid = arr.length / 2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && i < arr.length){
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j < arr.length) temp[k++] = arr[j++];

        print(temp);
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
