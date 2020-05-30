package com.java.z_exam.algorithm.linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:50 上午 2020/5/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
有序符号表
    刚才实现的符号表，我们可以称之为无序符号表，因为在插入的时候，并没有考虑键值对的顺序，而在实际生活
    中，有时候我们需要根据键的大小进行排序，插入数据时要考虑顺序，那么接下来我们就实现一下有序符号表。


 */
public class C12_OrderSymbolTable<Key extends Comparable<Key>,Value>  implements Iterable<Key>{


    private class Node {
        // 键
        public Key key;
        // 值
        public Value value;
        // 下一个节点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 记录首结点
    private int N; // 记录符号表中键值对的个数

    public C12_OrderSymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    // 根据键key，找对应的值
    public Value get(Key key){
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            if (currNode.key.equals(key)){
                return currNode.value;
            }

        }
        return null;
    }

    // 向符号表中插入一个键值对，注意：符号表中，键具有唯一性。
    public void put(Key key,Value val){
        //先从符号表中查找键为key的键值对
        Node currNode = head;
        Node currNodeNext = currNode.next;

        while (currNodeNext != null){


            if (currNodeNext.key.compareTo(key) > 0) {
                Node newNode = new Node(key, val, currNodeNext);
                currNode.next = newNode;
                N++;
                return;
            } else if (currNodeNext.key.compareTo(key) == 0) {
                currNodeNext.value = val;
                return;
            }

            currNode = currNode.next;
            currNodeNext = currNodeNext.next;

        }



        //符号表中没有键为key的键值对
        // 方式一：

        Node newNode = new Node(key, val, null);
        currNode.next = newNode;
        N++;
        // 方式二：
        /*Node oldFirst = head.next;
        Node newNode = new Node(key, val, oldFirst);
        head.next = newNode;
        N++;*/
    }

    // 删除键为key的键值对
    public void delete(Key key){
        Node currNode = head;
        while (currNode.next!= null){
            Node currNodeNext = currNode.next;

            if (currNodeNext.key.equals(key)) {
                currNode.next = currNodeNext.next;
                N--;
                return;
            }

        }
    }

    // 获取符号表的大小
    public int size() {
        return N;
    }


    @Override
    public Iterator<Key> iterator() {
        return new OIterator();
    }


    private class OIterator implements Iterator<Key> {

        Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Key next() {
            n = n.next;
            return n.key;
        }
    }
    public static void main(String[] args) {
        C12_OrderSymbolTable<Integer, String> bt = new C12_OrderSymbolTable<>();
        bt.put(4, "二哈");
        bt.put(3, "张三");
        bt.put(1, "李四");
        bt.put(1, "aa");
        bt.put(5, "王五");


        Iterator<Integer> iterator = bt.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}
