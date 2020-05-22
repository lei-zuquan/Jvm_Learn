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
 * TIM SORT
 * JAVA 对象排序专用
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
 *      java、python对象排序应用非常多，要求稳定
 *      对象排序一般要求稳定
 *      java对象排序使用都是归并排序
 *
 * TimSort（优化后的对象排序，如果面试中回复了此排序，对面试官印象大增）（Arrays.sort(Object) 1440行）
 * TimSort 是改进中的 MergeSort 归并排序（用到了插入排序（二分插入排序），也用到了归并排序）
 *      一下分很多块，两两归并，两两归并
 *
 * 归并排序设计思想：
 *      1、首先将数组分成两半，两个数组已经排好充，首先把数据分成两半；
 *      2、如果两半中没有排好序，再分成两半，直至排好序
 *      3、分配新数组，长度与原数组等长（两个子数组从头开始一一对比，小的放下来，数组下标后移1位）
 *      4、最后，需要判断剩余数未移动下来新数组
 */
public class T_0007_MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,3,6,8,1,7,9,4,2};
        //int[] arr = {1,4,7,8,3,6,9}; // 前期测试尽量使用基数个
        //int[] arr ={2,1};
        //sort(arr, 0, arr.length - 1);
        sort_test(arr, 0, arr.length-1);
        //merge_test(arr, 0, arr.length /2 +1, arr.length-1);

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

    /*
        1、先实现两个已经排好序的数据进行归并
            1，4，7，8，3，6，9
        2、归并前，需要创建新数组与原数组等长
        3、然后两个子数组两两比较大小，较小的放到新数组第一位，下标后移一位
        4、判断左边子数组是否有剩余，有则将剩余有序部分全部移入新数组中
        5、判断右边子数组是否有剩余，有则将剩余有序部分全部移入新数组中
        6、最后将全局排好序的数组存回原来的数组中
     */

    public static void sort_test(int[] arr, int left, int right){
        if (left == right) return;

        int mid = left + (right - left) / 2;

        sort_test(arr, left, mid);

        sort_test(arr, mid+1, right);

        int leftPrt = left;
        int rightPrt = mid + 1;
        merge_test(arr, leftPrt, rightPrt, right);
    }

    public static void merge_test(int[] arr, int leftPrt, int rightPrt, int rightBound){
        int mid = rightPrt - 1;
        int[] newTempArr = new int[rightBound - leftPrt + 1];


        int leftStart = leftPrt;
        int finishIndex = 0;

        while (leftPrt <= mid && rightPrt <= rightBound) { // 没有完成两个有序数据排序
            if (arr[leftPrt] <= arr[rightPrt]) {
                newTempArr[finishIndex++] = arr[leftPrt++];
            } else {
                newTempArr[finishIndex++] = arr[rightPrt++];
            }
        }

        // 判断左边子数组是否有剩余，有则将剩余有序部分全部移入新数组中
        while (leftPrt <= mid) newTempArr[finishIndex++] = arr[leftPrt++];

        // 判断右边子数组是否有剩余，有则将剩余有序部分全部移入新数组中
        while (rightPrt <= rightBound) newTempArr[finishIndex++] = arr[rightPrt++];

        // 最后将全局排好序的数组存回原来的数组中
        for (int i = 0; i < newTempArr.length; i++) {
            arr[i+leftStart] = newTempArr[i];
        }
    }





















}
