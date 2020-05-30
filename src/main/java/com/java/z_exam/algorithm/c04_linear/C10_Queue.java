package com.java.z_exam.algorithm.c04_linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:22 上午 2020/5/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
队列是一种基于先进先出(FIFO)的数据结构，是一种只能在一端进行插入,在另一端进行删除操作的特殊线性表，它
按照先进先出的原则存储数据，先进入的数据，在读取数据时先读被读出来。


类名 Queue
构造方法 Queue()：创建Queue对象
成员方法
    1.public boolean isEmpty()：判断队列是否为空，是返回true，否返回false
    2.public int size():获取队列中元素的个数
    3.public T dequeue():从队列中拿出一个元素
    4.public void enqueue(T t)：往队列中插入一个元素
成员变量
    1.private Node head:记录首结点
    2.private int N:当前栈的元素个数
    3.private Node last:记录最后一个结点
 */

//队列代码
public class C10_Queue<T> implements Iterable<T> {

    // 记录首节点
    private Node head;
    // 记录最后一个节点
    private Node last;
    // 记录节点数量
    private int N;

    public C10_Queue() {
        head = new Node(null, null);
        last = null;
        N = 0;
    }

    // 判断队列是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return N == 0;
    }

    // 获取队列中元素的个数
    public int size() {
        return N;
    }

    // 从队列中拿出一个元素
    public T dequeue() {
        if (isEmpty()) return null;

        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        if (isEmpty()) {
            last = null;
        }
        return oldFirst.item;
    }

    // 往队列中插入一个元素
    public void enqueue(T t){
        Node newNode = new Node(t, null);
        if (last == null) {

            head.next = newNode;

        } else {
            Node oldLast = last;
            oldLast.next = newNode;
        }
        last = newNode;
        //个数+1
        N++;
    }


    @Override
    public Iterator<T> iterator() {
        return new Qiterator();
    }

    private class Qiterator implements Iterator<T> {

        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node currNode = n.next;
            n = currNode;
            return currNode.item;
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

    public static void main(String[] args) {
        C10_Queue<String> queue = new C10_Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str+" ");
        }

        System.out.println("-----------------------------");
        while (!queue.isEmpty()){
            String result = queue.dequeue();
            System.out.println("出列了元素："+result);
            System.out.println(queue.size());
        }

    }
}
