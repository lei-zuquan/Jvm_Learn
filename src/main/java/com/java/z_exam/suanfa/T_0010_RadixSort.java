package com.java.z_exam.suanfa;

import java.util.Arrays;
import java.util.SortedMap;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:04 下午 2020/5/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 基数排序
 * 非比较排序
 * 桶思想的一种
 * 多关键字排序
 * 时间复杂度O(N)
 * 空间复杂度O(k*N)
 * 稳定排序
 *
 * 总结：
 *      本质上是一种多关键字排序
 *      有低位优先和高位优先两种
 *          LSD MDS (Least Significant Digit first) (Most...)
 *          MSD属于分治的思想
 *      百度百科的程序有问题
 *          空间复杂度变高
 *
 */
public class T_0010_RadixSort {
    public static void main(String[] args) {
        int[] arr = {421,240,115,532,305,430,124};

        int [] result = sort(arr);
        // 第一步，应该先求最高位数

        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];


        for (int i = 0; i < 3; i++) {
            int division = (int)Math.pow(10, i);
            System.out.println(division);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j]/division % 10;

                System.out.println(num + " ");

                count[num]++;
            }
            System.out.println();
            System.out.println(Arrays.toString(result));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m-1];
            }

            System.out.println(Arrays.toString(result));

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }

        return result;
    }
}
