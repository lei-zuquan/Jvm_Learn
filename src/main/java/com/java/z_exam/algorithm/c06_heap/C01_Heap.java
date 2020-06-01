package com.java.z_exam.algorithm.c06_heap;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-01 14:27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
1.1 堆的定义
堆是计算机科学中一类特殊的数据结构的统称，堆通常可以被看做是一棵完全二叉树的数组对象。

堆的特性：
     1.它是完全二叉树，除了树的最后一层结点不需要是满的，其它的每一层从左到右都是满的，如果最后一层结点不是满的，那么要求左满右不满。
     2.它通常用数组来实现。
        具体方法就是将二叉树的结点按照层级顺序放入数组中，根结点在位置1，它的子结点在位置2和3，而子结点的子
        结点则分别在位置4,5,6和7，以此类推。
             如果一个结点的位置为k，则它的父结点的位置为[k/2],而它的两个子结点的位置则分别为2k和2k+1。这样，在不
        使用指针的情况下，我们也可以通过计算数组的索引在树中上下移动：从a[k]向上一层，就令k等于k/2,向下一层就
        令k等于2k或2k+1。
     3.每个结点都大于等于它的两个子结点。这里要注意堆中仅仅规定了每个结点大于等于它的两个子结点，但这两个
        子结点的顺序并没有做规定，跟我们之前学习的二叉查找树是有区别的。



 */
public class C01_Heap<T extends Comparable<T>> {

    // 用来存储元素的数组
    private T[] items;

    // 记录堆中元素的个数
    private int N;

    public C01_Heap(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    // 交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 删除堆中最大的元素,并返回这个最大元素
    /*
            1.4.2 delMax删除最大元素方法的实现
        由堆的特性我们可以知道，索引1处的元素，也就是根结点就是最大的元素，当我们把根结点的元素删除后，需要
        有一个新的根结点出现，这时我们可以暂时把堆中最后一个元素放到索引1处，充当根结点，但是它有可能不满足
        堆的有序性需求，这个时候我们就需要通过一些方法，让这个新的根结点放入到合适的位置。

            所以，当删除掉最大元素后，只需要将最后一个元素放到索引1处，并不断的拿着当前结点a[k]与它的子结点a[2k]
        和a[2k+1]中的较大者交换位置，即可完成堆的有序调整。
     */
    public T delMax() {
        T max = items[1];
        // 交换索引1处和索引N处的值
        exch(1, N);
        // 删除最后位置上的元素
        items[N] = null;
        // 个数-1
        N--;
        sink(1);
        return max;
    }

    // 往堆中插入一个元素
    /*
    1.4.1 insert插入方法的实现
        堆是用数组完成数据元素的存储的，由于数组的底层是一串连续的内存地址，所以我们要往堆中插入数据，我们只
        能往数组中从索引0处开始，依次往后存放数据，但是堆中对元素的顺序是有要求的，每一个结点的数据要大于等
        于它的两个子结点的数据，所以每次插入一个元素，都会使得堆中的数据顺序变乱，这个时候我们就需要通过一些
        方法让刚才插入的这个数据放入到合适的位置。

        所以，如果往堆中新插入元素，我们只需要不断的比较新结点a[k]和它的父结点a[k/2]的大小，然后根据结果完成
        数据元素的交换，就可以完成堆的有序调整。
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    // 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        //如果已经到了根结点，就不需要循环了
        while (k > 1) {
            //比较当前结点和其父结点
            if (less(k / 2, k)) {
                //父结点小于当前结点，需要交换
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    // 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        //如果当前已经是最底层了，就不需要循环了 
        while (2 * k <= N) {
            //找到子结点中的较大者 
            int max;
            if (2 * k + 1 <= N) {
                //存在右子结点 
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                //不存在右子结点 
                max = 2 * k;
            }
            //比较当前结点和子结点中的较大者，如果当前结点不小，则结束循环
            if (!less(k, max)) {
                break;
            }
            //当前结点小，则交换，
            exch(k, max);
            k = max;
        }
    }


    public static void main(String[] args) {
        C01_Heap<String> heap = new C01_Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }
    }


}
