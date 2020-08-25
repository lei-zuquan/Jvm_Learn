package com.java.z_exam.algorithm.c02_sort;

import java.util.Arrays;

/**
 * @Author:
 * @Date: Created in 10:04 下午 2020/5/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
  基数排序
  非比较排序
  桶思想的一种
  多关键字排序
  时间复杂度 O( N*k)
  空间复杂度 O(N + k)
  稳定排序

  设计思想：
        基数排序属于高级的排序方法，该排序算法是在“桶排序”的基础上所进行的改进


  总结：
       本质上是一种多关键字排序
       有低位优先和高位优先两种
           LSD MDS (Least Significant Digit first) (Most...)
           MSD属于分治的思想
       百度百科的程序有问题
           空间复杂度变高

 */
/*
421,240,115,532,305,430,124
对个位数按桶进行分类，排序
240,430,421,532,124,115,305
对十位数按桶进行分类，排序
305,115,421,124,430,532,240
对百位数按桶进行分类，排序
115,124,240,305,421,430,532
 */
public class T_0010_RadixSort {
    public static void main(String[] args) {
        int[] arr = {421,240,115,532,305,430,124};

        int[] result = radixSort(arr);
        // 第一步，应该先求最高位数

        System.out.println(Arrays.toString(result));
    }
    
    public static int[] radixSort(int[] arr) {
        int[] result = new int[arr.length];

        int[] count = new int[10]; // 0~9 十个数

        for (int time = 0; time < 3; time++) {

            int pow = (int) Math.pow(10, time);

            for (int i = 0; i < arr.length; i++) {
                // 将个数取出来，对个数位进行桶计数
                int mod = arr[i] / pow % 10;
                count[mod]++;
            }

            // 累加数组，数组值对应排序后下标值+1
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 遍历原数组421,240,115,532,305,430,124
            for (int i = arr.length - 1; i >= 0; i--) {
                // 将个数取出来，对个数位进行桶计数
                int mod = arr[i] / pow % 10;
                result[--count[mod]] = arr[i];
            }

            System.out.println("第" + time + " 次基数排序：" + Arrays.toString(count));


            // 将排序好的数组，还原回arr，继续下一位排序
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 清空count计数数组
            Arrays.fill(count, 0);
            System.out.println("第" + time + " 次数组后排序：" + Arrays.toString(arr));
        }


        return result;
    }
}
