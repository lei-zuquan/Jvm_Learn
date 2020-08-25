package com.java.z_exam.algorithm.c02_sort;

/**
 * @Author:
 * @Date: Created in 3:32 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 冒泡排序

/*
  算法步骤
         冒泡：时间复杂度n^2，空间复杂度1，稳定
         基本不用，太慢
         冒泡排序解决了桶排序浪费空间的问题，但在算法的执行效率上却牺牲了很多，它的时间复杂度O(n^2)。
         假如我们的计算机每秒钟可以运行10亿次，那么对1亿个数进行排序，桶排序只需要0.1秒，而冒泡排序则需要1千万秒，达到115天之久。
         那么，有没有一种既不浪费空间又可以快一点的排序算法呢？


     比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     针对所有的元素重复以上的步骤，除了最后一个。
     持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

 */

public class T_0004_BubbleSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        bubbleSort(a);
        print(a);

    }

    /*
       冒泡排序设计思想：
           1、从第一个元素与第二个元素进行比较，如果第一个元素比第二个元素大，则进行交换；
           2、如果第二个元素比第三个元素大，则进行交换，直至与最后一个元素比较完成；完成一轮，完成此轮，则最后一个元素一定是最大的元素
           3、进行第二轮比较，也是从头开始，一直到倒数第二个元素；完成二轮，完成此轮，则倒数第二个元素是第二大的值
           4、如此类推，直至完成所有轮排序
       冒泡排序优化点：
           因为在冒泡过程的同一轮中，没有发现前面大、后面小的情况则证明数组已经排好序。则无需继续进行
       时间复杂度O(n^2)
       空间复杂度O(1)
       稳定性：稳定

       冒泡排序的时间复杂度分析 冒泡排序使用了双层for循环，其中内层循环的循环体是真正完成排序的代码，所以，
        我们分析冒泡排序的时间复杂度，主要分析一下内层循环体的执行次数即可。
        在最坏情况下，也就是假如要排序的元素为{6,5,4,3,2,1}逆序，那么：
        元素比较的次数为：
         (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
        元素交换的次数为：
         (N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
        总执行次数为：
         (N^2/2-N/2)+(N^2/2-N/2)=N^2-N;
        按照大O推导法则，保留函数中的最高阶项那么最终冒泡排序的时间复杂度为O(N^2).
    */
    public static void bubbleSort(int[] arr) {
        for (int time = 0; time < arr.length; time++) {
            boolean isFinished = true;
            for (int i = 0; i < arr.length - 1 - time; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isFinished = false;
                }
            }
            if (isFinished) {
                break;
            }
            //print(arr);
            //System.out.println("\t\t第" + (time + 1) + "次");
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
