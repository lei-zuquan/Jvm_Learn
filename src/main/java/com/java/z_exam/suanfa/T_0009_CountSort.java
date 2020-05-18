package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:19 下午 2020/5/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.Arrays;

/**
 * 计数排序
 * 桶思想的一种
 *
 * 最大但是范围小
 *      某大型企业数万名员工年龄排序
 *      如何快速得知高考名次（腾讯面试）
 * 总结
 *      计数排序是非比较排序
 *      适用于特定问题，也就是对源数据有要求
 *      时间复杂度：N
 *      空间复杂度：N+K
 */
public class T_0009_CountSort {
    public static void main(String[] args) {
        int[] arr = {2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};

        int[] result = sort(arr);

        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr){
        int[] result = new int[arr.length]; // 分配新数组，与原数组等长

        int[] count = new int[10]; // 原数组元素数值范围个数

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        System.out.println(Arrays.toString(count));
/* 因为不稳定
        for (int i = 0, j=0; i < count.length; i++) {
            while (count[i]-- > 0) result[j++] = i;
        }*/

        // 因为上述方式不够稳定，升级为累加数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        System.out.println(Arrays.toString(count));

        for (int i = arr.length-1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }

        return result;
    }

    static void findMax(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] > a[i+1]) swap(a, i, i+1);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
