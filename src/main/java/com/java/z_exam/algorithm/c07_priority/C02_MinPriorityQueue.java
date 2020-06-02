package com.java.z_exam.algorithm.c07_priority;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-02 9:53
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*

最小优先队列代码

最小优先队列实现起来也比较简单，我们同样也可以基于堆来完成最小优先队列。
我们前面学习堆的时候，堆中存放数据元素的数组要满足都满足如下特性：
    1.最大的元素放在数组的索引1处。
    2.每个结点的数据总是大于等于它的两个子结点的数据。

其实我们之前实现的堆可以把它叫做最大堆，我们可以用相反的思想实现最小堆，让堆中存放数据元素的数组满足
如下特性：
    1.最小的元素放在数组的索引1处。
    2.每个结点的数据总是小于等于它的两个子结点的数据。
这样我们就能快速的访问到堆中最小的数据。
 */
public class C02_MinPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public C02_MinPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //删除堆中最小的元素,并返回这个最小元素
    public T delMin() {
        //索引1处的值是最小值
        T min = items[1];
        //交换索引1处和索引N处的值
        exch(1, N);
        //删除索引N处的值
        items[N] = null;
        //数据元素-1
        N--;
        //对索引1处的值做下沉，使堆重新有序
        sink(1);
        //返回被删除的值
        return min;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        //如果没有父结点，则不再上浮
        while (k > 1) {
            //如果当前结点比父结点小，则交换
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        //如果没有子结点，则不再下沉
        while (2 * k <= N) {
            //找出子结点中的较小值的索引
            int min = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1, 2 * k)) {
                min = 2 * k + 1;
            }

            //如果当前结点小于子结点中的较小值，则结束循环

            if (less(k, min)) {
                break;
            }
            //当前结点大，交换
            exch(min, k);
            k = min;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        C02_MinPriorityQueue<String> minpq = new C02_MinPriorityQueue<>(20);

        for (String s : arr) {
            minpq.insert(s);
        }
        System.out.println(minpq.size());
        String del;
        while (!minpq.isEmpty()) {
            del = minpq.delMin();
            System.out.print(del + ",");
        }
    }

}
