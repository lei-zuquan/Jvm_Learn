package com.java.z_exam.algorithm.c06_heap;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-02 8:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给定一个数组：
     String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"}
    请对数组中的字符按从小到大排序。
实现步骤：
    1.构造堆；
    2.得到堆顶元素，这个值就是最大值；
    3.交换堆顶元素和数组中的最后一个元素，此时所有元素中的最大元素已经放到合适的位置；
    4.对堆进行调整，重新让除了最后一个元素的剩余元素中的最大值放到堆顶；
    5.重复2~4这个步骤，直到堆中剩一个元素为止。
 */
public class C03_HeapSort<T extends Comparable<T>> {

    // 对source数组中的数据从小到大排序
    /*
    堆排序过程
        对构造好的堆，我们只需要做类似于堆的删除操作，就可以完成排序。
        1.将堆顶元素和堆中最后一个元素交换位置；
        2.通过对堆顶元素下沉调整堆，把最大的元素放到堆顶(此时最后一个元素不参与堆的调整，因为最大的数据已经到了数组的最右边)
        3.重复1~2步骤，直到堆中剩最后一个元素。
     */
    public static void sort(Comparable[] source) {
        // 1、创建一个比原数组大1的数组
        Comparable[] heap = new Comparable[source.length + 1];
        // 2、构造堆
        createHeap(source, heap);
        // 3、堆排序

        // 3.1 定义一个变量，记录heap中未排序的所有元素中最大的索引
        int N = heap.length - 1;
        while (N != 1) {
            // 3.2 交换heap中索引1处的元素和N处的元素
            exch(heap, 1, N);
            N--;
            // 3.3 对索引1处的元素在0~N范围内做下沉操作
            sink(heap, 1, N);
        }

        // 4.heap中的数据已经有序，拷贝到source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    // 根据原数组source，构造出堆heap
    /*
        堆构造过程
            堆的构造，最直观的想法就是另外再创建一个和新数组数组，然后从左往右遍历原数组，每得到一个元素后，添加
            到新数组中，并通过上浮，对堆进行调整，最后新的数组就是一个堆。
            上述的方式虽然很直观，也很简单，但是我们可以用更聪明一点的办法完成它。创建一个新数组，把原数组
            0~length-1的数据拷贝到新数组的1~length处，再从新数组长度的一半处开始往1索引处扫描（从右往左），然后
            对扫描到的每一个元素做下沉调整即可。
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 1.把source中的数据拷贝到heap中，从heap的1索引处开始填充
        System.arraycopy(source, 0, heap, 1, source.length);

        // 2.从heap索引的一半处开始倒序遍历，对得到的每一个元素做下沉操作
        for (int i = (heap.length - 1) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    // 判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    // 交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 在heap堆中，对target处的元素做下沉，范围是0~range。
    private static void sink(Comparable[] heap, int target, int range) {
        // 没有子结点了
        while (2 * target <= range) {
            // 1.找出target结点的两个子结点中的较大值
            int max = 2 * target;
            if (2 * target + 1 <= range) {
                // 存在右子结点
                if (less(heap, target * 2, target * 2 + 1)) {
                    max = target * 2 + 1;
                }
            }

            // 2.如果当前结点的值小于子结点中的较大值，则交换
            if (less(heap, target, max)) {
                exch(heap, target, max);
            }

            // 3.更新target的值
            target = max;

        }
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        C03_HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
