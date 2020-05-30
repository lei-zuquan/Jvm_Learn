package com.java.z_exam.algorithm.c02_sort.sort_with_design;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-29 10:42
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 归并排序
    归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法的一个非常典型的应用。将已有序的子
    序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序
    表，称为二路归并。
需求：
    排序前：{8,4,5,7,1,3,6,2}
    排序后：{1,2,3,4,5,6,7,8}
排序原理：
     1.尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
     2.将相邻的两个子组进行合并成一个有序的大组；
     3.不断的重复步骤2，直到最终只有一个组为止。

类名 Merge
构造方法
    Merge()：创建Merge对象
成员方法
    1.public static void sort(Comparable[] a)：对数组内的元素进行排序
    2.private static void sort(Comparable[] a, int lo, int hi)：对数组a中从索引lo到索引hi之间的元素进行排序
    3.private static void merge(Comparable[] a, int lo, int mid, int hi):从索引lo到所以mid为一个子
    组，从索引mid+1到索引hi为另一个子组，把数组a中的这两个子组的数据合并成一个有序的大组（从索引lo到索引hi）
    4.private static boolean less(Comparable v,Comparable w):判断v是否小于w
    5.private static void exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值
成员变量
    1.private static Comparable[] assist：完成归并操作需要的辅助数组
 */
public class T05_Merge {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 2, 4, 8, 9};
        //Integer[] arr = {1, 2, -1, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static Comparable[] assist;//归并所需要的辅助数组

    /* 对数组a中的元素进行排序 */
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    /* 对数组a中的元素进行排序 */
    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        //对lo到mid之间的元素进行排序；
        // 排左边
        sort(arr, 0, mid);
        //对mid+1到hi之间的元素进行排序
        // 排右边
        sort(arr, mid + 1, right);

        //对lo到mid这组数据和mid到hi这组数据进行归并
        merge(arr, left, mid, right);
    }

    /*对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并 */
    public static void merge(Comparable[] arr, int leftPtr, int mid, int rightBound) {

        //Comparable[] assist = new Comparable[rightBound - leftPtr + 1];
        //int mid = rightPtr;
        int left = leftPtr;
        int right = mid + 1;
        int finishIndex = leftPtr;

        //比较左边小组和右边小组中的元素大小，哪个小，就把哪个数据填充到assist数组中
        while (left <= mid && right <= rightBound) {

            if (less(arr[left], arr[right])) {
                assist[finishIndex++] = arr[left++];
            } else {
                assist[finishIndex++] = arr[right++];
            }
        }

        //上面的循环结束后，如果退出循环的条件是p1<=mid，则证明左边小组中的数据已经归并完毕，如果退 出循环的条件是p2<=hi,则证明右边小组的数据已经填充完毕；
        // 所以需要把未填充完毕的数据继续填充到assist中,
        // 下面两个循环，只会执行其中的一个
        while (left <= mid) assist[finishIndex++] = arr[left++];
        while (right <= rightBound) assist[finishIndex++] = arr[right++];

        //到现在为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引处
        for (int i = leftPtr; i <= rightBound; i++) {
            arr[i] = assist[i];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


}
