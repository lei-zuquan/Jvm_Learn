package com.java.basic.c05_collection.c05_src;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:59 上午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.LinkedList;

/**
 * day22_07源码分析：LinkedList
 *
 * LinkedList:
 * 1、内部实现：链表
 * 记录Node first;
 *      Node last;
 *
 * 2、add(xx)
 * 默认添加到链表的尾部linkLast(xx)
 *
 * 3、add(int index, xx)
 *
 * 4、remove(xx)
 *
 *
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("xx");
        linkedList.add(0, "ss");
        linkedList.remove("x");
    }
}
