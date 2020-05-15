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
 *      最好的情况：发生在整个数组被分成两段长度相等的子数组时，递推式如下：4,1,3,2,6,5,7
 *                  O(1)   n=1
 *          T(n) =  2T(n/2) + O(n)  n>1
 *      T(n) = O(N * logN) 【最优】
 *
 *      最坏的情况：待排序的序列为正序或者逆序，每次划分只得到一个比上一次划分少一个记录的子序列：1,2,3,4
 *                  O(1)   n=1
 *          T(n) =  T(n-1) + O(n)  n>1
 *      T(n) = O( N^2) 【最差】避免最差，先判断是否已经排好序；随机取一个数，放到数组最后，再进行快排
 *
 *      平均时间复杂度：T(n)=O(nlog^n)，快速排序是一种不稳定的排序算法
 *
 * 空间复杂度：
 *      O(log2N)
 *
 *
 *
 * 快速排序核心思想：
 *      每次都取数组的第一个元素作为基准元素，凡是大于这个基准元素的都放在它的右边，凡是小于这个基准元素的都放在它的左边，具体步骤如下：
 *          1、设置两个变量i 和 j（也称为哨兵），令序列第一个元素为基准元素。
 *          2、i 指向序列的最左边，j 指向序列的最右边，j从右往左试探，i从左往右试探，直到j找到小于基准的数就停止，i 找到大小基准的数就停止，
 *              交换i 和 j 指向的两个数， j继续住左试探，i继续往右试探
 *          3、如果i 与 j相遇，则i 或 j上的元素与基准元素交换，则这一轮排序结束。
 *          对基准元素两边的序列重复以上操作。
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

        // 继续处理左边的序列
        sort(arr, leftBound, mid -1);
        // 继续处理右边的序列
        sort(arr, mid+1, rightBound);
    }

    // 分区
    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound]; // pivot 存放基准数
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left ++;
            while (left <= right && arr[right] > pivot) right --;

            //System.out.println("before swap: left ->" + left + " right->" + right);

            // 当left、right没有相遇时，交换两个数在数组中的位置
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
