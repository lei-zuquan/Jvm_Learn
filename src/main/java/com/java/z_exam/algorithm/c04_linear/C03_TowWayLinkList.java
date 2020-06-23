package com.java.z_exam.algorithm.c04_linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:25 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
get(int i):每一次查询，都需要从链表的头部开始，依次向后查找，随着数据元素N的增多，比较的元素越多，时间
复杂度为O(n)
insert(int i,T t):每一次插入，需要先找到i位置的前一个元素，然后完成插入操作，随着数据元素N的增多，查找的
元素越多，时间复杂度为O(n);
remove(int i):每一次移除，需要先找到i位置的前一个元素，然后完成插入操作，随着数据元素N的增多，查找的元
素越多，时间复杂度为O(n)


相比较顺序表，链表插入和删除的时间复杂度虽然一样，但仍然有很大的优势，因为链表的物理地址是不连续的，
它不需要预先指定存储空间大小，或者在存储过程中涉及到扩容等操作,同时它并没有涉及的元素的交换。

相比较顺序表，链表的查询操作性能会比较低。因此，如果我们的程序中查询操作比较多，建议使用顺序表，增删
操作比较多，建议使用链表。

 */
//双向链表代码
public class C03_TowWayLinkList <T> implements Iterable<T> {

    //首结点
    private Node head;
    //最后一个结点
    private Node last;
    //链表的长度
    private int N;

    public C03_TowWayLinkList() {
        last = null; head = new Node(null,null,null);
        N=0;
    }

    //清空链表
    public void clear(){
        last=null;
        head.next=last;
        head.pre=null;
        head.item=null;
        N=0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //插入元素t
    public void insert(T t){
        if (last==null){
            last = new Node(t,head,null);
            head.next = last;
        }else{
            Node oldLast = last;
            Node node = new Node(t, oldLast, null);
            oldLast.next = node;
            last = node;
        }
        //长度+1
        N++;
    }


    //向指定位置i处插入元素t
    public void insert(int i,T t){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //找到位置i的前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //当前结点
        Node curr = pre.next;
        //构建新结点
        Node newNode = new Node(t, pre, curr);
        curr.pre= newNode;
        pre.next = newNode;
        //长度+1
        N++;
    }

    //获取指定位置i处的元素
    public T get(int i){
        if (i<0||i>=N){
            throw new RuntimeException("位置不合法");
        }
        //寻找当前结点
        Node curr = head.next;
        for (int index = 0; index <i; index++) {
            curr = curr.next;
        }
        return curr.item;
    }

    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n= head;
        for (int i=0;n.next!=null;i++){
            n = n.next;
            if (n.next.equals(t)){
                return i;
            }
        }

        return -1;
    }

    //删除位置i处的元素，并返回该元素
    public T remove(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //寻找i位置的前一个元素
        Node pre = head;
        for (int index = 0; index <i ; index++) {
            pre = pre.next;
        }
        //i位置的元素
        Node curr = pre.next;
        //i位置的下一个元素
        Node curr_next = curr.next;
        pre.next = curr_next;
        curr_next.pre = pre;
        //长度-1；
        N--;
        return curr.item;
    }

    //获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

    public void reverse(){
        if (N==0){
            //当前是空链表，不需要反转
            return;
        }
        reverse(head.next);
    }

    /**
     * @param curr 当前遍历的结点
     * @return 反转后当前结点上一个结点
     * */
    public Node reverse(Node curr){
        //已经到了最后一个元素
        if (curr.next==null){
            //反转后，头结点应该指向原链表中的最后一个元素
            head.next=curr;
            return curr;
        }
        //当前结点的上一个结点
        Node pre = reverse(curr.next);
        pre.next = curr;
        //当前结点的下一个结点设为null
        curr.next=null;
        //返回当前结点
        return curr;
    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }


    //结点类
    private class Node{
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;
    }
}
