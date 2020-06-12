package com.java.z_exam.algorithm.c02_sort.sort_with_design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);

        Collections.sort(list, (v1, v2) -> {
            return v1 - v2;
        });

        System.out.println(list);

    }

}
