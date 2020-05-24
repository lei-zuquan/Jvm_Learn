package com.java.z_exam.suanfa;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:38 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
    希尔排序
    改进的插入排序（基于插入排序上，做了分段间隔插入；再将分段间隔缩小再进行排序，直至分段间隔缩小为1）

    时间复杂度：O(n^1.3)
    空间复杂度：O(1)

    经过一定的间隔，比如中间4个间隔，使用插入排序；然后间隔序列后移一位，再次使用插入排序；直至最后一位；
    缩小间隔，再排一遍。比如为2再排一遍；
    最后以间隔为1再排一遍；

    好处：在数组长度较大时，数据移动次数较少；在数组长度较小时，数据移动距离较短。
    但因希尔排序因为跳着排，所以不稳定

 */

public class T_0006_ShellSort {
    public static void main(String[] args) {
        int[] a = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        //sort(a);
        /*shellSort2(a);
        print(a);*/

        compareRunTime();
    }

    public static void compareRunTime() {
        for (int times = 0; times < 10; times++) {
            int[] arr = generateRandomArray();
            int[] arr2 = new int[arr.length];
            int[] arr3 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            System.arraycopy(arr, 0, arr3, 0, arr.length);

            // 算法开始时间
            long before = 0;
            long after = 0;
            before = System.currentTimeMillis();
            Arrays.sort(arr);
            after = System.currentTimeMillis();
            //System.err.print("Arrays.sort(arr) time:" + (after - before));

            before = System.currentTimeMillis();
            T_0006_ShellSort.shellSortLower(arr2);
            after = System.currentTimeMillis();
            //System.err.print("\t\tshellSort arr.length/2 time:" + (after - before));

            before = System.currentTimeMillis();
            T_0006_ShellSort.shellSort(arr3);
            after = System.currentTimeMillis();
            //System.err.println("\t\tshellSort Knuth序列 time:" + (after - before));
        }
    }


    /*
        示例：
        第一轮：间隔为4插入排序
        [9],6,11,3,[5],12,8,7,[10],15,14,4,[1],13,2
        [1],6,11,3,[5],12,8,7,[9],15,14,4,[10],13,2

        1,[6],11,3,5,[12],8,7,9,[15],14,4,10,[13],2
        1,[6],11,3,5,[12],8,7,9,[13],14,4,10,[15],2

        1,6,[11],3,5,12,[8],7,9,13,[14],4,10,15,[2]
        1,6,[2],3,5,12,[8],7,9,13,[11],4,10,15,[14]

        第二轮：间隔为2插入排序
        [1],6,[2],3,[5],12,[8],7,[9],13,[11],4,[10],15,[14]
        [1],6,[2],3,[5],12,[8],7,[9],13,[10],4,[11],15,[14]

        1,[6],2,[3],5,[12],8,[7],9,[13],10,[4],11,[15],14
        1,[3],2,[6],5,[4],8,[7],9,[12],10,[13],11,[15],14

        1,3,[2],6,[5],4,[8],7,[9],12,[10],13,[11],15,[14]
        1,3,[2],6,[5],4,[8],7,[9],12,[10],13,[11],15,[14]

        第三轮：间隔为1插入排序
     */
    public static void shellSort(int[] arr) {
        // Knuth序列
        // h = 1
        // h = 3*h + 1
        int h = 1;
        while (h <= arr.length / 3) {
            h = h*3 + 1;
        }

        // 先考虑间隔固定的情况
        int processTimes = 0;
        //int gap = 4;
        for (int gap = h; gap > 0 ; gap = (gap-1)/3) { // 数组长度除以2这种效率不是最好

            for (int time = gap; time < arr.length; time++) {
                for (int i = time; i >= gap; i-=gap) {
                    if (arr[i] < arr[i - gap]) {
                        swap(arr, i, i - gap);
                        processTimes++;
                    }
                }

                //print(arr);
                //System.out.println("第" + (time + 1) + "次");
            }
        }
        System.out.println("shellSort gap = Knuth序列： processTimes:" + processTimes);
    }

    public static void shellSortLower (int[] arr){
        int processTimes = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j-= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                        processTimes++;
                    }
                }
            }
        }
        System.out.println("shellSort gap = arr/2： processTimes:" + processTimes);
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

    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }

        return arr;
    }
}
