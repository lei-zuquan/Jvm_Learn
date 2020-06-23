package com.java.z_exam.algorithm.c02_sort.sort_with_design;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-23 9:01
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T07_CountSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        countSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        int tongLength = getMaxValue(arr) + 1;
        int[] tongArr = new int[tongLength];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tongArr[arr[i]]++;
        }

        /* 这种方式不太稳定
        for (int i = 0, j = 0; i < tongArr.length; i++) {
            while (tongArr[i]-- > 0) {
                result[j++] = i;
            }
        } */

        // 通过累加数组实现
        for (int i = 1; i < tongArr.length; i++) {
            tongArr[i] = tongArr[i] + tongArr[i - 1];
        }

        //
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = --tongArr[arr[i]];
            result[pos] = arr[i];
        }

        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        return maxValue;
    }
}
