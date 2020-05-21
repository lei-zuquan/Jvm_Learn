package com.java.z_exam.suanfa;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:14 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 * 插入排序
 * 时间复杂度n^2，空间复杂度1，稳定
 *
 * 对于基本有序的数组最好用
 * 稳定
 *
 * 插入排序比冒泡排序快一倍
 */

/*
插入排序示例：
9 6 1 3 5
6 9 1 3 5
----------
6 9 1 3 5
6 1 9 3 5
1 6 9 3 5
---------
1 6 9 3 5
1 6 3 9 5
1 3 6 9 5
1 3 6 9 5
---------
1 3 6 9 5
1 3 6 5 9
1 3 5 6 9
1 3 5 6 9

 */
public class T_0005_InsertionSort {
    public static void main(String[] args) {
        //int[] a ={9,3,1,4,6,8,7,5,2};
        //sort(a);
        int[] a = {9, 6, 1, 3, 5};
        insertionSort(a);
        print(a);
    }


    /*
        插入排序设计思想：
            1、对前面有序的数组进行插入式，即插入到合适的位置
                具体流程：
                    a.对数组第二个元素与第一个元素比较，进行插入排序；
                    b.对数组第3个元素向前2个已经排好序进行插入排序
                    c.如此类推 for (int i = time; i > 0; i--) { 比较大小判断，如果满足条件进行交换 }

        时间复杂度O(n^2)
        空间复杂度O(1)
        稳定性：稳定
     */
    public static void insertionSort(int[] arr) {
        for (int time = 1; time < arr.length; time++) {
            for (int i = time; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }

            print(arr);
            System.out.println("第" + (time + 1) + "次");
        }

    }


    public static void sort (int[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && (a[j] < a[j-1]); j--) {
                //if (a[j] < a[j-1]){
                swap(a, j, j - 1);
                print(a);
                System.out.println("第" + j + "次");
                //}
            }
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
