package com.java.basic.c04_data;

import java.nio.file.FileStore;

/**
 * 自定义一个单向链表
 *
 *      底层不是用数组，用结点类型
 */
public class MySingleList {
    private Node first; // 只记第一个
    private int total; // 总结点的数量

    public void add(Object obj){
        // 是否第一个
        if (first == null){
            first = new Node(obj, null);
        } else {
            // 先找到最后一个，然后把Node放到当前最后一个的next中
            Node now = first;
            while (now.next != null){
                now = now.next;
            }
            now.next = new Node(obj, null);
        }

        total++;
    }

    public int size(){
        return total;
    }

    public void remove(Object obj){
        if (obj == null){
            // 是第一个
            if (first.data == null){
                first = first.next;
            } else {
                Node left = first;
                Node now = first.next;
                while (now.data != null){
                    left = now;
                    now = now.next;
                }
                // now是要删除的结点
                left.next = now.next;
            }
        } else {
            // 是第一个
            if (obj.equals(first.data)){
                first = first.next;
            } else {
                Node left = first;
                Node now = first.next;
                while (!obj.equals(now.data)){
                    left = now;
                    now = now.next;
                }
                // now 是要删除的结点
                left.next = now.next;
            }
        }

        total--;

    }

    public Object[] toArray(){
        Object[] all = new Object[total];
        Node node = first;
        for (int i = 0; i < all.length; i++) {
            all[i] = node.data;
            node = node.next;
        }
        return all;
    }

    // 1、设计结点类型
    class Node{
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}
