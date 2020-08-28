package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:25 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 排序类中，将比较器作为参数传入，按照比较器策略来进行大小比较
public class T05_Sorter<T> {
    public void sort(T[] arr, T05_Comparator comparator) {

        for (int time = 0; time < arr.length - 1; time++) {
            int min = time; // 取当前剩下数组第一个元素下标为最小下标
            for (int i = time + 1; i < arr.length; i++) {
                // 找到比当前元素值更小的下标，从当前数组序列头开始一直到结尾
                min = comparator.compare(arr[i], arr[min]) == -1 ? i : min;
            }

            //System.out.println("minPos: " + minPos);
            // 找到后，将两个值进行交换
            swap(arr, min, time);

            //System.out.println("经过第" + i + "次循环之后，数组的内容：");
        }
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
