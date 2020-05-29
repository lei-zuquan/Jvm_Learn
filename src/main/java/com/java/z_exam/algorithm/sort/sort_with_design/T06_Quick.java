package com.java.z_exam.algorithm.sort.sort_with_design;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-29 12:47
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
快速排序
    快速排序是对冒泡排序的一种改进。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一
    部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序
    过程可以递归进行，以此达到整个数据变成有序序列。
需求：
    排序前:{6, 1, 2, 7, 9, 3, 4, 5, 8}
    排序后:{1, 2, 3, 4, 5, 6, 7, 8, 9}
排序原理：
    1.首先设定一个分界值，通过该分界值将数组分成左右两部分；
    2.将大于或等于分界值的数据放到到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值；
    3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两
        部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
    4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当
        左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成了。

类名 Quick
构造方法 Quick()：创建Quick对象
成员方法
    1.public static void sort(Comparable[] a)：对数组内的元素进行排序
    2.private static void sort(Comparable[] a, int lo, int hi)：对数组a中从索引lo到索引hi之间的元素进行排序
    3.public static int partition(Comparable[] a,int lo,int hi):对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
    4.private static boolean less(Comparable v,Comparable w):判断v是否小于w
    5.private static void exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值

切分原理：
把一个数组切分成两个子数组的基本思想：
    1.找一个基准值，用两个指针分别指向数组的头部和尾部；
    2.先从尾部向头部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置；
    3.再从头部向尾部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置；
    4.交换当前左边指针位置和右边指针位置的元素；
    5.重复2,3,4步骤，直到左边指针的值大于右边指针的值停止。

 */
public class T06_Quick {
    public static void main(String[] args) {

    }


}
