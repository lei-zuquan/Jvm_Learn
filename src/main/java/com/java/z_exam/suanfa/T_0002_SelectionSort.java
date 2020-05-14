package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:27 上午 2020/5/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 选择排序
public class T_0002_SelectionSort {
    public static void main(String[] args) {
        //int[] arr = {5,3,6,8,1,7,9,4,2};
        int[] arr = {5,8,5,2,9};

        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i; j < arr.length; j++) {
               minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            //System.out.println("minPos: " + minPos);

            swap(arr, i, minPos);


            //System.out.println("经过第" + i + "次循环之后，数组的内容：");
        }
        print(arr);

    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            swap(arr, i, minPos);
        }
        //print(arr);
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
