package com.java.z_exam.algorithm.linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:51 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

//单向列表代码
public class C02_LinkList<T> implements Iterable<T> {

    //记录头结点
    private Node head;
    //记录链表的长度
    private int N; public C02_LinkList(){
        //初始化头结点
        head = new Node(null,null);
        N=0;
    }
    //清空链表
    public void clear(){
        head.next=null;
        head.item=null; N=0;
    }

    //获取链表的长度
    public int length(){
        return N;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //获取指定位置i出的元素
    public T get(int i){
        if (i<0||i>=N){
            throw new RuntimeException("位置不合法！");
        }
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素t
    public void insert(T t){
        //找到最后一个节点
        Node n = head;
        while(n.next!=null){
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        //链表长度+1
        N++;
    }

    //向指定位置i处，添加元素t
    public void insert(int i,T t){
        if (i<0||i>N){
            throw new RuntimeException("位置不合法！");
        }
        //寻找位置i之前的结点
        Node pre = head;
        for (int index = 0; index <=i-1; index++) {
            pre = pre.next;
        }
        //位置i的结点
        Node curr = pre.next;
        //构建新的结点，让新结点指向位置i的结点
        Node newNode = new Node(t, curr);
        //让之前的结点指向新结点
        pre.next = newNode;
        //长度+1
        N++;
    }

    //删除指定位置i处的元素，并返回被删除的元素
    public T remove(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //寻找i之前的元素
        Node pre = head;
        for (int index = 0; index <=i-1; index++) {
            pre = pre.next;
        }
        //当前i位置的结点
        Node curr = pre.next;
        //前一个结点指向下一个结点，删除当前结点
        pre.next = curr.next;
        //长度-1
        N--;
        return curr.item;
    }

    //查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for (int i = 0;n.next!=null;i++){
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    //结点类
    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T>{
        private Node n;

        public LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }


}
