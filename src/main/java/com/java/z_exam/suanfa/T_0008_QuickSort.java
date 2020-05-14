package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:06 下午 2020/5/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 快速排序
 *
 * 时间复杂度：
 *      O(N * logN) 【最优】
 *      O( N * N) 【最差】避免最差，先判断是否已经排好序；随机取一个数，放到数组最后，再进行快排
 *
 * 空间复杂度：
 *      O(log2N)
 *
 *
 *
 * 实现思想：
 *
 * bug问题查找思路：
 *      1、通读程序
 *      2、输出中间值
 *      3、剪功能（缩小定位）
 *
 */
public class T_0008_QuickSort {
    public static void main(String[] args) {
        //int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6};
        //int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6, 0}; // 越界
        //int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6, 10}; // 越界
        //int[] arr = {7, 3, 2, 6, 8, 1, 9, 5, 4, 6, 10, 6}; //
        int[] arr = {7, 3, 2, 10, 8, 1, 9, 5, 4, 6}; //
        //int[] arr = {4, 6};

        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    // leftBound 左边位置，rightBound 右边位置
    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;

        int mid = partition(arr, leftBound, rightBound);

        sort(arr, leftBound, mid -1);
        sort(arr, mid+1, rightBound);
    }

    // 分区
    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left ++;
            while (left <= right && arr[right] > pivot) right --;

            //System.out.println("before swap: left ->" + left + " right->" + right);

            if (left < right) swap(arr, left, right);

            //System.out.print("--");
            //print(arr);
            //System.out.println();
        }

        // 将分界点移动到需要的位置上
        swap(arr, left, rightBound);

        return left;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
