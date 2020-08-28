package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author:
 * @Date: Created in 7:25 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T02_Sorter {
    public static void sort(T02_Cat[] arr) {

        for (int time = 0; time < arr.length - 1; time++) {
            int min = time; // 取当前剩下数组第一个元素下标为最小下标
            for (int i = time + 1; i < arr.length; i++) {
                // 找到比当前元素值更小的下标，从当前数组序列头开始一直到结尾
                min = arr[i].compareTo(arr[min]) == -1 ? i : min;
            }

            //System.out.println("minPos: " + minPos);
            // 找到后，将两个值进行交换
            swap(arr, min, time);

            //System.out.println("经过第" + i + "次循环之后，数组的内容：");
        }

    }

    private static void swap(T02_Cat[] arr, int i, int j){
        T02_Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
