package com.java.z_exam.algorithm.c02_sort.sort_with_design;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-26 17:24
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T02_Selection {

    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /*
        对数组a中的元素进行排序
     */
    public static void sort(Comparable[] arr) {
        for (int time = 0; time < arr.length - 1; time++) {
            int min = time; // 取当前剩下数组第一个元素下标为最小下标
            for (int i = time + 1; i < arr.length; i++) {
                // 找到比当前元素值更小的下标，从当前数组序列头开始一直到结尾
                if (greater(arr[min], arr[i])) {
                    min = i;
                }
            }

            //System.out.println("minPos: " + minPos);
            // 找到后，将两个值进行交换
            swap(arr, min, time);

            //System.out.println("经过第" + i + "次循环之后，数组的内容：");
        }
    }

    /*
        比较v元素是否大于w元素
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /*
        数组元素i和j交换位置
     */
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
