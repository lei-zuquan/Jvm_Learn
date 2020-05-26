package com.java.z_exam.algorithm.sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:27 上午 2020/5/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    选择排序

    选择：时间复杂度n^2，空间复杂度1，不稳定
        基本不用，不稳，最简单但是最没用的排序算法，也有优化空间

    选择排序的思想
        第一次从待排序的数据中选出最小的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小元素，
        然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。


 */
public class T_0002_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
        //int[] arr = {5,8,5,2,9};
        selectSort(arr);

        print(arr);
    }

    /*
      选择排序思想：
      从数据中遍历，选择最小的一个数出来，与第一个元素进行交换；完成一次
      再从剩余数组中，选择最小的一个数出来，与第一个元素进行交换；完成二次
      如此类推，直至完成数组排序

      数据比较次数：
        (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
      数据交换次数：
        N-1
      时间复杂度：N^2/2-N/2+（N-1）=N^2/2+N/2-1;
        根据大O推导法则，保留最高阶项，去除常数因子，时间复杂度为O(N^2)

      时间复杂度 O(n^2)
      空间复杂度 O(1)
      稳定性：不稳
     */
    public static void selectSort(int[] arr) {

        for (int time = 0; time < arr.length - 1; time++) {
            int min = time; // 取当前剩下数组第一个元素下标为最小下标
            for (int i = time + 1; i < arr.length; i++) {
                // 找到比当前元素值更小的下标，从当前数组序列头开始一直到结尾
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }

            //System.out.println("minPos: " + minPos);
            // 找到后，将两个值进行交换
            swap(arr, min, time);

            //System.out.println("经过第" + i + "次循环之后，数组的内容：");
        }

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
