package com.java.z_exam.algorithm.c02_sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author:
 * @Date: Created in 3:16 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 校对器
public class T_0003_DataChecker {

    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }

        return arr;
    }

    static void check() {
        boolean same = true;

        for (int times = 0; times < 10; times++) {
            int[] arr = generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);

            Arrays.sort(arr);
            //T_0002_SelectionSort.selectSort(arr2);
            //T_0004_BubbleSort.bubbleSort(arr2);
            T_0005_InsertionSort.insertionSort(arr2);
            //T_0006_ShellSort.shellSort(arr2);
            //T_0007_MergeSort.mergeSort(arr2, 0, arr2.length - 1);
            //T_0008_QuickSort.quickSort(arr2, 0, arr2.length - 1);
            //T_0009_CountSort.countSort(arr2);

            for (int i = 0; i < arr2.length; i++) {
                if (arr[i] != arr2[i]) {
                    same = false;
                    break;
                }
            }

            if (!same) break;
        }


        System.out.println(same == true ? "right": "wrong");
    }

    public static void main(String[] args) {
        check();
    }
}
