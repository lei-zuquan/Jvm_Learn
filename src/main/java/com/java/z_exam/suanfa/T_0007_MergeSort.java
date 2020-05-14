package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:21 下午 2020/5/8
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 归并排序
 * （前提是知道 两个数据已经排好序，使用递归方法）
 *
 * 重新分配与原空间等长
 *
 * 整个数组分成2半
 * 两个排好序的子数组【】 【】
 * 分成两半
 *
 * 归并时间复杂度：
 *      (N * logN)
 *
 * 空间复杂度：
 *      O(n)
 *
 * 应用场景：
 *      对象排序一般要求稳定
 *      java对象排序使用都是归并排序
 *
 * TimSort（优化后的对象排序，如果面试中回复了此排序，对面试官印象大增）
 *      一下分很多块，两两归并，两两归并
 */
public class T_0007_MergeSort {
    public static void main(String[] args) {
        // int[] arr = {5,3,6,8,1,7,9,4,2};
        int[] arr = {1,4,7,8,3,6,9}; // 前期测试尽量使用基数个
        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    // 递归写法
    public static void sort(int[] arr, int left, int right){
        if (left == right) return;

        // 分成两半
        int mid = left + (right - left) / 2; // (left + right) / 2 // right + left 可能会越界
        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid+1, right);

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
