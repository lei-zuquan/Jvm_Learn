package com.java.z_exam.algorithm.linear;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:51 下午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
链表中是否有环

使用快慢指针的思想，还是把链表比作一条跑道，链表中有环，那么这条跑道就是一条圆环跑道，在一条圆环跑道
中，两个人有速度差，那么迟早两个人会相遇，只要相遇那么就说明有环。
 */
public class C05_FastSlowPointer_CircleListCheck {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;
        //判断链表是否有环
        boolean circle = isCircle(first);
        System.out.println("first链表中是否有环："+circle);
    }

    /**
     * 判断链表中是否有环
     * @param first 链表首结点
     * @return ture为有环，false为无环
     */
    public static boolean isCircle(Node<String> first) {
        Node<String> slow = first;
        Node<String> fast = first;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast.equals(slow)){
                return true;
            }
        }

        return false;
    }

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item; this.next = next;
        }
    }
}
