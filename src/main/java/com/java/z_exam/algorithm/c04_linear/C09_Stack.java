package com.java.z_exam.algorithm.c04_linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-27 9:08
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 栈是一种基于先进后出(FILO)的数据结构，是一种只能在一端进行插入和删除操作的特殊线性表。它按照先进后出
 * 的原则存储数据，先进入的数据被压入栈底，最后的数据在栈顶，需要读数据的时候从栈顶开始弹出数据（最后一
 * 个数据被第一个读出来）。
 * 我们称数据进入到栈的动作为压栈，数据从栈中出去的动作为弹栈。
 */
public class C09_Stack<T> implements Iterable<T> {

    //记录首结点
    private Node head;
    //栈中元素的个数
    private int N;

    public C09_Stack() {
        head = new Node(null, null);
        N = 0;
    }

    //判断当前栈中元素个数是否为0
    public boolean isEmpty() {
        return N == 0;
    }

    //把t元素压入栈
    public void push(T t) {
        Node oldNext = head.next;
        Node node = new Node(t, oldNext);
        head.next = node;
        //个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop() {
        Node oldNext = head.next;
        if (oldNext == null) {
            return null;
        }
        //删除首个元素
        head.next = head.next.next;
        //个数-1
        N--;
        return oldNext.item;
    }

    //获取栈中元素的个数
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return node.item;
        }
    }

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
