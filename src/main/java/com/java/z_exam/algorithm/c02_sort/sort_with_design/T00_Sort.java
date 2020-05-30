package com.java.z_exam.algorithm.c02_sort.sort_with_design;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-26 17:43
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
class T00_Sort {

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] arr) {

    }

    // 比较v元素是否大于w元素
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    // 数组元素i和j交换位置
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
