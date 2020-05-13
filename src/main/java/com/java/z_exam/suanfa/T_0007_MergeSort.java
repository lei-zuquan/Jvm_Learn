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
        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    public static void sort(int[] arr, int left, int right){
        if (left == right) return;

        // 分成两半
        int mid = left + (right - left) / 2;
        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid+1, right);

        merge(arr, left, mid + 1, right);
    }

    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && i <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= rightBound) temp[k++] = arr[j++];

        //print(temp);
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
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
