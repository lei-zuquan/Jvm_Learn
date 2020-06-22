package com.java.z_exam.algorithm.c02_sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:21 下午 2020/5/8
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
  归并排序
  TIM SORT
  JAVA 对象排序专用
  （前提是知道 两个数据已经排好序，使用递归方法）

  重新分配与原空间等长

  整个数组分成2半
  两个排好序的子数组【】 【】
  分成两半

  归并时间复杂度：
       O(N * logN)

  空间复杂度：
       O(n)

  稳定性：稳定

  应用场景：
       java、python对象排序应用非常多，要求稳定
       对象排序一般要求稳定
       java对象排序使用都是归并排序

  TimSort（优化后的对象排序，如果面试中回复了此排序，对面试官印象大增）（Arrays.sort(Object) 1440行）
  TimSort 是改进中的 MergeSort 归并排序（用到了插入排序（二分插入排序），也用到了归并排序）
       一下分很多块，两两归并，两两归并

  归并排序设计思想：
       1、首先将数组分成两半，两个数组已经排好序，首先把数据分成两半；
       2、如果两半中没有排好序，再分成两半，直至排好序
       3、分配新数组，长度与原数组等长（两个子数组从头开始一一对比，小的放下来，数组下标后移1位）
       4、最后，需要判断剩余数未移动下来新数组
 */
public class T_0007_MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,3,6,8,1,7,9,4,2};

        mergeSort(arr, 0, arr.length - 1);

        print(arr);
    }

    // 递归写法
    public static void mergeSort(int[] arr, int left, int right){
        if (left == right) return;

        // 分成两半
        int mid = left + (right - left) / 2; // (left + right) / 2 // right + left 可能会越界
        // 左边排序
        mergeSort(arr, left, mid);
        // 右边排序
        mergeSort(arr, mid+1, right);

        // 最后将左右两边合并
        merge(arr, left, mid + 1, right);
    }

    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound){
            try {
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            } catch (ArrayIndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        }

        // 如果是左半节数组有遗留，将左半节数组进行移动
        while(i <= mid) temp[k++] = arr[i++];
        // 如果是右半节数组有遗留，将左半节数组进行移动
        while(j <= rightBound) temp[k++] = arr[j++];

        // print(temp);
        // 最后将排好序的数组，赋值给回arr
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }



}
