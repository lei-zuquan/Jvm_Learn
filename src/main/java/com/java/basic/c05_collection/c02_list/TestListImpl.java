package com.java.basic.c05_collection.c02_list;

import org.junit.Test;

import java.util.LinkedList;

/**
 * List的常见的实现类
 * 1、Vector：动态数组
 *      内部实现：数组，初始化大小为10
 * 2、ArrayList：动态数组（使用它多些一些，因为性能快一些）
 *      内部实现：数组，初始化大小为10
 * 3、LinkedList：双向链表、双端队列（使用它多些一些）
 *      内部实现：链表
 * 4、Stack：栈，又是Vector的子类
 *      内部实现：数组
 *
 * Stack:后进先出（LIFO）（Last in First out）、先进后出（FILO）(First in Last out)
 *      压栈：push， 弹栈：pop(移除栈顶元素)，peek(返回栈顶元素，但不移除)
 * 队列（Queue）：先进先出（FIFO）
 *      添加到队列offer(e)，移出队列pool()，返回队头不移除peek()
 * 双端队列(Deque)(Double ended queue)：队头和队尾都可以添加元素和移除元素
 *      offerFirst(e)、offerLast(e)
 *      pollFirst()、pollLast()
 *      peekFirst()、peekLast()
 *
 * 面试题：Vector与ArrayList有什么区别？
 * Vector：旧版，线程安全的，扩容为原来的2倍，支持迭代的方式更多，支持旧版Enumeration迭代器
 * ArrayList：新版，线程不安全，扩容为原来的1.5倍，不支持老版的Enumeration迭代器
 *
 * 面试题：动态数组和LinkedList有什么区别？
 *      1）内部实现不同：
 *          动态数组底层数据
 *          LinkedList是链表，元素的类型是节点类型，Node(prev,data,next)
 *      2）动态数组：对索引的相关操作，效率很记
 *          链表：对索引的相关操作，效率比较低
 *      3）动态数据：插入、删除，设计到称动元素
 *          链表：插入，删除，只涉及到前后的元素的关系
 *
 *  结论：如果是后的操作针对索引更多，那么选择动态数组，如果是添加和删除，插入等操作更多，选择链表
 *
 */
public class TestListImpl {

    @Test
    public void test(){
        LinkedList list = new LinkedList();
//        list.offerFirst("1");
//        list.offerFirst("2");
//        list.offerFirst("3");
        list.offerLast("1");
        list.offerLast("2");
        list.offerLast("3");

//        for (Object object : list) {
//            System.out.println(object);
//        }
        System.out.println(list.pollFirst());
        System.out.println(list.pollFirst());
        System.out.println(list.pollFirst());
        System.out.println(list.pollFirst());
    }
}
