package com.java.z_exam.algorithm.c02_sort.sort_with_design;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-26 17:39
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

public class T01_Bubble {

    // 对数组a的元素进行排序
    public static void sort(Comparable[] arr) {
        for (int endPos = arr.length - 1; endPos > 0; endPos--) {
            for (int i = 0; i < endPos; i++) {
                if (greater(arr[i], arr[i + 1])) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    // 判断v元素是否大于w元素
    private static boolean greater(Comparable v, Comparable w) {
        if (v.compareTo(w) > 0) {
            return true;
        } else if (v.compareTo(w) == 0) {
            return false;
        } else {
            return false;
        }
    }

    // 数组下标位置i和j交换元素
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


}
