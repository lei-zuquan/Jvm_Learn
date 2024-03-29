package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author:
 * @Date: Created in 7:25 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T01_Sorter {
    public static void sort(int[] arr) {

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
}
