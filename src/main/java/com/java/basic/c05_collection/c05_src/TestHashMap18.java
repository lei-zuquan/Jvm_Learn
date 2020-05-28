package com.java.basic.c05_collection.c05_src;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:42 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * day22_10源码分析：JDK1.8的HashMap
 *
 * JDK1.8的HashMap：底层实现（数组 + 链表/ 红黑树）
 *
 * 红黑树是一种特殊的二叉树，是一棵自平衡的二叉树，自动调整左右节点的个数，尽量保证两边是均匀
 *
 * 1、为什么要从JDK1.8之前链表设计，修改为链表或红黑树的设计？
 *      当某个链表比较长的时候，查找效康还是会降低。
 *      为了提高查询效率，那么把table[index]下面的链表微调整。
 *      如果table[index]的链表的节点的个数比较少，（8个或以内），就保持链表。如果超过8个，那么就要考虑把链表转为一棵红黑树
 *      TREEIFY_THRESHOLD : 树化阈值，从链表转为红黑树的临界值。
 *
 * 2、什么时候树化？
 *      table[index]下的结点数一达到8个就树化吗？
 *      如果table[index] 的节点数量已经达到8个了，还要判断table.length是否达到64，如果没有达到64，先扩容。
 *
 *      演示：8个 -> 9个 length 从 16  -> 32
 *           9个 -> 10个 length 从 32  -> 64
 *           10个 -> 11个 length已经达到64，table[index] 就从Node类型转为TreeNode类型，说明树化
 *      MIN_TREEIFY_CAPACITY：最小树化容量。
 *
 * 3、什么时候从树 -> 链表
 *      当你删除结点时，这棵树的结点个数少于6个，会反树化，变为链表
 *      UNTREEIFY_THRESHOLD：6个
 *
 *      树的结构太复杂，当结点少了之后，就用链表更好。
 *
 * 4、put的过程
 *      1）[index]的计算问题
 *      第一步用key的hashCode值调用hash()函数，干扰hash值，使得(key,value)更加均匀的分布table数组中。
 *          JDK1.8 中hash()算法更优化。
 *
 *      第二步：hash值与table.length-1做&运算，保证index在[0, length - 1]范围内
 *
 *      2）扩容问题
 *      第一种：当某个table[index]的链表的个数达到8个，并且table.length<64，那么会扩容
 *      第二种：size >= threshold，并且table[index] != null
 *          threshold = table.length * loadFator (它的默认值 DEFAULT_LOAD_FACTOR = 0.75f)
 *
 *      3）当把（key, value）添加到链表中，JDK1.8是在链表的尾部
 *      成语：七上八下
 */
public class TestHashMap18 {

    public static void main(String[] args) {
        String[] titleWordArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        final String[] kuWordArr = generateRandomArray(1000000);

        // 算法开始时间
        long before = 0;
        long after = 0;
        long spend = 0;

        int times;
        times = 0;
        before = System.currentTimeMillis();
        List<String> findResult = new ArrayList<>();
        for (int i = 0; i < titleWordArr.length; i++) {
            for (int j = 0; j < kuWordArr.length; j++) {
                if (titleWordArr[i].equals(kuWordArr[j])) {
                    findResult.add(titleWordArr[i]);
                }
                times++;
            }
        }
        after = System.currentTimeMillis();
        spend = after - before;
        System.out.println("传统方式：" + times + " 匹配次数, 耗时：" + spend + " 毫秒");
        System.out.println(findResult.toString());

        System.out.println("--------------------------------------------------------------");

        // 将kuWordArr，存入HashMap
        before = System.currentTimeMillis();
        HashMap<String, String> hashMap = new HashMap();
        for (int j = 0; j < kuWordArr.length; j++) {
            hashMap.put(kuWordArr[j], kuWordArr[j]);
        }

        times = 0;
        findResult.clear();

        for (int i = 0; i < titleWordArr.length; i++) {
            findResult.add(hashMap.get(titleWordArr[i]));
            times++;
        }
        after = System.currentTimeMillis();
        spend = after - before;
        System.out.println("HashMap方式：" + times + " 匹配次数, 耗时：" + spend + " 毫秒");
        System.out.println(findResult.toString());

        System.out.println("--------------------------------------------------------------");


    }

    static String[] generateRandomArray(int size) {
        Random r = new Random();
        String[] arr = new String[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(size) + "";
        }

        return arr;
    }

    @Test
    public void test1() {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 20; i++) {
            hashMap.put(new MyData(i), "xx" + i);
        }
    }
}


class MyData{
    private int num;

    public MyData(int num) {
        super();
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "num=" + num +
                '}';
    }

    // 特殊的设计
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return num == myData.num;
    }

    @Override
    public int hashCode() {
       /* final int prime = 31;
        int result = 1;
        result = prime * result + num;
        return result; */
       return 1; // 所有MyData的对象，hashCode值都是1，这里故意这样，虽然不符合我们之前设计hashCode的原则
        // 希望，以MyData对象为key的，都放在table[index] 中
    }
}
